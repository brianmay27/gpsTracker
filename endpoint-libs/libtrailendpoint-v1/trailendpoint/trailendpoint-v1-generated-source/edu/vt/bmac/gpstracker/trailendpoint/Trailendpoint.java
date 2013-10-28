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
 * on 2013-10-28 at 02:14:01 UTC 
 * Modify at your own risk.
 */

package edu.vt.bmac.gpstracker.trailendpoint;

/**
 * Service definition for Trailendpoint (v1).
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
 * This service uses {@link TrailendpointRequestInitializer} to initialize global parameters via its
 * {@link Builder}.
 * </p>
 *
 * @since 1.3
 * @author Google, Inc.
 */
@SuppressWarnings("javadoc")
public class Trailendpoint extends com.google.api.client.googleapis.services.json.AbstractGoogleJsonClient {

  // Note: Leave this static initializer at the top of the file.
  static {
    com.google.api.client.util.Preconditions.checkState(
        com.google.api.client.googleapis.GoogleUtils.MAJOR_VERSION == 1 &&
        com.google.api.client.googleapis.GoogleUtils.MINOR_VERSION >= 15,
        "You are currently running with version %s of google-api-client. " +
        "You need at least version 1.15 of google-api-client to run version " +
        "1.16.0-rc of the trailendpoint library.", com.google.api.client.googleapis.GoogleUtils.VERSION);
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
  public static final String DEFAULT_SERVICE_PATH = "trailendpoint/v1/";

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
  public Trailendpoint(com.google.api.client.http.HttpTransport transport, com.google.api.client.json.JsonFactory jsonFactory,
      com.google.api.client.http.HttpRequestInitializer httpRequestInitializer) {
    this(new Builder(transport, jsonFactory, httpRequestInitializer));
  }

  /**
   * @param builder builder
   */
  Trailendpoint(Builder builder) {
    super(builder);
  }

  @Override
  protected void initialize(com.google.api.client.googleapis.services.AbstractGoogleClientRequest<?> httpClientRequest) throws java.io.IOException {
    super.initialize(httpClientRequest);
  }

  /**
   * Create a request for the method "getTrail".
   *
   * This request holds the parameters needed by the the trailendpoint server.  After setting any
   * optional parameters, call the {@link GetTrail#execute()} method to invoke the remote operation.
   *
   * @param id
   * @return the request
   */
  public GetTrail getTrail(java.lang.String id) throws java.io.IOException {
    GetTrail result = new GetTrail(id);
    initialize(result);
    return result;
  }

  public class GetTrail extends TrailendpointRequest<edu.vt.bmac.gpstracker.trailendpoint.model.Trail> {

    private static final String REST_PATH = "trail/{id}";

    /**
     * Create a request for the method "getTrail".
     *
     * This request holds the parameters needed by the the trailendpoint server.  After setting any
     * optional parameters, call the {@link GetTrail#execute()} method to invoke the remote operation.
     * <p> {@link
     * GetTrail#initialize(com.google.api.client.googleapis.services.AbstractGoogleClientRequest)}
     * must be called to initialize this instance immediately after invoking the constructor. </p>
     *
     * @param id
     * @since 1.13
     */
    protected GetTrail(java.lang.String id) {
      super(Trailendpoint.this, "GET", REST_PATH, null, edu.vt.bmac.gpstracker.trailendpoint.model.Trail.class);
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
    public GetTrail setAlt(java.lang.String alt) {
      return (GetTrail) super.setAlt(alt);
    }

    @Override
    public GetTrail setFields(java.lang.String fields) {
      return (GetTrail) super.setFields(fields);
    }

    @Override
    public GetTrail setKey(java.lang.String key) {
      return (GetTrail) super.setKey(key);
    }

    @Override
    public GetTrail setOauthToken(java.lang.String oauthToken) {
      return (GetTrail) super.setOauthToken(oauthToken);
    }

    @Override
    public GetTrail setPrettyPrint(java.lang.Boolean prettyPrint) {
      return (GetTrail) super.setPrettyPrint(prettyPrint);
    }

    @Override
    public GetTrail setQuotaUser(java.lang.String quotaUser) {
      return (GetTrail) super.setQuotaUser(quotaUser);
    }

    @Override
    public GetTrail setUserIp(java.lang.String userIp) {
      return (GetTrail) super.setUserIp(userIp);
    }

    @com.google.api.client.util.Key
    private java.lang.String id;

    /**

     */
    public java.lang.String getId() {
      return id;
    }

    public GetTrail setId(java.lang.String id) {
      this.id = id;
      return this;
    }

    @Override
    public GetTrail set(String parameterName, Object value) {
      return (GetTrail) super.set(parameterName, value);
    }
  }

  /**
   * Create a request for the method "insertTrail".
   *
   * This request holds the parameters needed by the the trailendpoint server.  After setting any
   * optional parameters, call the {@link InsertTrail#execute()} method to invoke the remote
   * operation.
   *
   * @param content the {@link edu.vt.bmac.gpstracker.trailendpoint.model.Trail}
   * @return the request
   */
  public InsertTrail insertTrail(edu.vt.bmac.gpstracker.trailendpoint.model.Trail content) throws java.io.IOException {
    InsertTrail result = new InsertTrail(content);
    initialize(result);
    return result;
  }

  public class InsertTrail extends TrailendpointRequest<edu.vt.bmac.gpstracker.trailendpoint.model.Trail> {

    private static final String REST_PATH = "trail";

    /**
     * Create a request for the method "insertTrail".
     *
     * This request holds the parameters needed by the the trailendpoint server.  After setting any
     * optional parameters, call the {@link InsertTrail#execute()} method to invoke the remote
     * operation. <p> {@link
     * InsertTrail#initialize(com.google.api.client.googleapis.services.AbstractGoogleClientRequest)}
     * must be called to initialize this instance immediately after invoking the constructor. </p>
     *
     * @param content the {@link edu.vt.bmac.gpstracker.trailendpoint.model.Trail}
     * @since 1.13
     */
    protected InsertTrail(edu.vt.bmac.gpstracker.trailendpoint.model.Trail content) {
      super(Trailendpoint.this, "POST", REST_PATH, content, edu.vt.bmac.gpstracker.trailendpoint.model.Trail.class);
    }

    @Override
    public InsertTrail setAlt(java.lang.String alt) {
      return (InsertTrail) super.setAlt(alt);
    }

    @Override
    public InsertTrail setFields(java.lang.String fields) {
      return (InsertTrail) super.setFields(fields);
    }

    @Override
    public InsertTrail setKey(java.lang.String key) {
      return (InsertTrail) super.setKey(key);
    }

    @Override
    public InsertTrail setOauthToken(java.lang.String oauthToken) {
      return (InsertTrail) super.setOauthToken(oauthToken);
    }

    @Override
    public InsertTrail setPrettyPrint(java.lang.Boolean prettyPrint) {
      return (InsertTrail) super.setPrettyPrint(prettyPrint);
    }

    @Override
    public InsertTrail setQuotaUser(java.lang.String quotaUser) {
      return (InsertTrail) super.setQuotaUser(quotaUser);
    }

    @Override
    public InsertTrail setUserIp(java.lang.String userIp) {
      return (InsertTrail) super.setUserIp(userIp);
    }

    @Override
    public InsertTrail set(String parameterName, Object value) {
      return (InsertTrail) super.set(parameterName, value);
    }
  }

  /**
   * Create a request for the method "listTrail".
   *
   * This request holds the parameters needed by the the trailendpoint server.  After setting any
   * optional parameters, call the {@link ListTrail#execute()} method to invoke the remote operation.
   *
   * @return the request
   */
  public ListTrail listTrail() throws java.io.IOException {
    ListTrail result = new ListTrail();
    initialize(result);
    return result;
  }

  public class ListTrail extends TrailendpointRequest<edu.vt.bmac.gpstracker.trailendpoint.model.CollectionResponseTrail> {

    private static final String REST_PATH = "trail";

    /**
     * Create a request for the method "listTrail".
     *
     * This request holds the parameters needed by the the trailendpoint server.  After setting any
     * optional parameters, call the {@link ListTrail#execute()} method to invoke the remote
     * operation. <p> {@link
     * ListTrail#initialize(com.google.api.client.googleapis.services.AbstractGoogleClientRequest)}
     * must be called to initialize this instance immediately after invoking the constructor. </p>
     *
     * @since 1.13
     */
    protected ListTrail() {
      super(Trailendpoint.this, "GET", REST_PATH, null, edu.vt.bmac.gpstracker.trailendpoint.model.CollectionResponseTrail.class);
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
    public ListTrail setAlt(java.lang.String alt) {
      return (ListTrail) super.setAlt(alt);
    }

    @Override
    public ListTrail setFields(java.lang.String fields) {
      return (ListTrail) super.setFields(fields);
    }

    @Override
    public ListTrail setKey(java.lang.String key) {
      return (ListTrail) super.setKey(key);
    }

    @Override
    public ListTrail setOauthToken(java.lang.String oauthToken) {
      return (ListTrail) super.setOauthToken(oauthToken);
    }

    @Override
    public ListTrail setPrettyPrint(java.lang.Boolean prettyPrint) {
      return (ListTrail) super.setPrettyPrint(prettyPrint);
    }

    @Override
    public ListTrail setQuotaUser(java.lang.String quotaUser) {
      return (ListTrail) super.setQuotaUser(quotaUser);
    }

    @Override
    public ListTrail setUserIp(java.lang.String userIp) {
      return (ListTrail) super.setUserIp(userIp);
    }

    @com.google.api.client.util.Key
    private java.lang.String cursor;

    /**

     */
    public java.lang.String getCursor() {
      return cursor;
    }

    public ListTrail setCursor(java.lang.String cursor) {
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

    public ListTrail setLimit(java.lang.Integer limit) {
      this.limit = limit;
      return this;
    }

    @Override
    public ListTrail set(String parameterName, Object value) {
      return (ListTrail) super.set(parameterName, value);
    }
  }

  /**
   * Create a request for the method "removeTrail".
   *
   * This request holds the parameters needed by the the trailendpoint server.  After setting any
   * optional parameters, call the {@link RemoveTrail#execute()} method to invoke the remote
   * operation.
   *
   * @param id
   * @return the request
   */
  public RemoveTrail removeTrail(java.lang.String id) throws java.io.IOException {
    RemoveTrail result = new RemoveTrail(id);
    initialize(result);
    return result;
  }

  public class RemoveTrail extends TrailendpointRequest<Void> {

    private static final String REST_PATH = "trail/{id}";

    /**
     * Create a request for the method "removeTrail".
     *
     * This request holds the parameters needed by the the trailendpoint server.  After setting any
     * optional parameters, call the {@link RemoveTrail#execute()} method to invoke the remote
     * operation. <p> {@link
     * RemoveTrail#initialize(com.google.api.client.googleapis.services.AbstractGoogleClientRequest)}
     * must be called to initialize this instance immediately after invoking the constructor. </p>
     *
     * @param id
     * @since 1.13
     */
    protected RemoveTrail(java.lang.String id) {
      super(Trailendpoint.this, "DELETE", REST_PATH, null, Void.class);
      this.id = com.google.api.client.util.Preconditions.checkNotNull(id, "Required parameter id must be specified.");
    }

    @Override
    public RemoveTrail setAlt(java.lang.String alt) {
      return (RemoveTrail) super.setAlt(alt);
    }

    @Override
    public RemoveTrail setFields(java.lang.String fields) {
      return (RemoveTrail) super.setFields(fields);
    }

    @Override
    public RemoveTrail setKey(java.lang.String key) {
      return (RemoveTrail) super.setKey(key);
    }

    @Override
    public RemoveTrail setOauthToken(java.lang.String oauthToken) {
      return (RemoveTrail) super.setOauthToken(oauthToken);
    }

    @Override
    public RemoveTrail setPrettyPrint(java.lang.Boolean prettyPrint) {
      return (RemoveTrail) super.setPrettyPrint(prettyPrint);
    }

    @Override
    public RemoveTrail setQuotaUser(java.lang.String quotaUser) {
      return (RemoveTrail) super.setQuotaUser(quotaUser);
    }

    @Override
    public RemoveTrail setUserIp(java.lang.String userIp) {
      return (RemoveTrail) super.setUserIp(userIp);
    }

    @com.google.api.client.util.Key
    private java.lang.String id;

    /**

     */
    public java.lang.String getId() {
      return id;
    }

    public RemoveTrail setId(java.lang.String id) {
      this.id = id;
      return this;
    }

    @Override
    public RemoveTrail set(String parameterName, Object value) {
      return (RemoveTrail) super.set(parameterName, value);
    }
  }

  /**
   * Create a request for the method "updateTrail".
   *
   * This request holds the parameters needed by the the trailendpoint server.  After setting any
   * optional parameters, call the {@link UpdateTrail#execute()} method to invoke the remote
   * operation.
   *
   * @param content the {@link edu.vt.bmac.gpstracker.trailendpoint.model.Trail}
   * @return the request
   */
  public UpdateTrail updateTrail(edu.vt.bmac.gpstracker.trailendpoint.model.Trail content) throws java.io.IOException {
    UpdateTrail result = new UpdateTrail(content);
    initialize(result);
    return result;
  }

  public class UpdateTrail extends TrailendpointRequest<edu.vt.bmac.gpstracker.trailendpoint.model.Trail> {

    private static final String REST_PATH = "trail";

    /**
     * Create a request for the method "updateTrail".
     *
     * This request holds the parameters needed by the the trailendpoint server.  After setting any
     * optional parameters, call the {@link UpdateTrail#execute()} method to invoke the remote
     * operation. <p> {@link
     * UpdateTrail#initialize(com.google.api.client.googleapis.services.AbstractGoogleClientRequest)}
     * must be called to initialize this instance immediately after invoking the constructor. </p>
     *
     * @param content the {@link edu.vt.bmac.gpstracker.trailendpoint.model.Trail}
     * @since 1.13
     */
    protected UpdateTrail(edu.vt.bmac.gpstracker.trailendpoint.model.Trail content) {
      super(Trailendpoint.this, "PUT", REST_PATH, content, edu.vt.bmac.gpstracker.trailendpoint.model.Trail.class);
    }

    @Override
    public UpdateTrail setAlt(java.lang.String alt) {
      return (UpdateTrail) super.setAlt(alt);
    }

    @Override
    public UpdateTrail setFields(java.lang.String fields) {
      return (UpdateTrail) super.setFields(fields);
    }

    @Override
    public UpdateTrail setKey(java.lang.String key) {
      return (UpdateTrail) super.setKey(key);
    }

    @Override
    public UpdateTrail setOauthToken(java.lang.String oauthToken) {
      return (UpdateTrail) super.setOauthToken(oauthToken);
    }

    @Override
    public UpdateTrail setPrettyPrint(java.lang.Boolean prettyPrint) {
      return (UpdateTrail) super.setPrettyPrint(prettyPrint);
    }

    @Override
    public UpdateTrail setQuotaUser(java.lang.String quotaUser) {
      return (UpdateTrail) super.setQuotaUser(quotaUser);
    }

    @Override
    public UpdateTrail setUserIp(java.lang.String userIp) {
      return (UpdateTrail) super.setUserIp(userIp);
    }

    @Override
    public UpdateTrail set(String parameterName, Object value) {
      return (UpdateTrail) super.set(parameterName, value);
    }
  }

  /**
   * Builder for {@link Trailendpoint}.
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

    /** Builds a new instance of {@link Trailendpoint}. */
    @Override
    public Trailendpoint build() {
      return new Trailendpoint(this);
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
     * Set the {@link TrailendpointRequestInitializer}.
     *
     * @since 1.12
     */
    public Builder setTrailendpointRequestInitializer(
        TrailendpointRequestInitializer trailendpointRequestInitializer) {
      return (Builder) super.setGoogleClientRequestInitializer(trailendpointRequestInitializer);
    }

    @Override
    public Builder setGoogleClientRequestInitializer(
        com.google.api.client.googleapis.services.GoogleClientRequestInitializer googleClientRequestInitializer) {
      return (Builder) super.setGoogleClientRequestInitializer(googleClientRequestInitializer);
    }
  }
}