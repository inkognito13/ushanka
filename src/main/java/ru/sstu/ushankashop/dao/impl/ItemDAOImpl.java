package ru.sstu.ushankashop.dao.impl;

import org.springframework.stereotype.Service;
import ru.sstu.ushankashop.dto.Item;
import ru.sstu.ushankashop.dao.ItemDAO;

import java.util.Arrays;
import java.util.List;

@Service
public class ItemDAOImpl implements ItemDAO {
    private static List<Item> ITEMS = Arrays.asList(new Item(0L,"Hat-Ushanka","Warm and Cozy", 99.99,15));

    public List<Item> getAllItems() {
        return ITEMS;
    }
}
