/*
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
/*
 * This code was generated by https://code.google.com/p/google-apis-client-generator/
 * (build: 2013-10-23 18:35:03 UTC)
 * on 2013-10-28 at 02:14:05 UTC 
 * Modify at your own risk.
 */

package edu.vt.bmac.gpstracker.trailsendpoint;

/**
 * Service definition for Trailsendpoint (v1).
 *
 * <p>
 * This is an API
 * </p>
 *
 * <p>
 * For more information about this service, see the
 * <a href="" target="_blank">API Documentation</a>
 * </p>
 *
 * <p>
 * This service uses {@link TrailsendpointRequestInitializer} to initialize global parameters via its
 * {@link Builder}.
 * </p>
 *
 * @since 1.3
 * @author Google, Inc.
 */
@SuppressWarnings("javadoc")
public class Trailsendpoint extends com.google.api.client.googleapis.services.json.AbstractGoogleJsonClient {

  // Note: Leave this static initializer at the top of the file.
  static {
    com.google.api.client.util.Preconditions.checkState(
        com.google.api.client.googleapis.GoogleUtils.MAJOR_VERSION == 1 &&
        com.google.api.client.googleapis.GoogleUtils.MINOR_VERSION >= 15,
        "You are currently running with version %s of google-api-client. " +
        "You need at least version 1.15 of google-api-client to run version " +
        "1.16.0-rc of the trailsendpoint library.", com.google.api.client.googleapis.GoogleUtils.VERSION);
  }

  /**
   * The default encoded root URL of the service. This is determined when the library is generated
   * and normally should not be changed.
   *
   * @since 1.7
   */
  public static final String DEFAULT_ROOT_URL = "https://gpstracker-bmac.appspot.com/_ah/api/";

  /**
   * The default encoded service path of the service. This is determined when the library is
   * generated and normally should not be changed.
   *
   * @since 1.7
   */
  public static final String DEFAULT_SERVICE_PATH = "trailsendpoint/v1/";

  /**
   * The default encoded base URL of the service. This is determined when the library is generated
   * and normally should not be changed.
   */
  public static final String DEFAULT_BASE_URL = DEFAULT_ROOT_URL + DEFAULT_SERVICE_PATH;

  /**
   * Constructor.
   *
   * <p>
   * Use {@link Builder} if you need to specify any of the optional parameters.
   * </p>
   *
   * @param transport HTTP transport, which should normally be:
   *        <ul>
   *        <li>Google App Engine:
   *        {@code com.google.api.client.extensions.appengine.http.UrlFetchTransport}</li>
   *        <li>Android: {@code newCompatibleTransport} from
   *        {@code com.google.api.client.extensions.android.http.AndroidHttp}</li>
   *        <li>Java: {@link com.google.api.client.googleapis.javanet.GoogleNetHttpTransport#newTrustedTransport()}
   *        </li>
   *        </ul>
   * @param jsonFactory JSON factory, which may be:
   *        <ul>
   *        <li>Jackson: {@code com.google.api.client.json.jackson2.JacksonFactory}</li>
   *        <li>Google GSON: {@code com.google.api.client.json.gson.GsonFactory}</li>
   *        <li>Android Honeycomb or higher:
   *        {@code com.google.api.client.extensions.android.json.AndroidJsonFactory}</li>
   *        </ul>
   * @param httpRequestInitializer HTTP request initializer or {@code null} for none
   * @since 1.7
   */
  public Trailsendpoint(com.google.api.client.http.HttpTransport transport, com.google.api.client.json.JsonFactory jsonFactory,
      com.google.api.client.http.HttpRequestInitializer httpRequestInitializer) {
    this(new Builder(transport, jsonFactory, httpRequestInitializer));
  }

  /**
   * @param builder builder
   */
  Trailsendpoint(Builder builder) {
    super(builder);
  }

  @Override
  protected void initialize(com.google.api.client.googleapis.services.AbstractGoogleClientRequest<?> httpClientRequest) throws java.io.IOException {
    super.initialize(httpClientRequest);
  }

  /**
   * Create a request for the method "getTrails".
   *
   * This request holds the parameters needed by the the trailsendpoint server.  After setting any
   * optional parameters, call the {@link GetTrails#execute()} method to invoke the remote operation.
   *
   * @param id
   * @return the request
   */
  public GetTrails getTrails(java.lang.String id) throws java.io.IOException {
    GetTrails result = new GetTrails(id);
    initialize(result);
    return result;
  }

