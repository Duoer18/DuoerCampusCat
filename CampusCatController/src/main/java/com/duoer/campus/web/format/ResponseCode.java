package com.duoer.campus.web.format;

/**
 * 响应状态码枚举类
 *
 * @author duoer
 */
public enum ResponseCode {
    ERR(10000), BUSINESS_ERR(10010), SYSTEM_ERR(10020),
    REG_SUC(20001), REG_ERR(20000),
    LOG_SUC(20011), LOG_ERR(20010), LOG_EXT(20012),
    GET_SUC(20021), GET_ERR(20020),
    ADD_SUC(20031), ADD_ERR(20030),
    DEL_SUC(20041), DEL_ERR(20040),
    UPD_SUC(20051), UPD_ERR(20050);

    private final int code;

    ResponseCode(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
