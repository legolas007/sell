package com.usher.controller;

import com.usher.config.FastDFSClientWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * @Author: Usher
 * @Description:
 */
@RestController
@RequestMapping("/seller/product")
public class FastDFSController {

    @Autowired
    private FastDFSClientWrapper dfsClient;

    // 上传文件
    @PostMapping(value = "/upload")
    public String upload(MultipartFile file, HttpServletRequest request, HttpServletResponse response,
                               Map<String, Object> map) throws Exception {
        String fileUrl= dfsClient.uploadFile(file);
        map.put("picture",fileUrl);
        return fileUrl;
    }
}
