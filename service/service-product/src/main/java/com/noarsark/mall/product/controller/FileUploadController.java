package com.noarsark.mall.product.controller;

import com.noarsark.mall.common.result.Result;
import org.apache.commons.io.FilenameUtils;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient1;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author noarsark
 * @date 2022/7/28
 * @apiNote
 */
@RestController
@RequestMapping("admin/product/")
public class FileUploadController {

    @Value("${fileServer.url}")
    private String fileServerUrl;

    @PostMapping("fileUpload")
    public Result<String> fileUpload(MultipartFile file) throws Exception{
        String configFile = this.getClass().getResource("/tracker.conf").getFile();
        String path = null;

        if (configFile!=null){
            // 初始化
            ClientGlobal.init(configFile);
            // 创建trackerClient
            TrackerClient trackerClient = new TrackerClient();
            // 获取trackerService
            TrackerServer trackerServer = trackerClient.getConnection();
            // 创建storageClient1
            StorageClient1 storageClient1 = new StorageClient1(trackerServer, null);
            // getExtension获取到文件后缀名  zly.jpg  ---> xdfsfarwr1234554542as9082304.jpg
            // group1/M00/00/01/wKjIgF9zVVGEavWOAAAAAO_LJ4k561.png
            path = storageClient1.upload_appender_file1(file.getBytes(), FilenameUtils.getExtension(file.getOriginalFilename()), null);
            System.out.println("文件上传之后的路径：\t"+ fileServerUrl + path);
        }
        return Result.ok(fileServerUrl +path);
    }


}
