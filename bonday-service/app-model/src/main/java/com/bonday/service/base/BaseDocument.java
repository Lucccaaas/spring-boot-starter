package com.bonday.service.base;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.*;
import org.springframework.data.mongodb.config.EnableMongoAuditing;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by yunge on 16/3/31.
 */
public class BaseDocument implements Serializable {
    @Getter
    @Setter
    @Id
    private String id;

    @Getter
    @Setter
    @CreatedDate
    private Date create_date;

    @Getter
    @Setter
    @LastModifiedDate
    private Date update_date;

    @Getter
    @Setter
    @Version
    private Long version;

    @Getter
    @Setter
    @CreatedBy
    private String created_by;

    @Getter
    @Setter
    @LastModifiedBy
    private String modified_by;
}
