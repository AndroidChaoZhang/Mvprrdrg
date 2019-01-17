package democoolwidget.zc.com.mvprrdrg.base;

/**
 * Presenter基类
 */
public interface IBasePresenter<T extends IBaseView>{

    void attachView(T view);

    void detachView();
}
