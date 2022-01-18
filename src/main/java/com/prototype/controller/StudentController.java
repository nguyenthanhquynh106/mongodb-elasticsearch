package com.prototype.controller;

import com.prototype.elasticsearch.document.StudentElastic;
import com.prototype.elasticsearch.response.StudentResponseWithAvg;
import com.prototype.elasticsearch.response.StudentResponseWithRank;
import com.prototype.elasticsearch.response.StudentResponseWithSum;
import com.prototype.elasticsearch.service.StudentElasticService;
import com.prototype.mongodb.service.StudentMongoService;
import com.prototype.redis.document.StudentRedis;
import com.prototype.redis.service.StudentRedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private StudentElasticService studentElasticService;

    @Autowired
    private StudentRedisService studentRedisService;

    @GetMapping("/students")
    public ResponseEntity<Iterable<StudentElastic>> getAll() {
        return ResponseEntity.ok().body(studentElasticService.findAll());
    }

    @GetMapping("students/sum_score")
    public ResponseEntity<List<StudentResponseWithSum>> getAllStudentsWithSumScore() {
        return ResponseEntity.ok().body(studentElasticService.getAllStudentsWithSumScore());
    }

    @GetMapping("students/avg_score")
    public ResponseEntity<List<StudentResponseWithAvg>> getAllStudentsWithAvgScore() {
        return ResponseEntity.ok().body(studentElasticService.getAllStudentsWithAvgScore());
    }

    @GetMapping("students/rank")
    public ResponseEntity<List<StudentResponseWithRank>> getAllStudentsWithRank() {
        return ResponseEntity.ok().body(studentElasticService.getAllStudentsWithRank());
    }

    @GetMapping("students/{id}")
    public ResponseEntity<StudentRedis> getStudentById(@PathVariable String id) {
        return ResponseEntity.ok().body(studentRedisService.get(id));
    }
}
