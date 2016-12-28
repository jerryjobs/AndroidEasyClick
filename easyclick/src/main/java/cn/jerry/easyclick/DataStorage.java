package cn.jerry.easyclick;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.View;

import java.util.Calendar;
import java.util.Date;


/**
 * Created by jerry on 12/28/16.
 */

public class DataStorage {

    private Context context;
    private static DataStorage dataStorage = null;
    private SharedPreferences preferences;

    private DataStorage(Context context) {
        this.context = context;
        preferences = context.getSharedPreferences("easy_click_values", Context.MODE_PRIVATE);

    }

    public synchronized static DataStorage newInstance(Context context) {

        if (dataStorage == null) {
            dataStorage = new DataStorage(context);
        }
        return dataStorage;
    }

    public void putValue(View view) {
        int id = view.getId();
        if (preferences != null) {

        }
    }

    public void putString(String key, String value) {
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(key, value);
        editor.apply();
        editor.commit();
    }

    public void getString(String key, String defaultValue) {
        preferences.getString(key, defaultValue);
    }

    public void putDate(String key, Date date) {
        SharedPreferences.Editor editor = preferences.edit();
        editor.putLong(key, date.getTime());
        editor.apply();
        editor.commit();
    }

    public Date getDate(String key) {
        long value = preferences.getLong(key, 0);
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(value);
        return calendar.getTime();
    }

    public void putBoolean(String key, boolean value) {
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean(key, value);
        editor.apply();
        editor.commit();
    }

    public boolean getBoolean(String key) {
        return preferences.getBoolean(key, false);
    }

    public boolean isClicked(View view) {
        String key = Utils.genKey(view);
        return preferences.getBoolean(key, false);
    }

    public void setClicked(View view) {
        String key = Utils.genKey(view);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean(key, true);
        editor.apply();
        editor.commit();
    }

    public void putInt(String key, int value) {
        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt(key, value);
        editor.apply();
        editor.commit();
    }

    public int getInt(String key) {
        return preferences.getInt(key, 0);
    }

    public boolean isTwiceClick(View view) {
        String key = Utils.genKey(view);
        int times = getInt(key);
        if (times > 1) {
            return true;
        }
        putInt(key, times + 1);
        return false;
    }
}
