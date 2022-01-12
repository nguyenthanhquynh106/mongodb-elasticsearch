package com.prototype.mongodb.service.impl;

import com.prototype.mongodb.document.StudentMongo;
import com.prototype.mongodb.document.StudentResponse;
import com.prototype.mongodb.repository.StudentMongoRepository;
import com.prototype.mongodb.service.StudentMongoService;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationOperation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentMongoServiceImpl implements StudentMongoService {

    private StudentMongoRepository studentMongoRepository;

    private MongoTemplate mongoTemplate;

    public StudentMongoServiceImpl(StudentMongoRepository studentMongoRepository, MongoTemplate mongoTemplate) {
        this.studentMongoRepository = studentMongoRepository;
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public List<StudentMongo> findAll() {
        return studentMongoRepository.findAll();
    }

    @Override
    public int getUserRank(String id) {
        Optional<StudentMongo> studentMongoOptional = studentMongoRepository.findById(id);
        if (studentMongoOptional.isPresent()) {
            StudentMongo studentMongo = studentMongoOptional.get();

            Aggregation agg = Aggregation.newAggregation(
                    Aggregation.match(Criteria.where("avgScore").gte(studentMongo.getAvgScore())),
                    Aggregation.match(Criteria.where("className").is(studentMongo.getClassName())),
                    Aggregation.group("avgScore").count().as("count"),
                    Aggregation.group().count().as("rank"));

            AggregationResults<StudentResponse> studentResponses = mongoTemplate.aggregate(
                    agg, StudentMongo.class, StudentResponse.class);

            if (studentResponses.getUniqueMappedResult() != null) {
                StudentResponse studentResponse = studentResponses.getUniqueMappedResult();
                return studentMongo.getMathScore() > 0 ? studentResponse.getRank() : 0;
            }

        }
        return 0;
    }

    @Override
    public void update(StudentMongo studentMongo) {
        if (studentMongo.getAvgScore() == null || studentMongo.getAvgScore() == 0) {
            studentMongoRepository.delete(studentMongo);
            studentMongo.setAvgScore((studentMongo.getMathScore() + studentMongo.getPhysicScore() + studentMongo.getChemistryScore()) / 3);
            studentMongoRepository.save(studentMongo);
        }

    }

}
