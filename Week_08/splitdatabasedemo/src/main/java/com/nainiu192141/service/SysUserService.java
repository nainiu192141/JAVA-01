package com.nainiu192141.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.nainiu192141.entity.SysUser;

/**
 * <p>
 * 系统用户 服务类
 * </p>
 *
 * @author 86134
 */
public interface SysUserService extends IService<SysUser> {

    SysUser findUserByFirstDb(long id);

    int insertUser(SysUser user);

    int updateUser(SysUser user);

    int deleteUser(SysUser user);

}