  public class GetTrails extends TrailsendpointRequest<edu.vt.bmac.gpstracker.trailsendpoint.model.Trails> {

    private static final String REST_PATH = "trails/{id}";

    /**
     * Create a request for the method "getTrails".
     *
     * This request holds the parameters needed by the the trailsendpoint server.  After setting any
     * optional parameters, call the {@link GetTrails#execute()} method to invoke the remote
     * operation. <p> {@link
     * GetTrails#initialize(com.google.api.client.googleapis.services.AbstractGoogleClientRequest)}
     * must be called to initialize this instance immediately after invoking the constructor. </p>
     *
     * @param id
     * @since 1.13
     */
    protected GetTrails(java.lang.String id) {
      super(Trailsendpoint.this, "GET", REST_PATH, null, edu.vt.bmac.gpstracker.trailsendpoint.model.Trails.class);
      this.id = com.google.api.client.util.Preconditions.checkNotNull(id, "Required parameter id must be specified.");
    }

    @Override
    public com.google.api.client.http.HttpResponse executeUsingHead() throws java.io.IOException {
      return super.executeUsingHead();
    }

    @Override
    public com.google.api.client.http.HttpRequest buildHttpRequestUsingHead() throws java.io.IOException {
      return super.buildHttpRequestUsingHead();
    }

    @Override
    public GetTrails setAlt(java.lang.String alt) {
      return (GetTrails) super.setAlt(alt);
    }

    @Override
    public GetTrails setFields(java.lang.String fields) {
      return (GetTrails) super.setFields(fields);
    }

    @Override
    public GetTrails setKey(java.lang.String key) {
      return (GetTrails) super.setKey(key);
    }

    @Override
    public GetTrails setOauthToken(java.lang.String oauthToken) {
      return (GetTrails) super.setOauthToken(oauthToken);
    }

    @Override
    public GetTrails setPrettyPrint(java.lang.Boolean prettyPrint) {
      return (GetTrails) super.setPrettyPrint(prettyPrint);
    }

    @Override
    public GetTrails setQuotaUser(java.lang.String quotaUser) {
      return (GetTrails) super.setQuotaUser(quotaUser);
    }

    @Override
    public GetTrails setUserIp(java.lang.String userIp) {
      return (GetTrails) super.setUserIp(userIp);
    }

    @com.google.api.client.util.Key
    private java.lang.String id;

    /**

     */
    public java.lang.String getId() {
      return id;
    }

    public GetTrails setId(java.lang.String id) {
      this.id = id;
      return this;
    }

    @Override
    public GetTrails set(String parameterName, Object value) {
      return (GetTrails) super.set(parameterName, value);
    }
  }

  /**
   * Create a request for the method "insertTrails".
   *
   * This request holds the parameters needed by the the trailsendpoint server.  After setting any
   * optional parameters, call the {@link InsertTrails#execute()} method to invoke the remote
   * operation.
   *
   * @param content the {@link edu.vt.bmac.gpstracker.trailsendpoint.model.Trails}
   * @return the request
   */
  public InsertTrails insertTrails(edu.vt.bmac.gpstracker.trailsendpoint.model.Trails content) throws java.io.IOException {
    InsertTrails result = new InsertTrails(content);
    initialize(result);
    return result;
  }

  public class InsertTrails extends TrailsendpointRequest<edu.vt.bmac.gpstracker.trailsendpoint.model.Trails> {

    private static final String REST_PATH = "trails";

    /**
     * Create a request for the method "insertTrails".
     *
     * This request holds the parameters needed by the the trailsendpoint server.  After setting any
     * optional parameters, call the {@link InsertTrails#execute()} method to invoke the remote
     * operation. <p> {@link
     * InsertTrails#initialize(com.google.api.client.googleapis.services.AbstractGoogleClientRequest)}
     * must be called to initialize this instance immediately after invoking the constructor. </p>
     *
     * @param content the {@link edu.vt.bmac.gpstracker.trailsendpoint.model.Trails}
     * @since 1.13
     */
    protected InsertTrails(edu.vt.bmac.gpstracker.trailsendpoint.model.Trails content) {
      super(Trailsendpoint.this, "POST", REST_PATH, content, edu.vt.bmac.gpstracker.trailsendpoint.model.Trails.class);
    }

    @Override
    public InsertTrails setAlt(java.lang.String alt) {
      return (InsertTrails) super.setAlt(alt);
    }

    @Override
    public InsertTrails setFields(java.lang.String fields) {
      return (InsertTrails) super.setFields(fields);
    }

