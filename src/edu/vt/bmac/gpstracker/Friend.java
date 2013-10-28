package edu.vt.bmac.gpstracker;

import android.graphics.Bitmap;
import edu.vt.bmac.gpstracker.GPS.GpsInfo;
import android.content.Context;
import java.util.Collection;
import java.io.Serializable;
import java.util.ArrayList;

// -------------------------------------------------------------------------
/**
 *  Write a one-sentence summary of your class here.
 *  Follow it with additional details about its purpose, what abstraction
 *  it represents, and how to use it.
 *
 *  @author Brian
 *  @version Oct 23, 2013
 */

public class Friend implements Serializable
{
    private Trails sessions;
    private byte[] image;
    private String name;
    public Friend(String name) {
        this.name = name;
        sessions = new Trails();
    }
    public void setImage(byte[] image) {
        this.image = image;
    }
    public byte[] getImage() {
        return image;
    }
    public void addSession(Trail info) {
        sessions.addTrail(info);
    }
    public void updateSession(Trail info) {
        sessions.updateTrail(info);
    }
    public int getNewSessionId() {
        return sessions.getNewTrialId();
    }
    public String getName() {
        return name;
    }
    public Collection<Trail> getSessions() {
        return sessions.getTrails();
    }
    public Trails getTrails() {
        return sessions;
    }
    public int sessionSize() {
        if (sessions.getTrails() == null) {
            return 0;
        }
        return sessions.getTrails().size();
    }
}
