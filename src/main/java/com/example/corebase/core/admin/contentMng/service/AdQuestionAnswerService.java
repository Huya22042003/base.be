package com.example.corebase.core.admin.contentMng.service;

import com.example.corebase.core.admin.contentMng.model.dto.AdQuestionAnswerDetailDTO;
import com.example.corebase.core.admin.contentMng.model.dto.AdQuestionAnswerResDTO;
import com.example.corebase.core.admin.contentMng.model.request.AdQuestionAnswerFilterReq;
import com.example.corebase.core.admin.contentMng.model.request.AdQuestionAnswerReq;
import com.example.corebase.core.base.model.PageableObject;

public interface AdQuestionAnswerService {

    PageableObject<AdQuestionAnswerResDTO> getPageData(AdQuestionAnswerFilterReq req);

    AdQuestionAnswerDetailDTO getDataDetail(String id);

    Boolean saveData(AdQuestionAnswerReq req);

    Boolean rejectQuestion(String id);
}
