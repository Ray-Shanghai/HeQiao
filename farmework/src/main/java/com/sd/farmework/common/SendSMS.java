package com.sd.farmework.common;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import com.sd.farmework.common.util.StringUtil;

 

/**
 * 
 * @author 杨洋
 *
 */
public class SendSMS {
	
	 private PropertiesConstant propertiesConstant;
	 
	public PropertiesConstant getMessageConfig() {
		return propertiesConstant;
	}

	public void setMessageConfig(PropertiesConstant propertiesConstant) {
		this.propertiesConstant = propertiesConstant;
	}

	/**
	 * 
	 * 
	 * 获取短信模板
	 * @param type  getPassword 忘记密码调用模板   updatePassword 修改密码短信模板
	 * @return
	 */
	public Map<String,String> getSmsTemplate(String type){
		Map<String,String> map =new HashMap<String,String>();
		map.put("getPassword", "验证码[1]"+"用于您找回密码，我们工作人员不会向您索要验证码，请勿提供给任何人，以免造成账户或资金损失。");
		map.put("updatePassword", "验证码[1]"+"用于您修改密码，我们工作人员不会向您索要验证码，请勿提供给任何人，以免造成账户或资金损失。");
		Map<String,String>  retMap = new HashMap<String,String>();
		String strTle = map.get(type);
		if(StringUtil.isNullOrBlank(strTle)){
			retMap.put("code", "001");
			retMap.put("msg", "模板不存在");
		}else{
			retMap.put("code", "000");
			retMap.put("msg", "success");
			retMap.put("template", strTle);
		}
		
		return retMap;
	}
	
	/**
	 * @param MessageConfig 配置短信服务商 的账号密码和接口
	 * @param mobile   发送的电话号码，多个以逗号隔开， 例如：13812345678,13519876543,15812349876
	 * @param content  发送短信内容
	 * @param cell     扩展号（必须为数字或为空）
	 * @param sendTime 时发送时间（固定14位长度字符串，比如：20060912152435代表2006年9月12日15时24，为空表示立即发送）
	 * @return
	 * @throws UnsupportedEncodingException 
	 * @throws MalformedURLException 
	 */
	public int sendSMSMethod(String mobile,String content,String cell,String sendTime) throws UnsupportedEncodingException, MalformedURLException{
		/**
		 * 当大于0时，表示短信发送成功！
		 * 小于0时，详见借口文档
		 */
		int inputLine = 0;
		
		if("Y".equals(propertiesConstant.getSmsSwitch())){
			try {
					URL url = null;
					//必须通过GBK转码，不然接口调用失败
					String send_content=URLEncoder.encode(content.replaceAll("<br/>", " "), "GBK");//发送内容,格式转换
					//拼接接口地址,调用的短信接口地址，和文档中提供的地址不一样
					//https://IP+Port/ws/BatchSend2.aspx?CorpID=*&Pwd=*&Mobile=*&Content=*&SendTime=* 这个是文档中中提供的地址调用报错
					url = new URL(propertiesConstant.getSmsApiUrl()+"?CorpID="+propertiesConstant.getSmsAccountNo()+"&Pwd="+propertiesConstant.getSmsAccountPwd()+"&Mobile="+mobile+"&Content="+send_content+"&Cell=&SendTime="+sendTime);
					BufferedReader in = null;
					System.out.println(url);
				
					System.out.println("开始发送短信手机号码为 ："+mobile);
					in = new BufferedReader(new InputStreamReader(url.openStream()));
					inputLine = new Integer(in.readLine()).intValue();
				} catch (Exception e) {
					System.out.println("网络异常,发送短信失败！");
		 			return inputLine;
			}
			
		}
		System.out.println("结束发送短信返回值：  "+inputLine);
		return inputLine;
		
	}
	
	
	public static void main(String[] args) {
		PropertiesConstant propertiesConstant =new PropertiesConstant();
		propertiesConstant.setSmsApiUrl("https://sdk2.028lk.com/sdk2/Send.aspx");
		propertiesConstant.setSmsAccountNo("CDJS001470");
		propertiesConstant.setSmsAccountPwd("012345@");
		SendSMS sendSMS =new SendSMS();
		sendSMS.setMessageConfig(propertiesConstant);
		
		try {
			
			Map<String,String> map =sendSMS.getSmsTemplate("getPassword");
			if(map.get("code").equals("000")){
				String content = map.get("template").replace("[1]", "234533");
				
				sendSMS.sendSMSMethod("18192182303", content, "", "");
			}else{
				System.out.println(map.get("msg"));
			}
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
