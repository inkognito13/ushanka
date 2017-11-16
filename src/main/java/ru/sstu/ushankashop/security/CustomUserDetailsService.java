package ru.sstu.ushankashop.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.sstu.ushankashop.dao.UserDAO;
import ru.sstu.ushankashop.domain.UserEntity;

import javax.transaction.Transactional;

/**
 * @author Dmitry Tarasov
 * Date: 11/16/2017
 * Time: 12:19
 */
@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    UserDAO userDAO;
    
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        UserEntity userEntity = userDAO.findByEmail(s);
        if (userEntity == null) {
            throw new UsernameNotFoundException(s);
        }
        return new CustomUserDetails(userEntity);
    }
}
