package ru.sstu.ushankashop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.sstu.ushankashop.dao.RoleDAO;
import ru.sstu.ushankashop.dao.ShippingInfoDAO;
import ru.sstu.ushankashop.dao.UserDAO;
import ru.sstu.ushankashop.domain.ShippingInfoEntity;
import ru.sstu.ushankashop.domain.UserEntity;
import ru.sstu.ushankashop.dto.ShippingInfo;
import ru.sstu.ushankashop.dto.User;

import javax.transaction.Transactional;

@Service
public class UserService {

    @Autowired
    UserDAO userDAO;
    
    @Autowired
    RoleDAO roleDAO;
    
    @Transactional
    public User create(User user){
        UserEntity entity = user.toEntity();
        entity.getRoles().add(roleDAO.findRoleByName("USER"));
        return new User(userDAO.merge(entity));
    }
    
    @Transactional
    public User addShippingInfoToUser(ShippingInfo shippingInfo){
        UserEntity userEntity = userDAO.findById(1L);
        ShippingInfoEntity shippingInfoEntity = shippingInfo.toEntity();
        shippingInfoEntity.setUser(userEntity);
        userEntity.getShippingInfo().add(shippingInfoEntity);
//        shippingInfoDAO.create(shippingInfoEntity);
        return new User(userDAO.merge(userEntity));
    }
    
    @Transactional
    public User getUserInfo(String email){
        return new User(userDAO.findByEmail(email));
    }
}
