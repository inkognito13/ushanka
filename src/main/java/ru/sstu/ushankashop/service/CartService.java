package ru.sstu.ushankashop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.sstu.ushankashop.dao.CartDAO;
import ru.sstu.ushankashop.dao.ItemDAO;
import ru.sstu.ushankashop.dao.UserDAO;
import ru.sstu.ushankashop.domain.CartEntity;
import ru.sstu.ushankashop.domain.CommerceItemEntity;
import ru.sstu.ushankashop.domain.ItemEntity;
import ru.sstu.ushankashop.domain.UserEntity;
import ru.sstu.ushankashop.dto.Cart;

import javax.transaction.Transactional;

@Service
public class CartService {

    @Autowired
    CartDAO cartDAO;
    @Autowired
    UserDAO userDAO;
    @Autowired
    ItemDAO itemDAO;

    @Transactional
    public Cart addItemToCart(Long itemId, Integer quantity) {
        UserEntity userEntity = userDAO.findById(1L);
        CartEntity cart = userEntity.getCart();
        if (userEntity.getCart() == null) {
            cart = new CartEntity();
            cart.setUser(userEntity);
        }
        ItemEntity item = itemDAO.getItemById(itemId);
        
        boolean itemAlreadyExists = false;
        
        for (CommerceItemEntity commerceItemEntity : cart.getItems()) {
            if (commerceItemEntity.getItem().equals(item)) {
                commerceItemEntity.setQuantity(commerceItemEntity.getQuantity() + quantity);
                itemAlreadyExists = true;
            }
        }
        
        if (!itemAlreadyExists){
            CommerceItemEntity commerceItemEntity = new CommerceItemEntity();
            commerceItemEntity.setQuantity(quantity);
            commerceItemEntity.setItem(item);
            commerceItemEntity.setCart(cart);
            cart.getItems().add(commerceItemEntity);
        }
        
        return new Cart(cartDAO.merge(cart));
    }
    
    @Transactional
    public Cart removeItemFromCart(Long itemId) {
        UserEntity userEntity = userDAO.findById(1L);
        CartEntity cart = userEntity.getCart();
        CommerceItemEntity toDelete = null;
        for (CommerceItemEntity commerceItemEntity:cart.getItems()){
            if (commerceItemEntity.getItem().getId().equals(itemId)){
                toDelete = commerceItemEntity;
            }
        }
        if (toDelete!=null){
            cart.getItems().remove(toDelete);
        }
        return new Cart(cartDAO.merge(cart));
    }

    public Cart update(Long itemId, Integer quantity) {
        return null;
    }
}
