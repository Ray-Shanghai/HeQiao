package com.sd.farmework.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sd.farmework.common.HttpSessionProvider;
import com.sd.farmework.common.JSONUtils;
import com.sd.farmework.pojo.TmUserArchivesInfo;

/**
 * 生成验证码
 * @author 王超超
 * 2016-10-26
 * 
 */

@Controller
@Scope("prototype")
@RequestMapping(value="/wx/common")
public class CommonController {
	Logger logger = Logger.getLogger(CommonController.class);
	
 
	@RequestMapping(value = "/getCurrentAccountType", method = RequestMethod.POST)
	public void getCurrentAccountType(HttpServletRequest request,HttpServletResponse response,HttpSession session) throws IOException{
		 
		Map map =new HashMap();
		map.put("code", "000");
		HttpSessionProvider http =new HttpSessionProvider();
		TmUserArchivesInfo  tmUserArchivesInfo=(TmUserArchivesInfo) session.getAttribute(HttpSessionProvider.CURRENT_USER_ARCHIVES_SESSION_KEY);
		if(tmUserArchivesInfo!=null){
			
			map.put("teamName", tmUserArchivesInfo.getTeamName());
			map.put("company", tmUserArchivesInfo.getCompany());
		}
		
		
		
		
		JSONUtils.objectToJson(request, response, map);
		
	}
}
