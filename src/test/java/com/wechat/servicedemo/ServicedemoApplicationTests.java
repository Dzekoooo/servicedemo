package com.wechat.servicedemo;

import com.alibaba.fastjson.JSONObject;
import com.wechat.servicedemo.util.OkHttpUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ServicedemoApplicationTests {
	private static final String ACCESS_TOKEN = "6_Q34UfetRKW10kbm3ug9eLmVMzQraVphoMbfd-qE7_Zeu8Fbd6VLikvP0iHivJ72QnThdbjtQGWHWndXWHb2aVY02efYfIVfUMlJfvkABC4OX6VnogFgvr_PHj6vJSfoglaAU8qSfqwYWwbKAJMIcABAADZ";

	/**
	 * 设置所属行业
	 */
	private static final String SET_INDUSTRY = "https://api.weixin.qq.com/cgi-bin/template/api_set_industry?access_token=" + ACCESS_TOKEN;

	/**
	 * 获取设置的行业信息
	 */
	private static final String GET_INDUSTRY = "https://api.weixin.qq.com/cgi-bin/template/get_industry?access_token=" + ACCESS_TOKEN;

	/**
	 * 请求消息模板队列
	 */
	private static final String TEM_ID_URL = "https://api.weixin.qq.com/cgi-bin/template/get_all_private_template?access_token=6_MMbHLImw22lMFlQqsmmBcymnVUxXWdMGHJO3mMFM5CSv09tXam9gGyy37qKr_HZ4_6U0RP9hKQI7uhRRbAeKwJQZrJUtDrRtk3tNRb2q0bQHAQxTje2FhQU1VYIzmvGC4qmWN_CdwiHYudXSHRSeAFATDE";


	/**
	 * 发送消息模板接口
	 */
	private static final String POST_URL = "https://api.weixin.qq.com/cgi-bin/message/template/send?access_token=" + ACCESS_TOKEN;


	@Test
	public void postTest() {

		//行业
		StringBuffer industry = new StringBuffer();
		industry.append("{");
		industry.append("\"industry_id1\":" + "\"" + "1" + "\",");
		industry.append("\"industry_id2\":" + "\"" + "4" + "\"}");
		String str_industry = new String(industry);
		System.out.println("str_industry = " + str_industry);


		//消息模板
		StringBuffer sb = new StringBuffer();
		sb.append("{");
		sb.append("\"touser\":" + "\"" + "o3tk61V1Okg754B3baaJdIbDY9h8" + "\",");
		sb.append("\"template_id\":" + "\"" + "YqZFokb3hxUuo72zCiGny4D0QuPNqVPdWa4tG-FDad8" + "\",");
		sb.append("\"data\":" + "{");
		sb.append("\"first\":" + "\"" + "恭喜你购买成功" + "\",");
		sb.append("\"product\":" + "\"" + "商品A" + "\",");
		sb.append("\"price\":" + "\"" + "25$" + "\",");
		sb.append("\"time\":" + "\"" + "133213211" + "\",");
		sb.append("\"remark\":" + "\"" + "欢迎再次购买" + "\"}");
		sb.append("}");
		String data = new String(sb);
		System.out.println("data = " + data);

//		发送消息模板
		JSONObject jsonObject = OkHttpUtil.httpPost(POST_URL, data);
		System.out.println("jsonObject = " + jsonObject);

		//设置所属行业
//		JSONObject jsonObject = OkHttpUtil.httpPost(SET_INDUSTRY, str_industry);
//		System.out.println("jsonObject = " + jsonObject);

		//获取设置的行业信息
//		JSONObject jsonObject = OkHttpUtil.httpGet(GET_INDUSTRY);
//		System.out.println("jsonObject = " + jsonObject);

//		查询消息模板队列
		JSONObject jsonObject1 = OkHttpUtil.httpGet(TEM_ID_URL);
		System.out.println("jsonObject = " + jsonObject1);



	}
}
