package ru.sstu.ushankashop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.sstu.ushankashop.dao.ItemDAO;
import ru.sstu.ushankashop.domain.ItemEntity;
import ru.sstu.ushankashop.dto.Item;

import java.util.ArrayList;
import java.util.List;

@Service
public class CatalogService {
    @Autowired
    private ItemDAO itemDAO;

    public ItemDAO getItemDAO() {
        return itemDAO;
    }

    public void setItemDAO(ItemDAO itemDAO) {
        this.itemDAO = itemDAO;
    }

    public List<Item> getAllItems(){
        List<Item> items = new ArrayList<Item>();
        for (ItemEntity entity:getItemDAO().getAllItems()){
            Item dto = new Item(entity);
            items.add(dto);
        }
        return items;
    }

    public Item getItemDetails(Long id){
        return new Item(getItemDAO().getItemById(id));
    }
}
