package com.vas.mydoubt.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Question {

    @Id
    @Column(name = "QUESTION_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer questionId;

    @Column(name = "DESCRIPTION")
    private String description;

    @OneToMany(mappedBy = "questions", cascade = CascadeType.ALL)
    private List<Answer> answers;

}
