package ru.sstu.ushankashop.dto;

import ru.sstu.ushankashop.domain.ItemEntity;

public class Item {
    private Long id;
    private String name;
    private String description;
    private String price;
    private Integer count;

    public Item() {
    }

    public Item(ItemEntity entity){
        this.id = entity.getId();
        this.name = entity.getName();
        this.description = entity.getDescription();
        this.count = entity.getCount();
        this.price = entity.getPrice().toString();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Item(Long id, String name, String description, Double price, Integer count) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price.toString();
        this.count = count;
    }
}
