package com.continuuity.common.conf;

/**
 * Constants used by different systems are all defined here.
 */
public class Constants {
  /**
   * Service names.
   */
  public static final String
    SERVICE_METRICS_COLLECTION_SERVER = "metricscollection";
  public static final String
    SERVICE_METRICS_FRONTEND_SERVER = "metricsfrontend";
  public static final String
      SERVICE_METADATA_SERVER = "metadata";
  @Deprecated
  public static final String
      SERVICE_FLOW_SERVER = "flow-service";
  public static final String
      SERVICE_APPFABRIC_SERVER = "app-fabric-service";

  /**
   * Common across components.
   */
  public static final String CFG_ZOOKEEPER_ENSEMBLE = "zookeeper.quorum";

  // ENG-443 setting for avoiding OOME when telnetd to server port.
  public static final String CFG_MAX_READ_BUFFER = "thrift.max.read.buffer";

  // ENG-440 Connection URL for location used for storing the flows states
  // and history.
  @Deprecated
  public static final String CFG_STATE_STORAGE_CONNECTION_URL =
    "state.storage.connection.url";

  @Deprecated
  public static final String CFG_COMMAND_PORT_ENABLED =
    "command.port.enabled";

  /**
   * Default constants for common
   */
  public static final String DEFAULT_ZOOKEEPER_ENSEMBLE = "localhost:2181";

  // ENG-443 1 MB max read buffer size.
  public static final int DEFAULT_MAX_READ_BUFFER = 1048576;

  // ENG-440 Connection URL for location used for storing the flows states
  // and history.
  public static final String DEFAULT_STATE_STORAGE_CONNECTION_URL =
    "jdbc:hsqldb:mem:flowmanagement?user=sa";

  public static final boolean DEFAULT_COMMAND_PORT_ENABLED = false;

  /**
   * App Fabric Server
   */
  public static final String CFG_APP_FABRIC_SERVER_ADDRESS = "app.server.address";
  public static final String CFG_APP_FABRIC_SERVER_PORT = "app.server.port";
  public static final String CFG_APP_FABRIC_OUTPUT_DIR  = "app.output.dir";
  public static final String CFG_APP_FABRIC_TEMP_DIR    = "app.temp.dir";

  /**
   * Default.
   */
  public static final int DEFAULT_APP_FABRIC_SERVER_PORT = 45000;
  public static final String DEFAULT_APP_FABRIC_SERVER_ADDRESS = "localhost";

  /**
   * Configuration key names used by resource manager.
   */
  @Deprecated
  public static final String
    CFG_RESOURCE_MANAGER_REMOTE_DIR = "resource.manager.remote.dir";
  @Deprecated
  public static final String
    CFG_RESOURCE_MANAGER_LOCAL_DIR = "resource.manager.local.dir";
  @Deprecated
  public static final String
    CFG_RESOURCE_MANAGER_SERVER_PORT = "resource.manager.server.port";
  @Deprecated
  public static final String
    CFG_RESOURCE_MANAGER_SERVER_THREADS = "resource.manager.server.threads";
  @Deprecated
  public static final String
    CFG_RESOURCE_MANAGER_SERVER_ADDRESS = "resource.manager.server.address";

  /**
   * Defaults for resource manager.
   */
  @Deprecated
  public static final String
    DEFAULT_RESOURCE_MANAGER_LOCAL_DIR = "build/continuuity/flow/manager/local";
  @Deprecated
  public static final String
    DEFAULT_RESOURCE_MANAGER_REMOTE_DIR = "build/continuuity/flow/manager/remote";
  @Deprecated
  public static final String
    DEFAULT_RESOURCE_MANAGER_SERVER_ADDRESS = "0.0.0.0";

  /**
   * Constants used by resource manager.
   */
  public static final String JAR_EXTENSION=".jar";
  public static final String STANDARD_FAR_FLOWS_CONFIG_FILE = "flows.json";
  public static final String MANIFEST_FILE_PATH = "META-INF/MANIFEST.MF";
  public static final int RESOURCE_MANAGER_VERSION_FIND_ATTEMPTS = 10;

  /**
   * Default constants defined for resource manager
   */
  @Deprecated
  public static final int DEFAULT_RESOURCE_MANAGER_SERVER_PORT = 45000;
  @Deprecated
  public static final int DEFAULT_RESOURCE_MANAGER_SERVER_THREADS = 2;


  /**
   * Constants used by Tuple serializer
   */
  @Deprecated
  public static final int MAX_SERDE_BUFFER = 1024 * 1024;

  /**
   * Configuration key names used by flow manager
   */
  @Deprecated
  public static final String CFG_FLOW_MANAGER_SERVER_PORT =
        "flow.manager.server.port";
  @Deprecated
  public static final String CFG_FLOW_MANAGER_SERVER_THREADS =
        "flow.manager.server.threads";
  @Deprecated
  public static final String CFG_FLOW_MANAGER_SERVER_ADDRESS =
        "flow.manager.server.address";


  /**
   * Default constants defined for flow manager.
   */
  @Deprecated
  public static final int DEFAULT_FLOW_MANAGER_SERVER_PORT = 45001;
  @Deprecated
  public static final int DEFAULT_FLOW_MANAGER_SERVER_THREADS = 2;
  @Deprecated
  public static final String DEFAULT_FLOW_MANAGER_SERVER_ADDRESS = "0.0.0.0";


  /**
   * Configuration for Cloud FAR Service.
   */
  @Deprecated
  public static final String
    CFG_RESOURCE_MANAGER_CLOUD_HOST = "resource.manager.cloud.hostname";
  @Deprecated
  public static final String
    CFG_RESOURCE_MANAGER_CLOUD_PORT = "resource.manager.cloud.port";
  @Deprecated
  public static final String
    DEFAULT_RESOURCE_MANAGER_CLOUD_HOST = "localhost";
  @Deprecated
  public static final int
    DEFAULT_RESOURCE_MANAGER_CLOUD_PORT = DEFAULT_RESOURCE_MANAGER_SERVER_PORT;

