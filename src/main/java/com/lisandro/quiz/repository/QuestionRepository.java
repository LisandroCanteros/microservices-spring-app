package com.lisandro.quiz.repository;

import com.lisandro.quiz.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Integer> {
    List<Question> findAllByCategory(String category);

    @Query(value = "SELECT * FROM question q WHERE q.category = :category LIMIT :numberOfQuestions", nativeQuery = true)
    List<Question> findByCategoryLimit(@Param("category") String category, @Param("numberOfQuestions") int amount);
}
