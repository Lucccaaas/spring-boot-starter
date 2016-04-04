package com.bonday.service.user;

import com.bonday.service.base.RepositoryCustom;
import com.bonday.service.domain.User;

import java.util.Optional;

/**
 * Created by yunge on 16/3/31.
 */
public interface UserRepositoryCustom extends RepositoryCustom {
    Optional<User> id(String id);
}
