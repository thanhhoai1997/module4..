package com.example.service;

import com.example.model.Upload;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UploadFileService {
    private List<Upload> list = new ArrayList<>();
    public void uploadFile(MultipartFile file) throws IOException {
        String foderUpload = "D:\\A0423I1_Nguyen_Thanh_Hoai\\module4\\03-dataBingding_Form\\bt2\\src\\main\\resources\\upload_file.properties";
        String fileName = file.getOriginalFilename();
        FileCopyUtils.copy(file.getBytes(),new File(foderUpload + fileName));
    }

    public void save(Upload upload) {
        list.add(upload);

    }

    public List<Upload> findAll() {
        return list;
    }
}
