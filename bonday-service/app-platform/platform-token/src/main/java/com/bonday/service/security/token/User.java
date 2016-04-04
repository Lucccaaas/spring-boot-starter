package com.bonday.service.security.token;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Created by yunge on 16/4/1.
 */
@Data
@AllArgsConstructor
public class User {
    String name;
    String pwd;

    @Override
    public String toString() {
        return "user{" +
                "name='" + name + '\'' +
                ", pwd='" + pwd + '\'' +
                '}' + "user{" +
                "name='" + name + '\'' +
                ", pwd='" + pwd + '\'' +
                '}' + "user{" +
                "name='" + name + '\'' +
                ", pwd='" + pwd + '\'' +
                '}';
    }
}
