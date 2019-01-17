package democoolwidget.zc.com.mvprrdrg.ui.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import java.util.List;

public class FragmentPagerAdapter extends android.support.v4.app.FragmentPagerAdapter {
    private List<Fragment> listFragment;
    private List<String> listTitle;

    public FragmentPagerAdapter(FragmentManager fm, List<Fragment> list,List<String> listTitle) {
        super(fm);
        this.listFragment = list;
        this.listTitle = listTitle;
    }

    @Override
    public int getCount() {
        return listFragment.size();
    }

    @Override
    public Fragment getItem(int arg0) {
        return listFragment.get(arg0);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return listTitle.get(position);
    }

}
