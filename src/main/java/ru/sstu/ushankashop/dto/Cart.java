package ru.sstu.ushankashop.dto;

import ru.sstu.ushankashop.domain.CartEntity;
import ru.sstu.ushankashop.domain.CommerceItemEntity;
import ru.sstu.ushankashop.domain.ItemEntity;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    List<CommerceItem> items;

    public Cart(CartEntity entity) {
        for (CommerceItemEntity itemEntity : entity.getItems()) {
            getItems().add(new CommerceItem(itemEntity));
        }
    }

    public Cart() {
    }

    public List<CommerceItem> getItems() {
        if (this.items == null) {
            this.items = new ArrayList<CommerceItem>();
        }
        return items;
    }

    public void setItems(List<CommerceItem> items) {
        this.items = items;
    }
}
