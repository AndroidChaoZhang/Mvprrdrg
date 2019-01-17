package democoolwidget.zc.com.mvprrdrg.model.network.api;

import java.util.List;

import democoolwidget.zc.com.mvprrdrg.model.bean.GirlItemBean;
import democoolwidget.zc.com.mvprrdrg.model.bean.NetworkBean;
import democoolwidget.zc.com.mvprrdrg.model.network.resp.HttpResponse;
import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface Apis {
    String HOST  = "http://gank.io/api/";

    @GET("data/福利/1/1")
    Flowable<NetworkBean> getVersion();

    @GET("data/福利/{num}/{page}")
    Flowable<HttpResponse<List<GirlItemBean>>> getGirlListInfo(@Path("num")int num,@Path("page")int page);
}
