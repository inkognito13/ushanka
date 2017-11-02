package ru.sstu.ushankashop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.sstu.ushankashop.dao.UserDAO;
import ru.sstu.ushankashop.domain.UserEntity;
import ru.sstu.ushankashop.dto.User;

@Service
public class UserService {

    @Autowired
    UserDAO userDAO;

    public User create(User user){
        return new User(userDAO.create(user.toEntity()));
    }
}
