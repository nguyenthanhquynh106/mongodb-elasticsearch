package com.prototype.worker;

import com.prototype.elasticsearch.document.StudentElastic;
import com.prototype.elasticsearch.service.StudentElasticService;
import com.prototype.mongodb.document.StudentMongo;
import com.prototype.mongodb.service.StudentMongoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class InitData {

    @Autowired
    private StudentMongoService studentMongoService;

    @Autowired
    private StudentElasticService studentElasticService;

    public void updateDataMongo() {
        List<StudentMongo> studentsOfMongo = studentMongoService.findAll();
        for (StudentMongo studentMongo : studentsOfMongo) {
            studentMongoService.update(studentMongo);
        }

    }

    public void initDataElastic() {
        studentElasticService.deleteAll();

        List<StudentMongo> students = studentMongoService.findAll();
        System.out.println(students);
        for (StudentMongo studentMongo : students) {
            StudentElastic studentElastic = StudentElastic.convertToElastic(studentMongo);
            studentElasticService.save(studentElastic);
        }

        System.out.println("Thêm dữ liệu vào Elasticsearch thành công!");
    }

}
