package com.epcm.common;

import com.epcm.enunn.StatusEnum;
import com.epcm.exception.StatusException;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

//构造通用结果处理类，返回状态
public class ReturnCodeBuilder {
    //状态码
    private int statusCode;
    //状态信息
    private String message;
    //传输的数据
    private Object data;
    //请求URL
    private String url;
    //数据数量
    private Long count;

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public Map<String,Object> buildMap () {
        Map<String,Object> statusMap = new HashMap<>();
        statusMap.put("statusCode", statusCode);
        statusMap.put("message", message);
        statusMap.put("timestamp", new Date().getTime());
        statusMap.put("data", data);
        statusMap.put("url", url);
        statusMap.put("count", count);
        return statusMap;
    }

    public static Builder successBuilder () {
        return new Builder().code(200).message(StatusEnum.SUCCESS.getDescription());
    }

    public static Builder failedBuilder () {
        return new Builder().code(700).message(StatusEnum.FAIL.getDescription());
    }

    public static Builder failedBuilder (int code) {
        StatusEnum statusEnum = StatusEnum.getByCode(code);
        if (statusEnum == null) {
            return failedBuilder();
        }
        return new Builder().code(code).message(statusEnum.getDescription());
    }

    public static Builder failedBuilder (String errorName) {
        StatusEnum statusEnum = StatusEnum.valueOf(errorName);
        return new Builder().code(statusEnum.getCode()).message(statusEnum.getDescription());
    }

    public static Builder failedBuilder (StatusException statusException) {
        return new Builder().code(statusException.getCode()).message(statusException.getMessage());
    }

    public static class Builder{
        //状态码
        private int statusCode;
        //状态信息
        private String message;
        //传输的数据
        private Object data;
        //请求url
        private String url;
        //数据数量
        private Long count;

        public Builder code (int statusCode) {
            this.statusCode = statusCode;
            return this;
        }

        public Builder message (String message) {
            this.message = message;
            return this;
        }

        public Builder addDataValue (Object data) {
            this.data = data;
            return this;
        }

        public Builder addDataCount (Long count) {
            this.count = count;
            return this;
        }

        public Builder url (String url) {
            this.url = url;
            return this;
        }

        public Map<String, Object> buildMap () {
            ReturnCodeBuilder returnCodeBuilder = new ReturnCodeBuilder();
            returnCodeBuilder.setStatusCode(this.statusCode);
            returnCodeBuilder.setMessage(this.message);
            returnCodeBuilder.setData(this.data);
            returnCodeBuilder.setUrl(url);
            returnCodeBuilder.setCount(count);
            return returnCodeBuilder.buildMap();
        }
    }
}

