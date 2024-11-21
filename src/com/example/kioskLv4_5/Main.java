package com.example.kioskLv4_5;


import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // 메인에서 데이터 넣고
        // 키오스크에서 넣은데이터 입출력

        Kiosk kiosk = new Kiosk(getMenu());
        kiosk.start();
    }

    private static Menu getMenu() {
        ArrayList<MenuItem> bugers = new ArrayList<>();
        bugers.add(new MenuItem("ShackBurger", "6.9", "토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        bugers.add(new MenuItem("SmokeShack", "8.9", "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"));
        bugers.add(new MenuItem("Cheeseburger", "6.9", "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
        bugers.add(new MenuItem("Hamburger", "5.4", "비프패티를 기반으로 야채가 들어간 기본버거"));

        ArrayList<MenuItem> drinks = new ArrayList<>();
        drinks.add(new MenuItem("Coke", "2.5", "코카콜라 맛있다 맛있으면 또먹어"));
        drinks.add(new MenuItem("Soda", "2.5", "파워 탄산 사이다 목탁~! 켁켁"));
        drinks.add(new MenuItem("MilkShake", "4.5", "감튀 찍먹하면 JMT 다들 아시죵?"));
        drinks.add(new MenuItem("Coffee", "3.5", "우~아하게 최고급 원두로 내린 구수한 커피 향 맡으면서 한잔 어때요?"));
        drinks.add(new MenuItem("Juice", "3.0", "상큼하고 달콤한 생과일 쥬스!"));

        ArrayList<MenuItem> desserts = new ArrayList<>();
        desserts.add(new MenuItem("HotDog", "4.8", "참나무 칩으로 훈연한 비프 소시지와 토종효모 포테이토 번을 사용한 핫도그"));
        desserts.add(new MenuItem("Fries", "4.2", "바삭하고 담백한 크링클 컷 프라이"));
        desserts.add(new MenuItem("Cheese Fries", "4.9", "고소하고 진한 치즈 소스를 듬뿍 올린 크링클 컷 프라이"));

        Menu menuList = new Menu(bugers, drinks, desserts);
        return menuList;
    }
}