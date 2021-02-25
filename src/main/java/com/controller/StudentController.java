package com.controller;

import com.pojo.*;
import com.service.StudentService;
import com.utils.DateFormatUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Controller
public class StudentController {
    @Autowired
    StudentService studentService;
//    注册
    @RequestMapping("/createStudent")
    @ResponseBody
    public boolean createStudent(@RequestBody Student student){
        System.out.println(student);
        boolean register = studentService.register(student);
        System.out.println(register);
        return register;
//        return studentService.register(student);
    }

//    登录
    @RequestMapping("/login")
    @ResponseBody
    public boolean login(@RequestBody Person person){
        System.out.println(person.getType());
        int type = person.getType();
        boolean mark = false;
        switch (type){
            case 1:
                mark = studentService.avalidateLogin(person);
                break;
            case 2:
               mark = studentService.avalidateLoginTea(person);
                break;
            case 3:
                mark = studentService.avalidateLoginManager(person);
                System.out.println(mark);
                break;
            case 4:
                mark = studentService.avalidateLoginCompany(person);
                break;
            default:

        }
        return mark;
    }
//    学生信息查询
    @RequestMapping("/studentInfo")
    @ResponseBody
    public Student studentInfo(@RequestBody Student student){
        System.out.println(student);
        return studentService.studentInfo(student.getId());

    }
//    申请实习公司
    @RequestMapping("/applicationCompany")
    @ResponseBody
    public boolean applicationCompany(@RequestBody Student student){
        return studentService.applicationCompany(student);
    }
//    查询实习公司
    @RequestMapping("/applicationInfo")
    @ResponseBody
    public List<String> applicationInfo(){
        return studentService.applicationInfo();

    }
//    上载论文 form表单解决
    @RequestMapping(value = "/commitPage" ,method= RequestMethod.POST,produces="application/json; charset=utf-8")
    @ResponseBody
    public String  commitPage(int id,String NewText){
        PaperText paperText = new PaperText();
        Date date = new Date();
        paperText.setId(id);
        String tutor = studentService.findTutor(id);
        paperText.setTutor(tutor);
        paperText.setPapertext(NewText);
        paperText.setCreatetime(DateFormatUtil.date2String(date));
        paperText.setIsdelete(0);
        boolean b = studentService.commitPage(paperText);
        String a = null;
        if (b){
            a = "提交成功！！！";
        }else {
            a = "提交失败！！！请重新操作";
        }
        return a;
    }
//    提问
    @RequestMapping("/askQusetion")
    @ResponseBody
    public boolean askQusetion(@RequestBody Question question){
        return studentService.askQusetion(question);
    }
//  学生填写详细信息（学生信息完善）
    @RequestMapping("/stuInsertInfo")
    @ResponseBody
    public boolean stuInsertInfo(@RequestBody Student student){
        return studentService.stuInsertInfo(student);
    }
//    成绩查询
    @RequestMapping("/queryScore")
    @ResponseBody
    public Score queryScore(@RequestBody Student student){
        return studentService.queryScore(student.getId());
    }
}
