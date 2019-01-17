package democoolwidget.zc.com.mvprrdrg.model.db;

import java.util.List;

import democoolwidget.zc.com.mvprrdrg.model.bean.GirlItemBean;

public interface DBHelper {
    void insertGirlList(List<GirlItemBean> girlListInfo);
    List<GirlItemBean> getGirlList();
}
