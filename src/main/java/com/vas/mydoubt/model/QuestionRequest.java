package com.vas.mydoubt.model;

import com.vas.mydoubt.entity.Answer;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class QuestionRequest {
    private String questionDescription;
    private String username;
}
