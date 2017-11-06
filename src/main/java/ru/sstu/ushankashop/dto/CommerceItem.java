package ru.sstu.ushankashop.dto;

import ru.sstu.ushankashop.domain.CommerceItemEntity;

/**
 * @author Dmitry Tarasov
 * Date: 11/06/2017
 * Time: 16:24
 */
public class CommerceItem {
    private Item item;
    private Integer quantity;

    public CommerceItem() {
    }

    public CommerceItem(CommerceItemEntity commerceItemEntity) {
        this.item = new Item(commerceItemEntity.getItem());
        this.quantity = commerceItemEntity.getQuantity();
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
