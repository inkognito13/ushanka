package ru.sstu.ushankashop.domain;

import java.util.Date;

public class OrderEntity {
    private Long id;
    private Double total;
    private Date date; 
    private UserEntity user;
    private PaymentInfoEntity paymentInfo;
    private ShippingInfoEntity shippingInfo;
}
