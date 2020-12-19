package com.shepherd.manage.user.mapper;

import com.shepherd.manage.user.bean.MbUserBean;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author chengxiong
 * @weChat cx4932
 * @datetime 2020/12/17 11:41
 */
@Repository
public interface MbUserMapper {
    MbUserBean findUserByUserName(String userName);

    int batchAddUser(List<MbUserBean> list);
}
