package com.bonday.service.rest.controller.session;

import com.bonday.service.domain.User;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static org.springframework.http.HttpStatus.NON_AUTHORITATIVE_INFORMATION;

/**
 * Created by yunge on 16/4/4.
 */
public interface SessionHelper {
    default HttpServletResponse addCookie(User user, String token, HttpServletResponse response) {
        Cookie cookie = new Cookie("token", token);
        cookie.setPath("/");
        cookie.setDomain(".bonday.cn");
        cookie.setHttpOnly(true);
        cookie.setMaxAge(60 * 5);
        response.addCookie(cookie);
        return response;
    }
}
