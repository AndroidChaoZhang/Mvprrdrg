package democoolwidget.zc.com.mvprrdrg.ui.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import democoolwidget.zc.com.mvprrdrg.MyApplication;
import democoolwidget.zc.com.mvprrdrg.R;
import democoolwidget.zc.com.mvprrdrg.model.bean.GirlItemBean;
import democoolwidget.zc.com.mvprrdrg.utils.AppUtil;

public class GirlAdapter extends BaseQuickAdapter<GirlItemBean, BaseViewHolder> {
    private Context mContext;

    public GirlAdapter(Context mContext, @Nullable List<GirlItemBean> data) {
        super(R.layout.item_girl, data);
        this.mContext = mContext;
    }

    @Override
    protected void convert(final BaseViewHolder helper, final GirlItemBean item) {
        final ImageView iv_girl = helper.getView(R.id.iv_girl);
        //存在记录的高度时先Layout再异步加载图片
        if (item.getHeight() > 0) {
            ViewGroup.LayoutParams layoutParams = iv_girl.getLayoutParams();
            layoutParams.height = item.getHeight();
        }
        Glide.with(mContext).asBitmap().load(item.getUrl()).into(new SimpleTarget<Bitmap>(AppUtil.getWindowWidth()/2,AppUtil.getWindowWidth()/2) {
            @Override
            public void onResourceReady(@NonNull Bitmap resource, @Nullable Transition<? super Bitmap> transition) {
                if (item.getHeight() <= 0) {
                    int width = resource.getWidth();
                    int height = resource.getHeight();
                    int realHeight = (AppUtil.getWindowWidth() / 2) * height / width;
                    ViewGroup.LayoutParams lp = iv_girl.getLayoutParams();
                    lp.height = realHeight;
                }
                iv_girl.setImageBitmap(resource);
            }
        });
        helper.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MyApplication.getInstance(),"点击了第"+helper.getAdapterPosition()+"个美女图片",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
