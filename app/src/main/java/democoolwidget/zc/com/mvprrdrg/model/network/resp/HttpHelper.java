package democoolwidget.zc.com.mvprrdrg.model.network.resp;

import java.util.List;

import democoolwidget.zc.com.mvprrdrg.model.bean.GirlItemBean;
import democoolwidget.zc.com.mvprrdrg.model.bean.NetworkBean;
import io.reactivex.Flowable;

public interface HttpHelper {
    Flowable<NetworkBean> fetchVersion();
    Flowable<HttpResponse<List<GirlItemBean>>> getGirlListInfo(int num, int page);

}
