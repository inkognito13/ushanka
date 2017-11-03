package ru.sstu.ushankashop.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Entity
@Table(name = "ORDER_")
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "total")
    private Float total;
    @Column(name = "date")
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date date; 
    @ManyToOne
    @JoinColumn(name = "user_id",nullable = false)
    private UserEntity user;
    @ManyToOne
    @JoinColumn(name = "payment_info_id", nullable = false)
    private PaymentInfoEntity paymentInfo;
    @ManyToOne
    @JoinColumn(name = "shipping_info_id", nullable = false)
    private ShippingInfoEntity shippingInfo;

    public OrderEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Float getTotal() {
        return total;
    }

    public void setTotal(Float total) {
        this.total = total;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public PaymentInfoEntity getPaymentInfo() {
        return paymentInfo;
    }

    public void setPaymentInfo(PaymentInfoEntity paymentInfo) {
        this.paymentInfo = paymentInfo;
    }

    public ShippingInfoEntity getShippingInfo() {
        return shippingInfo;
    }

    public void setShippingInfo(ShippingInfoEntity shippingInfo) {
        this.shippingInfo = shippingInfo;
    }
}
