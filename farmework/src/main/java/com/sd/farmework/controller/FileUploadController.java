package com.sd.farmework.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.sd.farmework.common.FileUpload;
import com.sd.farmework.common.PropertiesConstant;
import com.sd.farmework.common.util.StringUtil;

/**
 * Created by shhao.
 * Date: 17-3-1
 * Time:11:36
 * 处理文件上传下载
 */

@Controller
public class FileUploadController {
	@Autowired
	private   PropertiesConstant propertiesConstant;
    @RequestMapping("upload")
    public void upload( HttpServletRequest request, HttpServletResponse response) throws IOException {
        
    	MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;  
    	List<MultipartFile> list=multipartRequest.getFiles("files");
    	
    	
    	if (list.size()>0) {
			for(MultipartFile MultipartFile : list){
				String filePath =  FileUpload.uploadFile(MultipartFile, request,propertiesConstant);
				if(StringUtil.isNotNullOrBlank(filePath)){
				response.setContentType("text/html;charset=utf-8");
				response.getWriter().write(filePath+(list.size()>1?"^":""));
				}
			}
    	}
    	
    }
    
    @RequestMapping("download")
    public void download(String fileName,String resouceName, HttpServletResponse response) throws IOException {
        OutputStream os = response.getOutputStream();
        String[]fileType=fileName.split("\\.");
        Map map=new HashMap();
        map.put("jpg", "image/jpeg;");
        map.put("xls", "application/x-xls;");
        map.put("xlsx", "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;");
        map.put("doc", "application/msword;");
        map.put("docx", "application/vnd.openxmlformats-officedocument.wordprocessingml.document;");
        map.put("txt", "text/plain;");
        map.put("pdf", "application/pdf;");
        try {
            response.reset();
            response.setHeader("Content-Disposition", "attachment; filename=" + java.net.URLEncoder.encode(resouceName, "UTF-8"));  
            response.setContentType(map.get(fileType[fileType.length-1])+" charset=utf-8");
            os.write(FileUtils.readFileToByteArray(FileUpload.getFile(fileName,propertiesConstant)));
            os.flush();
        } finally {
            if (os != null) {
                os.close();
            }
        }
    }
    
}
