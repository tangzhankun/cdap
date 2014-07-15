/*
 * Copyright 2012-2014 Continuuity, Inc.
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

package com.continuuity.app.metrics;

import com.continuuity.common.metrics.MetricsCollectionService;
import com.continuuity.common.metrics.MetricsScope;

/**
 * Metrics Collector for Service.
 */
public class ServiceRunnableMetrics extends AbstractProgramMetrics {

  public ServiceRunnableMetrics(MetricsCollectionService collectionService, String applicationId,
                                String serviceId, String runnableId) {
    super(collectionService.getCollector(
      MetricsScope.USER, String.format("%s.s.%s.%s", applicationId, serviceId, runnableId), "0"));
  }
}
