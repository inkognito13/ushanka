package ru.sstu.ushankashop.dto;

import ru.sstu.ushankashop.domain.PaymentInfoEntity;
import ru.sstu.ushankashop.domain.ShippingInfoEntity;
import ru.sstu.ushankashop.domain.UserEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Dmitry Tarasov
 * Date: 10/28/2017
 * Time: 18:37
 */
public class User {
    private Long id;
    private String email;
    private String password;
    private List<ShippingInfo> shippingInfo;
    private List<PaymentInfo> paymentInfo;

    public User(UserEntity entity) {
        this.id = entity.getId();
        this.email = entity.getEmail();
        this.password = entity.getPassword();
        if (entity.getShippingInfo() != null) {
            for (ShippingInfoEntity shippingInfoEntity : entity.getShippingInfo()) {
                getShippingInfo().add(new ShippingInfo(shippingInfoEntity));
            }
        }
    }

    public User() {
    }

    public UserEntity toEntity() {
        UserEntity entity = new UserEntity();
        entity.setEmail(this.email);
        entity.setPassword(this.password);
        return entity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public List<ShippingInfo> getShippingInfo() {
        if (shippingInfo == null) {
            this.shippingInfo = new ArrayList<ShippingInfo>();
        }
        return shippingInfo;
    }

    public void setShippingInfo(List<ShippingInfo> shippingInfo) {
        this.shippingInfo = shippingInfo;
    }

    public List<PaymentInfo> getPaymentInfo() {
        if (paymentInfo == null) {
            setPaymentInfo(new ArrayList<PaymentInfo>());
        }
        return paymentInfo;
    }

    public void setPaymentInfo(List<PaymentInfo> paymentInfo) {
        this.paymentInfo = paymentInfo;
    }
}
