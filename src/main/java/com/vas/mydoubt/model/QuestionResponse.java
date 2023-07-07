package com.vas.mydoubt.model;

import com.vas.mydoubt.entity.Answer;
import lombok.Data;

import java.util.List;

@Data
public class QuestionResponse {

    private Integer questionId;
    private String description;
    private List<Answer> answers;

}