    @Override
    public InsertTrails setKey(java.lang.String key) {
      return (InsertTrails) super.setKey(key);
    }

    @Override
    public InsertTrails setOauthToken(java.lang.String oauthToken) {
      return (InsertTrails) super.setOauthToken(oauthToken);
    }

    @Override
    public InsertTrails setPrettyPrint(java.lang.Boolean prettyPrint) {
      return (InsertTrails) super.setPrettyPrint(prettyPrint);
    }

    @Override
    public InsertTrails setQuotaUser(java.lang.String quotaUser) {
      return (InsertTrails) super.setQuotaUser(quotaUser);
    }

    @Override
    public InsertTrails setUserIp(java.lang.String userIp) {
      return (InsertTrails) super.setUserIp(userIp);
    }

    @Override
    public InsertTrails set(String parameterName, Object value) {
      return (InsertTrails) super.set(parameterName, value);
    }
  }

  /**
   * Create a request for the method "listTrails".
   *
   * This request holds the parameters needed by the the trailsendpoint server.  After setting any
   * optional parameters, call the {@link ListTrails#execute()} method to invoke the remote operation.
   *
   * @return the request
   */
  public ListTrails listTrails() throws java.io.IOException {
    ListTrails result = new ListTrails();
    initialize(result);
    return result;
  }

  public class ListTrails extends TrailsendpointRequest<edu.vt.bmac.gpstracker.trailsendpoint.model.CollectionResponseTrails> {

    private static final String REST_PATH = "trails";

    /**
     * Create a request for the method "listTrails".
     *
     * This request holds the parameters needed by the the trailsendpoint server.  After setting any
     * optional parameters, call the {@link ListTrails#execute()} method to invoke the remote
     * operation. <p> {@link
     * ListTrails#initialize(com.google.api.client.googleapis.services.AbstractGoogleClientRequest)}
     * must be called to initialize this instance immediately after invoking the constructor. </p>
     *
     * @since 1.13
     */
    protected ListTrails() {
      super(Trailsendpoint.this, "GET", REST_PATH, null, edu.vt.bmac.gpstracker.trailsendpoint.model.CollectionResponseTrails.class);
    }

    @Override
    public com.google.api.client.http.HttpResponse executeUsingHead() throws java.io.IOException {
      return super.executeUsingHead();
    }

    @Override
    public com.google.api.client.http.HttpRequest buildHttpRequestUsingHead() throws java.io.IOException {
      return super.buildHttpRequestUsingHead();
    }

    @Override
    public ListTrails setAlt(java.lang.String alt) {
      return (ListTrails) super.setAlt(alt);
    }

    @Override
    public ListTrails setFields(java.lang.String fields) {
      return (ListTrails) super.setFields(fields);
    }

    @Override
    public ListTrails setKey(java.lang.String key) {
      return (ListTrails) super.setKey(key);
    }

    @Override
    public ListTrails setOauthToken(java.lang.String oauthToken) {
      return (ListTrails) super.setOauthToken(oauthToken);
    }

    @Override
    public ListTrails setPrettyPrint(java.lang.Boolean prettyPrint) {
      return (ListTrails) super.setPrettyPrint(prettyPrint);
    }

    @Override
    public ListTrails setQuotaUser(java.lang.String quotaUser) {
      return (ListTrails) super.setQuotaUser(quotaUser);
    }

    @Override
    public ListTrails setUserIp(java.lang.String userIp) {
      return (ListTrails) super.setUserIp(userIp);
    }

    @com.google.api.client.util.Key
    private java.lang.String cursor;

    /**

     */
    public java.lang.String getCursor() {
      return cursor;
    }

    public ListTrails setCursor(java.lang.String cursor) {
      this.cursor = cursor;
      return this;
    }

    @com.google.api.client.util.Key
    private java.lang.Integer limit;

    /**

     */
    public java.lang.Integer getLimit() {
      return limit;
    }

    public ListTrails setLimit(java.lang.Integer limit) {
      this.limit = limit;
      return this;
    }

    @Override
    public ListTrails set(String parameterName, Object value) {
      return (ListTrails) super.set(parameterName, value);
    }
  }

  /**
   * Create a request for the method "removeTrails".
   *
   * This request holds the parameters needed by the the trailsendpoint server.  After setting any
   * optional parameters, call the {@link RemoveTrails#execute()} method to invoke the remote
   * operation.
   *
   * @param id
   * @return the request
   */
  public RemoveTrails removeTrails(java.lang.String id) throws java.io.IOException {
    RemoveTrails result = new RemoveTrails(id);
    initialize(result);
    return result;
  }

