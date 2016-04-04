package com.bonday.service.domain;

import com.bonday.service.base.BaseDocument;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by yunge on 16/3/28.
 */
@Data
@NoArgsConstructor
@Document(collection = "users")
public class User extends BaseDocument {
    private String name;
    private String display_name;
    private String password;
    private String firstName;
    private String lastName;

    public User(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return String.format(
                "user[firstName='%s', lastName='%s']",
                firstName, lastName);
    }

//    private Integer age;

    //账户信息
//    private Account account;
}
