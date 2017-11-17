package ru.sstu.ushankashop.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "USER")
@NamedQueries(
        @NamedQuery(name = "selectUserByEmail", query = "from UserEntity u where u.email=:email")
)
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "email", unique = true)
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
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "USER_ROLE",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id")
    )
    private Set<RoleEntity> roles;


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

    public Set<RoleEntity> getRoles() {
        if (roles == null) {
            roles = new HashSet<RoleEntity>();
        }
        return roles;
    }

    public void setRoles(Set<RoleEntity> roles) {
        this.roles = roles;
    }

    public CartEntity getCart() {
        return cart;
    }

    public void setCart(CartEntity cart) {
        this.cart = cart;
    }
}
