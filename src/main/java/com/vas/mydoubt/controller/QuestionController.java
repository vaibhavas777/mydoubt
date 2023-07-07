package com.vas.mydoubt.controller;

import com.vas.mydoubt.model.QuestionRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("admin/question")
public class QuestionController {

    @PostMapping
    public ResponseEntity createQuestion(@RequestBody QuestionRequest request){
        return null;
    }

    @GetMapping("/{qid}")
    public ResponseEntity getQuestionById(@PathVariable String qid){
        return null;
    }

    @GetMapping("/getAll")
    public ResponseEntity getAllQuestions(){
        return null;
    }

    @GetMapping("/{qid}")
    public ResponseEntity deleteQuestionById(@PathVariable String qid){
        return null;
    }

    @PutMapping
    public ResponseEntity updateQuestion(@RequestBody QuestionRequest request){
        return null;
    }
}
