package com.example.corebase.core.admin.developer.controller;

import com.example.corebase.core.admin.developer.model.request.AdMenuFilterRequest;
import com.example.corebase.core.admin.developer.model.request.AdMenuRequest;
import com.example.corebase.core.admin.developer.service.AdMenuMngService;
import com.example.corebase.core.base.model.ResponseObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin/menu")
public class AdMenuMngController {

    @Autowired
    private AdMenuMngService service;

    /**
     * Get Page Menu
     * @api /admin/menu/list
     * @param req
     * @return
     */
    @PostMapping("/list")
    public ResponseObject getPageMenu(@RequestBody AdMenuFilterRequest req) {
        return new ResponseObject(service.getPageMenu(req));
    }

    /**
     * created Menu
     * @api /admin/menu/create
     * @param req
     * @return
     */
    @PostMapping("/create")
    public ResponseObject createMenu(@RequestBody AdMenuRequest req) {
        return new ResponseObject(service.createMenu(req));
    }

    /**
     * Update Menu
     * @api /admin/menu/update
     * @param req
     * @return
     */
    @PutMapping("/update")
    public ResponseObject updateMenu(@RequestBody AdMenuRequest req) {
        return new ResponseObject(service.updateMenu(req));
    }

    /**
     * Delete Menu
     * @api /admin/menu/delete
     * @param req
     * @return
     */
    @DeleteMapping("/delete")
    public ResponseObject deleteMenu(@RequestBody String req) {
        return new ResponseObject(service.deleteMenu(req));
    }

    /**
     * Detail Menu
     * @api /admin/menu/detail
     * @param id
     * @return
     */
    @PostMapping("/detail")
    public ResponseObject goToDetail(@RequestBody String id) {
        return new ResponseObject(service.getMenuDetail(id));
    }

    /**
     * Get Page Menu
     * @api /admin/menu/get-form
     * @param
     * @return
     */
    @PostMapping("/get-form")
    public ResponseObject getForm() {
        return new ResponseObject(service.getFormList());
    }
}
