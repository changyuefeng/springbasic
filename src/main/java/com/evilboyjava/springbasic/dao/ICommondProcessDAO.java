package com.evilboyjava.springbasic.dao;

import com.evilboyjava.springbasic.model.EmployeeCommond;
import com.evilboyjava.springbasic.model.Result;

import java.util.List;

/**
 * Created by Administrator on 14-2-9.
 */
public interface ICommondProcessDAO {
    public Result insert(EmployeeCommond commond);
    public Result delete(EmployeeCommond commond);
    public Result select(EmployeeCommond commond);
}
