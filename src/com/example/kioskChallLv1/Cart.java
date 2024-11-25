package com.example.kioskChallLv1;

/**
 * 장바구니의 음식 클래스
 * 음식이름, 가격(수량*단가), 수량이 필드로 있음
 */
public class Cart {
    private String name;// 장바구니 안 음식이름
    private double price;// 장바구니 안 한개 음식의 총 가격
    private int quantity; // 장바구니 안 한개 음식의 수량

    /**
     * 생성자
     * 생성자를 이용해 장바구니 메뉴를 세팅 (추후 리스트에 넣기 위함)
     * @param name 음식이름
     * @param price 음식가겨
     * @param quantity 음식 수량
     */
    public Cart(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }


    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    /**
     * 같은 음식이 장바구니에 추가될때 객체를 생성하지 않고,
     * 음식의 수량을 +1 한 후 가격도 수량*단가 로 변경해줌.
     * @param unitPrice 음식 원래 가격(음식 단가)
     */
    public void plusQuantityPrice(double unitPrice) {
        this.quantity +=1;
        this.price=quantity*unitPrice;
    }

    /**
     * 장바구니 메뉴 수정 메서드
     * 수량을 입력 받아 해당음식의 수량과 총 가격을 수정.
     * @param quantity 사용자가 입력한 수량(수량 변경시)
     */
    public void modifyQuantity(int quantity) {
        double unitPrice=this.price/(this.quantity*1.0);
        this.quantity = quantity;
        this.price=quantity*unitPrice;
    }
}
