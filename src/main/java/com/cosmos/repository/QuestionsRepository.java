package com.cosmos.repository;

import com.cosmos.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionsRepository extends JpaRepository<Question,Long> {
}
