package com.example.kioskLv4_5;

import java.util.ArrayList;

public class MenuItem {// 개별 음식 항목을 관리하는 클래스입니다. 현재는 햄버거만 관리합니다.
    private String name;
    private String price;
    private String explain;
    private ArrayList<String> ls = new ArrayList<>();
    public MenuItem(String name,String price,String explain) {
        this.name = name;
        this.price = price;
        this.explain = explain;
        ls.add(name);
        ls.add(price);
        ls.add(explain);
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }

    public String getExplain() {
        return explain;
    }
}
