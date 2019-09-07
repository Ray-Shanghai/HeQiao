package com.sd.farmework;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.SocketException;
import java.net.UnknownHostException;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class QianMing {
	/**
	 * @param args
	 * @throws UnknownHostException 
	 * @throws SocketException 
	 */
	public static void main(String[] args) throws UnknownHostException, SocketException {
		 
			
			String str="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";
			
			try {
				GenerateImage(str,"d://test1.png");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	  
	 
	//图片转化成base64字符串  
	    public static String GetImageStr()  
	    {//将图片文件转化为字节数组字符串，并对其进行Base64编码处理  
	        String imgFile = "D:\\360CloudUI\\tupian\\jt.jpg";//待处理的图片  
	        InputStream in = null;  
	        byte[] data = null;  
	        //读取图片字节数组  
	        try   
	        {  
	            in = new FileInputStream(imgFile);          
	            data = new byte[in.available()];  
	            in.read(data);  
	            in.close();  
	        }   
	        catch (IOException e)   
	        {  
	            e.printStackTrace();  
	        }  
	        //对字节数组Base64编码  
	        BASE64Encoder encoder = new BASE64Encoder();  
	        return encoder.encode(data);//返回Base64编码过的字节数组字符串  
	    }  
	      
	    //base64字符串转化成图片  
	    public static boolean GenerateImage(String imgStr,String filePath)  
	    {   //对字节数组字符串进行Base64解码并生成图片  
	        if (imgStr == null) //图像数据为空  
	            return false;  
	        BASE64Decoder decoder = new BASE64Decoder();  
	        try   
	        {  
	            //Base64解码  
	            byte[] b = decoder.decodeBuffer(imgStr);  
	            for(int i=0;i<b.length;++i)  
	            {  
	                if(b[i]<0)  
	                {//调整异常数据  
	                    b[i]+=256;  
	                }  
	            }  
	            //生成jpeg图片  
	            String imgFilePath = filePath;//新生成的图片  
	            OutputStream out = new FileOutputStream(imgFilePath);      
	            out.write(b);  
	            out.flush();  
	            out.close();  
	            return true;  
	        }   
	        catch (Exception e)   
	        {  
	            return false;  
	        }  
	    }  
}