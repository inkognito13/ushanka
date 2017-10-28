package ru.sstu.ushankashop.domain;

import java.util.List;

public class UserEntity {
    private Long id;
    private String email;
    private String password;
    private List<ShippingInfoEntity> shippingInfo;
    private List<PaymentInfoEntity> paymentInfo;
}
