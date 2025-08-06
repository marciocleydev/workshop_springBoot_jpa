package com.educandoweb.course.entities.enums;

public enum OrderStatus {
    WAITING_PAYMENT(1),     //é atribuido valores para evitar que um programador coloque outro enum no meio desses que já tem e mude a sequencia de numeros padrao atribuida e quebre o banco de dados.
    PAID(2),
    SHIPPED(3),
    DELIVERED(4),
    CANCELED(5);

    private int code;

    private OrderStatus(int code) {//construtor do enum sempre é private
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static OrderStatus valueOf(int code) {     
        for (OrderStatus status : OrderStatus.values()) {
            if (status.getCode() == code) {
                return status;
            }
        }
        throw new IllegalArgumentException("code doesn't existe");
    }
}
