package com.sd.farmework.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sd.farmework.common.HttpSessionProvider;
import com.sd.farmework.common.JSONUtils;
import com.sd.farmework.common.MakeCertPic;
import com.sd.farmework.common.PropertiesConstant;
import com.sd.farmework.common.util.StringUtil;

/**
 * 生成验证码
 * @author 王超超
 * 2016-10-26
 * 
 */

@Controller
@Scope("prototype")
@RequestMapping(value="/wx")
public class CodeController {
	Logger logger = Logger.getLogger(CodeController.class);
	
	@Autowired
	private PropertiesConstant propertiesConstant;
	@RequestMapping(value = "/getCode", method = RequestMethod.GET)
	public String getCode(HttpSession session, Model model,HttpServletRequest request,HttpServletResponse response,String msgType,String mobileNo) throws IOException{
		OutputStream out  = response.getOutputStream();
		
 
		String str=MakeCertPic.getCertPic(0,0,out);
		if("getPassword".equals(msgType)){
			session.removeAttribute(HttpSessionProvider.GET_PASSWORD_IMG_CODE);//使用后的图形验证码立即清除
			session.setAttribute(HttpSessionProvider.GET_PASSWORD_IMG_CODE, str);
		}
		if("updatePassword".equals(msgType)){
			session.removeAttribute(HttpSessionProvider.UPDATE_PASSWORD_IMG_CODE);//使用后的图形验证码立即清除
			session.setAttribute(HttpSessionProvider.UPDATE_PASSWORD_IMG_CODE, str);
		}
		if("updatePhone".equals(msgType)){
			session.removeAttribute(HttpSessionProvider.UPDATE_PHONE_IMG_CODE);//使用后的图形验证码立即清除
			session.setAttribute(HttpSessionProvider.UPDATE_PHONE_IMG_CODE, str);
		}
		
		response.setContentType("image/jpeg; charset=utf-8");
		
		out.write(str.getBytes());
		out.close();
		 
		return null;
	}
	
	
	
	/**
	 * 验证opt动态码
	 * @author 王超超
	 * 
	 */
	@RequestMapping(value = "/verifyOtp", method = RequestMethod.GET)
	@ResponseBody
	public String verifyOtp(HttpSession session, Model model,HttpServletRequest request,
			HttpServletResponse response,String msgType) throws IOException{
		String mobileNo = request.getParameter("mobileNo");
		String dynamicCode = request.getParameter("dynamicCode");
		
		
		logger.info("CodeController.verifyOtp[mobileNo="+mobileNo+"\t imgCode="+dynamicCode+"]");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("code", "000");
		map.put("msg", "success");
		
		String sessionCode ="";
		if("getPassword".equals(msgType)){
			sessionCode=(String)session.getAttribute(HttpSessionProvider.GET_PASSWORD_MOBILE_OTP+mobileNo);
			session.removeAttribute(HttpSessionProvider.GET_PASSWORD_MOBILE_OTP+mobileNo);//使用后的动态码立即清除
		}
		if("updatePassword".equals(msgType)){
			sessionCode=(String)session.getAttribute(HttpSessionProvider.UPDATE_PASSWORD_MOBILE_OTP+mobileNo);//使用后的图形验证码立即清除
			session.removeAttribute(HttpSessionProvider.UPDATE_PASSWORD_MOBILE_OTP+mobileNo);//使用后的动态码立即清除
		}
		if("updatePhone".equals(msgType)){
			sessionCode=(String)session.getAttribute(HttpSessionProvider.UPDATE_PHONE_MOBILE_OTP+mobileNo);//使用后的图形验证码立即清除
			session.removeAttribute(HttpSessionProvider.UPDATE_PHONE_MOBILE_OTP+mobileNo);//使用后的动态码立即清除
			 
		}
		//验证图形验证码
		if(StringUtil.isNullOrBlank(dynamicCode)||!dynamicCode.equals(sessionCode)){
			map.put("code", "001");
			map.put("msg", "动态码验证错误");
			JSONUtils.objectToJson(request, response, map);
			return null;
		}
		logger.info(mobileNo+"otp动态码验证成功");
		map.put("mobileNo", mobileNo);
		
		JSONUtils.objectToJson(request, response, map);
		return null;
	}
	
	
}
