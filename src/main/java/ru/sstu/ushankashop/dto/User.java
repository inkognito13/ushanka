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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ShippingInfoEntity getShippingInfoEntity() {
        return shippingInfoEntity;
    }

    public void setShippingInfoEntity(ShippingInfoEntity shippingInfoEntity) {
        this.shippingInfoEntity = shippingInfoEntity;
    }

    public PaymentInfoEntity getPaymentInfoEntity() {
        return paymentInfoEntity;
    }

    public void setPaymentInfoEntity(PaymentInfoEntity paymentInfoEntity) {
        this.paymentInfoEntity = paymentInfoEntity;
    }
}
