package com.welltalk.caps.Service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.welltalk.caps.Entity.JournalEntity;
import com.welltalk.caps.Repository.JournalRepository;

@Service
public class JournalService {

	
	private JournalRepository journalRepository;
	@Autowired
    public JournalService(JournalRepository journalRepository) {
        this.journalRepository = journalRepository;
    }
	public List<JournalEntity> getAllJournalsByUserId(int userId) {
        return journalRepository.findByUserid(userId);
    }

	
	public JournalEntity updateJournal(int JournalID, JournalEntity newJournalDetails) throws Exception{
		JournalEntity journal = new JournalEntity();
		
		try {
			journal = journalRepository.findById(JournalID).get();
			
			journal.setType(newJournalDetails.getType());
			journal.setDate(newJournalDetails.getDate());
			journal.setMood(newJournalDetails.getMood());
			journal.setTitle(newJournalDetails.getTitle());
			journal.setMessage(newJournalDetails.getMessage());
			
			return journalRepository.save(journal);
		}catch(NoSuchElementException nex) {
			throw new Exception("ID Number "+ JournalID + "Does Not Exist!");
		}
	}
	public String deleteJournal(int id) {
		String msg;
		
		if (journalRepository.findById(id) !=null) { // Find the record
			journalRepository.deleteById(id);        // Delete the Record
			
			msg = "Journal ID Number " + id + " Is Successfully Deleted!";
		}
		else 
			msg = "Journal ID Number " + id + " Is Not Found!";
		
		return msg;
	}
	

  
}
