package ru.sstu.ushankashop.domain;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "CART")
public class CartEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity user;
    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL)
    private List<CommerceItemEntity> items;

    public CartEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public List<CommerceItemEntity> getItems() {
        if (items == null) {
            items = new ArrayList<CommerceItemEntity>();
        }
        return items;
    }

    public void setItems(List<CommerceItemEntity> items) {
        this.items = items;
    }
}
