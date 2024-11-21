package com.example.kioskLv2_3;

import java.util.ArrayList;

/**
 * 키오스크 프로그램 메인 클래스
 * 키오스크 작동 클래스의 함수를 호출하여 프로그램이 작동합니다.
 * 메인클래스에서는 메뉴를 설정, 키오스크 작동함수 호출
 */
public class Main {
    public static void main(String[] args) {
        Kiosk kiosk = new Kiosk(getMenuItems());//키오스크 객체 생성 및 생성자에 메뉴리스트를 넣어줌
        kiosk.start(); // 사용자의 입력과 출력 기능을 작동시키는 함수.
    }

    /**
     * 메뉴 항목을 생성하여 ArrayList로 반환합니다.
     *
     * @return ArrayList<MenuItem> 메뉴 항목 리스트
     */
    private static ArrayList<MenuItem> getMenuItems() {
        // 각 메뉴 항목 생성
        MenuItem ShackBurger = new MenuItem("ShackBurger", "6.9", "토마토, 양상추, 쉑소스가 토핑된 치즈버거");
        MenuItem SmokeShack = new MenuItem("SmokeShack", "8.9", "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거");
        MenuItem Cheeseburger = new MenuItem("Cheeseburger", "6.9", "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거");
        MenuItem Hamburger = new MenuItem("Hamburger", "5.4", "비프패티를 기반으로 야채가 들어간 기본버거");

        // 메뉴 리스트 생성 및 추가
        ArrayList<MenuItem> menuItems = new ArrayList<>();
        menuItems.add(ShackBurger);
        menuItems.add(SmokeShack);
        menuItems.add(Cheeseburger);
        menuItems.add(Hamburger);
        return menuItems;
    }
}