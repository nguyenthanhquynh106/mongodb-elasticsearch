package com.prototype.redis.document;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.prototype.mongodb.document.StudentMongo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StudentRedis implements Serializable {
    @Id
    private String studentId;

    @JsonProperty(value = "name")
    private String name;

    @JsonProperty(value = "class")
    private String className;

    @JsonProperty(value = "math_score")
    private Float mathScore;

    @JsonProperty(value = "physic_score")
    private Float physicScore;

    @JsonProperty(value = "chemistry_score")
    private Float chemistryScore;

    public static StudentRedis convertToRedis(StudentMongo studentMongo) {
        return StudentRedis.builder()
                .studentId(studentMongo.getStudentId().toString())
                .name(studentMongo.getName())
                .className(studentMongo.getClassName())
                .mathScore(studentMongo.getMathScore())
                .physicScore(studentMongo.getPhysicScore())
                .chemistryScore(studentMongo.getChemistryScore())
                .build();
    }
}
