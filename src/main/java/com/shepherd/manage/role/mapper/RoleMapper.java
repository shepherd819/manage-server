package com.shepherd.manage.role.mapper;


import com.shepherd.manage.role.bean.MbMenuBean;
import com.shepherd.manage.role.bean.RoleBean;
import com.shepherd.manage.role.bean.RoleMenuBean;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author chengxiong
 * @weChat cx4932
 * @datetime 2020/12/19 14:21
 */
@Repository
public interface RoleMapper {

    int batchAddRole(List<RoleBean> list);

    List<MbMenuBean> roleMenuList(List<RoleBean> list);

    List<MbMenuBean> getMenuList();

    List<RoleBean> getRoleList();

    List<String> getRoleMenuList(String roleId);

    int batchAddRoleMenu(List<RoleMenuBean> list);

    int deleteRoleMenu(@Param("roleId") String roleId,@Param("list") List<String> list);

    int updateRoleInfo(RoleBean roleBean);
}
