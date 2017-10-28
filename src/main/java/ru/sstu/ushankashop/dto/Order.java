package ru.sstu.ushankashop.dto;

import java.util.List;

public class Order {
    private List<Item> items;
    private String total;
    private PaymentInfo payment;
    private ShippingInfo shipping;
}
