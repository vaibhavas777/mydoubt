package com.vas.mydoubt.repo;

import com.vas.mydoubt.entity.Answer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnswerRepo extends JpaRepository<Integer, Answer> {
}
