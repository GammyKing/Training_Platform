package com.service.Impl;

import com.dao.ManagerDao;
import com.pojo.Company;
import com.pojo.Student;
import com.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ManagerServiceImpl implements ManagerService {
    @Autowired
    ManagerDao managerDao;


    @Override
    public List<Student> selectStuUser() {
        return managerDao.selectStuUser();
    }

    @Override
    public boolean modifyStuUser(Student student) {
        if (student.getPwd() != null){
            int i = managerDao.modifyPwd(student);
            return i!=0?true:false;
        }else if (student.getStuname() != null){
            int i = managerDao.modifyStuName(student);
            return i!=0?true:false;
        }else{
            Student student1 = managerDao.selectUserTutor(student);
            System.out.println(student1.getTutor());
            if (student1.getTutor()!=null){
                int i = managerDao.modifyTutor(student);
                return i!=0?true:false;
            }else{
                int i = managerDao.insertTutor(student);
                return i!=0?true:false;
            }


        }
    }

    @Override
    public boolean deleteStuUser(Student student) {
        int i = managerDao.deleteStuUser(student);
        return i!=0?true:false;
    }

    @Override
    public boolean registerCompany(Student student) {
        int i = managerDao.registerCompany(student);
        return i!=0?true:false;
    }

    @Override
    public List<Company> selectCompany() {
        return managerDao.selectCompany();
    }

    @Override
    public boolean modifyCompany(Company company) {
        int i = managerDao.modifyCompany(company);
        return i!=0?true:false;
    }

    @Override
    public boolean deleteCompany(Company company) {
        int i = managerDao.deleteCompany(company);
        return i!=0?true:false;
    }

    @Override
    public boolean addCompany(Company company) {
        company.setIsdelete(0);
        int i = managerDao.addCompany(company);
        return i!=0?true:false;
    }

    @Override
    public boolean modifyScore(Student student) {
        int i = managerDao.modifyScore(student);
       return i!=0?true:false;
    }

    @Override
    public List<Student> scoreInfo() {
        return managerDao.scoreInfo();
    }

    @Override
    public List<Company> selectCompanyInfo() {
        return managerDao.selectCompany();
    }

    @Override
    public boolean modifyCompanyPwd(Company company) {
        int i = managerDao.modifyCompanyPwd(company);
        return i != 0 ? true : false;
    }
}
