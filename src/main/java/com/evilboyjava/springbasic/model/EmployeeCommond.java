package com.evilboyjava.springbasic.model;

/**
 * Created by Administrator on 14-2-9.
 */
public class EmployeeCommond extends Employee   {
    public static final String ADD = "add";
    public static final String EXIT = "exit";
    public static final String DELETE = "delete";
    public static final String QUERY = "query";
    private String action = null;
    public String getAction() {
        return action;
    }
    public void setAction(String action) {
        this.action = action;
    }

}
