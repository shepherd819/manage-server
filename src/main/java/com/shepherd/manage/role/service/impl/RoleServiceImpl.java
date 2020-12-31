package com.shepherd.manage.role.service.impl;

import com.shepherd.manage.common.ResBean;
import com.shepherd.manage.common.exception.BaseException;
import com.shepherd.manage.common.util.StringUtil;
import com.shepherd.manage.role.bean.MbMenuBean;
import com.shepherd.manage.role.bean.RoleBean;
import com.shepherd.manage.role.bean.RoleMenuBean;
import com.shepherd.manage.role.mapper.RoleMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chengxiong
 * @weChat cx4932
 * @datetime 2020/12/29 10:11
 */
@Service
public class RoleServiceImpl {

    private static final Logger log = LogManager.getLogger(RoleServiceImpl.class);

    @Autowired
    private RoleMapper roleMapper;

    public ResBean menuList(){
        ResBean resBean = new ResBean();
        List<MbMenuBean> menuList = roleMapper.getMenuList();
        resBean.setResult(menuList);
        return resBean;
    }

    public ResBean roleList(){
        ResBean resBean = new ResBean();
        List<RoleBean> roleList = roleMapper.getRoleList();
        resBean.setResult(roleList);
        return resBean;
    }

    public ResBean roleMenuList(String roleId){
        ResBean resBean = new ResBean();
        List<String> roleMenuList = roleMapper.getRoleMenuList(roleId);
        resBean.setResult(roleMenuList);
        return resBean;
    }

    @Transactional
    public ResBean updateRoleMenu(RoleBean roleBean){
        if(roleBean == null || StringUtil.isEmpty(roleBean.getRoleId())){
            throw new BaseException("参数不全");
        }
        List<String> old = roleMapper.getRoleMenuList(roleBean.getRoleId());
        List<String> nowMenus = new ArrayList<>();
        List<String> addMenuIds = roleBean.getMenuIdList();
        nowMenus.addAll(addMenuIds);
        addMenuIds.removeAll(old); //新增的菜单id
        old.removeAll(nowMenus); //删除的菜单id
        if(addMenuIds.size() > 0){ //插入新增菜单
            List<RoleMenuBean> addRoleMenuList = new ArrayList<>();
            for (String menuId : addMenuIds) {
                RoleMenuBean roleMenuBean = new RoleMenuBean();
                roleMenuBean.setRoleId(roleBean.getRoleId());
                roleMenuBean.setMenuId(menuId);
                addRoleMenuList.add(roleMenuBean);
            }
            int i = roleMapper.batchAddRoleMenu(addRoleMenuList);
            log.info("角色id:" + roleBean.getRoleId() + "新增"+ i + "个菜单");
        }
        if(old.size() > 0){ //删除旧菜单
            int i = roleMapper.deleteRoleMenu(roleBean.getRoleId(), old);
            log.info("角色id:" + roleBean.getRoleId() + "删除"+ i + "个菜单");
        }

        ResBean result = new ResBean();
        return result;
    }

    @Transactional
    public ResBean addOrUpdateRole(RoleBean roleBean){
        if(StringUtil.isEmpty(roleBean.getRoleId())){ //新增
//            roleMapper.addUserRole(roleBean);
        }else{ //修改
            roleMapper.updateRoleInfo(roleBean);
        }
        ResBean result = new ResBean();
        return result;
    }
}
