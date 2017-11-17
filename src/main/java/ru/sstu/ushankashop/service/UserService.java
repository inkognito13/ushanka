package ru.sstu.ushankashop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.sstu.ushankashop.dao.RoleDAO;
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
    
    @Autowired
    PasswordEncoder passwordEncoder;
    
    @Transactional
    public User create(User user){
        UserEntity entity = user.toEntity();
        entity.setPassword(passwordEncoder.encode(entity.getPassword()));
        entity.getRoles().add(roleDAO.findRoleByName("USER"));
        return new User(userDAO.merge(entity));
    }
    
    @Transactional
    public User addShippingInfoToUser(String email, ShippingInfo shippingInfo){
        UserEntity userEntity = userDAO.findByEmail(email);
        ShippingInfoEntity shippingInfoEntity = shippingInfo.toEntity();
        shippingInfoEntity.setUser(userEntity);
        userEntity.getShippingInfo().add(shippingInfoEntity);
        return new User(userDAO.merge(userEntity));
    }
    
    @Transactional
    public User getUserInfo(String email){
        return new User(userDAO.findByEmail(email));
    }
}
