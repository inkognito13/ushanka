package ru.sstu.ushankashop.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.sstu.ushankashop.dao.CartDAO;
import ru.sstu.ushankashop.domain.CartEntity;
import ru.sstu.ushankashop.domain.ItemEntity;

import javax.persistence.EntityManager;

/**
 * @author Dmitry Tarasov
 * Date: 11/06/2017
 * Time: 15:15
 */
@Service
public class CartDAOImpl implements CartDAO {

    @Autowired
    EntityManager entityManager;

    public CartEntity merge(CartEntity cartEntity) {
        return entityManager.merge(cartEntity);
    }
}
