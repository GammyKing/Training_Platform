package com.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pojo.Company;
import com.pojo.Student;
import com.service.ManagerService;
import com.utils.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
public class ManagerController {
    @Autowired
    ManagerService managerService;

    //  管理员查询学生信息(pageUtil)
    @RequestMapping("/selectStuUser")
    @ResponseBody
    public PageUtils selectStuUser(@RequestBody Map<String, Object> params) {
        List<Student> students = managerService.selectStuUser();
        PageHelper.offsetPage(Integer.parseInt(params.get("offset").toString()), Integer.parseInt(params.get("pageNumber").toString()));
        PageInfo<Student> pageInfo = new PageInfo<>(students);
        return new PageUtils(pageInfo.getList(), new Long(pageInfo.getTotal()).intValue());
    }

    //    管理员修改学生信息
    @RequestMapping("/modifyStuUser")
    @ResponseBody
    public boolean modifyStuUser(@RequestBody Student student) {
        return managerService.modifyStuUser(student);
    }
//    管理员删除学生用户
    @RequestMapping("/deleteStuUser")
    @ResponseBody
    public boolean deleteStuUser(@RequestBody Student student){
        return managerService.deleteStuUser(student);
    }

/*
//    管理员录入学生选择的学生实习单位
    @RequestMapping("/registerCompany")
    @ResponseBody
    public boolean registerCompany(@RequestBody Student student){
        return managerService.registerCompany(student);
    }
*/

/*//     实习公司选择
    @RequestMapping("/selectCompanyInfo")
    @ResponseBody
    public List<Company> selectCompanyInfo(){
         return managerService.selectCompanyInfo();
    }*/
//    管理员查看实习公司
    @RequestMapping("/selectCompany")
    @ResponseBody
    public PageUtils selectCompany(@RequestBody Map<String,Object> params){
        List<Company> companyList = managerService.selectCompany();
        System.out.println(companyList);
        PageHelper.offsetPage(Integer.parseInt(params.get("offset").toString()), Integer.parseInt(params.get("pageNumber").toString()));
        PageInfo<Company> pageInfo = new PageInfo<>(companyList);
        return new PageUtils(pageInfo.getList(), new Long(pageInfo.getTotal()).intValue());
    }

//    修改实习公司名
    @RequestMapping("/modifyCompanyName")
    @ResponseBody
    public boolean modifyCompany(@RequestBody Company company){
        return managerService.modifyCompany(company);
    }
//   修改公司登录密码
    @RequestMapping("modifyCompanyPwd")
    @ResponseBody
    public boolean modifyCompanyPwd(@RequestBody Company company){
        return managerService.modifyCompanyPwd(company);
    }
//    删除实习单位
    @RequestMapping("/deleteCompany")
    @ResponseBody
    public boolean deleteCompany(@RequestBody Company company){
        return managerService.deleteCompany(company);
    }

//    发布实习单位
    @RequestMapping("/addCompany")
    @ResponseBody
    public boolean addCompany(@RequestBody Company company){
        return managerService.addCompany(company);
    }

/*//    管理员修改成绩
    @RequestMapping("/modifyScore")
    @ResponseBody
    public boolean modifyScore(@RequestBody Student student){
        return managerService.modifyScore(student);
    }
//    管理员查看成绩
    @RequestMapping("scoreInfo")
    @ResponseBody
    public PageUtils scoreInfo(@RequestBody Map<String, Object> params){
        List<Student> students = managerService.scoreInfo();
        PageHelper.offsetPage(Integer.parseInt(params.get("offset").toString()),Integer.parseInt(params.get("pageNumber").toString()));
        PageInfo<Student> pageInfo = new PageInfo<>(students);
        return new PageUtils(pageInfo.getList(),new Long(pageInfo.getTotal()).intValue());
    }*/


}
