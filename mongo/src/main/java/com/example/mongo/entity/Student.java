package com.example.mongo.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "student")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {

	@Id
	private String id;
	private String name;
	private String email;
	private Long mobile;
}
