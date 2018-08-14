package com.zzx;

import com.alibaba.fastjson.JSON;
import com.meizu.push.sdk.server.IFlymePush;
import com.meizu.push.sdk.server.constant.ErrorCode;
import com.meizu.push.sdk.server.constant.PushResponseCode;
import com.meizu.push.sdk.server.constant.ResultPack;
import com.meizu.push.sdk.server.model.push.PushResult;
import com.meizu.push.sdk.server.model.push.VarnishedMessage;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class msg {
    public void pushmsg(String titleText,String contentText,String expandContext,int expandType) throws Exception {
        //推送对象
        String appsecret="fcec639c756b415da30e47237b8bc35e";
        IFlymePush push = new IFlymePush(appsecret,false);

        //组装消息
        long appid1=115070;
        //通知栏信息
        VarnishedMessage message = new VarnishedMessage.Builder().appId(appid1)
//                .restrictedPackageNames(new String[]{"com.xxx.abc"})//多包名推送时才需配置，不填表示所有
                .title(titleText).content(contentText)
                .noticeBarType(2)
                .noticeExpandType(expandType)
                .noticeExpandContent(expandContext)
                .clickType(2).url("http://www.baidu.com").parameters(JSON.parseObject("{\"k1\":\"value1\",\"k2\":0,\"k3\":\"value3\"}"))
                .offLine(true).validTime(24)
                .suspend(true).clearNoticeBar(true).vibrate(true).lights(true).sound(true)
                .build();
        System.out.println("推送信息"+titleText+" "+contentText);

        //目标用户
        String usr1="RA50c63430b6b44485c0576637b537a63740560410462";
        List<String> pushIds = new ArrayList<>();
        pushIds.add(usr1);
        // 1 调用推送服务
        ResultPack<PushResult> result = push.pushMessage(message, pushIds);
        if (result.isSucceed()) {
            // 2 调用推送服务成功 （其中map为设备的具体推送结果，一般业务针对超速的code类型做处理）
            PushResult pushResult = result.value();
            String msgId = pushResult.getMsgId();//推送消息ID，用于推送流程明细排查
            Map<String, List<String>> targetResultMap = pushResult.getRespTarget();//推送结果，全部推送成功，则map为empty
            System.out.println("push msgId:" + msgId);
            System.out.println("push targetResultMap:" + targetResultMap);
            if (targetResultMap != null && !targetResultMap.isEmpty()) {
                // 3 判断是否有获取超速的target
                if (targetResultMap.containsKey(PushResponseCode.RSP_SPEED_LIMIT.getValue())) {
                    // 4 获取超速的target
                    List<String> rateLimitTarget = targetResultMap.get(PushResponseCode.RSP_SPEED_LIMIT.getValue());
                    System.out.println("rateLimitTarget is :" + rateLimitTarget);
                    //TODO 5 业务处理，重推......
                }
            }
        } else {
            // 调用推送接口服务异常 eg: appId、appKey非法、推送消息非法.....
            result.code(); //服务异常码
            result.comment();//服务异常描述

            //全部超速
            if (String.valueOf(ErrorCode.APP_REQUEST_EXCEED_LIMIT.getValue()).equals(result.code())) {
                //TODO 5 业务处理，重推......
            }
            System.out.println(String.format("pushMessage error code:%s comment:%s", result.code(), result.comment()));
        }
    }
}
