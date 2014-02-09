package com.evilboyjava.springbasic.dao;

import com.evilboyjava.springbasic.model.Employee;
import com.evilboyjava.springbasic.model.EmployeeCommond;
import com.evilboyjava.springbasic.model.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 14-2-9.
 */
@Component
public class CommondProcessMysqlDAO implements ICommondProcessDAO {
    private static final String SQL_INSERT = "INSERT INTO  employee  values (?, ?)";

    private static final String SQL_DELETE = "delete from  employee "
            + "where name = ?";

    private static final String SQL_SELECT = ""
            + "SELECT NAME,age FROM  employee "  + "where name = ?";;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    @Transactional
    public Result insert(EmployeeCommond commond) {
        Result result = new Result();
        try {
            jdbcTemplate.update(SQL_INSERT,
                    commond.getName(),
                    commond.getAge());
            result.setResult(Result.OK);
        } catch (Exception e) {
            result.setResult(Result.ERROR);
            result.setMessage(e.getMessage());
            System.out.println(result.getMessage());
        }
        return result;
    }

    @Override
    @Transactional
    public Result delete(EmployeeCommond commond) {
        Result result = new Result();
        try {
            jdbcTemplate.update(SQL_DELETE,
                    commond.getName());
            result.setResult(Result.OK);
        } catch (Exception e) {
            result.setResult(Result.ERROR);
            result.setMessage(e.getMessage());
        }
        return result;
    }

    public Result select(EmployeeCommond commond) {
        Result result = new Result();
        try {
            result.setList(jdbcTemplate.queryForList(
                    SQL_SELECT, commond.getName()
            ));
            result.setResult(Result.OK);
        } catch (Exception e) {
            result.setResult(Result.ERROR);
            result.setMessage(e.getMessage());
        }
        return result;
    }
}
