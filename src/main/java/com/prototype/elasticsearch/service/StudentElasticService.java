package com.prototype.elasticsearch.service;

import com.prototype.elasticsearch.document.StudentElastic;
import com.prototype.elasticsearch.response.StudentResponseWithAvg;
import com.prototype.elasticsearch.response.StudentResponseWithRank;
import com.prototype.elasticsearch.response.StudentResponseWithSum;

import java.util.List;

public interface StudentElasticService {
    StudentElastic save(StudentElastic studentElastic);

    void deleteAll();

    Iterable<StudentElastic> findAll();

    StudentElastic findByName(String name);

    List<StudentResponseWithSum> getAllStudentsWithSumScore();

    List<StudentResponseWithAvg> getAllStudentsWithAvgScore();

    List<StudentResponseWithRank> getAllStudentsWithRank();

}
