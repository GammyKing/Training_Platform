package com.service;

import com.pojo.Answer;
import com.pojo.PaperText;
import com.pojo.Student;
import com.pojo.Teacher;

import java.util.List;

public interface TeacherService {
    boolean createTeacher(Teacher teacher);

    boolean checkPaper(Student student);

    List<Answer> showStuQuestion(String tutor);

    boolean answerQuestion(Answer answer);

    String findTutor(int id);

    List<PaperText> Papers(String tutor);

    String showPaper(int id);
}