  public class RemoveTrails extends TrailsendpointRequest<Void> {

    private static final String REST_PATH = "trails/{id}";

    /**
     * Create a request for the method "removeTrails".
     *
     * This request holds the parameters needed by the the trailsendpoint server.  After setting any
     * optional parameters, call the {@link RemoveTrails#execute()} method to invoke the remote
     * operation. <p> {@link
     * RemoveTrails#initialize(com.google.api.client.googleapis.services.AbstractGoogleClientRequest)}
     * must be called to initialize this instance immediately after invoking the constructor. </p>
     *
     * @param id
     * @since 1.13
     */
    protected RemoveTrails(java.lang.String id) {
      super(Trailsendpoint.this, "DELETE", REST_PATH, null, Void.class);
      this.id = com.google.api.client.util.Preconditions.checkNotNull(id, "Required parameter id must be specified.");
    }

    @Override
    public RemoveTrails setAlt(java.lang.String alt) {
      return (RemoveTrails) super.setAlt(alt);
    }

    @Override
    public RemoveTrails setFields(java.lang.String fields) {
      return (RemoveTrails) super.setFields(fields);
    }

    @Override
    public RemoveTrails setKey(java.lang.String key) {
      return (RemoveTrails) super.setKey(key);
    }

    @Override
    public RemoveTrails setOauthToken(java.lang.String oauthToken) {
      return (RemoveTrails) super.setOauthToken(oauthToken);
    }

    @Override
    public RemoveTrails setPrettyPrint(java.lang.Boolean prettyPrint) {
      return (RemoveTrails) super.setPrettyPrint(prettyPrint);
    }

    @Override
    public RemoveTrails setQuotaUser(java.lang.String quotaUser) {
      return (RemoveTrails) super.setQuotaUser(quotaUser);
    }

    @Override
    public RemoveTrails setUserIp(java.lang.String userIp) {
      return (RemoveTrails) super.setUserIp(userIp);
    }

    @com.google.api.client.util.Key
    private java.lang.String id;

    /**

     */
    public java.lang.String getId() {
      return id;
    }

    public RemoveTrails setId(java.lang.String id) {
      this.id = id;
      return this;
    }

    @Override
    public RemoveTrails set(String parameterName, Object value) {
      return (RemoveTrails) super.set(parameterName, value);
    }
  }

  /**
   * Create a request for the method "updateTrails".
   *
   * This request holds the parameters needed by the the trailsendpoint server.  After setting any
   * optional parameters, call the {@link UpdateTrails#execute()} method to invoke the remote
   * operation.
   *
   * @param content the {@link edu.vt.bmac.gpstracker.trailsendpoint.model.Trails}
   * @return the request
   */
  public UpdateTrails updateTrails(edu.vt.bmac.gpstracker.trailsendpoint.model.Trails content) throws java.io.IOException {
    UpdateTrails result = new UpdateTrails(content);
    initialize(result);
    return result;
  }

  public class UpdateTrails extends TrailsendpointRequest<edu.vt.bmac.gpstracker.trailsendpoint.model.Trails> {

    private static final String REST_PATH = "trails";

    /**
     * Create a request for the method "updateTrails".
     *
     * This request holds the parameters needed by the the trailsendpoint server.  After setting any
     * optional parameters, call the {@link UpdateTrails#execute()} method to invoke the remote
     * operation. <p> {@link
     * UpdateTrails#initialize(com.google.api.client.googleapis.services.AbstractGoogleClientRequest)}
     * must be called to initialize this instance immediately after invoking the constructor. </p>
     *
     * @param content the {@link edu.vt.bmac.gpstracker.trailsendpoint.model.Trails}
     * @since 1.13
     */
    protected UpdateTrails(edu.vt.bmac.gpstracker.trailsendpoint.model.Trails content) {
      super(Trailsendpoint.this, "PUT", REST_PATH, content, edu.vt.bmac.gpstracker.trailsendpoint.model.Trails.class);
    }

    @Override
    public UpdateTrails setAlt(java.lang.String alt) {
      return (UpdateTrails) super.setAlt(alt);
    }

    @Override
    public UpdateTrails setFields(java.lang.String fields) {
      return (UpdateTrails) super.setFields(fields);
    }

    @Override
    public UpdateTrails setKey(java.lang.String key) {
      return (UpdateTrails) super.setKey(key);
    }