  /**
   * Configuration for OpenTSDB
   */
  public static final String
    CFG_OPENTSDB_SERVER_ADDRESS = "opentsdb.server.address";
  public static final String
    CFG_OPENTSDB_SERVER_PORT = "opentsdb.server.port";

  /**
   * Defaults for OpenTSDB
   */
  public static final String DEFAULT_OPENTSDB_SERVER_ADDRESS = "localhost";
  public static final int DEFAULT_OPENTSDB_SERVER_PORT = 4242;

  /**
   * Configuration for Metrics collection server
   */
  public static final String
    CFG_METRICS_COLLECTOR_SERVER_ADDRESS
    = "overlord.metrics.collection.server.address";
  public static final String
    CFG_METRICS_COLLECTOR_SERVER_PORT
    = "overlord.metrics.collection.server.port";
  public static final String
    CFG_METRICS_FRONTEND_SERVER_ADDRESS
    = "overlord.metrics.frontend.server.address";
  public static final String
    CFG_METRICS_FRONTEND_SERVER_PORT
    = "overlord.metrics.frontend.server.port";
  public static final String
    CFG_METRICS_FRONTEND_SERVER_THREADS
    = "overlord.metrics.frontend.server.threads";
  public static final String
    CFG_METRICS_CONNECTION_URL = "overlord.metrics.connection.url";
  public static final String
    CFG_METRICS_COLLECTION_FLOW_SYSTEM_PLUGINS
    = "overlord.metrics.processor.plugins.flowsystem";
  public static final String
    CFG_METRICS_COLLECTION_SYSTEM_PLUGINS
    = "overlord.metrics.processor.plugins.system";
  public static final String
    CFG_METRICS_COLLECTION_FLOW_USER_PLUGINS
    = "overlord.metrics.processor.plugins.flowuser";
  public static final String
    CFG_METRICS_COLLECTION_ALLOWED_TIMESERIES_METRICS
    = "overlord.metrics.timeseries.metrics";

  /**
   * Defaults for metrics collection server
   */
  public static final String
    DEFAULT_METRICS_COLLECTOR_SERVER_ADDRESS = "localhost";
  public static final int DEFAULT_METRICS_COLLECTOR_SERVER_PORT = 45003;
  public static final String
    DEFAULT_METRICS_FRONTEND_SERVER_ADDRESS = "localhost";
  public static final int
    DEFAULT_METRICS_FRONTEND_SERVER_PORT = 45002;
  public static final int
    DEFAULT_METRICS_FRONTEND_SERVER_THREADS = 2;
  public static final String
    DEFAULT_METIRCS_CONNECTION_URL = "jdbc:hsqldb:mem:metricsdb?user=sa";
  public static final String
    DEFAULT_METRICS_COLLECTION_ALLOWED_TIMESERIES_METRICS = "processed.count";

  /**
   * Configuration for Metadata service
   */
  public static final String
    CFG_METADATA_SERVER_ADDRESS = "metadata.server.address";
  public static final String
    CFG_METADATA_SERVER_PORT = "metadata.server.port";
  public static final String
    CFG_METADATA_SERVER_THREADS = "metadata.server.threads";

  /**
   * Defaults for metadata service
   */
  public static final String
    DEFAULT_METADATA_SERVER_ADDRESS = "localhost";
  public static final int
    DEFAULT_METADATA_SERVER_PORT = 45004;
  public static final int
    DEFAULT_METADATA_SERVER_THREADS = 2;

  /**
   * Configuration for consolidated overlord service.
   */
  public static final String
    CFG_OVERLORD_SERVER_ADDRESS = "overlord.server.address";
  public static final String
    CFG_OVERLORD_SERVER_PORT = "overlord.server.port";
  public static final String
    CFG_OVERLORD_SERVER_THREADS = "overlord.server.threads";

  /**
   * Defaults for Overlord service
   */
  public static final String
    DEFAULT_OVERLORD_SERVER_ADDRESS = "localhost";
  public static final int
    DEFAULT_OVERLORD_SERVER_PORT = 45005;
  public static final int
    DEFAULT_OVERLORD_SERVER_THREADS = 10;

  /**
   * Config for Log Collection
   */
  public static final String CFG_LOG_COLLECTION_ROOT =
      "log.collection.root";
  public static final String DEFAULT_LOG_COLLECTION_ROOT =
      "data/logs";
  public static final String CFG_LOG_COLLECTION_PORT =
      "log.collection.port";
  public static final int DEFAULT_LOG_COLLECTION_PORT =
      12157;
  public static final String CFG_LOG_COLLECTION_THREADS =
      "log.collection.threads";
  public static final int DEFAULT_LOG_COLLECTION_THREADS =
      10;
  public static final String CFG_LOG_COLLECTION_SERVER_ADDRESS =
      "log.collection.server.address";
  public static final String DEFAULT_LOG_COLLECTION_SERVER_ADDRESS =
      "localhost";

  /**
   * Constants related to Passport
   */
  public final static String CFG_PASSPORT_SERVER_ADDRESS_KEY = "passport.server.address";
  public final static String CFG_PASSPORT_SERVER_PORT_KEY = "passport.server.port";
  public final static String CONTINUUITY_API_KEY_HEADER = "X-Continuuity-ApiKey";
  public final static String CFG_APPFABRIC_ENVIRONMENT = "appfabric.environment";
  public final static String DEFAULT_APPFABRIC_ENVIRONMENT = "devsuite";

}
