package com.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pojo.Answer;
import com.pojo.PaperText;
import com.pojo.Student;
import com.pojo.Teacher;
import com.service.TeacherService;
import com.utils.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
public class TeacherController {
    @Autowired
    TeacherService teacherService;

    //    教师注册
    @RequestMapping("/createTeacher")
    @ResponseBody
    public boolean createTeacher(@RequestBody Teacher teacher) {
        return teacherService.createTeacher(teacher);
    }
    //    显示学生论文
    @RequestMapping("/Papers")
    @ResponseBody
    public PageUtils Papers(@RequestBody Map<String,Object> params){
        String id = params.get("id").toString();
        int id1 = Integer.parseInt(id);
        String tutor = teacherService.findTutor(id1);
        List<PaperText> papers = teacherService.Papers(tutor);
        PageHelper.offsetPage(Integer.parseInt(params.get("offset").toString()), Integer.parseInt(params.get("pageNumber").toString()));
        PageInfo<PaperText> pageInfo = new PageInfo<>(papers);
        return new PageUtils(pageInfo.getList(), new Long(pageInfo.getTotal()).intValue());
    }
    //    显示论文内容
    @RequestMapping("/showPaper")
    @ResponseBody
    public String showPaper(@RequestBody Student student){
        System.out.println(student.getId());
        return teacherService.showPaper(student.getId());
    }
    //    提交论文成绩
    @RequestMapping("/checkPaper")
    @ResponseBody
    public boolean checkPaper(@RequestBody Student student) {
        return teacherService.checkPaper(student);
    }

    //    老师显示自己学生的问题(pageUtil)
    @RequestMapping("/showStuQuestion")
    @ResponseBody
    public PageUtils showStuQuestion(@RequestBody Map<String, Object> params) {
        String id = params.get("id").toString();
        int id1 = Integer.parseInt(id);
        String tutor = teacherService.findTutor(id1);
        List<Answer> answers = teacherService.showStuQuestion(tutor);
        PageHelper.offsetPage(Integer.parseInt(params.get("offset").toString()), Integer.parseInt(params.get("pageNumber").toString()));
        PageInfo<Answer> pageInfo = new PageInfo<>(answers);
        return new PageUtils(pageInfo.getList(), new Long(pageInfo.getTotal()).intValue());
    }
    //    老师回答自己学生的问题
    @RequestMapping("/answerQuestion")
    @ResponseBody
    public boolean answerQuestion(@RequestBody Answer answer){
        System.out.println(answer+"回答");
        return teacherService.answerQuestion(answer);
    }
}


