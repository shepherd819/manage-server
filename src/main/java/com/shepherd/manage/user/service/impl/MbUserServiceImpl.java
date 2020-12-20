package com.shepherd.manage.user.service.impl;

import com.shepherd.manage.user.bean.MbMenuBean;
import com.shepherd.manage.user.bean.MbUserBean;
import com.shepherd.manage.user.mapper.MbUserMapper;
import com.shepherd.manage.user.mapper.RoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chengxiong
 * @weChat cx4932
 * @datetime 2020/12/19 14:13
 */

@Service
public class MbUserServiceImpl implements UserDetailsService {

    @Autowired
    private MbUserMapper mbUserMapper;

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        MbUserBean user = mbUserMapper.findUserByUserName(username);
        if(user==null){
            throw new UsernameNotFoundException("用户名不存在");
        }
        if(user.getRoles()==null||user.getRoles().size()<1){
            user.setMenuList(new ArrayList<>());
            return user;
        }
        //根据用户拥有的角色查询用户菜单
        List<MbMenuBean> mbMenuBeans = roleMapper.roleMenuList(user.getRoles());
        user.setMenuList(mbMenuBeans);
        return user;
    }
}
