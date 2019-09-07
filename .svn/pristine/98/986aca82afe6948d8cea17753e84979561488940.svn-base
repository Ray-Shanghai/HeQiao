package com.sd.farmework.common;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class JSONUtils {
   public static void objectToJson(HttpServletRequest request,HttpServletResponse response,Map map){
	   	HttpSessionProvider httpSessionProvider =new HttpSessionProvider();
	   	String currentAccountType=	httpSessionProvider.getAccountTypeSession(request);
        map.put("currentAccountType", currentAccountType);
       Map map1= httpSessionProvider.getUserMessage(request.getSession());
       map.put("userMessage", JSONObject.fromObject( map1));
        
		JSONObject js = JSONObject.fromObject(map);
		String restr=js.toString();
		
		try {
			
			response.setCharacterEncoding("UTF-8");
			response.setContentType("application/json");
			PrintWriter pw;
			pw = response.getWriter();
			pw.write(restr);
			pw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
   }
   public static void objectToJsonArray(HttpServletRequest request,HttpServletResponse response,List list){
	   JSONArray js = JSONArray.fromObject(list);
		String restr=js.toString();
		
		try {
			response.setCharacterEncoding("UTF-8");
			response.setContentType("application/json");
			PrintWriter pw;
			pw = response.getWriter();
			pw.write(restr);
			pw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
  }
}
