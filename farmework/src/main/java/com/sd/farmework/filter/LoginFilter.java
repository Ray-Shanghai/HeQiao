package com.sd.farmework.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sd.farmework.common.HttpSessionProvider;
import com.sd.farmework.common.JSONUtils;
import com.sd.farmework.common.util.StringUtil;
import com.sd.farmework.pojo.SysUserInfo;

public class LoginFilter implements Filter {

	public void init(FilterConfig filterConfig) throws ServletException {

	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {

		// 获得在下面代码中要用的request,response,session对象
		response.reset();
		HttpServletRequest servletRequest = (HttpServletRequest) request;
		HttpServletResponse servletResponse = (HttpServletResponse) response;
		HttpSession session = servletRequest.getSession();

		
		
		
		// 获得用户请求的URI
		String path = servletRequest.getRequestURI();
		
		// 微信
		if (path.indexOf("/wx/") > -1 || path.indexOf("/wxpage/") > -1) {
			String code = servletRequest.getParameter("code");
			if(path.indexOf(".jpg")>-1||path.indexOf(".png")>-1||path.indexOf(".html")>-1||path.indexOf(".css")>-1||path.indexOf(".js")>-1){
				chain.doFilter(servletRequest, servletResponse);
				return;
			}else if(path.indexOf(".do")>-1&&StringUtil.isNullOrBlank(code)){
				//微信端登陆外地址
				String loginOutPath[] = {"/common/","userLogin.do","WxUserInfoModule/addUserInfo.do","wx/getCode.do","sendOtpCode.do"};
			    boolean isTrue =false;
			   for (int i = 0; i < loginOutPath.length; i++) {
				    if(path.indexOf(loginOutPath[i])>-1){
				    	isTrue =true;
				    	break;
				    }
			   }
			   SysUserInfo sysUser= (SysUserInfo) servletRequest.getSession().getAttribute(HttpSessionProvider.CURRENT_USER_SESSION_KEY);
			   if(sysUser!=null||isTrue){
				   chain.doFilter(servletRequest, servletResponse);
					return;
			   }else{
					Map map = new HashMap();
					map.put("code", HttpSessionProvider.FILTER_LOGIN_TIME_ERROR_CODE);
					map.put("msg", "登录超时，请重新登录");
					JSONUtils.objectToJson(servletRequest, servletResponse, map);
					return;
				 }
			}else if(path.indexOf(".do")>-1){
				chain.doFilter(servletRequest, servletResponse);
				return ;
			}
			Map<String, String> map = new HashMap<String, String>();
			
			
			 
			
			//个人中心------------
			//登录
			map.put("/login",
					"/wxpage/heqiao/index.html");
			//登录
			map.put("/detail3",
					"/wxpage/heqiao/currencyDetail.html");
			map.put("/detail2",
					"/wxpage/heqiao/leaveDetail.html");
			map.put("/detail1",
					"/wxpage/heqiao/payDetail.html");
		 
			//微信公众号菜单----
			
			
			boolean isTrue =false;
			
			for (String key : map.keySet()) {
				if (path.indexOf(key) > -1) {
					
					
					
					StringBuffer urlPath = new StringBuffer();
					urlPath.append(map.get(key));
					urlPath.append("?code=");
					urlPath.append(code);
					if(key.indexOf("detail")>-1){
						
						String path1[] = path.split("/");
						String noteId = path1[path1.length - 3];
						String taskId = path1[path1.length - 2];
						String noteType = path1[path1.length - 1];

						urlPath.append("&noteId=");
						urlPath.append(noteId);
						urlPath.append("&taskId=");
						urlPath.append(taskId);
						urlPath.append("&noteType=");
						urlPath.append(noteType);
					}
					
					
					servletResponse.sendRedirect(servletRequest
							.getContextPath() + urlPath);
					isTrue =true;
					break;
				}
			}
			if(isTrue){
				return;
			}
			

		 
			
		} else {

			// 从session里取员工工号信息
			Object obj = session
					.getAttribute(HttpSessionProvider.CURRENT_USER_SESSION_KEY);
			List<String> paths = new ArrayList<String>();
			paths.add("login.html");

			paths.add("manager/loginIn/SysUserInfo/query.do");
			paths.add("manager/loginIn/SysUserInfo/PcLogin.do");
			paths.add("/manager/loginIn/SysUserInfo/userLoginOut.do");
			paths.add("/manager/loginIn/currencyNote/queryWaitingListAll.do");
			paths.add("/manager/loginIn/currencyNote/queryByPkIdForMysql");
			boolean isTrue = false;
			if (path.indexOf("/resources/") > -1 || path.indexOf("/css/") > -1) {
				isTrue = true;
			} else {

				// 创建类Constants.java，里面写的是无需过滤的页面
				for (int i = 0; i < paths.size(); i++) {
					if (path.indexOf(paths.get(i)) > -1) {
						isTrue = true;
						break;
					}
				}
			}

			if (isTrue) {
				chain.doFilter(servletRequest, servletResponse);
				return;
			}

			if (obj == null && path.indexOf("/loginIn/") > -1) {
 				Map map = new HashMap();
				map.put("code", "111");
				map.put("msg", "登录超时，请重新登录");
				JSONUtils.objectToJson(servletRequest, servletResponse, map);
				return;
			} else {
				chain.doFilter(request, response);
			}
		}

	}

	public void destroy() {

	}

}