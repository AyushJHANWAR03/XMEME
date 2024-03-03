package com.crio.starter.service;

import com.crio.starter.data.GreetingsEntity;
import com.crio.starter.exchange.GetMemeResponse;
import com.crio.starter.exchange.PostMemeResponse;
import com.crio.starter.repository.GreetingsRepository;
import lombok.RequiredArgsConstructor;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GreetingsService {
  @Autowired
  private final GreetingsRepository greetingsRepository;

  @Autowired
  private final MongoTemplate mongoTemplate;

  public GreetingsEntity addmeme(GreetingsEntity meme) {
    
    Query query = new Query();
    query.addCriteria(Criteria.where( "name"). is (meme.getName () )) ; 
    query.addCriteria(Criteria.where("url").is(meme.getUrl() )) ;
    query.addCriteria(Criteria.where ("caption"). is (meme. getCaption ( ) )) ;
    boolean alreadyexists = mongoTemplate.exists(query, "memes");
    if (alreadyexists == true) {
      return null; 
    } else {
      return greetingsRepository.save(meme);
    }

  }
    public GetMemeResponse getMemelist() {
        Sort sort = Sort.by(Sort.Direction.DESC, "id");
        List<GreetingsEntity> memefetch = greetingsRepository.findAll(Example.of(new GreetingsEntity()), sort);
        int size = memefetch.size();
        if(size == 0){
          return new GetMemeResponse(memefetch);
        } else if(size<100){
          return new GetMemeResponse(memefetch);
        } else{
            return new GetMemeResponse(memefetch.stream().limit(100).collect(Collectors.toList()));
        }
    }

    public Optional<GreetingsEntity> getMeme(String memeid){
    
      return greetingsRepository.findById(memeid);
    }


}
