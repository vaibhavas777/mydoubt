package com.vas.mydoubt.repo;

import com.vas.mydoubt.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepo extends JpaRepository<Integer, Question> {
}
