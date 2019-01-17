package democoolwidget.zc.com.mvprrdrg.model.prefs;

import android.content.Context;
import android.content.SharedPreferences;

import javax.inject.Inject;

import democoolwidget.zc.com.mvprrdrg.MyApplication;

public class ImplPreferencesHelper implements PreferencesHelper {

    private static final String PREFERENCES_NAME = "mvprrdrg_sp";

    private final SharedPreferences mSharedPreferences;

    @Inject
    public ImplPreferencesHelper() {
        mSharedPreferences = MyApplication.getInstance().getSharedPreferences(PREFERENCES_NAME, Context.MODE_PRIVATE);
    }

    @Override
    public void setPrefString(String key, String value) {
        mSharedPreferences.edit().putString(key, value).apply();
    }

    @Override
    public String getPrefString(String key, String value) {
        return mSharedPreferences.getString(key, value);
    }
}
