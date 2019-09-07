package com.sd.farmework.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.sd.farmework.common.HttpSessionProvider;
import com.sd.farmework.common.util.StringUtil;
import com.sd.farmework.pojo.SysUserInfo;
import com.sd.farmework.service.SysUserInfoService;
import com.sd.farmework.wx.QYWeixinUtil;
import com.sd.farmework.wx.QYWxConstant;


/**
 * 公用controller创建session
 * @author wangchaochao
 * 2017-03-02
 * 
 */

 @Scope("prototype")
 @Controller("wx_baseController")
public class BaseController {
	 
	 	@Autowired
		private SysUserInfoService SysUserInfoService;
		@Autowired 
		protected QYWxConstant QYWxConstant ;

		
		
		public  SysUserInfo setUserSession(String code,HttpServletRequest request){
			SysUserInfo userInfo =null;
			try {
				if(StringUtil.isNotNullOrBlank(code)){
					Map map = QYWeixinUtil.getWeiXinUserInfo(code, QYWxConstant);
					//Map map =new HashMap();
					//map.put("code", "000");
					if(map.get("code")=="000"){
						Map map1=(Map) map.get("result");
						userInfo = new SysUserInfo();
						userInfo.setWxOpenId((String) map1.get("UserId"));
						userInfo = (SysUserInfo)SysUserInfoService.queryUserInfoByOpenId(userInfo);
						System.out.println("BaseController获取微信id"+map1.get("UserId"));
						System.out.println("查询出的用户信息"+userInfo.toString());
						if(userInfo!=null){
							request.getSession().setAttribute(HttpSessionProvider.CURRENT_USER_SESSION_KEY,userInfo);
						
						}
						
					}
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return userInfo;
						 
			}
			return userInfo;
		}
		/**
		 * 获取用户session
		 * @param request
		 * @return
		 */
		public  SysUserInfo getUserSession(HttpServletRequest request){
			SysUserInfo sessionUser  = null; 
			String code = request.getParameter("code");
			if(request.getSession().getAttribute(HttpSessionProvider.CURRENT_USER_SESSION_KEY)!=null){
				sessionUser= (SysUserInfo)request.getSession().getAttribute(HttpSessionProvider.CURRENT_USER_SESSION_KEY);
			}else{
				sessionUser = setUserSession(code,request);
				System.out.println("session中的用户："+sessionUser.toString());
			}
			return sessionUser;
		}
	 
}
