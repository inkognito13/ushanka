package ru.sstu.ushankashop.dto;

import ru.sstu.ushankashop.domain.PaymentInfoEntity;
import ru.sstu.ushankashop.domain.ShippingInfoEntity;

/**
 * @author Dmitry Tarasov
 * Date: 10/28/2017
 * Time: 18:37
 */
public class User {
    private String email;
    private String password;
    private ShippingInfoEntity shippingInfoEntity;
    private PaymentInfoEntity paymentInfoEntity;
}
