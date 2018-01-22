package com.wechat.servicedemo.util;

import com.alibaba.fastjson.JSONObject;
import com.wechat.servicedemo.entity.*;
import com.wechat.servicedemo.operate.DataGet;
import com.wechat.servicedemo.operate.UserGet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

/**
*@Author: ZhangZhe
*@Description       实现消息推送方法
*@Date: 2018/1/19
*/
public class WXUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(WXUtil.class);

    public static AccessToken accessToken() {
        AccessToken token = null;
        //获取access_token
        if (null == TokenThread.accessToken || "".equals(TokenThread.accessToken.getAccessToken())) {
            token = GetAccessTokenUtil.getAccessToken(InfoUtil.APP_ID, InfoUtil.APP_SECRET);
        } else {
            token = TokenThread.accessToken;
        }
        return token;
    }


    /**
     * 推送给个人
     * @param userName
     */
    public static void sendMessageToUser(String userName) {
        //接收模板消息内容
        String data = DataGet.dataGet(userName);
        AccessToken accessToken = accessToken();
        //获取消息发送接口
        String url = InfoUtil.SEND_MESSAGE_URL.replace("ACCESS_TOKEN", accessToken.getAccessToken()).replace(" ", "");
        JSONObject jsonObject = OkHttpUtil.httpPost(url, data);
        if (null == jsonObject) {
            LOGGER.info("=============消息推送失败======================");
        } else {
            LOGGER.info("=============消息推送成功======================");
        }
    }

    public static void sendMessageToUserList() {
        Map<String, String> map = new HashMap<>();
        AccessToken accessToken = accessToken();
        String url = InfoUtil.SEND_MESSAGE_URL.replace("ACCESS_TOKEN", accessToken.getAccessToken()).replace(" ", "");
        map = UserGet.userGet();
        int count = 0;
        JSONObject jsonObject = new JSONObject();
        for (Map.Entry<String, String> entry: map.entrySet()) {
            String data = DataGet.dataGet(entry.getKey());
            jsonObject = OkHttpUtil.httpPost(url, data);
            count++;
        }
        LOGGER.info("========共成功推送了:" + count + "人==============" );
//        System.out.println("共成功推送了：" + count + "人");
    }
}

