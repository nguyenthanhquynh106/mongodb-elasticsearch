package com.prototype.elasticsearch.repository;

import com.prototype.elasticsearch.document.StudentElastic;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentElasticRepository extends ElasticsearchRepository<StudentElastic, String> {
    StudentElastic findByName(String name);
}
