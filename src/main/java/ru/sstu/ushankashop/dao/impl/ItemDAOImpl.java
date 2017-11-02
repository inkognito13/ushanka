package ru.sstu.ushankashop.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.sstu.ushankashop.domain.ItemEntity;
import ru.sstu.ushankashop.dto.Item;
import ru.sstu.ushankashop.dao.ItemDAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

@Service
public class ItemDAOImpl implements ItemDAO {

    @Autowired
    EntityManager entityManager;

    @Transactional
    public List<ItemEntity> getAllItems() {
        return entityManager.createQuery("select i from ItemEntity i", ItemEntity.class).getResultList();
    }

    @Transactional
    public ItemEntity getItemById(Long id) {
        List<ItemEntity> result = null;
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<ItemEntity> criteria = builder.createQuery(ItemEntity.class);
        Root<ItemEntity> root = criteria.from(ItemEntity.class);
        criteria.where(
                builder.equal(root.get("id"), id)
        );
        result = entityManager.createQuery(criteria).getResultList();

        return result.get(0);
    }
}
