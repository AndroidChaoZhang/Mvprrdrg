package democoolwidget.zc.com.mvprrdrg.model.network;

import java.util.List;

import javax.inject.Inject;

import democoolwidget.zc.com.mvprrdrg.model.bean.GirlItemBean;
import democoolwidget.zc.com.mvprrdrg.model.bean.NetworkBean;
import democoolwidget.zc.com.mvprrdrg.model.network.api.Apis;
import democoolwidget.zc.com.mvprrdrg.model.network.resp.HttpHelper;
import democoolwidget.zc.com.mvprrdrg.model.network.resp.HttpResponse;
import io.reactivex.Flowable;

/**
 * Created by codeest on 2016/8/3.
 */
public class RetrofitHelper implements HttpHelper {

    private Apis mApis;
    @Inject
    public RetrofitHelper (Apis apiService) {
        this.mApis = apiService;
    }


    @Override
    public Flowable<NetworkBean> fetchVersion() {
        return mApis.getVersion();
    }

    @Override
    public Flowable<HttpResponse<List<GirlItemBean>>> getGirlListInfo(int num, int page) {
        return mApis.getGirlListInfo(num,page);
    }
}
