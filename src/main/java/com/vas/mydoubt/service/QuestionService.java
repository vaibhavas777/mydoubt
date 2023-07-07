package com.vas.mydoubt.service;

import com.vas.mydoubt.entity.Question;
import org.springframework.stereotype.Service;

@Service
public interface QuestionService {

    Question createQuestion();
}
