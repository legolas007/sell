package com.usher.config;

import java.io.IOException;
import java.io.InputStream;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.github.tobato.fastdfs.domain.StorePath;
import com.github.tobato.fastdfs.service.FastFileStorageClient;

/**
 * @Author: Usher
 * @Description:
 */
@Component
public class FastDFSClientWrapper {

    @Autowired
    private FastFileStorageClient storageClient;

    public String uploadFile(MultipartFile file) throws IOException {
        StorePath storePath = storageClient.uploadFile((InputStream)file.getInputStream(),file.getSize(), FilenameUtils.getExtension(file.getOriginalFilename()),null);
        return getResAccessUrl(storePath);
    }

    /**
     * 上传文件
     * @return 文件访问地址
     * @throws IOException
     */
    public String uploadFileStream(InputStream is,long size,String fileName) throws IOException {
        StorePath storePath = storageClient.uploadFile(is,size, FilenameUtils.getExtension(fileName),null);
        return getResAccessUrl(storePath);
    }
    // 封装文件完整URL地址
    private String getResAccessUrl(StorePath storePath) {
        String fileUrl = "http://192.168.25.133" + "/" + storePath.getFullPath();
        return fileUrl;
    }
}