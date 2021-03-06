package com.nainiu192141.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nainiu192141.entity.SysUser;
import com.nainiu192141.mapper.SysUserMapper;
import com.nainiu192141.service.SysUserService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 系统用户 服务实现类
 * </p>
 *
 * @author 86134
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {

    @Override
    public SysUser findUserByFirstDb(long id) {
        return this.baseMapper.selectById(id);
    }

    @Override
    public int insertUser(SysUser user) {
        return this.baseMapper.insert(user);
    }

    @Override
    public int updateUser(SysUser user) {
        LambdaUpdateWrapper<SysUser> updateWrapper = new UpdateWrapper<SysUser>().lambda();
        updateWrapper.set(SysUser::getUserId,20).set(SysUser::getUsername,"zs");
        return this.baseMapper.update(user,updateWrapper);
    }

    @Override
    public int deleteUser(SysUser user) {
        LambdaQueryWrapper<SysUser> queryWrapper = new QueryWrapper<SysUser>().lambda();
        queryWrapper.eq(SysUser::getUserId,4);
        return this.baseMapper.delete(queryWrapper);
    }


}
