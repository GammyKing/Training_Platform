package com.service.Impl;

import com.dao.PlatformDao;
import com.pojo.Student;
import com.service.PlatformService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlatformServiceImpl implements PlatformService {
    @Autowired
    PlatformDao platformDao;
    @Override
    public boolean insertScore(Student student) {
        int i = platformDao.insertScore(student);
        return i!=0?true:false;
    }

    @Override
    public String findCompanyName(int id) {
        return platformDao.findCompanyName(id);
    }

    @Override
    public List<Student> showStudent(String companyName) {
        return platformDao.showStudent(companyName);
    }
}
