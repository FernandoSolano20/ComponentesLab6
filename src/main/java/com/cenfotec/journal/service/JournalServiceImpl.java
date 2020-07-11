package com.cenfotec.journal.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.stereotype.Service; 
import com.cenfotec.journal.domain.Journal; 
import com.cenfotec.journal.repository.JournalRepository; 

@Service  
public class JournalServiceImpl implements JournalService {
	@Autowired  
	JournalRepository journalRepo;    
	
	@Override  
	public void saveJournal(Journal newJournal) 
	{   
		journalRepo.save(newJournal);  
	} 
	 
	 @Override  public List<Journal> getAllJournals() 
	 {   
		 return journalRepo.findAll();  
	 }
	 
	 @Override
	 public Optional<Journal> getJournals(Long id) {
		 return journalRepo.findById(id);
	 }
}
