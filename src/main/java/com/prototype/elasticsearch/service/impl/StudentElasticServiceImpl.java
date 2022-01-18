package com.prototype.elasticsearch.service.impl;

import com.prototype.elasticsearch.document.StudentElastic;
import com.prototype.elasticsearch.repository.StudentElasticRepository;
import com.prototype.elasticsearch.response.StudentResponseWithAvg;
import com.prototype.elasticsearch.response.StudentResponseWithRank;
import com.prototype.elasticsearch.response.StudentResponseWithSum;
import com.prototype.elasticsearch.service.StudentElasticService;
import com.prototype.mongodb.service.StudentMongoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentElasticServiceImpl implements StudentElasticService {

    @Autowired
    StudentElasticRepository studentElasticRepository;

    @Autowired
    private StudentMongoService studentMongoService;

    @Override
    public StudentElastic save(StudentElastic studentElastic) {
        return studentElasticRepository.save(studentElastic);
    }

    @Override
    public void deleteAll() {
        studentElasticRepository.deleteAll();
    }

    @Override
    public Iterable<StudentElastic> findAll() {
        return studentElasticRepository.findAll();
    }

    @Override
    public StudentElastic findByName(String name) {
        return studentElasticRepository.findByName(name);
    }

    @Override
    public List<StudentResponseWithAvg> getAllStudentsWithAvgScore() {
        Iterable<StudentElastic> list = studentElasticRepository.findAll();
        List<StudentResponseWithAvg> results = new ArrayList<>();
        list.forEach(s -> {
            StudentResponseWithAvg studentResponseWithAvg = new StudentResponseWithAvg();
            studentResponseWithAvg.setStudentId(s.getStudentId());
            studentResponseWithAvg.setName(s.getName());
            studentResponseWithAvg.setClassName(s.getClassName());
            studentResponseWithAvg.setMathScore(s.getMathScore());
            studentResponseWithAvg.setPhysicScore(s.getPhysicScore());
            studentResponseWithAvg.setChemistryScore(s.getChemistryScore());
            studentResponseWithAvg.setAvgScore((s.getMathScore() + s.getPhysicScore() + s.getChemistryScore()) / 3);
            results.add(studentResponseWithAvg);
        });
        return results;
    }

    @Override
    public List<StudentResponseWithSum> getAllStudentsWithSumScore() {
        Iterable<StudentElastic> list = studentElasticRepository.findAll();
        List<StudentResponseWithSum> results = new ArrayList<>();
        list.forEach(s -> {
            StudentResponseWithSum studentResponseWithSum = new StudentResponseWithSum();
            studentResponseWithSum.setStudentId(s.getStudentId());
            studentResponseWithSum.setName(s.getName());
            studentResponseWithSum.setClassName(s.getClassName());
            studentResponseWithSum.setMathScore(s.getMathScore());
            studentResponseWithSum.setPhysicScore(s.getPhysicScore());
            studentResponseWithSum.setChemistryScore(s.getChemistryScore());
            studentResponseWithSum.setSumScore(s.getMathScore() + s.getPhysicScore() + s.getChemistryScore());
            results.add(studentResponseWithSum);
        });
        return results;
    }

    @Override
    public List<StudentResponseWithRank> getAllStudentsWithRank() {
        Iterable<StudentElastic> list = studentElasticRepository.findAll();
        List<StudentResponseWithRank> results = new ArrayList<>();
        list.forEach(s -> {
            StudentResponseWithRank studentResponseWithRank = new StudentResponseWithRank();
            studentResponseWithRank.setStudentId(s.getStudentId());
            studentResponseWithRank.setName(s.getName());
            studentResponseWithRank.setClassName(s.getClassName());
            studentResponseWithRank.setMathScore(s.getMathScore());
            studentResponseWithRank.setPhysicScore(s.getPhysicScore());
            studentResponseWithRank.setChemistryScore(s.getChemistryScore());
            studentResponseWithRank.setRank(studentMongoService.getUserRank(s.getStudentId()));
            results.add(studentResponseWithRank);
        });
        results.sort((o1, o2) -> {
            if (o1.getClassName().equals(o2.getClassName())) {
                return o2.getRank() - o1.getRank();
            } else {
                return o1.getClassName().compareTo(o2.getClassName());
            }
        });
        return results;
    }

}
