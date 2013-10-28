package edu.vt.bmac.gpstracker;

import android.content.SharedPreferences;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.preference.PreferenceFragment;
import android.preference.PreferenceManager;

// -------------------------------------------------------------------------
/**
 *  The settings page for the application. Used to update user settings
 *
 *  @author Brian McNamara (bmac), Anthony Allen(ala2555), Chris Pan (chrisp3)
 *  @version Apr 30, 2013
 */
public class SettingsActivity extends PreferenceActivity
implements OnSharedPreferenceChangeListener
{
    public void onCreate(Bundle saved) {
        super.onCreate(saved);
        android.util.Log.d("settings","In the Activity");
        String type = this.getIntent().getStringExtra("settings");
        Settings settings = new Settings();
        settings.setType(type);
        if (type.equals("tracker")) {
            PreferenceManager.setDefaultValues(this, R.xml.settings, false);
            getFragmentManager().beginTransaction().replace(android.R.id.content,
                settings).commit();
        } else if(type.equals("main")) {
            PreferenceManager.setDefaultValues(this, R.xml.main_pref, false);
            getFragmentManager().beginTransaction().replace(android.R.id.content,
                settings).commit();
        }

    }

    // -------------------------------------------------------------------------
    /**
     *  Fragment for the main settings. Used for the new approch to settings
     *  in 14+ api levels
     *
     *  @author Brian
     *  @version Apr 30, 2013
     */
    public static class Settings extends PreferenceFragment
    {
        private String type;
        public void setType(String type) {
            this.type = type;
        }
        public void onCreate(Bundle saved) {
            super.onCreate(saved);
            android.util.Log.d("settings","In the fragment");
            if (type.equals("main")) {
                addPreferencesFromResource(R.xml.main_pref);
            } else if (type.equals("tracker")) {
                addPreferencesFromResource(R.xml.settings);
            }
        }
    }

    public void onSharedPreferenceChanged(
        SharedPreferences sharedPreferences,
        String key)
    {
        android.util.Log.d("settings", key);

    }
}

