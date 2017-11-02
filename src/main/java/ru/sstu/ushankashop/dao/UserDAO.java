package ru.sstu.ushankashop.dao;

import ru.sstu.ushankashop.domain.UserEntity;

public interface UserDAO {
    UserEntity create(UserEntity user);
}
