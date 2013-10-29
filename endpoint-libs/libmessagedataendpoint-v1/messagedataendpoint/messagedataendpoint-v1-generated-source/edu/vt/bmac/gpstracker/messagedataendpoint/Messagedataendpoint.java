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
 * on 2013-10-28 at 09:45:45 UTC 
 * Modify at your own risk.
 */

package edu.vt.bmac.gpstracker.messagedataendpoint;

/**
 * Service definition for Messagedataendpoint (v1).
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
 * This service uses {@link MessagedataendpointRequestInitializer} to initialize global parameters via its
 * {@link Builder}.
 * </p>
 *
 * @since 1.3
 * @author Google, Inc.
 */
@SuppressWarnings("javadoc")
public class Messagedataendpoint extends com.google.api.client.googleapis.services.json.AbstractGoogleJsonClient {

  // Note: Leave this static initializer at the top of the file.
  static {
    com.google.api.client.util.Preconditions.checkState(
        com.google.api.client.googleapis.GoogleUtils.MAJOR_VERSION == 1 &&
        com.google.api.client.googleapis.GoogleUtils.MINOR_VERSION >= 15,
        "You are currently running with version %s of google-api-client. " +
        "You need at least version 1.15 of google-api-client to run version " +
        "1.16.0-rc of the messagedataendpoint library.", com.google.api.client.googleapis.GoogleUtils.VERSION);
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
  public static final String DEFAULT_SERVICE_PATH = "messagedataendpoint/v1/";

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
  public Messagedataendpoint(com.google.api.client.http.HttpTransport transport, com.google.api.client.json.JsonFactory jsonFactory,
      com.google.api.client.http.HttpRequestInitializer httpRequestInitializer) {
    this(new Builder(transport, jsonFactory, httpRequestInitializer));
  }

  /**
   * @param builder builder
   */
  Messagedataendpoint(Builder builder) {
    super(builder);
  }

  @Override
  protected void initialize(com.google.api.client.googleapis.services.AbstractGoogleClientRequest<?> httpClientRequest) throws java.io.IOException {
    super.initialize(httpClientRequest);
  }

  /**
   * Create a request for the method "getMessageData".
   *
   * This request holds the parameters needed by the the messagedataendpoint server.  After setting
   * any optional parameters, call the {@link GetMessageData#execute()} method to invoke the remote
   * operation.
   *
   * @param id
   * @return the request
   */
  public GetMessageData getMessageData(java.lang.Long id) throws java.io.IOException {
    GetMessageData result = new GetMessageData(id);
    initialize(result);
    return result;
  }

  public class GetMessageData extends MessagedataendpointRequest<edu.vt.bmac.gpstracker.messagedataendpoint.model.MessageData> {

    private static final String REST_PATH = "messagedata/{id}";

    /**
     * Create a request for the method "getMessageData".
     *
     * This request holds the parameters needed by the the messagedataendpoint server.  After setting
     * any optional parameters, call the {@link GetMessageData#execute()} method to invoke the remote
     * operation. <p> {@link GetMessageData#initialize(com.google.api.client.googleapis.services.Abstr
     * actGoogleClientRequest)} must be called to initialize this instance immediately after invoking
     * the constructor. </p>
     *
     * @param id
     * @since 1.13
     */
    protected GetMessageData(java.lang.Long id) {
      super(Messagedataendpoint.this, "GET", REST_PATH, null, edu.vt.bmac.gpstracker.messagedataendpoint.model.MessageData.class);
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
    public GetMessageData setAlt(java.lang.String alt) {
      return (GetMessageData) super.setAlt(alt);
    }

    @Override
    public GetMessageData setFields(java.lang.String fields) {
      return (GetMessageData) super.setFields(fields);
    }

    @Override
    public GetMessageData setKey(java.lang.String key) {
      return (GetMessageData) super.setKey(key);
    }

    @Override
    public GetMessageData setOauthToken(java.lang.String oauthToken) {
      return (GetMessageData) super.setOauthToken(oauthToken);
    }

    @Override
    public GetMessageData setPrettyPrint(java.lang.Boolean prettyPrint) {
      return (GetMessageData) super.setPrettyPrint(prettyPrint);
    }

    @Override
    public GetMessageData setQuotaUser(java.lang.String quotaUser) {
      return (GetMessageData) super.setQuotaUser(quotaUser);
    }

    @Override
    public GetMessageData setUserIp(java.lang.String userIp) {
      return (GetMessageData) super.setUserIp(userIp);
    }

    @com.google.api.client.util.Key
    private java.lang.Long id;

    /**

     */
    public java.lang.Long getId() {
      return id;
    }

    public GetMessageData setId(java.lang.Long id) {
      this.id = id;
      return this;
    }

    @Override
    public GetMessageData set(String parameterName, Object value) {
      return (GetMessageData) super.set(parameterName, value);
    }
  }

  /**
   * Create a request for the method "insertMessageData".
   *
   * This request holds the parameters needed by the the messagedataendpoint server.  After setting
   * any optional parameters, call the {@link InsertMessageData#execute()} method to invoke the remote
   * operation.
   *
   * @param content the {@link edu.vt.bmac.gpstracker.messagedataendpoint.model.MessageData}
   * @return the request
   */
  public InsertMessageData insertMessageData(edu.vt.bmac.gpstracker.messagedataendpoint.model.MessageData content) throws java.io.IOException {
    InsertMessageData result = new InsertMessageData(content);
    initialize(result);
    return result;
  }

  public class InsertMessageData extends MessagedataendpointRequest<edu.vt.bmac.gpstracker.messagedataendpoint.model.MessageData> {

    private static final String REST_PATH = "messagedata";

    /**
     * Create a request for the method "insertMessageData".
     *
     * This request holds the parameters needed by the the messagedataendpoint server.  After setting
     * any optional parameters, call the {@link InsertMessageData#execute()} method to invoke the
     * remote operation. <p> {@link InsertMessageData#initialize(com.google.api.client.googleapis.serv
     * ices.AbstractGoogleClientRequest)} must be called to initialize this instance immediately after
     * invoking the constructor. </p>
     *
     * @param content the {@link edu.vt.bmac.gpstracker.messagedataendpoint.model.MessageData}
     * @since 1.13
     */
    protected InsertMessageData(edu.vt.bmac.gpstracker.messagedataendpoint.model.MessageData content) {
      super(Messagedataendpoint.this, "POST", REST_PATH, content, edu.vt.bmac.gpstracker.messagedataendpoint.model.MessageData.class);
    }

    @Override
    public InsertMessageData setAlt(java.lang.String alt) {
      return (InsertMessageData) super.setAlt(alt);
    }

    @Override
    public InsertMessageData setFields(java.lang.String fields) {
      return (InsertMessageData) super.setFields(fields);
    }

    @Override
    public InsertMessageData setKey(java.lang.String key) {
      return (InsertMessageData) super.setKey(key);
    }

    @Override
    public InsertMessageData setOauthToken(java.lang.String oauthToken) {
      return (InsertMessageData) super.setOauthToken(oauthToken);
    }

    @Override
    public InsertMessageData setPrettyPrint(java.lang.Boolean prettyPrint) {
      return (InsertMessageData) super.setPrettyPrint(prettyPrint);
    }

    @Override
    public InsertMessageData setQuotaUser(java.lang.String quotaUser) {
      return (InsertMessageData) super.setQuotaUser(quotaUser);
    }

    @Override
    public InsertMessageData setUserIp(java.lang.String userIp) {
      return (InsertMessageData) super.setUserIp(userIp);
    }

    @Override
    public InsertMessageData set(String parameterName, Object value) {
      return (InsertMessageData) super.set(parameterName, value);
    }
  }

  /**
   * Create a request for the method "listMessageData".
   *
   * This request holds the parameters needed by the the messagedataendpoint server.  After setting
   * any optional parameters, call the {@link ListMessageData#execute()} method to invoke the remote
   * operation.
   *
   * @return the request
   */
  public ListMessageData listMessageData() throws java.io.IOException {
    ListMessageData result = new ListMessageData();
    initialize(result);
    return result;
  }

  public class ListMessageData extends MessagedataendpointRequest<edu.vt.bmac.gpstracker.messagedataendpoint.model.CollectionResponseMessageData> {

    private static final String REST_PATH = "messagedata";

    /**
     * Create a request for the method "listMessageData".
     *
     * This request holds the parameters needed by the the messagedataendpoint server.  After setting
     * any optional parameters, call the {@link ListMessageData#execute()} method to invoke the remote
     * operation. <p> {@link ListMessageData#initialize(com.google.api.client.googleapis.services.Abst
     * ractGoogleClientRequest)} must be called to initialize this instance immediately after invoking
     * the constructor. </p>
     *
     * @since 1.13
     */
    protected ListMessageData() {
      super(Messagedataendpoint.this, "GET", REST_PATH, null, edu.vt.bmac.gpstracker.messagedataendpoint.model.CollectionResponseMessageData.class);
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
    public ListMessageData setAlt(java.lang.String alt) {
      return (ListMessageData) super.setAlt(alt);
    }

    @Override
    public ListMessageData setFields(java.lang.String fields) {
      return (ListMessageData) super.setFields(fields);
    }

    @Override
    public ListMessageData setKey(java.lang.String key) {
      return (ListMessageData) super.setKey(key);
    }

    @Override
    public ListMessageData setOauthToken(java.lang.String oauthToken) {
      return (ListMessageData) super.setOauthToken(oauthToken);
    }

    @Override
    public ListMessageData setPrettyPrint(java.lang.Boolean prettyPrint) {
      return (ListMessageData) super.setPrettyPrint(prettyPrint);
    }

    @Override
    public ListMessageData setQuotaUser(java.lang.String quotaUser) {
      return (ListMessageData) super.setQuotaUser(quotaUser);
    }

    @Override
    public ListMessageData setUserIp(java.lang.String userIp) {
      return (ListMessageData) super.setUserIp(userIp);
    }

    @com.google.api.client.util.Key
    private java.lang.String cursor;

    /**

     */
    public java.lang.String getCursor() {
      return cursor;
    }

    public ListMessageData setCursor(java.lang.String cursor) {
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

    public ListMessageData setLimit(java.lang.Integer limit) {
      this.limit = limit;
      return this;
    }

    @Override
    public ListMessageData set(String parameterName, Object value) {
      return (ListMessageData) super.set(parameterName, value);
    }
  }

  /**
   * Create a request for the method "removeMessageData".
   *
   * This request holds the parameters needed by the the messagedataendpoint server.  After setting
   * any optional parameters, call the {@link RemoveMessageData#execute()} method to invoke the remote
   * operation.
   *
   * @param id
   * @return the request
   */
  public RemoveMessageData removeMessageData(java.lang.Long id) throws java.io.IOException {
    RemoveMessageData result = new RemoveMessageData(id);
    initialize(result);
    return result;
  }

  public class RemoveMessageData extends MessagedataendpointRequest<Void> {

    private static final String REST_PATH = "messagedata/{id}";

    /**
     * Create a request for the method "removeMessageData".
     *
     * This request holds the parameters needed by the the messagedataendpoint server.  After setting
     * any optional parameters, call the {@link RemoveMessageData#execute()} method to invoke the
     * remote operation. <p> {@link RemoveMessageData#initialize(com.google.api.client.googleapis.serv
     * ices.AbstractGoogleClientRequest)} must be called to initialize this instance immediately after
     * invoking the constructor. </p>
     *
     * @param id
     * @since 1.13
     */
    protected RemoveMessageData(java.lang.Long id) {
      super(Messagedataendpoint.this, "DELETE", REST_PATH, null, Void.class);
      this.id = com.google.api.client.util.Preconditions.checkNotNull(id, "Required parameter id must be specified.");
    }

    @Override
    public RemoveMessageData setAlt(java.lang.String alt) {
      return (RemoveMessageData) super.setAlt(alt);
    }

    @Override
    public RemoveMessageData setFields(java.lang.String fields) {
      return (RemoveMessageData) super.setFields(fields);
    }

    @Override
    public RemoveMessageData setKey(java.lang.String key) {
      return (RemoveMessageData) super.setKey(key);
    }

    @Override
    public RemoveMessageData setOauthToken(java.lang.String oauthToken) {
      return (RemoveMessageData) super.setOauthToken(oauthToken);
    }

    @Override
    public RemoveMessageData setPrettyPrint(java.lang.Boolean prettyPrint) {
      return (RemoveMessageData) super.setPrettyPrint(prettyPrint);
    }

    @Override
    public RemoveMessageData setQuotaUser(java.lang.String quotaUser) {
      return (RemoveMessageData) super.setQuotaUser(quotaUser);
    }

    @Override
    public RemoveMessageData setUserIp(java.lang.String userIp) {
      return (RemoveMessageData) super.setUserIp(userIp);
    }

    @com.google.api.client.util.Key
    private java.lang.Long id;

    /**

     */
    public java.lang.Long getId() {
      return id;
    }

    public RemoveMessageData setId(java.lang.Long id) {
      this.id = id;
      return this;
    }

    @Override
    public RemoveMessageData set(String parameterName, Object value) {
      return (RemoveMessageData) super.set(parameterName, value);
    }
  }

  /**
   * Create a request for the method "updateMessageData".
   *
   * This request holds the parameters needed by the the messagedataendpoint server.  After setting
   * any optional parameters, call the {@link UpdateMessageData#execute()} method to invoke the remote
   * operation.
   *
   * @param content the {@link edu.vt.bmac.gpstracker.messagedataendpoint.model.MessageData}
   * @return the request
   */
  public UpdateMessageData updateMessageData(edu.vt.bmac.gpstracker.messagedataendpoint.model.MessageData content) throws java.io.IOException {
    UpdateMessageData result = new UpdateMessageData(content);
    initialize(result);
    return result;
  }

  public class UpdateMessageData extends MessagedataendpointRequest<edu.vt.bmac.gpstracker.messagedataendpoint.model.MessageData> {

    private static final String REST_PATH = "messagedata";

    /**
     * Create a request for the method "updateMessageData".
     *
     * This request holds the parameters needed by the the messagedataendpoint server.  After setting
     * any optional parameters, call the {@link UpdateMessageData#execute()} method to invoke the
     * remote operation. <p> {@link UpdateMessageData#initialize(com.google.api.client.googleapis.serv
     * ices.AbstractGoogleClientRequest)} must be called to initialize this instance immediately after
     * invoking the constructor. </p>
     *
     * @param content the {@link edu.vt.bmac.gpstracker.messagedataendpoint.model.MessageData}
     * @since 1.13
     */
    protected UpdateMessageData(edu.vt.bmac.gpstracker.messagedataendpoint.model.MessageData content) {
      super(Messagedataendpoint.this, "PUT", REST_PATH, content, edu.vt.bmac.gpstracker.messagedataendpoint.model.MessageData.class);
    }

    @Override
    public UpdateMessageData setAlt(java.lang.String alt) {
      return (UpdateMessageData) super.setAlt(alt);
    }

    @Override
    public UpdateMessageData setFields(java.lang.String fields) {
      return (UpdateMessageData) super.setFields(fields);
    }

    @Override
    public UpdateMessageData setKey(java.lang.String key) {
      return (UpdateMessageData) super.setKey(key);
    }

    @Override
    public UpdateMessageData setOauthToken(java.lang.String oauthToken) {
      return (UpdateMessageData) super.setOauthToken(oauthToken);
    }

    @Override
    public UpdateMessageData setPrettyPrint(java.lang.Boolean prettyPrint) {
      return (UpdateMessageData) super.setPrettyPrint(prettyPrint);
    }

    @Override
    public UpdateMessageData setQuotaUser(java.lang.String quotaUser) {
      return (UpdateMessageData) super.setQuotaUser(quotaUser);
    }

    @Override
    public UpdateMessageData setUserIp(java.lang.String userIp) {
      return (UpdateMessageData) super.setUserIp(userIp);
    }

    @Override
    public UpdateMessageData set(String parameterName, Object value) {
      return (UpdateMessageData) super.set(parameterName, value);
    }
  }

  /**
   * Builder for {@link Messagedataendpoint}.
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

    /** Builds a new instance of {@link Messagedataendpoint}. */
    @Override
    public Messagedataendpoint build() {
      return new Messagedataendpoint(this);
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
     * Set the {@link MessagedataendpointRequestInitializer}.
     *
     * @since 1.12
     */
    public Builder setMessagedataendpointRequestInitializer(
        MessagedataendpointRequestInitializer messagedataendpointRequestInitializer) {
      return (Builder) super.setGoogleClientRequestInitializer(messagedataendpointRequestInitializer);
    }

    @Override
    public Builder setGoogleClientRequestInitializer(
        com.google.api.client.googleapis.services.GoogleClientRequestInitializer googleClientRequestInitializer) {
      return (Builder) super.setGoogleClientRequestInitializer(googleClientRequestInitializer);
    }
  }
}
