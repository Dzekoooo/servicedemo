package com.wechat.servicedemo.util;

import com.wechat.servicedemo.entity.AccessToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
*@Author: ZhangZhe
*@Description       定时获取access_token的线程
*@Date: 2018/1/19
*/
public class TokenThread implements Runnable {

    private static final Logger LOGGER = LoggerFactory.getLogger(TokenThread.class);

    public static AccessToken accessToken = null;

    @Override
    public void run() {
        while (true) {
            try {
                accessToken = GetAccessTokenUtil.getAccessToken(InfoUtil.APP_ID, InfoUtil.APP_SECRET);
                if (null != accessToken) {
                    LOGGER.info("获取access_token成功,有效时长{}秒", accessToken.getExpiresin(), accessToken.getAccessToken());
                    Thread.sleep((accessToken.getExpiresin() - 200) * 1000);
                } else {
                    Thread.sleep(60 * 1000);
                }
            } catch (InterruptedException e) {
                try {
                    Thread.sleep(60 * 1000);
                } catch (InterruptedException e1) {
                    LOGGER.error("{}", e1);
                }
                LOGGER.error("{}", e);
            }
        }

    }
}
