package com.continuuity.hive.datasets;

import com.continuuity.hive.context.Constants;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hive.serde2.AbstractSerDe;
import org.apache.hadoop.hive.serde2.SerDeException;
import org.apache.hadoop.hive.serde2.SerDeStats;
import org.apache.hadoop.hive.serde2.objectinspector.ObjectInspector;
import org.apache.hadoop.hive.serde2.objectinspector.ObjectInspectorFactory;
import org.apache.hadoop.io.ObjectWritable;
import org.apache.hadoop.io.Writable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Properties;

/**
 * SerDe to serialize Dataset Objects.
 */
public class DatasetSerDe extends AbstractSerDe {
  private static final Logger LOG = LoggerFactory.getLogger(DatasetSerDe.class);

  private Type rowType;

  @Override
  public void initialize(Configuration entries, Properties properties) throws SerDeException {
    String datasetName = properties.getProperty(Constants.DATASET_NAME);
    entries.set(Constants.DATASET_NAME, datasetName);
    try {
      rowType = DatasetAccessor.getRowScannableType(entries);
    } catch (IOException e) {
      LOG.error("Got exception while trying to instantiate dataset {}", datasetName, e);
      throw new SerDeException(e);
    }
  }

  @Override
  public Class<? extends Writable> getSerializedClass() {
    // Writing to Datasets not supported.
    return Writable.class;
  }

  @Override
  public Writable serialize(Object o, ObjectInspector objectInspector) throws SerDeException {
    throw new UnsupportedOperationException("Cannot write to Datasets yet");
  }

  @Override
  public SerDeStats getSerDeStats() {
    // TODO: add real Sataset stats
    return new SerDeStats();
  }

  @Override
  public Object deserialize(Writable writable) throws SerDeException {
    ObjectWritable objectWritable = (ObjectWritable) writable;
    return objectWritable.get();
  }

  @Override
  public ObjectInspector getObjectInspector() throws SerDeException {
    return ObjectInspectorFactory.getReflectionObjectInspector(rowType,
                                                               ObjectInspectorFactory.ObjectInspectorOptions.JAVA);
  }
}
