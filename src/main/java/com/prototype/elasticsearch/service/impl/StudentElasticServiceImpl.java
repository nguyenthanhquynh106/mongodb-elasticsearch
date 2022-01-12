package com.prototype.elasticsearch.service.impl;

import com.prototype.elasticsearch.document.StudentElastic;
import com.prototype.elasticsearch.repository.StudentElasticRepository;
import com.prototype.elasticsearch.service.StudentElasticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentElasticServiceImpl implements StudentElasticService {

    @Autowired
    StudentElasticRepository studentElasticRepository;

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
    public Float getSumScore(String id) {
        Optional<StudentElastic> studentElastic = studentElasticRepository.findById(id);
        System.out.println(studentElastic);
        return studentElastic.isPresent() ? studentElastic.get().getAvgScore()*3 : null;
    }

    @Override
    public Float getAvgScore(String id) {
        Optional<StudentElastic> studentElastic = studentElasticRepository.findById(id);
        System.out.println(studentElastic);
        return studentElastic.isPresent() ? studentElastic.get().getAvgScore() : null;
    }

}
