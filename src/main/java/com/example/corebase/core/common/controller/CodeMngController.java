package com.example.corebase.core.common.controller;

import com.example.corebase.core.common.service.CodeMngService;
import com.example.corebase.core.common.service.dto.CodeMngDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/code")
public class CodeMngController {

    private final Logger log = LoggerFactory.getLogger(CodeMngController.class);

    private final CodeMngService codeMngService;

    public CodeMngController(CodeMngService codeMngService) {
        this.codeMngService = codeMngService;
    }

    @GetMapping("/search")
    public List<CodeMngDTO> getCodeByUpId(@RequestParam String upCdId) {
        try {
            return codeMngService.getByUpId(upCdId);
        } catch (Exception e) {
            log.error(e.getMessage());
            throw e;
        }
    }

    @GetMapping("/listCode/{upcIdList}")
    public List<CodeMngDTO> getCodeByUpIdList(@PathVariable(name="upcIdList") List<String> upcIdList) {
        try {
            return codeMngService.getListCode(upcIdList);
        } catch (Exception e) {
            log.error(e.getMessage());
            throw e;
        }
    }
}
