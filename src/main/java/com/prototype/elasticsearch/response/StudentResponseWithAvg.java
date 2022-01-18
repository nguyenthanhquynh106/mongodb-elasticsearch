package com.prototype.elasticsearch.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class StudentResponseWithAvg {

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

    @JsonProperty("avg_score")
    private Float avgScore;

}
