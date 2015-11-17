package com.mx.lb.eventbusdemo;

import java.util.List;

/**
 * Created on 2015/11/16 23:24
 * Created by Author boobooL
 * 邮箱：boobooMX@163.com
 */
public class Event {



    public static  class ItemListEvent{
        private List<Item>items;
        public ItemListEvent(List<Item> items){
            this.items=items;
        }
        public List<Item>getItems(){
            return items;
        }

    }

}
