package com.test.pms.controller;

import com.test.pms.pojo.Result;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@RestController
public class UploadController {
    @PostMapping("/upload")
    public Result upload(MultipartFile image) throws IOException {
        String originalFilename = image.getOriginalFilename();

        String newFileName = UUID.randomUUID().toString()+originalFilename.substring(originalFilename.lastIndexOf("."));
        image.transferTo(new File("C:\\Users\\ss\\Desktop\\PMS\\images\\"+newFileName));

        return Result.success();
    }
}
