package com.shepherd.manage.role.bean;

import java.util.List;

/**
 * @author chengxiong
 * @weChat cx4932
 * @datetime 2020/12/20 15:41
 */
public class MbMenuBean {
    private Long menuId;
    private String menuName;
    private String menuPath;
    private String menuIcon;
    private List<MbMenuBean> childs;

    public Long getMenuId() {
        return menuId;
    }

    public void setMenuId(Long menuId) {
        this.menuId = menuId;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getMenuPath() {
        return menuPath;
    }

    public void setMenuPath(String menuPath) {
        this.menuPath = menuPath;
    }

    public String getMenuIcon() {
        return menuIcon;
    }

    public void setMenuIcon(String menuIcon) {
        this.menuIcon = menuIcon;
    }

    public List<MbMenuBean> getChilds() {
        return childs;
    }

    public void setChilds(List<MbMenuBean> childs) {
        this.childs = childs;
    }
}
