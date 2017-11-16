package ru.sstu.ushankashop.dao;

import org.springframework.stereotype.Service;
import ru.sstu.ushankashop.domain.RoleEntity;

/**
 * @author Dmitry Tarasov
 * Date: 11/16/2017
 * Time: 14:11
 */
@Service
public interface RoleDAO {
    RoleEntity findRoleByName(String name);
}
