package com.crio.starter.controller;

import com.crio.starter.data.GreetingsEntity;
import com.crio.starter.exchange.GetMemeResponse;
import com.crio.starter.exchange.PostMemeRequest;
import com.crio.starter.exchange.PostMemeResponse;
import com.crio.starter.exchange.ResponseDto;
import com.crio.starter.repository.GreetingsRepository;
import com.crio.starter.service.GreetingsService;
import io.netty.handler.traffic.GlobalChannelTrafficShapingHandler;
import lombok.RequiredArgsConstructor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Validated
public class GreetingsController {

  @Autowired
  private final GreetingsService mservice;

  public GreetingsController(GreetingsService mservice) {
    this.mservice = mservice;
  }
  @PostMapping("/memes/")
  public ResponseEntity<PostMemeResponse> Storememe(@Valid @RequestBody GreetingsEntity meme){
    GreetingsEntity isPresent = mservice.addmeme(meme);
    // PostMemeResponse response = new PostMemeResponse(meme.getId());
    if(isPresent == null){
      return new ResponseEntity<>(HttpStatus.CONFLICT);
    } else{
      return new ResponseEntity<>(new PostMemeResponse(isPresent.getId()),HttpStatus.CREATED);
    }
  }

  @GetMapping("/memes/")
  public List<GreetingsEntity> getallmemes(){
    GetMemeResponse memes = mservice.getMemelist();
    return memes.getMemelist() ;
  }

  @GetMapping("/memes/{id}")
  public ResponseEntity<GreetingsEntity> Getmemesbyid(@PathVariable String id){
    Optional<GreetingsEntity> memeinfo = mservice.getMeme(id);
    if(memeinfo.isEmpty ()) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
      else{
        return new ResponseEntity<>(memeinfo.get() ,HttpStatus.CREATED) ;
      }
      
  }
}
