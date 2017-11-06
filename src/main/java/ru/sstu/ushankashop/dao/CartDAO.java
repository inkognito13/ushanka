package ru.sstu.ushankashop.dao;

import ru.sstu.ushankashop.domain.CartEntity;

/**
 * @author Dmitry Tarasov
 * Date: 11/06/2017
 * Time: 15:16
 */
public interface CartDAO {
    CartEntity merge(CartEntity cartEntity);
}
