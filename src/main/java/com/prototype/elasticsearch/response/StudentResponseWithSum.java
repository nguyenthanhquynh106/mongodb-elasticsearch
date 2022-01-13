package com.prototype.elasticsearch.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Field;

@Data
public class StudentResponseWithSum {

    @JsonProperty("id")
    private String studentId;

    @JsonProperty("name")
    private String name;

    @JsonProperty("class")
    private String className;

    @JsonProperty("math_score")
    private Float mathScore;

    @JsonProperty("physic_score")
    private Float physicScore;

    @JsonProperty("chemistry_score")
    private Float chemistryScore;

    @JsonProperty("sum_score")
    private Float sumScore;

}
