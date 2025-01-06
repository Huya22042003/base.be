package com.example.corebase.core.admin.developer.controller;

import com.example.corebase.core.admin.developer.model.request.AdResourceRequest;
import com.example.corebase.core.admin.developer.model.request.AdResourceFilterRequest;
import com.example.corebase.core.admin.developer.service.AdResourceMngService;
import com.example.corebase.core.base.model.ResponseObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin/resource")
public class AdResourceMngController {

    @Autowired
    private AdResourceMngService service;

    /**
     * Get Page Resource
     * @api /admin/resource/list
     * @param req
     * @return
     */
    @PostMapping("/list")
    public ResponseObject getPageResource(@RequestBody AdResourceFilterRequest req) {
        return new ResponseObject(service.getPageResource(req));
    }

    /**
     * created Resource
     * @api /admin/resource/create
     * @param req
     * @return
     */
    @PostMapping("/create")
    public ResponseObject createResource(@RequestBody AdResourceRequest req) {
        return new ResponseObject(service.createResource(req));
    }

    /**
     * Update Resource
     * @api /admin/resource/update
     * @param req
     * @return
     */
    @PutMapping("/update")
    public ResponseObject updateResource(@RequestBody AdResourceRequest req) {
        return new ResponseObject(service.updateResource(req));
    }

    /**
     * Delete Resource
     * @api /admin/resource/delete
     * @param req
     * @return
     */
    @DeleteMapping("/delete")
    public ResponseObject deleteResource(@RequestBody String req) {
        return new ResponseObject(service.deleteResource(req));
    }

    /**
     * Detail Resource
     * @api /admin/resource/detail
     * @param id
     * @return
     */
    @PostMapping("/detail")
    public ResponseObject goToDetail(@RequestBody String id) {
        return new ResponseObject(service.getResourceDetail(id));
    }

    /**
     * Form data Resource
     * @api /admin/resource/form-data
     * @param
     * @return
     */
    @GetMapping("/form-data")
    public ResponseObject getFormList() {
        return new ResponseObject(service.getFormList());
    }
}