    @Override
    public UpdateTrails setOauthToken(java.lang.String oauthToken) {
      return (UpdateTrails) super.setOauthToken(oauthToken);
    }

    @Override
    public UpdateTrails setPrettyPrint(java.lang.Boolean prettyPrint) {
      return (UpdateTrails) super.setPrettyPrint(prettyPrint);
    }

    @Override
    public UpdateTrails setQuotaUser(java.lang.String quotaUser) {
      return (UpdateTrails) super.setQuotaUser(quotaUser);
    }

    @Override
    public UpdateTrails setUserIp(java.lang.String userIp) {
      return (UpdateTrails) super.setUserIp(userIp);
    }

    @Override
    public UpdateTrails set(String parameterName, Object value) {
      return (UpdateTrails) super.set(parameterName, value);
    }
  }

  /**
   * Builder for {@link Trailsendpoint}.
   *
   * <p>
   * Implementation is not thread-safe.
   * </p>
   *
   * @since 1.3.0
   */
  public static final class Builder extends com.google.api.client.googleapis.services.json.AbstractGoogleJsonClient.Builder {

    /**
     * Returns an instance of a new builder.
     *
     * @param transport HTTP transport, which should normally be:
     *        <ul>
     *        <li>Google App Engine:
     *        {@code com.google.api.client.extensions.appengine.http.UrlFetchTransport}</li>
     *        <li>Android: {@code newCompatibleTransport} from
     *        {@code com.google.api.client.extensions.android.http.AndroidHttp}</li>
     *        <li>Java: {@link com.google.api.client.googleapis.javanet.GoogleNetHttpTransport#newTrustedTransport()}
     *        </li>
     *        </ul>
     * @param jsonFactory JSON factory, which may be:
     *        <ul>
     *        <li>Jackson: {@code com.google.api.client.json.jackson2.JacksonFactory}</li>
     *        <li>Google GSON: {@code com.google.api.client.json.gson.GsonFactory}</li>
     *        <li>Android Honeycomb or higher:
     *        {@code com.google.api.client.extensions.android.json.AndroidJsonFactory}</li>
     *        </ul>
     * @param httpRequestInitializer HTTP request initializer or {@code null} for none
     * @since 1.7
     */
    public Builder(com.google.api.client.http.HttpTransport transport, com.google.api.client.json.JsonFactory jsonFactory,
        com.google.api.client.http.HttpRequestInitializer httpRequestInitializer) {
      super(
          transport,
          jsonFactory,
          DEFAULT_ROOT_URL,
          DEFAULT_SERVICE_PATH,
          httpRequestInitializer,
          false);
    }

    /** Builds a new instance of {@link Trailsendpoint}. */
    @Override
    public Trailsendpoint build() {
      return new Trailsendpoint(this);
    }

    @Override
    public Builder setRootUrl(String rootUrl) {
      return (Builder) super.setRootUrl(rootUrl);
    }

    @Override
    public Builder setServicePath(String servicePath) {
      return (Builder) super.setServicePath(servicePath);
    }

    @Override
    public Builder setHttpRequestInitializer(com.google.api.client.http.HttpRequestInitializer httpRequestInitializer) {
      return (Builder) super.setHttpRequestInitializer(httpRequestInitializer);
    }

    @Override
    public Builder setApplicationName(String applicationName) {
      return (Builder) super.setApplicationName(applicationName);
    }

    @Override
    public Builder setSuppressPatternChecks(boolean suppressPatternChecks) {
      return (Builder) super.setSuppressPatternChecks(suppressPatternChecks);
    }

    @Override
    public Builder setSuppressRequiredParameterChecks(boolean suppressRequiredParameterChecks) {
      return (Builder) super.setSuppressRequiredParameterChecks(suppressRequiredParameterChecks);
    }

    @Override
    public Builder setSuppressAllChecks(boolean suppressAllChecks) {
      return (Builder) super.setSuppressAllChecks(suppressAllChecks);
    }

    /**
     * Set the {@link TrailsendpointRequestInitializer}.
     *
     * @since 1.12
     */
    public Builder setTrailsendpointRequestInitializer(
        TrailsendpointRequestInitializer trailsendpointRequestInitializer) {
      return (Builder) super.setGoogleClientRequestInitializer(trailsendpointRequestInitializer);
    }

    @Override
    public Builder setGoogleClientRequestInitializer(
        com.google.api.client.googleapis.services.GoogleClientRequestInitializer googleClientRequestInitializer) {
      return (Builder) super.setGoogleClientRequestInitializer(googleClientRequestInitializer);
    }
  }
}
