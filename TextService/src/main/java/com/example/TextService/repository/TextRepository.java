package com.example.TextService.repository;

import com.example.TextService.model.DBtext;
import com.example.TextService.model.Text;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface TextRepository extends MongoRepository<DBtext, String> {

}
