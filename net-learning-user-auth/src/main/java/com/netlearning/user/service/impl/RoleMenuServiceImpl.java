package com.netlearning.user.service.impl;

import com.netlearning.framework.base.CommonResult;
import com.netlearning.framework.bean.BeanCopyUtils;
import com.netlearning.framework.domain.userAuth.*;
import com.netlearning.framework.exception.ExceptionCode;
import com.netlearning.framework.snowflake.SequenceService;
import com.netlearning.framework.utils.CollectionUtils;
import com.netlearning.user.mapper.MenuMapper;
import com.netlearning.user.mapper.RoleMapper;
import com.netlearning.user.mapper.RoleMenuMapper;
import com.netlearning.user.service.RoleMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: net-learning
 * @description:
 * @author: XUCHANG
 * @time: 2019/12/20 17:23
 */
@Service
public class RoleMenuServiceImpl implements RoleMenuService {
    @Autowired
    private RoleMenuMapper roleMenuMapper;
    @Autowired
    private MenuMapper menuMapper;
    @Autowired
    private SequenceService sequenceService;
    @Autowired
    private RoleMapper roleMapper;


    @Override
    public CommonResult<RoleMenuResult> query(RoleMenuParam roleMenuParam) {

        List<Menu> allmenuList = this.getRoleAllMenu(roleMenuParam);
        RoleMenuResult roleMenuResult = new RoleMenuResult();
        roleMenuResult.setRoleId(roleMenuParam.getRoleId());
        roleMenuResult.setMenus(allmenuList);

        return CommonResult.success(roleMenuResult);
    }

    /**
     * 查询该角色下的所有的菜单资源
     * @param roleMenuParam
     * @return
     */
    private List<Menu> getRoleAllMenu(RoleMenuParam roleMenuParam) {
        List<Long> menuIds = new ArrayList<>();

        RoleMenuExample example = new RoleMenuExample();
        RoleMenuExample.Criteria criteria = example.createCriteria();
        if (roleMenuParam.getMenuId() != null){
            criteria.andMenuIdEqualTo(roleMenuParam.getMenuId());
        }
        if (roleMenuParam.getRoleId() != null){
            criteria.andRoleIdEqualTo(roleMenuParam.getRoleId());
        }
        List<RoleMenu> result = roleMenuMapper.selectByExample(example);

        for (RoleMenu roleMenu : result){
            if (!menuIds.contains(roleMenu.getMenuId())){
                menuIds.add(roleMenu.getMenuId());
            }
        }
        //所有的菜单
        List<Menu> allmenuList = new ArrayList<>();

        MenuExample menuExample = new MenuExample();

        //菜单id不为空
        if (roleMenuParam.getMenuId() != null){
            //父的
            MenuExample.Criteria subMenuParentExampleCriteria = menuExample.createCriteria();
            if (!CollectionUtils.isEmpty(menuIds)){
                subMenuParentExampleCriteria.andMenuIdIn(menuIds);
            }
            List<Menu> parentMenuList = menuMapper.selectByExample(menuExample);
            if (!CollectionUtils.isEmpty(parentMenuList)){
                allmenuList.addAll(parentMenuList);
            }
            //子
            menuExample = new MenuExample();
            MenuExample.Criteria subMenuExampleCriteria = menuExample.createCriteria();
            if (!CollectionUtils.isEmpty(menuIds)){
                subMenuExampleCriteria.andParentIdIn(menuIds);
            }
            List<Menu> subMenuList = menuMapper.selectByExample(menuExample);
            if (!CollectionUtils.isEmpty(subMenuList)){
                allmenuList.addAll(subMenuList);
            }

        }else {//菜单id为空
            MenuExample.Criteria menuExampleCriteria = menuExample.createCriteria();
            if (!CollectionUtils.isEmpty(menuIds)){
                menuExampleCriteria.andMenuIdIn(menuIds);
            }
            List<Menu> menuList = menuMapper.selectByExample(menuExample);
            if (!CollectionUtils.isEmpty(menuList)){
                allmenuList.addAll(menuList);
            }
        }
        return allmenuList;
    }



    @Override
    public CommonResult<Boolean> add(RoleMenu roleMenu) {
        try {
            roleMenuMapper.insertSelective(roleMenu);
            return CommonResult.success(true);
        }catch (Exception e){
            return CommonResult.fail(ExceptionCode.UserAuthCode.CODE002.code,ExceptionCode.UserAuthCode.CODE002.message);
        }
    }

    @Override
    public CommonResult<Boolean> edit(RoleMenu roleMenu) {
        try {
            RoleMenuExample example = new RoleMenuExample();
            RoleMenuExample.Criteria criteria = example.createCriteria();
            if (roleMenu.getMenuId() != null){
                criteria.andMenuIdEqualTo(roleMenu.getMenuId());
            }
            if (roleMenu.getRoleId() != null){
                criteria.andRoleIdEqualTo(roleMenu.getRoleId());
            }
            roleMenuMapper.updateByExampleSelective(roleMenu,example);
            return CommonResult.success(true);
        }catch (Exception e){
            return CommonResult.fail(ExceptionCode.UserAuthCode.CODE003.code,ExceptionCode.UserAuthCode.CODE003.message);
        }
    }

