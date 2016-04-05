package com.bonday.service.rest.controller.account;

import com.bonday.service.domain.User;
import com.bonday.service.rest.controller.BaseController;
import com.bonday.service.security.token.TokenService;
import com.bonday.service.user.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Collection;

import static org.springframework.http.HttpStatus.OK;
import static org.springframework.web.bind.annotation.RequestMethod.*;

/**
 * Created by yunge on 16/4/3.
 */
@RestController
@RequestMapping("/accounts")
public class AccountController extends BaseController {
    @Resource
    TokenService tokenService;
    @Resource
    UserRepository userRepository;

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/sign_up", method = POST)
    ResponseEntity<User> signUp(HttpServletRequest request, HttpServletResponse response, @RequestBody User userForm) {
        User user = userRepository.save(userForm);
        if(user == null) {

        } else {

        }
        String token = tokenService.generateToken(GSON.toJson(user));
        Cookie cookie = new Cookie("token", token);
        cookie.setPath("/");
        cookie.setDomain(".bonday.cn");
        cookie.setHttpOnly(true);
        cookie.setMaxAge(60 * 5);
        response.addCookie(cookie);
        return new ResponseEntity<User>(user, OK);
    }


    @RequestMapping(value = "/all1", method = GET)
    @ResponseBody
    ResponseEntity<Collection<User>> getAll(HttpServletRequest request, HttpServletResponse response) {
        Collection<User> users = userRepository.findAll();
        return new ResponseEntity(users, OK);
    }

    @RequestMapping(value = "/all", method = DELETE)
    @ResponseBody
    ResponseEntity removeAll() {
        userRepository.deleteAll();
        return new ResponseEntity(OK);
    }
}
