package democoolwidget.zc.com.mvprrdrg.rx;

import android.text.TextUtils;

import democoolwidget.zc.com.mvprrdrg.base.IBaseView;
import io.reactivex.subscribers.ResourceSubscriber;
import retrofit2.HttpException;

public abstract class CommonSubscriber<T> extends ResourceSubscriber<T> {
    private IBaseView mView;
    private String mErrorMsg;
    private boolean isShowErrorState = true;

    protected CommonSubscriber(IBaseView view){
        this.mView = view;
    }

    protected CommonSubscriber(IBaseView view, String errorMsg){
        this.mView = view;
        this.mErrorMsg = errorMsg;
    }

    protected CommonSubscriber(IBaseView view, boolean isShowErrorState){
        this.mView = view;
        this.isShowErrorState = isShowErrorState;
    }

    protected CommonSubscriber(IBaseView view, String errorMsg, boolean isShowErrorState){
        this.mView = view;
        this.mErrorMsg = errorMsg;
        this.isShowErrorState = isShowErrorState;
    }

    @Override
    public void onComplete() {

    }

    @Override
    public void onError(Throwable e) {
        if (mView == null) {
            return;
        }
        if (mErrorMsg != null && !TextUtils.isEmpty(mErrorMsg)) {
            mView.showErrorMsg(mErrorMsg);
        } else if (e instanceof Exception) {
            mView.showErrorMsg(e.toString());
        } else if (e instanceof HttpException) {
            mView.showErrorMsg("数据加载失败ヽ(≧Д≦)ノ");
        } else {
            mView.showErrorMsg("未知错误ヽ(≧Д≦)ノ");
        }
        if (isShowErrorState) {
//            mView.stateError();
        }
    }
}