    @Override
    public CommonResult<Boolean> delete(RoleMenu roleMenu) {
        try {
            RoleMenuExample example = new RoleMenuExample();
            RoleMenuExample.Criteria criteria = example.createCriteria();
            if (roleMenu.getMenuId() != null){
                criteria.andMenuIdEqualTo(roleMenu.getMenuId());
            }
            if (roleMenu.getRoleId() != null){
                criteria.andRoleIdEqualTo(roleMenu.getRoleId());
            }
            roleMenuMapper.deleteByExample(example);
            return CommonResult.success(true);
        }catch (Exception e){
            return CommonResult.fail(ExceptionCode.UserAuthCode.CODE004.code,ExceptionCode.UserAuthCode.CODE004.message);
        }
    }

    @Override
    public CommonResult<List<MenuItem>> tree(RoleTreeParam roleTreeParam) {

        //该角色的所有菜单资源
        RoleMenuParam roleMenuParam = new RoleMenuParam();
        roleMenuParam.setMenuId(roleTreeParam.getMenuParentId());
        roleMenuParam.setRoleId(roleTreeParam.getRoleId());
        List<Menu> allMenuList = this.getRoleAllMenu(roleMenuParam);

        //角色菜单资源
        List<MenuItem> roleTreeMenuList = this.getRoleTreeMenu(allMenuList);

        return CommonResult.success(roleTreeMenuList);
    }

    /**
     * 返回该角色下的三层次的树形菜资源
     * @param result
     * @return
     */
    public List<MenuItem> getRoleTreeMenu( List<Menu> result) {
        List<MenuItem> roleTreeMenus = new ArrayList<>();
        //第一层
        Map<Long,Menu> oneTree = new HashMap<>();
        for (Menu menu : result){
            if (menu.getParentId() == null){
                if (!oneTree.containsKey(menu.getMenuId())){
                    oneTree.put(menu.getMenuId(),menu);
                }
            }
        }
        //第二层
        Map<Long,List<Menu>> twoTree = new HashMap<>();
        for (Menu menu : result){
            if (oneTree.containsKey(menu.getParentId())){
                if (twoTree.containsKey(menu.getParentId())){
                    twoTree.get(menu.getParentId()).add(menu);
                }else {
                    List<Menu> list = new ArrayList<>();
                    list.add(menu);
                    twoTree.put(menu.getParentId(),list);
                }
            }
        }
        //第三层
        Map<Long,List<Menu>> threeTree = new HashMap<>();
        for (Map.Entry<Long,List<Menu>> twoEntey : twoTree.entrySet()){
            List<Menu> twoTreeVlaue = twoEntey.getValue();
            for (Menu twoMenu : twoTreeVlaue){
                Long twoKey = twoMenu.getMenuId();
                for (Menu menu : result){
                    if (twoKey.equals(menu.getParentId())){
                        if (threeTree.containsKey(twoKey)){
                            threeTree.get(twoKey).add(menu);
                        }else {
                            List<Menu> list = new ArrayList<>();
                            list.add(menu);
                            threeTree.put(twoKey,list);
                        }
                    }
                }
            }
        }
        //封装返回
        for (Map.Entry<Long,Menu> oneEntry : oneTree.entrySet()){
            MenuItem oneTreeMenu = new MenuItem();
            Long oneKey = oneEntry.getKey();
            Menu oneValue = oneEntry.getValue();
            BeanCopyUtils.copyProperties(oneValue,oneTreeMenu);
            if (twoTree.containsKey(oneKey)){
                List<Menu> twoMenus = twoTree.get(oneKey);
                List<MenuItem> twoMenuItems = BeanCopyUtils.copy(twoMenus,MenuItem.class);
                if (CollectionUtils.isEmpty(twoMenuItems)){
                    oneTreeMenu.setSubMenus(new ArrayList<>());
                }else {
                    oneTreeMenu.setSubMenus(twoMenuItems);
                }

                for (MenuItem twoMenu : twoMenuItems){
                    if (threeTree.containsKey(twoMenu.getMenuId())){
                        List<Menu> threeMenus = threeTree.get(twoMenu.getMenuId());
                        List<MenuItem> threeMenuItems = BeanCopyUtils.copy(threeMenus,MenuItem.class);
                        if (CollectionUtils.isEmpty(threeMenuItems)){
                            twoMenu.setSubMenus(new ArrayList<>());
                        }else {
                            twoMenu.setSubMenus(threeMenuItems);
                        }

                    }
                }
            }else {
                oneTreeMenu.setSubMenus(new ArrayList<>());
            }
            roleTreeMenus.add(oneTreeMenu);
        }

        return roleTreeMenus;
    }
}
