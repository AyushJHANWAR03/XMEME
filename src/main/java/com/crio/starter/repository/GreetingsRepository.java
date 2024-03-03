package com.crio.starter.repository;

import com.crio.starter.data.GreetingsEntity;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface GreetingsRepository extends MongoRepository<GreetingsEntity, String> {
   
}
