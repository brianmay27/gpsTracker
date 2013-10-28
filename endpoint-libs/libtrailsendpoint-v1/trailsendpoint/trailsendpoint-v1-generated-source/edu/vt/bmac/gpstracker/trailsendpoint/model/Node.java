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

package edu.vt.bmac.gpstracker.trailsendpoint.model;

/**
 * Model definition for Node.
 *
 * <p> This is the Java data model class that specifies how to parse/serialize into the JSON that is
 * transmitted over HTTP when working with the trailsendpoint. For a detailed explanation see:
 * <a href="http://code.google.com/p/google-http-java-client/wiki/JSON">http://code.google.com/p/google-http-java-client/wiki/JSON</a>
 * </p>
 *
 * @author Google, Inc.
 */
@SuppressWarnings("javadoc")
public final class Node extends com.google.api.client.json.GenericJson {

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.Float accuracy;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.Double alt;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.Double lat;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.Double lon;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.Integer satalites;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.Float speed;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key @com.google.api.client.json.JsonString
  private java.lang.Long time;

  /**
   * @return value or {@code null} for none
   */
  public java.lang.Float getAccuracy() {
    return accuracy;
  }

  /**
   * @param accuracy accuracy or {@code null} for none
   */
  public Node setAccuracy(java.lang.Float accuracy) {
    this.accuracy = accuracy;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.Double getAlt() {
    return alt;
  }

  /**
   * @param alt alt or {@code null} for none
   */
  public Node setAlt(java.lang.Double alt) {
    this.alt = alt;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.Double getLat() {
    return lat;
  }

  /**
   * @param lat lat or {@code null} for none
   */
  public Node setLat(java.lang.Double lat) {
    this.lat = lat;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.Double getLon() {
    return lon;
  }

  /**
   * @param lon lon or {@code null} for none
   */
  public Node setLon(java.lang.Double lon) {
    this.lon = lon;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.Integer getSatalites() {
    return satalites;
  }

  /**
   * @param satalites satalites or {@code null} for none
   */
  public Node setSatalites(java.lang.Integer satalites) {
    this.satalites = satalites;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.Float getSpeed() {
    return speed;
  }

  /**
   * @param speed speed or {@code null} for none
   */
  public Node setSpeed(java.lang.Float speed) {
    this.speed = speed;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.Long getTime() {
    return time;
  }

  /**
   * @param time time or {@code null} for none
   */
  public Node setTime(java.lang.Long time) {
    this.time = time;
    return this;
  }

  @Override
  public Node set(String fieldName, Object value) {
    return (Node) super.set(fieldName, value);
  }

  @Override
  public Node clone() {
    return (Node) super.clone();
  }

}
