package com.crio.starter.data;

import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.constraints.NotNull;
import com.mongodb.lang.NonNull;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Document;
import org.bson.types.ObjectId;

@Data
@NoArgsConstructor
@Document(collection = "memes")
public class GreetingsEntity {
  @Id
  private String id;

  @NotNull
  private String name;
  
  @NotNull
  private String caption;

  @NotNull
  private String url;

}
