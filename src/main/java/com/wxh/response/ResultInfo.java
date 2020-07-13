package com.wxh.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName: ResultInfo
 * @Description: 响应结果信息类
 * @Author wxh
 * @Date: 2020/7/13 16:25
 * @Version V1.0.0
 * @Since 1.8
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResultInfo {
    /**
     *  成功状态：true或false
     */
    private boolean succeed;
    /**
     *  响应消息状态码
     */
    private String code;
    /**
     *  响应消息描述
     */
    private String msg;
    /**
     *  响应的数据
     */
    private Object data;
    /**
     *  响应输出SQL
     */
    private Object sql;
}
