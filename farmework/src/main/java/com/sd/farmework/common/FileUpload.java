package com.sd.farmework.common;

 
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import com.sd.farmework.common.util.StringUtil;

/**
 * Created by shhao.
 * Date: 14-9-1
 * Time:下午4:12
 */

public class FileUpload {

  
	//文件上传
    public static String uploadFile(MultipartFile file, HttpServletRequest request,PropertiesConstant propertiesConstant) throws IOException {
        String fileName = file.getOriginalFilename();
        if(StringUtil.isNotNullOrBlank(fileName)){
	        SimpleDateFormat sf=new SimpleDateFormat("yyyyMMddHHmmss");
	        if("application/pdf".equals(file.getContentType())){fileName=".pdf";}
	        File tempFile = new File(propertiesConstant.getFilePath(),  sf.format(new Date())+String.valueOf(fileName));
	        if (!tempFile.getParentFile().exists()) {
	            tempFile.getParentFile().mkdir();
	        }
	        if (!tempFile.exists()) {
	            tempFile.createNewFile();
	        }
	        file.transferTo(tempFile);
	        return "download.do?fileName=" + tempFile.getName();
        }
        return "";
    }
    
    public static File getFile(String fileName,PropertiesConstant propertiesConstant) {
        return new File(propertiesConstant.getFilePath(), fileName);
    }
}
