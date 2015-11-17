package com.mx.lb.eventbusdemo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created on 2015/11/16 23:22
 * Created by Author boobooL
 * 邮箱：boobooMX@163.com
 */
public class Item {

    public String is;
    public String content;

    public static List<Item>ITEMS=new ArrayList<>();
    static {
        addItem(new Item("1", "Item 1"));
        addItem(new Item("2", "Item 2"));
        addItem(new Item("3", "Item 3"));
        addItem(new Item("4", "Item 4"));
        addItem(new Item("5", "Item 5"));
        addItem(new Item("6", "Item 6"));
    }

    private static void addItem(Item item){
        ITEMS.add(item);

    }


    public Item(String is, String content) {
        this.is = is;
        this.content = content;
    }

    @Override
    public String toString() {
        return content;
    }
}
