package com.example.corebase.core.admin.developer.controller;

import com.example.corebase.core.admin.developer.model.request.AdModuleFilterRequest;
import com.example.corebase.core.admin.developer.model.request.AdModuleRequest;
import com.example.corebase.core.admin.developer.service.AdModuleMngService;
import com.example.corebase.core.base.model.ResponseObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin/module")
public class AdModuleMngController {

    @Autowired
    private AdModuleMngService service;

    /**
     * Get Page Module
     * @api /admin/module/list
     * @param req
     * @return
     */
    @PostMapping("/list")
    public ResponseObject getPageModule(@RequestBody AdModuleFilterRequest req) {
        return new ResponseObject(service.getPageModule(req));
    }

    /**
     * created Module
     * @api /admin/module/create
     * @param req
     * @return
     */
    @PostMapping("/create")
    public ResponseObject createModule(@RequestBody AdModuleRequest req) {
        return new ResponseObject(service.createModule(req));
    }

    /**
     * Update Module
     * @api /admin/module/update
     * @param req
     * @return
     */
    @PutMapping("/update")
    public ResponseObject updateModule(@RequestBody AdModuleRequest req) {
        return new ResponseObject(service.updateModule(req));
    }

    /**
     * Delete Module
     * @api /admin/module/delete
     * @param req
     * @return
     */
    @DeleteMapping("/delete")
    public ResponseObject deleteModule(@RequestBody String req) {
        return new ResponseObject(service.deleteModule(req));
    }

    /**
     * Detail Module
     * @api /admin/module/detail
     * @param id
     * @return
     */
    @PostMapping("/detail")
    public ResponseObject getModuleDetail(@RequestBody String id) {
        return new ResponseObject(service.getModuleDetail(id));
    }

}
