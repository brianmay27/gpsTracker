package edu.vt.bmac.gpstracker;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.NoSuchElementException;

// -------------------------------------------------------------------------
/**
 *  Write a one-sentence summary of your class here.
 *  Follow it with additional details about its purpose, what abstraction
 *  it represents, and how to use it.
 *
 *  @author Brian
 *  @version Oct 24, 2013
 */

public class Trails implements Serializable
{
    private HashMap<Integer, Trail> trails;
    public Trails() {
        trails = new HashMap<Integer, Trail>();
    }
    public void addTrail(Trail info) {
        Integer id = 0;
        if (!trails.isEmpty()) {
            for (Trail trail : trails.values()) {
                if (trail.getId() >= id) {
                    id = trail.getId() + 1;
                }
            }
        }
        info.setId(id);
        trails.put(id, info);
    }
    public void updateTrail(Trail info) {
        trails.put(info.getId(), info);
    }
    public int getNewTrialId() {
        Integer id = 0;
        if (!trails.isEmpty()) {
            for (Trail trail : trails.values()) {
                if (trail.getId() >= id) {
                    id = trail.getId() + 1;
                }
            }
        }
        trails.put(id, null);
        return id;
    }
    public Trail getTrail(Integer id) throws NoSuchElementException{
        Trail ret;
        if ((ret=trails.get(id)) == null) {
            throw new NoSuchElementException();
        }
        return ret;
    }
    public Collection<Trail> getTrails() {
        return trails.values();
    }
}
