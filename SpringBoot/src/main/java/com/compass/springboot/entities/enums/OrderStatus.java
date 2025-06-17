package com.compass.springboot.entities.enums;

public enum OrderStatus {

    WAITING_PAYMENT(1),
    PAID(2),
    SHIPPED(3),
    DELIVERED(4),
    CANCELLED(5);

    private int code;

    OrderStatus(int code) {this.code = code;}

    public int getCode() {return code;}
    public static OrderStatus fromCode(int code) {

        for (OrderStatus status : OrderStatus.values()) {

            if (status.getCode() == code) {return status;}
        }

        throw new IllegalArgumentException("Invalid OrderStatus code: " + code);
    }
}
