package com.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pojo.Company;
import com.pojo.Student;
import com.service.PlatformService;
import com.utils.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
public class PlatformController {
    @Autowired
    PlatformService platformService;
//    学生显示
    @RequestMapping("/showStudent")
    @ResponseBody
    public PageUtils showStudent(@RequestBody Map<String,Object> params){
        String id = params.get("id").toString();
        int id1 = Integer.parseInt(id);
        String companyName = platformService.findCompanyName(id1);
        List<Student> students = platformService.showStudent(companyName);
        System.out.println(students+"/showStudent");
        PageHelper.offsetPage(Integer.parseInt(params.get("offset").toString()),Integer.parseInt(params.get("pageNumber").toString()));
        PageInfo<Student> pageInfo = new PageInfo<>(students);
        return new PageUtils(pageInfo.getList(),new Long(pageInfo.getTotal()).intValue());
    }
//    实习打分
    @RequestMapping("/Score")
    @ResponseBody
    public boolean Score(@RequestBody Student student){
        System.out.println(student);
      return platformService.insertScore(student);
    }
}
