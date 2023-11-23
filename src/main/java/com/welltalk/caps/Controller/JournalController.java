/*package com.welltalk.caps.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.welltalk.caps.Entity.JournalEntity;
import com.welltalk.caps.Repository.JournalRepository;
import com.welltalk.caps.Service.JournalService;


@RestController
@RequestMapping("/journal")
public class JournalController {


	@GetMapping("/print")
	public String printJournals() {
		return "Hello";
	}
	
	@Autowired
	JournalRepository jrepo;
	
	@Autowired
	JournalService jserv;
	
	@GetMapping("/getAllJournals")
	public List<JournalEntity> getAllJournals(){
		return jrepo.findAll();
	}
	
	@PutMapping("/updateJournal")
	public JournalEntity updateJournal(@RequestParam int JournalID, @RequestBody JournalEntity newJournalDetails) throws Exception{
		return jserv.updateJournal(JournalID, newJournalDetails);
	}
	@DeleteMapping("/deleteJournal/{JournalID}")
	public String deleteUser(@PathVariable int JournalID) {
		return jserv.deleteJournal(JournalID);
	}
	
	@PostMapping("/createJournal")
	public JournalEntity createUser(@RequestBody JournalEntity journal) {
		return jrepo.save(journal);
	}
}
*/
package com.welltalk.caps.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.welltalk.caps.Repository.JournalRepository;
import com.welltalk.caps.Service.JournalService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.welltalk.caps.Entity.JournalEntity;


@RestController
@CrossOrigin(origins = "http://localhost:19006/")
public class JournalController {

    private JournalRepository journalRepository;
	private JournalService journalService;
	
	@Autowired
    public JournalController(JournalService journalService, JournalRepository journalRepository) {
        this.journalService = journalService;
        this.journalRepository = journalRepository;
    }
    
    @PostMapping("/journal")
    public ResponseEntity<String> createJournalEntry(@RequestBody JournalEntity journalEntry) {
        try {
            journalRepository.save(journalEntry);
            return ResponseEntity.ok("Journal entry saved successfully!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error saving journal entry: " + e.getMessage());
        }
    }

    @GetMapping("/getAll")
    public List<JournalEntity> getAllJournal() {
        return journalRepository.findAll();
    }

    @GetMapping("/journal/{userid}")
    public List<JournalEntity> getAllJournalsByUserId(@PathVariable int userid) {
        return journalService.getAllJournalsByUserId(userid);
    }
    
    @PutMapping("/journal/{id}")
    public ResponseEntity<String> updateJournalEntry(@PathVariable("id") int id, @RequestBody JournalEntity updatedEntry) {
        Optional<JournalEntity> journalEntry = journalRepository.findById(id);
        if (journalEntry.isPresent()) {
            JournalEntity existingEntry = journalEntry.get();
            existingEntry.setTitle(updatedEntry.getTitle());
            existingEntry.setType(updatedEntry.getType());
            existingEntry.setDate(updatedEntry.getDate());
            existingEntry.setMood(updatedEntry.getMood());
            existingEntry.setMessage(updatedEntry.getMessage());
            journalRepository.save(existingEntry);
            return ResponseEntity.ok("Journal entry updated successfully!");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("/journal/{id}")
    public ResponseEntity<String> deleteJournalEntry(@PathVariable("id") int id) {
        Optional<JournalEntity> journalEntry = journalRepository.findById(id);
        if (journalEntry.isPresent()) {
            journalRepository.deleteById(id);
            return ResponseEntity.ok("Journal entry deleted successfully!");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping("/journalGet/{id}")
    public ResponseEntity<JournalEntity> getJournalEntryById(@PathVariable("id") int id) {
        Optional<JournalEntity> journalEntry = journalRepository.findById(id);
        return journalEntry.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/getByUser")
    public List<JournalEntity> getJournalsByUser(@RequestParam("userid") int userid) {
        List<JournalEntity> allJournals = journalRepository.findAll();
        List<JournalEntity> userJournals = new ArrayList<>();
        
        for (JournalEntity journal : allJournals) {
            if (journal.getUserid() == userid) { 
                userJournals.add(journal);
            }
        }
        
        return userJournals;
    }
   
   
    
}