package com.shepherd.manage.role.controller;

import com.shepherd.manage.common.ResBean;
import com.shepherd.manage.common.Result;
import com.shepherd.manage.role.bean.RoleBean;
import com.shepherd.manage.role.service.impl.RoleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author chengxiong
 * @weChat cx4932
 * @datetime 2020/12/25 9:26
 */
@RestController
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleServiceImpl roleService;

    /**
     *@description: 获取菜单列表
     *@author: chengxiong
     *@datatime: 2020/12/29 10:49
     *@param: []
     *@return: java.lang.String
     */
    @GetMapping("/menuList")
    public String menuList(){
        ResBean resBean = roleService.menuList();
        return Result.getResult(resBean);
    }

    @GetMapping("/roleList")
    public String roleList(){
        ResBean resBean = roleService.roleList();
        return Result.getResult(resBean);
    }

    @GetMapping("/roleMenuList")
    public String roleMenuList(String roleId){
        ResBean resBean = roleService.roleMenuList(roleId);
        return Result.getResult(resBean);
    }

    @PostMapping("/roleMenu")
    public String roleMenu(@RequestBody RoleBean roleBean){
        ResBean resBean = roleService.updateRoleMenu(roleBean);
        return Result.getResult(resBean);
    }

}
