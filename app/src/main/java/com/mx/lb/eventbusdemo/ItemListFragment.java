package com.mx.lb.eventbusdemo;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import de.greenrobot.event.EventBus;

/**
 * Created on 2015/11/16 23:27
 * Created by Author boobooL
 * 邮箱：boobooMX@163.com
 */
public class ItemListFragment extends ListFragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //register
        EventBus.getDefault().register(this);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        EventBus.getDefault().unregister(this);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //开启线程加载列表
        new Thread(){
            @Override
            public void run() {
                try{
                    Thread.sleep(2000);//模拟延时

                    //发布事件，在后台线程发的事件
                    EventBus.getDefault().post(new Event.ItemListEvent(Item.ITEMS));
                }catch (Exception e){
                    e.printStackTrace();
                }

            }
        }.start();
    }

    public void onEventMainThread(Event.ItemListEvent event){
        setListAdapter(new ArrayAdapter<Item>(
                getActivity(),
                android.R.layout.simple_list_item_1,
                android.R.id.text1,
                event.getItems()
        ));

    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        EventBus.getDefault().post(getListView().getItemAtPosition(position));
    }
}
