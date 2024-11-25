package com.example.kioskChallLv1;

import java.util.ArrayList;

/**
 * 개별 음식 항목을 관리하는 클래스입니다.
 */
public class MenuItem {
    private String name; // 음식이름
    private double price; // 음식 가격
    private String explain; // 음식 설명
    public MenuItem(String name,double price,String explain) {
        this.name = name;
        this.price = price;
        this.explain = explain;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getExplain() {
        return explain;
    }
}
