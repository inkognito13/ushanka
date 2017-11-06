package ru.sstu.ushankashop.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "USER")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ShippingInfoEntity> shippingInfo;
    @OneToMany(mappedBy = "user")
    private List<PaymentInfoEntity> paymentInfo;
    @OneToMany(mappedBy = "user")
    private List<OrderEntity> orders;
    @OneToOne(mappedBy = "user")
    private CartEntity cart;

    public UserEntity() {
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

    public List<ShippingInfoEntity> getShippingInfo() {
        if (this.shippingInfo == null) {
            this.shippingInfo = new ArrayList<ShippingInfoEntity>();
        }
        return shippingInfo;
    }

    public void setShippingInfo(List<ShippingInfoEntity> shippingInfo) {
        this.shippingInfo = shippingInfo;
    }

    public List<PaymentInfoEntity> getPaymentInfo() {
        return paymentInfo;
    }

    public void setPaymentInfo(List<PaymentInfoEntity> paymentInfo) {
        this.paymentInfo = paymentInfo;
    }

    public List<OrderEntity> getOrders() {
        return orders;
    }

    public void setOrders(List<OrderEntity> orders) {
        this.orders = orders;
    }

    public CartEntity getCart() {
        return cart;
    }

    public void setCart(CartEntity cart) {
        this.cart = cart;
    }
}
