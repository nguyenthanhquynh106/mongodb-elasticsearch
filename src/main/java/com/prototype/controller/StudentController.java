package com.prototype.controller;

import com.prototype.elasticsearch.document.StudentElastic;
import com.prototype.elasticsearch.service.StudentElasticService;
import com.prototype.mongodb.document.StudentMongo;
import com.prototype.mongodb.service.StudentMongoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private StudentMongoService studentMongoService;

    @Autowired
    private StudentElasticService studentElasticService;

    @GetMapping("/students")
    public Iterable<StudentElastic> getAll() {
        return studentElasticService.findAll();
    }

    @GetMapping("/students/{name}")
    public StudentElastic findByName(@PathVariable String name) {
        return studentElasticService.findByName(name);
    }

    @GetMapping("/sumScore/{id}")
    public Float getSumScore(@PathVariable String id) {
        return studentElasticService.getSumScore(id);
    }

    @GetMapping("/avgScore/{id}")
    public Float getAvgScore(@PathVariable String id) {
        return studentElasticService.getAvgScore(id);
    }

    @GetMapping("/rank/{id}")
    public int getRank(@PathVariable String id) {
        return studentMongoService.getUserRank(id);
    }
}
