package com.shepherd.manage.user.bean;

import com.shepherd.manage.role.bean.MbMenuBean;
import com.shepherd.manage.role.bean.RoleBean;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MbUserBean implements UserDetails {

    private Long userId;
    private String username;
    private String password;
    private List<RoleBean> roles;
    private String mobileNo;
    private String email;
    private String headImgUrl;
    private List<MbMenuBean> menuList;

    private boolean accountNonExpired;
    private boolean accountNonLocked;
    private boolean credentialsNonExpired;
    private boolean enabled;

    public void setId(Long userId) {
        this.userId = userId;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRoles(List<RoleBean> roles) {
        this.roles = roles;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setHeadImgUrl(String headImgUrl) {
        this.headImgUrl = headImgUrl;
    }

    public void setAccountNonExpired(boolean accountNonExpired) {
        this.accountNonExpired = accountNonExpired;
    }

    public void setAccountNonLocked(boolean accountNonLocked) {
        this.accountNonLocked = accountNonLocked;
    }

    public void setCredentialsNonExpired(boolean credentialsNonExpired) {
        this.credentialsNonExpired = credentialsNonExpired;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Long getUserId() {
        return userId;
    }

    public List<RoleBean> getRoles() {
        return roles;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public String getEmail() {
        return email;
    }

    public String getHeadImgUrl() {
        return headImgUrl;
    }

    public List<MbMenuBean> getMenuList() {
        return menuList;
    }

    public void setMenuList(List<MbMenuBean> menuList) {
        this.menuList = menuList;
    }

    /**
     *@description: 返回用户角色
     *@author: chengxiong
     *@datatime: 2020/12/19 14:02
     *@param: []
     *@return: java.util.Collection<? extends org.springframework.security.core.GrantedAuthority>
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        for (RoleBean role : getRoles()) {
            authorities.add(new SimpleGrantedAuthority(role.getRoleName()));
        }
        return authorities;
    }

    /**
     *@description: 返回用户密码
     *@author: chengxiong
     *@datatime: 2020/12/19 14:02
     *@param: []
     *@return: java.lang.String
     */
    @Override
    public String getPassword() {
        return password;
    }

    /**
     *@description: 返回用户名
     *@author: chengxiong
     *@datatime: 2020/12/19 14:03
     *@param: []
     *@return: java.lang.String
     */
    @Override
    public String getUsername() {
        return username;
    }

    /**
     *@description: 账户是否未过期
     *@author: chengxiong
     *@datatime: 2020/12/19 14:03
     *@param: []
     *@return: boolean
     */
    @Override
    public boolean isAccountNonExpired() {
        return accountNonExpired;
    }

    /**
     *@description: 账户是否未锁定
     *@author: chengxiong
     *@datatime: 2020/12/19 14:03
     *@param: []
     *@return: boolean
     */
    @Override
    public boolean isAccountNonLocked() {
        return accountNonLocked;
    }

    /**
     *@description: 密码是否未过期
     *@author: chengxiong
     *@datatime: 2020/12/19 14:03
     *@param: []
     *@return: boolean
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return credentialsNonExpired;
    }

    /**
     *@description: 账户是否可用
     *@author: chengxiong
     *@datatime: 2020/12/19 14:03
     *@param: []
     *@return: boolean
     */
    @Override
    public boolean isEnabled() {
        return enabled;
    }
}
