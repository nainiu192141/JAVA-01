package com.nainiu192141;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.nainiu192141.entity.SysUser;
import com.nainiu192141.mapper.SysUserMapper;
import com.nainiu192141.service.SysUserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@SpringBootTest
@Slf4j
@RunWith(SpringRunner.class)
public class SpringBootDynamicDataSourceApplicationTests {

    @Autowired
    private SysUserService userService;

    @Autowired
    private SysUserMapper sysUserMapper;
    @Test
    public void contextLoads() {
        SysUser user = userService.getById(1);
        log.info(user.toString());
    }

    @Test
    public void test() {
        SysUser user = userService.findUserByFirstDb(1);
        log.info("第一个数据库 : [{}]", user.toString());
        SysUser user2 = userService.findUserBySecondDb(1);
        log.info("第二个数据库 : [{}]", user2.toString());
    }

    @Test
    public void aInsert() {
        SysUser user = new SysUser();
        user.setUsername("zhangsan");
        user.setUserId(20L);
        sysUserMapper.insert(user);
    }
    @Test
    public void bDelete() {
        sysUserMapper.deleteById(1);
        List<Integer> ids = new ArrayList<>();
        ids.add(2);
        ids.add(3);
        sysUserMapper.deleteBatchIds(ids);
        LambdaQueryWrapper<SysUser> queryWrapper = new QueryWrapper<SysUser>().lambda();
        queryWrapper.eq(SysUser::getUserId,4);
        sysUserMapper.delete(queryWrapper);
        HashMap map = new HashMap();
        map.put("user_id",5);
        sysUserMapper.deleteByMap(map);
    }
    @Test
    public void cUpdate() {
        SysUser user = sysUserMapper.selectById(1);
        user.setUserId(30L);
        sysUserMapper.updateById(user);
        LambdaUpdateWrapper<SysUser> updateWrapper = new UpdateWrapper<SysUser>().lambda();
        updateWrapper.set(SysUser::getUserId,20).set(SysUser::getUsername,"zs");
        sysUserMapper.update(user,updateWrapper);
    }
    @Test
    public void dSelect() {
        LambdaQueryWrapper<SysUser> queryWrapper = new QueryWrapper<SysUser>().lambda();
        queryWrapper.eq(SysUser::getUserId,1);
        SysUser user1 = sysUserMapper.selectOne(queryWrapper);
        System.out.println(user1);
        List<Integer> ids = new ArrayList<>();
        ids.add(1);
        ids.add(2);
        List<SysUser> userList = sysUserMapper.selectBatchIds(ids);
        System.out.println(userList);
        LambdaQueryWrapper<SysUser> queryWrapper1 = new QueryWrapper<SysUser>().lambda();
        queryWrapper1.gt(SysUser::getUserId,10);
        List<SysUser> userList1 =sysUserMapper.selectList(queryWrapper1);
        System.out.println(userList1);
    }
}
