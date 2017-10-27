package ru.sstu.ushankashop.domain;


import java.util.List;

public class CartEntity {
    private Long id;
    private UserEntity user;
    private List<ItemEntity> items;
}
