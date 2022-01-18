package com.prototype.mongodb.document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(value = "student")
public class StudentMongo implements Serializable {

    @Id
    private ObjectId studentId;

    @Field(name = "name")
    private String name;

    @Field(name = "class")
    private String className;

    @Field(name = "math_score")
    private Float mathScore;

    @Field(name = "physic_score")
    private Float physicScore;

    @Field(name = "chemistry_score")
    private Float chemistryScore;

    @Field(name = "avg_score")
    private Float avgScore;

}
