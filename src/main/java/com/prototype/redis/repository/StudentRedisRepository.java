package com.prototype.redis.repository;

import com.prototype.redis.document.StudentRedis;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public class StudentRedisRepository {
    final Logger logger = LoggerFactory.getLogger(StudentRedisRepository.class);

    @Autowired
    private RedisTemplate template;

    public void create(StudentRedis student) {
        template.opsForHash().put("STUDENT", student.getStudentId(), student);
        logger.info(String.format("Student with id=%s saved!", student.getStudentId()));
    }

    public StudentRedis get(String id) {
        return (StudentRedis) template.opsForHash().get("STUDENT", id);
    }

    public Map<String, StudentRedis> getAll() {
        return template.opsForHash().entries("STUDENT");
    }

    public void update(StudentRedis student) {
        template.opsForHash().put("STUDENT", student.getStudentId(), student);
        logger.info(String.format("Student with id=%s updated!", student.getStudentId()));
    }

    public void delete(String id) {
        template.opsForHash().delete("STUDENT", id);
        logger.info(String.format("Student with id=%s deleted!", id));
    }
}
