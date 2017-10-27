package ru.sstu.ushankashop.domain;

public class OrderEntity {
    private Long id;
    private Double total;
    private UserEntity user;
    private PaymentInfoEntity paymentInfo;
    private ShippingInfoEntity shippingInfo;
}
