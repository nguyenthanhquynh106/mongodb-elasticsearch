package com.prototype.mongodb.repository;

import com.prototype.mongodb.document.StudentMongo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentMongoRepository extends MongoRepository<StudentMongo, String> {

    List<StudentMongo> findAll();

    StudentMongo save(StudentMongo studentMongo);
}