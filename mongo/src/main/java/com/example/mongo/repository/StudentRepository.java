package com.example.mongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.mongo.entity.Student;

@Repository
public interface StudentRepository extends MongoRepository<Student, String>{

}
