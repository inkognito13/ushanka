package ru.sstu.ushankashop.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.sstu.ushankashop.dao.ShippingInfoDAO;
import ru.sstu.ushankashop.domain.ShippingInfoEntity;

import javax.persistence.EntityManager;

/**
 * @author Dmitry Tarasov
 * Date: 11/03/2017
 * Time: 19:42
 */
@Service
public class ShippingInfoDAOImpl implements ShippingInfoDAO {
    
    @Autowired
    EntityManager entityManager;
    
    public ShippingInfoEntity create(ShippingInfoEntity entity) {
        return entityManager.merge(entity);
    }
}
