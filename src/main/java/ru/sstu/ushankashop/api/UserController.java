package ru.sstu.ushankashop.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
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
public class UserController extends BaseController {

    @Autowired
    UserService userService;
    
    @RequestMapping(value = "shippingInfo", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public User addShippingInfo(@RequestBody ShippingInfo shippingInfo) {
        return userService.addShippingInfoToUser(getPrincipal(), shippingInfo);
    }

    @RequestMapping(method = RequestMethod.GET)
    public User getUserInfo(OAuth2Authentication auth) {
        return userService.getUserInfo(getPrincipal());
    }
}
