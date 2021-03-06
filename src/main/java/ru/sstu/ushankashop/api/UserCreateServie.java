package ru.sstu.ushankashop.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.sstu.ushankashop.dto.User;
import ru.sstu.ushankashop.service.UserService;

/**
 * @author Dmitry Tarasov
 * Date: 11/19/2017
 * Time: 16:21
 */
@RestController
@RequestMapping("users")
public class UserCreateServie {

    @Autowired
    UserService userService;

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public User create(@RequestBody User user) {
        return userService.create(user);
    }
}
