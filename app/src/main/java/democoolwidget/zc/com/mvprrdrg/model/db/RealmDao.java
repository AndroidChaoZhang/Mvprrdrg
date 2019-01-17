package democoolwidget.zc.com.mvprrdrg.model.db;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmObject;
import io.realm.RealmResults;

public class RealmDao {

    /**@return 保存或者修改是否成功 */
    public static boolean insert (Realm realm,List<? extends RealmObject> list) {
        try {
            realm.beginTransaction();
            realm.insert(list);
            realm.commitTransaction();
            return true;
        } catch (Exception e) {
            realm.cancelTransaction();
            return false;
        }
    }

    /**查询所有数据*/
    public static List<? extends RealmObject> findAllList (Realm realm,Class<? extends RealmObject> clazz) {
         RealmResults<? extends RealmObject> results = realm.where(clazz).findAll();
        return realm.copyFromRealm(results);
    }
}
