package com.nainiu192141.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nainiu192141.datasource.CurDataSource;
import com.nainiu192141.datasource.DataSourceNames;
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

    @CurDataSource(name = DataSourceNames.SECOND)
    @Override
    public SysUser findUserBySecondDb(long id) {
        return this.baseMapper.selectById(id);
    }

}
