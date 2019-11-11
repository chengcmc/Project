package com.project.manager.controller;

import com.github.tobato.fastdfs.domain.fdfs.StorePath;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import com.project.utils.NameUtil;
import com.project.utils.StringUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
@Controller
@RequestMapping("/restful/file")
public class FileUploadController {
    //注入组件
    @Autowired
    private FastFileStorageClient storageClient;
    //定义照片路径，作为图片服务器的地址
    @Value("${SHOP_IMG_URL}")
    private String imgurl;
    //实现文件上传的方法
    @PostMapping("/upload")
    @ResponseBody
    public Map<String,Object> fileUpload(MultipartFile file){
        Map<String,Object> map=new HashMap<>();
        //获得文件的大小
        long size=file.getSize();
        //获得文件的后缀名
        String orginal=file.getOriginalFilename();
        String suffixName= FilenameUtils.getExtension(orginal);
        //获得文件类型
        Integer uploadFlieType = NameUtil.getUploadFlieType(suffixName);
        //获得文件成功上传后的访问路径
        String visitUrl=null;
        try {
            if(uploadFlieType==1) { //判断是否是一个图片，是图片再传
                //实现文件上传 要求传递的文件后缀名 jpg gif 返回上传成功后的存储路径
                String orginalName = StringUtils.substringAfterLast(orginal, ".");
                StorePath storePath = storageClient.uploadFile(file.getInputStream(), size, suffixName, null);
                System.out.println("文件上传路径为："+storePath);
                String fullPath = storePath.getFullPath();
                //"http://192.168.5.121/"
                visitUrl=imgurl+fullPath;
                map.put("state","SUCCESS");
                map.put("url",visitUrl);
                map.put("size",file.getSize());
                map.put("original",orginalName);
                map.put("type",file.getContentType());

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return map;
    }
}
