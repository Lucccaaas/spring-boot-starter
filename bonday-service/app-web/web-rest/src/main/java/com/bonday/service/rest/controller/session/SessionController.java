package com.bonday.service.rest.controller.session;

import com.bonday.service.domain.User;
import com.bonday.service.rest.controller.BaseController;
import com.bonday.service.security.token.TokenService;
import com.bonday.service.user.UserRepository;
import com.google.gson.Gson;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static org.springframework.http.HttpStatus.NON_AUTHORITATIVE_INFORMATION;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * Created by yunge on 16/4/4.
 */
@RestController
@RequestMapping("/session")
public class SessionController extends BaseController implements SessionHelper {
    @Resource
    TokenService tokenService;
    @Resource
    UserRepository userRepository;

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/sign_in", method = POST)
    public ResponseEntity<User> signIn(HttpServletRequest request, HttpServletResponse response, @RequestBody User userForm) {
        ResponseEntity<User> responseEntity = new ResponseEntity<User>(userForm, OK);
        String token = tokenService.generateToken(GSON.toJson(userForm));
        userRepository
                .findByNameAndPassword(userForm.getName(), userForm.getPassword())
                .ifPresent(user -> addCookie(user, token, response));
        return new ResponseEntity<User>(userForm, OK);
    }
}
