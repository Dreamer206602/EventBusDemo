package com.mx.lb.eventbusdemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import de.greenrobot.event.EventBus;

/**
 * Created on 2015/11/16 23:35
 * Created by Author boobooL
 * 邮箱：boobooMX@163.com
 */
public class ItemDetailFragment extends Fragment {

    private TextView tv;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EventBus.getDefault().register(this);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    public void onEventMainThread(Item item){

        if (item != null) {
            tv.setText(item.content);
        }

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View ret=inflater.inflate(R.layout.fragment_item_detail,container,false);
        tv= (TextView) ret.findViewById(R.id.item_detail);

        return ret;


    }
}
