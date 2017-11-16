package ru.sstu.ushankashop.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.sstu.ushankashop.dao.RoleDAO;
import ru.sstu.ushankashop.domain.RoleEntity;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 * @author Dmitry Tarasov
 * Date: 11/16/2017
 * Time: 14:13
 */
@Service
public class RoleDAOImpl implements RoleDAO {

    @Autowired
    EntityManager entityManager;

    public RoleEntity findRoleByName(String name) {
        TypedQuery<RoleEntity> query = entityManager.createNamedQuery("findRoleByName", RoleEntity.class);
        query.setParameter("name", name);
        return query.getSingleResult();
    }
}
