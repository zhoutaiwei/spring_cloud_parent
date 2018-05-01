package com.api.gateway.controller;

import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Controller
public class FileUploadController {
    /**
     * 上传文件
     * 测试方法： http://localhost:5555/index.html
     * 使用命令  ： curl -F "file =@文件全名" localhost:5555/upload
     * @param file
     * @return
     * @throws IOException
     */
    @PostMapping("/upload")
    public @ResponseBody String fileUpload(@RequestParam(value = "file",required = true)MultipartFile file) throws IOException {
        byte[] bytes = file.getBytes();
        File fileToSave = new File(file.getOriginalFilename());
        FileCopyUtils.copy(bytes,fileToSave);
        System.out.println("文件 上传中、。。。。");
        return fileToSave.getAbsolutePath();
    }

}
