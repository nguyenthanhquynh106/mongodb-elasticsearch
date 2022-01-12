package com.prototype.mongodb.document;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

@Data
public class StudentResponse {

    @Id
    private ObjectId studentId;

    private String name;

    private String avgScore;

    private int rank;
}
