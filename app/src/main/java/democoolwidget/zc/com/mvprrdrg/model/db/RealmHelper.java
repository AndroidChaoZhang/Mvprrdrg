package democoolwidget.zc.com.mvprrdrg.model.db;

import java.util.List;

import javax.inject.Inject;

import democoolwidget.zc.com.mvprrdrg.model.bean.GirlItemBean;
import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by codeest on 16/8/16.
 */

public class RealmHelper implements DBHelper {

    private static final String DB_NAME = "myRealm.realm";

    private Realm mRealm;

    @Inject
    public RealmHelper() {
        Realm.getInstance(new RealmConfiguration.Builder()
                .name(DB_NAME)
                .build());
        mRealm = Realm.getDefaultInstance();
    }

    /**增加美女查询的数据信息*/
    @Override
    public void insertGirlList(List<GirlItemBean> girlListInfo) {
        RealmDao.insert(mRealm,girlListInfo);
    }

    /**获取美女的数据信息*/
    @Override
    public List<GirlItemBean> getGirlList() {
        return (List<GirlItemBean>) RealmDao.findAllList(mRealm, GirlItemBean.class);
    }
}
