package com.example.corebase.core.common.service;

import com.example.corebase.core.common.service.dto.CodeMngDTO;
import com.example.corebase.repository.CodeMngRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CodeMngService {

    private final CodeMngRepository codeMngRepository;

    public CodeMngService(CodeMngRepository codeMngRepository) {
        this.codeMngRepository = codeMngRepository;
    }

    /**
     * 코드 검색
     *
     * @param upCdId
     * @return
     */
    public List<CodeMngDTO> getByUpId(String upCdId) {
//        List<CodeMngEntity> listResult = codeMngRepository.selectByUpCdId(upCdId);
//        List<CodeMngDTO> listCode = listResult.stream().map(item -> modelMapper.map(item, CodeMngDTO.class))
//                .collect(Collectors.toList());

        return null;
    }

    public List<CodeMngDTO> getListCode(List<String> listUpCdId) {
//        List<CodeMngEntity> listResult = codeMngRepository.findByUpCdIdInAndUseYn(listUpCdId, "Y");
//        List<CodeMngDTO> listCode = listResult.stream().map(item -> modelMapper.map(item, CodeMngDTO.class))
//                .collect(Collectors.toList());

        return null;
    }
}
