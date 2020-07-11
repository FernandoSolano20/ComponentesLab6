package com.cenfotec.journal.repository;
import org.springframework.data.jpa.repository.JpaRepository;  
import com.cenfotec.journal.domain.Journal;

public interface JournalRepository extends JpaRepository<Journal, Long> {
	
}
