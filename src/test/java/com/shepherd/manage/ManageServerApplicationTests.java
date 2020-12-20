package com.shepherd.manage;

import com.shepherd.manage.user.bean.MbUserBean;
import com.shepherd.manage.user.bean.RoleBean;
import com.shepherd.manage.user.mapper.MbUserMapper;
import com.shepherd.manage.user.mapper.RoleMapper;
import com.shepherd.manage.user.service.impl.MbUserServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class ManageServerApplicationTests {

    @Autowired
    MbUserMapper userMapper;
    @Autowired
    RoleMapper roleMapper;
    @Autowired
    MbUserServiceImpl service;
    @Test
    void contextLoads() {
        MbUserBean shepherd = userMapper.findUserByUserName("shepherd");
        System.out.println(shepherd);
    }

    @Test
    void userInitTest(){
        MbUserBean u1 = new MbUserBean();
        u1.setUsername("shepherd");
        u1.setPassword("123");
        u1.setMobileNo("19956593318");
        u1.setAccountNonExpired(true);
        u1.setAccountNonLocked(true);
        u1.setCredentialsNonExpired(true);
        u1.setEnabled(true);

        MbUserBean u2 = new MbUserBean();
        u2.setUsername("javaboy");
        u2.setPassword("123");
        u2.setMobileNo("17602107889");
        u2.setAccountNonExpired(true);
        u2.setAccountNonLocked(true);
        u2.setCredentialsNonExpired(true);
        u2.setEnabled(true);
        List<MbUserBean> userList = new ArrayList<>();
        userList.add(u1);
        userList.add(u2);
        userMapper.batchAddUser(userList);
    }

    @Test
    void roleInitTest(){
        RoleBean r1 = new RoleBean();
        r1.setRoleName("ROLE_admin");
        r1.setRoleNameZh("管理员");
        RoleBean r2 = new RoleBean();
        r2.setRoleName("ROLE_user");
        r2.setRoleNameZh("普通用户");
        List<RoleBean> roleList = new ArrayList<>();
        roleList.add(r1);
        roleList.add(r2);
        roleMapper.batchAddRole(roleList);
    }

    @Test
    void selectUserTest(){
        UserDetails shepherd = service.loadUserByUsername("shepherd");
        System.out.println(shepherd);
    }

}
