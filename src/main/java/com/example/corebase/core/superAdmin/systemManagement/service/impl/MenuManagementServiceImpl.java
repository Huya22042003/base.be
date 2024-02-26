package com.example.corebase.core.superAdmin.systemManagement.service.impl;

import com.example.corebase.core.superAdmin.systemManagement.model.response.MenuLoginResponse;
import com.example.corebase.core.superAdmin.systemManagement.model.response.MenuLoginResponseImpl;
import com.example.corebase.core.superAdmin.systemManagement.repository.MenuLoginRepository;
import com.example.corebase.core.superAdmin.systemManagement.service.MenuManagementService;
import com.example.corebase.util.LanguageCommon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("objectLoginService")
public class MenuManagementServiceImpl implements MenuManagementService {

    @Autowired
    @Qualifier("objectLoginRepository")
    private MenuLoginRepository repository;

    @Autowired
    private LanguageCommon languageCommon;

    @Override
    public List<MenuLoginResponseImpl> getMenuLogin() {
        List<MenuLoginResponse> menuLoginRepository = repository.getAllMenuLoginResponse("admin");
//        List<MenuLoginResponseImpl> menuLoginResponses = getMenuLoginResponse(menuLoginRepository);
        List<MenuLoginResponseImpl> root = buildRootMenuTree(menuLoginRepository);
        List<MenuLoginResponseImpl> notRoot = buildNotRootMenuTree(menuLoginRepository);

        root.forEach(el -> {
            el.setChildId(buildSubMenuTree(el.getId(), notRoot));
        });

        return root;
    }

    public List<MenuLoginResponseImpl> buildRootMenuTree(List<MenuLoginResponse> menuList) {
        List<MenuLoginResponseImpl> menuTree = new ArrayList<>();
        for (MenuLoginResponse el : menuList) {
            if (el.getParentId() == null) {
                MenuLoginResponseImpl node = new MenuLoginResponseImpl(el.getId(), el.getCode(),
                        languageCommon.getMessageProperties(el.getKey()), el.getUrl(),
                        new ArrayList<>(), el.getOrderBy(), el.getParentId());
                menuTree.add(node);
            }
        }

        return menuTree;
    }

    public List<MenuLoginResponseImpl> buildNotRootMenuTree(List<MenuLoginResponse> menuList) {
        List<MenuLoginResponseImpl> menuTree = new ArrayList<>();

        for (MenuLoginResponse el : menuList) {
            if (el.getParentId() != null) {
                MenuLoginResponseImpl node = new MenuLoginResponseImpl(el.getId(), el.getCode(),
                        languageCommon.getMessageProperties(el.getKey()), el.getUrl(),
                        new ArrayList<>(), el.getOrderBy(), el.getParentId());
                menuTree.add(node);
            }
        }

        return menuTree;
    }

    private List<MenuLoginResponseImpl> buildSubMenuTree(Long parentId, List<MenuLoginResponseImpl> objectsList) {
        List<MenuLoginResponseImpl> subMenuTree = new ArrayList<>();
        for (MenuLoginResponseImpl el : objectsList) {
            if (parentId.equals(el.getParentId())) {
                MenuLoginResponseImpl node = new MenuLoginResponseImpl(el.getId(), el.getCode(),
                        el.getName(), el.getUrl(),
                        buildSubMenuTree(el.getId(), objectsList), el.getOrderBy(), el.getParentId());
                subMenuTree.add(node);
            }
        }

        return subMenuTree;
    }

}
