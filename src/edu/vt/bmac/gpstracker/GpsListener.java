package edu.vt.bmac.gpstracker;

import java.util.EventListener;

// -------------------------------------------------------------------------
/**
 *  Used to help impliment the gps to allow the activity to update
 *
 *  @author Brian McNamara (bmac), Anthony Allen(ala2555), Chris Pan (chrisp3)
 *  @version Apr 7, 2013
 */
public interface GpsListener extends EventListener
{
    // ----------------------------------------------------------
    /**
     * when the gps updates call this
     * @param item a string to distinguish items
     */
    void onUpdate(String item);
    // ----------------------------------------------------------
    /**
     * if an error happens, may not be used
     * @param error a throwable error
     */
    void onError(Throwable error);
    /**
     * When the GPS receives a new status it will call this
     * @param Status the status to be displayed
     */
    void onStatusUpdate(String Status);
}
