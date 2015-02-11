/*
 * Copyright © 2014-2015 Cask Data, Inc.
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
package co.cask.cdap.data.stream.service;

import co.cask.cdap.common.conf.Constants;
import co.cask.cdap.gateway.auth.Authenticator;
import co.cask.cdap.gateway.handlers.AuthenticatedHttpHandler;
import co.cask.http.BodyConsumer;
import co.cask.http.HttpHandler;
import co.cask.http.HttpResponder;
import com.google.inject.Inject;
import org.jboss.netty.handler.codec.http.HttpRequest;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

/**
 * The {@link HttpHandler} for handling REST call to stream endpoints.
 *
 * TODO: Currently stream "dataset" is implementing old dataset API, hence not supporting multi-tenancy.
 */
@Path(Constants.Gateway.API_VERSION_2 + "/streams")
public final class StreamHandlerV2 extends AuthenticatedHttpHandler {

  // StreamHandler for V3 APIs,to which calls will be delegated to.
  private final StreamHandler streamHandler;

  @Inject
  public StreamHandlerV2(Authenticator authenticator, StreamHandler streamHandler) {
    super(authenticator);
    this.streamHandler = streamHandler;
  }

  @GET
  @Path("/{stream}/info")
  public void getInfo(HttpRequest request, HttpResponder responder,
                      @PathParam("stream") String stream) throws Exception {
    streamHandler.getInfo(rewriteRequest(request), responder, Constants.DEFAULT_NAMESPACE, stream);
  }

  @PUT
  @Path("/{stream}")
  public void create(HttpRequest request, HttpResponder responder,
                     @PathParam("stream") String stream) throws Exception {
    streamHandler.create(rewriteRequest(request), responder, Constants.DEFAULT_NAMESPACE, stream);
  }

  @POST
  @Path("/{stream}")
  public void enqueue(HttpRequest request, HttpResponder responder,
                      @PathParam("stream") String stream) throws Exception {
    streamHandler.enqueue(rewriteRequest(request), responder, Constants.DEFAULT_NAMESPACE, stream);
  }

  @POST
  @Path("/{stream}/async")
  public void asyncEnqueue(HttpRequest request, HttpResponder responder,
                           @PathParam("stream") String stream) throws Exception {
    streamHandler.asyncEnqueue(rewriteRequest(request), responder, Constants.DEFAULT_NAMESPACE, stream);
  }

  @POST
  @Path("/{stream}/batch")
  public BodyConsumer batch(HttpRequest request, HttpResponder responder,
                            @PathParam("stream") String stream) throws Exception {
    return streamHandler.batch(rewriteRequest(request), responder, Constants.DEFAULT_NAMESPACE, stream);
  }

  @POST
  @Path("/{stream}/truncate")
  public void truncate(HttpRequest request, HttpResponder responder,
                       @PathParam("stream") String stream) throws Exception {
    streamHandler.truncate(rewriteRequest(request), responder, Constants.DEFAULT_NAMESPACE, stream);
  }

  @PUT
  @Path("/{stream}/config")
  public void setConfig(HttpRequest request, HttpResponder responder,
                        @PathParam("stream") String stream) throws Exception {
    streamHandler.setConfig(rewriteRequest(request), responder, Constants.DEFAULT_NAMESPACE, stream);
  }

  /**
   * Updates the request URI to its v3 URI before delegating the call to the corresponding v3 handler.
   * Note: This piece of code is duplicated in LogHandler, but its ok since this temporary, till we
   * support v2 APIs
   *
   * @param request the original {@link HttpRequest}
   * @return {@link HttpRequest} with modified URI
   */
  public HttpRequest rewriteRequest(HttpRequest request) {
    String originalUri = request.getUri();
    request.setUri(originalUri.replaceFirst(Constants.Gateway.API_VERSION_2, Constants.Gateway.API_VERSION_3 +
      "/namespaces/" + Constants.DEFAULT_NAMESPACE));
    return request;
  }
}