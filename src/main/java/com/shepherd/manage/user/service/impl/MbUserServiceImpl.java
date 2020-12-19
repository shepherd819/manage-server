package com.shepherd.manage.user.service.impl;

import com.shepherd.manage.user.bean.MbUserBean;
import com.shepherd.manage.user.mapper.MbUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author chengxiong
 * @weChat cx4932
 * @datetime 2020/12/19 14:13
 */

@Service
public class MbUserServiceImpl implements UserDetailsService {

    @Autowired
    private MbUserMapper mbUserMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        MbUserBean user = mbUserMapper.findUserByUserName(username);
        if(user==null){
            throw new UsernameNotFoundException("用户名不存在");
        }
        return user;
    }
}
