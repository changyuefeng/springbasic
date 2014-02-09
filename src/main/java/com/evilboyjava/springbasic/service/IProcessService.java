package com.evilboyjava.springbasic.service;

import com.evilboyjava.springbasic.model.EmployeeCommond;
import com.evilboyjava.springbasic.model.Result;


/**
 * Created by Administrator on 14-2-9.
 */
public interface IProcessService {
    public Result onCommond(EmployeeCommond commond);
}
