package com.fine.fineapp.ui.tabmain;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.fine.fineapp.R;
import com.fine.fineapp.ui.base.BaseActivity;
import com.fine.fineapp.ui.fragment.AccountFragment;
import com.fine.fineapp.ui.fragment.FirstLayerFragment;
import com.fine.fineapp.ui.fragment.MessageFragment;
import com.fine.fineapp.ui.fragment.WorkFragment;
import com.shizhefei.view.indicator.Indicator;
import com.shizhefei.view.indicator.IndicatorViewPager;
import com.shizhefei.view.indicator.transition.OnTransitionTextListener;
import com.shizhefei.view.viewpager.SViewPager;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    private IndicatorViewPager indicatorViewPager;
    @Nullable
    @BindView(R.id.tabmain_indicator)
    Indicator indicator;
    @BindView(R.id.tabmain_viewPager)
    SViewPager viewPager;

    private List<Fragment> fragmentList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabmain);
        ButterKnife.bind(this);
        initFragments();
        indicator.setOnTransitionListener(new OnTransitionTextListener().setColor(getResources().getColor(R.color.color_app_primary), Color.GRAY));
        indicatorViewPager = new IndicatorViewPager(indicator, viewPager);
        indicatorViewPager.setAdapter(new MyAdapter(getSupportFragmentManager()));
        // 禁止viewpager的滑动事件
        viewPager.setCanScroll(true);
        // 设置viewpager保留界面不重新加载的页面数量
        viewPager.setOffscreenPageLimit(4);
    }

    private void initFragments(){
        fragmentList.clear();
        FirstLayerFragment mainFragment = new FirstLayerFragment();
        MessageFragment messageFragment = new MessageFragment();
        WorkFragment workFragment = new WorkFragment();
        AccountFragment accountFragment = new AccountFragment();
        fragmentList.add(mainFragment);
        fragmentList.add(messageFragment);
        fragmentList.add(workFragment);
        fragmentList.add(accountFragment);
    }

    private class MyAdapter extends IndicatorViewPager.IndicatorFragmentPagerAdapter {
        private String[] tabNames = { "主页", "消息", "工作", "我" };
        private int[] tabIcons = { R.drawable.maintab_1_selector, R.drawable.maintab_2_selector, R.drawable.maintab_3_selector,
                R.drawable.maintab_4_selector };
        private LayoutInflater inflater;

        public MyAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
            inflater = LayoutInflater.from(getApplicationContext());
        }

        @Override
        public int getCount() {
            return fragmentList.size();
        }

        @Override
        public View getViewForTab(int position, View convertView, ViewGroup container) {
            if (convertView == null) {
                convertView = (TextView) inflater.inflate(R.layout.tab_main, container, false);
            }
            TextView textView = (TextView) convertView;
            textView.setText(tabNames[position]);
            textView.setCompoundDrawablesWithIntrinsicBounds(0, tabIcons[position], 0, 0);
            return textView;
        }

        @Override
        public Fragment getFragmentForPage(int position) {
            Fragment mainFragment = fragmentList.get(position);
            Bundle bundle = new Bundle();
            bundle.putString(FirstLayerFragment.INTENT_STRING_TABNAME, tabNames[position]);
            bundle.putInt(FirstLayerFragment.INTENT_INT_INDEX, position);
            mainFragment.setArguments(bundle);
            return mainFragment;
        }
    }
}
