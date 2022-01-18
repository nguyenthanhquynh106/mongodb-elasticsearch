package com.prototype.redis.service.impl;

import com.prototype.mongodb.document.StudentMongo;
import com.prototype.mongodb.repository.StudentMongoRepository;
import com.prototype.redis.document.StudentRedis;
import com.prototype.redis.repository.StudentRedisRepository;
import com.prototype.redis.service.StudentRedisService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentRedisServiceImpl implements StudentRedisService {

    final Logger logger = LoggerFactory.getLogger(StudentRedisRepository.class);

    @Autowired
    private StudentMongoRepository studentMongoRepository;

    @Autowired
    StudentRedisRepository studentRedisRepository;

    @Override
    public StudentRedis get(String id) {
        if (studentRedisRepository.get(id) == null) {
            Optional<StudentMongo> studentMongoOptional = studentMongoRepository.findById(id);
            if (studentMongoOptional.isPresent()) {
                logger.info(String.format("___________Retrieved student with id=%s from MongoDB___________", id));
                StudentRedis student = StudentRedis.convertToRedis(studentMongoOptional.get());
                studentRedisRepository.create(student);
                return student;
            }
            logger.info(String.format("___________Not found student with id=%s from MongoDB___________", id));
            return null;
        }
        logger.info(String.format("___________Retrieved student with id=%s from Redis___________", id));
        return studentRedisRepository.get(id);
    }
}
