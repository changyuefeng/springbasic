package com.evilboyjava.springbasic.model;

import java.util.List;

/**
 * Created by Administrator on 14-2-9.
 */
public class Result {
    public static final String OK = "ok";
    public static final String ERROR = "error";

    private String result = null;
    private String message = null;
    private List<?> list = null;

    public List<?> getList() {
        return list;
    }

    public void setList(List<?> list) {
        this.list = list;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
