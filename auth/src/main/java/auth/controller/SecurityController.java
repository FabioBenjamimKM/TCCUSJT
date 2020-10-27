package auth.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import auth.controller.domain.Const;
import auth.entity.User;

@Controller
public class SecurityController {

    @RequestMapping(value = "/user-auth", method = RequestMethod.GET)
    @ResponseBody
    @Secured({Const.ROLE_CLIENT, Const.ROLE_ADMIN})
    public User user() {
        return (User) SecurityContextHolder.getContext()
                .getAuthentication()
                .getPrincipal();
    }
}
