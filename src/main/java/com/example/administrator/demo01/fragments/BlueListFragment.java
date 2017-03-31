package com.example.administrator.demo01.fragments;

import android.app.Fragment;
import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.administrator.demo01.R;
import com.example.administrator.demo01.adapters.BlueListAdapter;
import com.example.administrator.demo01.bean.BlueBean;

import java.util.ArrayList;

import static android.app.Activity.RESULT_OK;

/**
 * 蓝牙开发1：扫描获取到所有的蓝牙设备
 */

public class BlueListFragment extends Fragment {
    private static final int REQUEST_ENABLE_BT = 0;
    private RecyclerView mRecyclerView;
    private BlueListAdapter mBlueListAdapter;
    private ArrayList<BlueBean> mBlueDatas=new ArrayList<>();


    public static BlueListFragment getInstance() {
        return new BlueListFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_bluelist,container,false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mRecyclerView= (RecyclerView) view.findViewById(R.id.cy_blue_list);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mBlueListAdapter=new BlueListAdapter(mBlueDatas);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //开始扫描蓝牙设备
        //TODO:1.获取蓝牙设配器，这里获取默认的就可以，单例模式
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        if(null==defaultAdapter){//表示这个设备不支持蓝牙功能
            Toast.makeText(getActivity(),"对不起，您的设备不支持蓝牙功能",Toast.LENGTH_SHORT).show();
            return;
        }
        //TODO:2.检查蓝牙是否可用，也就是是否为打开状态
        if(defaultAdapter.isEnabled()){//表示蓝牙为打开状态，可以使用
        }else{//如果没有打开，则需要申请打开蓝牙
            Intent enableBtIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            startActivityForResult(enableBtIntent, REQUEST_ENABLE_BT);
        }

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(resultCode==RESULT_OK){
            if(requestCode==REQUEST_ENABLE_BT){//表示打开蓝牙成功

            }
        }else{
            if(requestCode==REQUEST_ENABLE_BT){//表示打开蓝牙失败

            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
