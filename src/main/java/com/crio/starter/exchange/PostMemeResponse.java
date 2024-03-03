package com.crio.starter.exchange;

import lombok.AllArgsConstructor;
import lombok.Data;
import com.mongodb.lang.NonNull;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

@Data
@AllArgsConstructor
public class PostMemeResponse {
    @NonNull
    private String id;
}
