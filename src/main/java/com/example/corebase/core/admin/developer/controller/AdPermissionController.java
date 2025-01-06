package com.example.corebase.core.admin.developer.controller;

import com.example.corebase.core.admin.developer.model.dto.AdPermissionResDto;
import com.example.corebase.core.admin.developer.model.request.AdPermissionFilterRequest;
import com.example.corebase.core.admin.developer.model.request.AdPermissionRequest;
import com.example.corebase.core.admin.developer.service.AdPermissionService;
import com.example.corebase.core.base.model.PageableObject;
import com.example.corebase.core.base.model.ResponseObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin/permission")
public class AdPermissionController {

    @Autowired
    private AdPermissionService service;

    /**
     * Get Page permission
     * @api /admin/permission/list
     * @param req
     * @return
     */
    @PostMapping("/list")
    public ResponseObject<PageableObject<AdPermissionResDto>> getPagePermission(@RequestBody AdPermissionFilterRequest req) {
        return new ResponseObject(service.getPagePermission(req));
    }

    /**
     * Update permission
     * @api /admin/permission/update
     * @param req
     * @return
     */
    @PostMapping("/update")
    public ResponseObject updatePermission(@RequestBody AdPermissionRequest req) {
        return new ResponseObject(service.updatePermission(req));
    }

    /**
     * Delete permission
     * @api /admin/permission/delete
     * @param req
     * @return
     */
    @DeleteMapping("/delete")
    public ResponseObject deletePermission(@RequestBody String req) {
        return new ResponseObject(service.deletePermission(req));
    }

    /**
     * Detail permission
     * @api /admin/permission/detail
     * @param req
     * @return
     */
    @PostMapping("/detail")
    public ResponseObject getPermissionDetail(@RequestBody String req) {
        return new ResponseObject(service.getPermissionDetail(req));
    }
}
