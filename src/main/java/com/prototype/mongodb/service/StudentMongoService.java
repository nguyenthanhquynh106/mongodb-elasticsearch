package com.prototype.mongodb.service;

import com.prototype.mongodb.document.StudentMongo;

import java.util.List;

public interface StudentMongoService {

    List<StudentMongo> findAll();

    int getUserRank(String id);

    void update(StudentMongo studentMongo);
}
