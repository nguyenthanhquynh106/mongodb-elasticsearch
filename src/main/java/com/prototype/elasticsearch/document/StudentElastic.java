package com.prototype.elasticsearch.document;

import com.prototype.mongodb.document.StudentMongo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(indexName = "quynh", type = "student")
public class StudentElastic implements Serializable {

	@Id
	private String studentId;

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

	public static StudentElastic convertToElastic(StudentMongo studentMongo) {
		return StudentElastic.builder()
				.studentId(studentMongo.getStudentId().toString())
				.name(studentMongo.getName())
				.className(studentMongo.getClassName())
				.mathScore(studentMongo.getMathScore())
				.physicScore(studentMongo.getPhysicScore())
				.chemistryScore(studentMongo.getChemistryScore())
				.build();
	}
}
