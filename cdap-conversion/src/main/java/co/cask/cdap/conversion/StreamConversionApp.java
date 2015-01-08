/*
 * Copyright © 2015 Cask Data, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package co.cask.cdap.conversion;

import co.cask.cdap.api.app.AbstractApplication;
import co.cask.cdap.api.dataset.lib.FileSet;
import co.cask.cdap.api.dataset.lib.FileSetProperties;
import co.cask.cdap.internal.io.Schema;
import co.cask.cdap.internal.io.SchemaTypeAdapter;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.avro.mapreduce.AvroKeyInputFormat;
import org.apache.avro.mapreduce.AvroKeyOutputFormat;

/**
 *
 */
public class StreamConversionApp extends AbstractApplication {
  private static final Gson GSON = new GsonBuilder()
    .registerTypeAdapter(Schema.class, new SchemaTypeAdapter())
    .create();

  @Override
  public void configure() {
    Schema schema = Schema.recordOf(
      "streamEvent",
      Schema.Field.of("ts", Schema.of(Schema.Type.LONG)),
      Schema.Field.of("header1", Schema.unionOf(Schema.of(Schema.Type.NULL), Schema.of(Schema.Type.STRING))),
      Schema.Field.of("header2", Schema.unionOf(Schema.of(Schema.Type.NULL), Schema.of(Schema.Type.STRING))),
      Schema.Field.of("body", Schema.of(Schema.Type.STRING)));
    addWorkflow(new StreamConversionWorkflow());
    // this should not be in the app.  But there is no way to pass in the name of the dataset at runtime...
    // do this to get an outline of the app in place then change it after the framework can support runtime datasets.
    createDataset("converted_stream", FileSet.class, FileSetProperties.builder()
      .setBasePath("converted_stream")
      .setInputFormat(AvroKeyInputFormat.class)
      .setOutputFormat(AvroKeyOutputFormat.class)
      .setOutputProperty("schema", GSON.toJson(schema))
      .build());
  }
}
