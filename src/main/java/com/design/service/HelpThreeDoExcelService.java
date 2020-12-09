package com.design.service;

import org.springframework.web.multipart.MultipartFile;

public interface HelpThreeDoExcelService {
    public String readExcelFile(MultipartFile file);
}
