package com.nainiu192141.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 系统用户
 * </p>
 *
 * @author 86134
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ToString
public class SysUser implements Serializable {

    private static final long serialVersionUID = 1L;

    //@TableId(value = "user_id", type = IdType.AUTO)
    private Long userId;

    private String username;

    private String password;

    private String salt;

    private String email;

    private String mobile;

    private Integer status;

    private Long createUserId;

    private LocalDateTime createTime;


}
