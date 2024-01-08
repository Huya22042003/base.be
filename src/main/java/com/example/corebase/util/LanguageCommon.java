package com.example.corebase.util;

import com.example.corebase.infrastructure.constant.Constants;
import com.example.corebase.infrastructure.constant.LanguageConstants;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LanguageCommon {

    @Autowired
    private HttpSession session;

    public boolean changeLanguageCommon(String languageConstants) {
        try {
            session.setAttribute(LanguageConstants.LANGUAGE_BASE, languageConstants);
        } catch (Exception exception) {
            exception.printStackTrace();
            return false;
        }
        return true;
    }

    public String getMessageProperties(String key) {
        Object languageSwitch = session.getAttribute(LanguageConstants.LANGUAGE_BASE);
        if (LanguageConstants.LANGUAGE_ENGLISH.equals(languageSwitch)) {
            return PropertiesRead.getProperty(key, Constants.FileProperties.PROPERTIES_MESSAGE_EN);
        }
        if (LanguageConstants.LANGUAGE_VIETNAMESE.equals(languageSwitch)) {
            return PropertiesRead.getProperty(key, Constants.FileProperties.PROPERTIES_MESSAGE_VN);
        }
        return PropertiesRead.getProperty(key, Constants.FileProperties.PROPERTIES_MESSAGE_VN);
    }
}
