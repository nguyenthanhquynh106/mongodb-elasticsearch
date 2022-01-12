package com.prototype.elasticsearch.service;

import com.prototype.elasticsearch.document.StudentElastic;

public interface StudentElasticService {
    StudentElastic save(StudentElastic studentElastic);

    void deleteAll();

    Iterable<StudentElastic> findAll();

    StudentElastic findByName(String name);

    Float getSumScore(String id);

    Float getAvgScore(String id);

}
