package com.dao;

import com.pojo.Answer;
import com.pojo.PaperText;
import com.pojo.Student;
import com.pojo.Teacher;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TeacherDao {
    int createTeacher(Teacher teacher);

    int checkPaper(Student student);

    List<Answer> showStuQuestion(String tutor);

    int answerQuestion(Answer answer);

    String findTutor(int id);

    List<PaperText> Papers(String tutor);

    String showPaper(int id);
}
