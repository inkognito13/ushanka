package ru.sstu.ushankashop.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.sstu.ushankashop.dto.ShippingInfo;
import ru.sstu.ushankashop.dto.User;
import ru.sstu.ushankashop.service.UserService;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public User create(@RequestBody User user) {
        return userService.create(user);
    }
    
    @RequestMapping(value = "shippingInfo", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public User addShippingInfo(@RequestBody ShippingInfo shippingInfo) {
        return userService.addShippingInfoToUser(shippingInfo);
    }

    @RequestMapping(method = RequestMethod.GET)
    public User getUserInfo() {
        return userService.getUserInfo(getPrincipal());
    }

    private String getPrincipal() {
        String userName = null;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
            userName = ((UserDetails) principal).getUsername();
        } else {
            userName = principal.toString();
        }
        return userName;
    }
}
