package com.example.kioskLv4_5;

import java.util.ArrayList;

/**
 * MenuItem 클래스를 관리하는 클래스입니다.
 * 카테고리 별 음식이 들어있는 List가 필드로 있습니다.
 */
public class Menu {
    private ArrayList<MenuItem> buger = new ArrayList<>(); // 버거종류의 메뉴 리스트
    private ArrayList<MenuItem> drink = new ArrayList<>(); // 음료종류의 메뉴 리스트
    private ArrayList<MenuItem> desserts = new ArrayList<>(); // 디저트 종류의 메뉴 리스트

    public Menu() {} // 기본생성자

    /**
     * ArrayList<MenuItem>으로 각 카테고리별 음식을 넣어줌.
     * @param buger
     * @param drink
     * @param desserts
     */
    public Menu(ArrayList<MenuItem> buger, ArrayList<MenuItem> drink, ArrayList<MenuItem> desserts) {
        this.buger = buger;
        this.drink = drink;
        this.desserts = desserts;
    }

    /**
     *
     * @return 버거종류의 메뉴 리스트반환
     */
    public ArrayList<MenuItem> getBuger() {
        return buger;
    }

    /**
     *
     * @return 음료종류의 메뉴 리스트
     */
    public ArrayList<MenuItem> getDrink() {
        return drink;
    }

    /**
     *
     * @return 디저트 종류의 메뉴 리스트
     */
    public ArrayList<MenuItem> getDesserts() {
        return desserts;
    }

}