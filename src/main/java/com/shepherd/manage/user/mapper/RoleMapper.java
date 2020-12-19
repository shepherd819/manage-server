package com.shepherd.manage.user.mapper;

import com.shepherd.manage.user.bean.RoleBean;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author chengxiong
 * @weChat cx4932
 * @datetime 2020/12/19 14:21
 */
@Repository
public interface RoleMapper {
    int addRole(RoleBean roleBean);

    int batchAddRole(List<RoleBean> list);
}
