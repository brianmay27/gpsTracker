package edu.vt.bmac.gpstracker;

import java.io.Serializable;
import java.util.ArrayList;

// -------------------------------------------------------------------------
/**
 *  Write a one-sentence summary of your class here.
 *  Follow it with additional details about its purpose, what abstraction
 *  it represents, and how to use it.
 *
 *  @author Brian
 *  @version Oct 25, 2013
 */

public class Trail implements Serializable
{
    /**
     * Create a new Trail object.
     * @param username
     * @param name
     * @param id
     * @param plots
     * @param time
     * @param dist
     * @param alt
     * @param speed
     */
    public Trail(
        String username,
        String name,
        int id,
        ArrayList<Node> plots,
        String time,
        String dist,
        String alt,
        String speed)
    {
        this.username = username;
        this.name = name;
        this.id = id;
        this.plots = plots;
        this.time = time;
        this.dist = dist;
        this.alt = alt;
        this.speed = speed;
    }
    private String username;
    private String name;
    private int id;
    private ArrayList<Node> plots;
    private String time;
    private String dist;
    private String alt;
    private String speed;
    public String getUsername()
    {
        return username;
    }
    public void setUsername(String username)
    {
        this.username = username;
    }
    public String getName()
    {
        return name;
    }
    public void setName(String name)
    {
        this.name = name;
    }
    public int getId()
    {
        return id;
    }
    public void setId(int id)
    {
        this.id = id;
    }
    public ArrayList<Node> getPlots()
    {
        return plots;
    }
    public void setPlots(ArrayList<Node> plots)
    {
        this.plots = plots;
    }
    public String getTime()
    {
        return time;
    }
    public void setTime(String time)
    {
        this.time = time;
    }
    public String getDist()
    {
        return dist;
    }
    public void setDist(String dist)
    {
        this.dist = dist;
    }
    public String getAlt()
    {
        return alt;
    }
    public void setAlt(String alt)
    {
        this.alt = alt;
    }
    public String getSpeed()
    {
        return speed;
    }
    public void setSpeed(String speed)
    {
        this.speed = speed;
    }

}
