package ru.sstu.ushankashop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
    ShippingInfoDAO shippingInfoDAO;
    
    @Transactional
    public User create(User user){
        return new User(userDAO.create(user.toEntity()));
    }
    
    @Transactional
    public User addShippingInfoToUser(ShippingInfo shippingInfo, Long userId){
        UserEntity userEntity = userDAO.findById(userId);
        ShippingInfoEntity shippingInfoEntity = shippingInfo.toEntity();
        shippingInfoEntity.setUser(userEntity);
        shippingInfoDAO.create(shippingInfoEntity);
        return new User(userEntity);
    }
}
