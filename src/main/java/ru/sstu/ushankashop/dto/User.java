package ru.sstu.ushankashop.dto;

import ru.sstu.ushankashop.domain.PaymentInfoEntity;
import ru.sstu.ushankashop.domain.ShippingInfoEntity;
import ru.sstu.ushankashop.domain.UserEntity;

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

    public User(UserEntity entity) {
        this.email = entity.getEmail();
        this.password = entity.getPassword();
    }

    public User() {
    }

    public UserEntity toEntity(){
        UserEntity entity = new UserEntity();
        entity.setEmail(this.email);
        entity.setPassword(this.password);
        return entity;
    }
}
