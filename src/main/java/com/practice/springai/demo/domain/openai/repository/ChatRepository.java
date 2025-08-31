package com.practice.springai.demo.domain.openai.repository;

import com.practice.springai.demo.domain.openai.entity.ChatEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ChatRepository extends JpaRepository<ChatEntity,Long> {
  List<ChatEntity> findByUserIdOrderByCreatedAtAsc(String userId);
}
