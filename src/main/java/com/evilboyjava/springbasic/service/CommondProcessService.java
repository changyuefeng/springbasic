package com.evilboyjava.springbasic.service;
import com.evilboyjava.springbasic.dao.CommondProcessMysqlDAO;
import com.evilboyjava.springbasic.dao.ICommondProcessDAO;
import com.evilboyjava.springbasic.model.EmployeeCommond;
import com.evilboyjava.springbasic.model.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
/**
 * Created by Administrator on 14-2-9.
 */
@Component
public class CommondProcessService implements IProcessService {
    private Result result = null;
    @Autowired
    private ICommondProcessDAO cmdProcessDAO = null;

    public CommondProcessService(){

    }
    @Override
    public Result onCommond(EmployeeCommond commond){
        if(commond.getAction().equals(EmployeeCommond.ADD)){
            this.result = add(commond);
        }else if(commond.getAction().equals(EmployeeCommond.QUERY)){
            this.result = query(commond);
        }else if(commond.getAction().equals(EmployeeCommond.DELETE)){
            this.result = delete(commond);
        }
        return this.result;
    }

    public Result add(EmployeeCommond commond){
        return  cmdProcessDAO.insert(commond);
    }
    public Result query(EmployeeCommond commond){
        return cmdProcessDAO.select(commond);
    }
    public Result delete(EmployeeCommond commond){
        return cmdProcessDAO.delete(commond);
    }
}
