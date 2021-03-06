/*
 * Copyright © 2014 Cask Data, Inc.
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

package co.cask.cdap.common.exception;

import javax.annotation.Nullable;

/**
 * Thrown when an element cannot be deleted.
 */
public class CannotBeDeletedException extends Exception {

  private final String elementType;
  private final String elementId;
  private String reason;

  public CannotBeDeletedException(String elementType, String elementId) {
    super(String.format("Element '%s' of type '%s' cannot be deleted.", elementId, elementType));
    this.elementType = elementType;
    this.elementId = elementId;
  }

  public CannotBeDeletedException(String elementType, String elementId, String reason) {
    super(String.format("Element '%s' of type '%s' cannot be deleted. Reason: %s", elementId, elementType, reason));
    this.elementType = elementType;
    this.elementId = elementId;
    this.reason = reason;
  }

  public CannotBeDeletedException(String elementType, String elementId, Throwable cause) {
    super(String.format("Element '%s' of type '%s' cannot be deleted. Reason: %s",
                        elementId, elementType, cause.getMessage()), cause);
    this.elementType = elementType;
    this.elementId = elementId;
  }

  /**
   * @return Type of element: flow, stream, dataset, etc
   */
  public String getElementType() {
    return elementType;
  }

  /**
   * @return ID of the element
   */
  public String getElementId() {
    return elementId;
  }

  /**
   * @return the reason why the element cannot be deleted
   */
  @Nullable
  public String getReason() {
    return reason;
  }
}
