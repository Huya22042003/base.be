package com.example.corebase.core.superAdmin.systemManagement.service.impl;

import com.example.corebase.core.superAdmin.systemManagement.model.response.SuMenuLoginResponse;
import com.example.corebase.core.superAdmin.systemManagement.model.response.SuMenuLoginResponseImpl;
import com.example.corebase.core.superAdmin.systemManagement.repository.SuMenuLoginRepository;
import com.example.corebase.core.superAdmin.systemManagement.service.SuMenuManagementService;
import com.example.corebase.util.LanguageCommon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("objectLoginService")
public class SuMenuManagementServiceImpl implements SuMenuManagementService {

    @Autowired
    @Qualifier("objectLoginRepository")
    private SuMenuLoginRepository repository;

    @Autowired
    private LanguageCommon languageCommon;

    @Override
    public List<SuMenuLoginResponseImpl> getMenuLogin() {
        List<SuMenuLoginResponse> menuLoginRepository = repository.getAllMenuLoginResponse("admin");
//        List<MenuLoginResponseImpl> menuLoginResponses = getMenuLoginResponse(menuLoginRepository);
        List<SuMenuLoginResponseImpl> root = buildRootMenuTree(menuLoginRepository);
        List<SuMenuLoginResponseImpl> notRoot = buildNotRootMenuTree(menuLoginRepository);

        root.forEach(el -> {
            el.setChildId(buildSubMenuTree(el.getId(), notRoot));
        });

        return root;
    }

    public List<SuMenuLoginResponseImpl> buildRootMenuTree(List<SuMenuLoginResponse> menuList) {
        List<SuMenuLoginResponseImpl> menuTree = new ArrayList<>();
        for (SuMenuLoginResponse el : menuList) {
            if (el.getParentId() == null) {
                SuMenuLoginResponseImpl node = new SuMenuLoginResponseImpl(el.getId(), el.getCode(),
                        languageCommon.getMessageProperties(el.getKey()) == "" ?
                                el.getName() : languageCommon.getMessageProperties(el.getKey()), el.getUrl(),
                        el.getIcon(), new ArrayList<>(), el.getOrderBy(), el.getParentId());
                menuTree.add(node);
            }
        }

        return menuTree;
    }

    public List<SuMenuLoginResponseImpl> buildNotRootMenuTree(List<SuMenuLoginResponse> menuList) {
        List<SuMenuLoginResponseImpl> menuTree = new ArrayList<>();

        for (SuMenuLoginResponse el : menuList) {
            if (el.getParentId() != null) {
                SuMenuLoginResponseImpl node = new SuMenuLoginResponseImpl(el.getId(), el.getCode(),
                        languageCommon.getMessageProperties(el.getKey()), el.getUrl(),
                        el.getIcon(), new ArrayList<>(), el.getOrderBy(), el.getParentId());
                menuTree.add(node);
            }
        }

        return menuTree;
    }

    private List<SuMenuLoginResponseImpl> buildSubMenuTree(Long parentId, List<SuMenuLoginResponseImpl> objectsList) {
        List<SuMenuLoginResponseImpl> subMenuTree = new ArrayList<>();
        for (SuMenuLoginResponseImpl el : objectsList) {
            if (parentId.equals(el.getParentId())) {
                SuMenuLoginResponseImpl node = new SuMenuLoginResponseImpl(el.getId(), el.getCode(),
                        el.getName(), el.getUrl(),
                        el.getIcon(), buildSubMenuTree(el.getId(), objectsList), el.getOrderBy(), el.getParentId());
                subMenuTree.add(node);
            }
        }

        return subMenuTree;
    }

}
