package ru.sstu.ushankashop.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.sstu.ushankashop.dao.UserDAO;
import ru.sstu.ushankashop.domain.UserEntity;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Service
public class UserDAOImpl implements UserDAO {

    @Autowired
    EntityManager entityManager;
    
    public UserEntity merge(UserEntity user) {
        return entityManager.merge(user);
    }


    public UserEntity findById(Long id) {
        return entityManager.find(UserEntity.class, id);
    }

    public UserEntity findByEmail(String email) {
        Query query = entityManager.createNamedQuery("selectUserByEmail", UserEntity.class);
        query.setParameter("email",email);
        List<UserEntity> result = query.getResultList();
        if (result.isEmpty()) {
            return null;
        } else {
            return result.get(0);
        }
    }
}
