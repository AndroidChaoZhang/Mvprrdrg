package democoolwidget.zc.com.mvprrdrg.model.manager;

import java.util.List;

import democoolwidget.zc.com.mvprrdrg.model.bean.GirlItemBean;
import democoolwidget.zc.com.mvprrdrg.model.bean.NetworkBean;
import democoolwidget.zc.com.mvprrdrg.model.db.DBHelper;
import democoolwidget.zc.com.mvprrdrg.model.network.resp.HttpHelper;
import democoolwidget.zc.com.mvprrdrg.model.network.resp.HttpResponse;
import democoolwidget.zc.com.mvprrdrg.model.prefs.PreferencesHelper;
import io.reactivex.Flowable;

public class DataManager implements HttpHelper, DBHelper, PreferencesHelper {

    HttpHelper mHttpHelper;
    DBHelper mDbHelper;
    PreferencesHelper mPreferencesHelper;

    public DataManager(HttpHelper httpHelper, DBHelper dbHelper, PreferencesHelper preferencesHelper) {
        mHttpHelper = httpHelper;
        mDbHelper = dbHelper;
        mPreferencesHelper = preferencesHelper;
    }


    @Override
    public Flowable<NetworkBean> fetchVersion() {
        return mHttpHelper.fetchVersion();
    }

    @Override
    public Flowable<HttpResponse<List<GirlItemBean>>> getGirlListInfo(int num, int page) {
        return mHttpHelper.getGirlListInfo(num, page);
    }

    @Override
    public void insertGirlList(List<GirlItemBean> girlListInfo) {
        mDbHelper.insertGirlList(girlListInfo);
    }

    @Override
    public List<GirlItemBean> getGirlList() {
        return mDbHelper.getGirlList();
    }

    @Override
    public void setPrefString(String key, String value) {
        mPreferencesHelper.setPrefString(key,value);
    }

    @Override
    public String getPrefString(String key, String value) {
        return mPreferencesHelper.getPrefString(key,value);
    }
}
