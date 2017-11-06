package ru.sstu.ushankashop.dao;

import ru.sstu.ushankashop.domain.UserEntity;

public interface UserDAO {
    UserEntity merge(UserEntity user);
    UserEntity findById(Long id);
}
