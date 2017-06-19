package com.balance.repository;

import com.balance.model.EscalaresHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EscalaresHistoryRepository extends JpaRepository<EscalaresHistory, Integer> {
}
