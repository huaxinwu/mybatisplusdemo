package com.wxh.enums;

/**
 * @ClassName: CodeEnum
 * @Description: 状态码枚举类
 * @Author wxh
 * @Date: 2020/7/13 16:36
 * @Version V1.0.0
 * @Since 1.8
 */
public enum CodeEnum {
    /** 成功 */
    SUCCESS("000", "查询成功"),
    /** 失败 */
    FAILURE("001", "查询失败");

    /**
     *  状态码
     */
    private String code;
    /**
     * 状态码描述
     */
    private String msg;

    CodeEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }


}
