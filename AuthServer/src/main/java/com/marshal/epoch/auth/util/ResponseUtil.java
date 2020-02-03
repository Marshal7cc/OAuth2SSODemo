package com.marshal.epoch.auth.util;

import com.alibaba.fastjson.JSON;

import com.marshal.epoch.auth.constants.BaseConstant;
import com.marshal.epoch.auth.dto.PageableData;
import com.marshal.epoch.auth.dto.ResponseEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * @auth: Marshal
 * @date: 2019/8/27
 * @desc: response工具类
 */
public class ResponseUtil implements BaseConstant {

    private static final Logger logger = LoggerFactory.getLogger(ResponseUtil.class);

    private ResponseUtil() {
    }

    /**
     * 请求成功
     *
     * @return
     */
    public static ResponseEntity responseOk() {
        return responseOk(OPERATE_SUCCESS);
    }

    public static ResponseEntity responseOk(String message) {
        return new ResponseEntity(message);
    }

    public static ResponseEntity responseOk(List<?> rows) {
        return new ResponseEntity(new PageableData(rows));
    }

    public static ResponseEntity responseOk(Object data) {
        return new ResponseEntity(data);
    }

    /**
     * 请求失败
     *
     * @return
     */
    public static ResponseEntity responseErr() {
        return responseErr(OPERATE_FAIL);
    }

    public static ResponseEntity responseErr(String message) {
        return new ResponseEntity(false, message);
    }

    public static ResponseEntity responseErr(Integer code, String message) {
        return new ResponseEntity(false, message);
    }

    public static void responseErr(HttpServletResponse response, String message) {
        response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        PrintWriter writer = null;
        try {
            writer = response.getWriter();
            writer.write(JSON.toJSONString(responseErr(message)));
        } catch (IOException e) {
            logger.error("io exception happen ,please check");
        } finally {
            writer.close();
        }
    }


}
