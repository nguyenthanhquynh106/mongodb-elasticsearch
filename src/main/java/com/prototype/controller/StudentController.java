package com.prototype.controller;

import com.prototype.elasticsearch.document.StudentElastic;
import com.prototype.elasticsearch.response.StudentResponseWithAvg;
import com.prototype.elasticsearch.response.StudentResponseWithRank;
import com.prototype.elasticsearch.response.StudentResponseWithSum;
import com.prototype.elasticsearch.service.StudentElasticService;
import com.prototype.mongodb.service.StudentMongoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private StudentElasticService studentElasticService;

    @GetMapping("/students")
    //curl -XGET "http://localhost:9200/quynh/student/_search?pretty&filter_path=hits.hits._source"
    public ResponseEntity<Iterable<StudentElastic>> getAll() {
        return ResponseEntity.ok().body(studentElasticService.findAll());
    }

    @GetMapping("/students/{name}")
    public StudentElastic findByName(@PathVariable String name) {
        return studentElasticService.findByName(name);
    }

    @GetMapping("students/sum_score")
    public ResponseEntity<List<StudentResponseWithSum>> getStudentsWithSumScore() {
        return ResponseEntity.ok().body(studentElasticService.getStudentsWithSumScore());
    }

    @GetMapping("students/avg_score")
    public ResponseEntity<List<StudentResponseWithAvg>> getStudentsWithAvgScore() {
        return ResponseEntity.ok().body(studentElasticService.getStudentsWithAvgScore());
    }

    @GetMapping("students/rank")
    public ResponseEntity<List<StudentResponseWithRank>> getStudentsWithRank() {
        return ResponseEntity.ok().body(studentElasticService.getStudentsWithRank());
    }
}
