package com.example.administrator.demo01;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.FrameLayout;

import com.example.administrator.demo01.fragments.BlueListFragment;

public class MainActivity extends FragmentActivity {
    private FrameLayout mFlFragmentHolder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mFlFragmentHolder = (FrameLayout) findViewById(R.id.fl_holder);
    }

    /**
     * 扫描蓝牙，打开蓝牙，进行连接     
     * @param view
     */
    public void openBlue(View view) {
        getFragmentManager().beginTransaction().replace(R.id.fl_holder, BlueListFragment.getInstance()).commit();
    }
}
