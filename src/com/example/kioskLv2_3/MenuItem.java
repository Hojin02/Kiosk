package com.example.kioskLv2_3;

import java.util.ArrayList;

/**
 * 개별 음식 항목을 관리하는 클래스입니다. 현재는 햄버거만 관리합니다.
 */
public class MenuItem {
    private String name; // 음식 이름
    private String price; // 음식 가격
    private String explain; // 음식 설명
    private ArrayList<String> ls = new ArrayList<>(); // 음식을 담을 리스트 객체 생성

    /**
     * 생성자 매개변수로 받은 변수를 필드에 저장 및 리스트에 추가.
     *
     * @param name 음식 이름
     * @param price 음식 가격
     * @param explain 음식 설명
     */
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
    } // 음식 이름을 반환

    public String getPrice() {
        return price;
    }// 음식 가격을 반환

    public String getExplain() {
        return explain;
    }// 음식 설명을 반환
}
