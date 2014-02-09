package com.evilboyjava.springbasic;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Map;

import com.evilboyjava.springbasic.model.Employee;
import com.evilboyjava.springbasic.model.EmployeeCommond;
import com.evilboyjava.springbasic.model.Result;
import com.evilboyjava.springbasic.service.IProcessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 14-2-9.
 */
@Component
@Configuration
@ComponentScan(basePackages = "com.evilboyjava.springbasic.util")
public class RunApplication {
    @Autowired
    public static EmployeeCommond commond;
    @Autowired
    public static IProcessService processService;
    public final static String OK = "ok";
    public final static String EROOR = "error";

    public static void printMenu() {
        System.out.println("使用帮助");
        System.out.println("add: 添加员工");
        System.out.println("query: 查询员工");
        System.out.println("delete:　删除员工");
    }

    public static void printResult(Result result) {
        if (result.getResult().equals(Result.ERROR)) {
            System.out.println("处理结果: " + result.getResult());
            System.out.println("错误信息: " + result.getMessage());
        } else{
            System.out.println("处理结果: " + result.getResult());
            if(result.getList() != null){
                for(Object obj:result.getList()){
                    System.out.println("员工名:" + ((Map)obj).get("NAME"));
                    System.out.println("员工年龄:" + ((Map)obj).get("age"));
                }
            }
        }
    }

    public static void resetCommond() {
        commond.setAction("");
        commond.setName("");
        commond.setAge("");
    }

    public static String parseLine(String line, int wordNumber) {
        resetCommond();
        if (line.split(" ").length != wordNumber) return EROOR;
        commond.setAction(line.split(" ")[0]);
        commond.setName(line.split(" ")[1]);
        if (wordNumber == 3)
            commond.setAge(line.split(" ")[2]);
        //commond.setAge(Integer.parseInt(line.split(" ")[2]));
        return OK;
    }

    public static void commangByConsole() {
        BufferedReader bfr = null;
        try {
            bfr = new BufferedReader(new InputStreamReader(System.in));
            String line = null;
            printMenu();
            while ((line = bfr.readLine()) != null) {
                if (line.equals(EmployeeCommond.EXIT))
                    break;
                else if (line.split(" ")[0].equals(EmployeeCommond.ADD)) {
                    if (parseLine(line, 3).equals(OK)) {
                        System.out.println("run add logic");
                        printResult(processService.onCommond(commond));
                    } else printMenu();
                } else if (line.split(" ")[0].equals(EmployeeCommond.QUERY)) {
                    if (parseLine(line, 2).equals(OK)) {
                        System.out.println("run query logic");
                        printResult(processService.onCommond(commond));
                    } else printMenu();
                } else if (line.split(" ")[0].equals(EmployeeCommond.DELETE)) {
                    if (parseLine(line, 2).equals(OK)) {
                        System.out.println("run delete logic");
                        printResult(processService.onCommond(commond));
                    } else printMenu();
                } else {
                    printMenu();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        commond = com.evilboyjava.springbasic.util.AplicationContext.getApplicationContext().getBean(EmployeeCommond.class);
        processService = com.evilboyjava.springbasic.util.AplicationContext.getApplicationContext().getBean(IProcessService.class);
        commangByConsole();
    }
}
