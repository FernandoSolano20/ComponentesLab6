package com.cenfotec.journal.web;

import java.text.ParseException;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller; 
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cenfotec.journal.domain.Journal; 
import com.cenfotec.journal.service.JournalService; 
 
 

@Controller
public class JournalController {
	@Autowired  
	JournalService journalService; 
	 
	 @RequestMapping("/")  
	 public String index(Model model) throws ParseException 
	 {   
		 model.addAttribute("journal", journalService.getAllJournals());   
		 Journal newEntry = new Journal("Hola Mundo", "un saludo", "07/15/2017");   
		 journalService.saveJournal(newEntry);
		 return "index";  
	 }
	 
	 @RequestMapping(value="/form", method=RequestMethod.GET)  
	 public String formGet() throws ParseException 
	 {   
		 return "form";  
	 } 
	 
	 @PostMapping( "form" )
	 public void form(@RequestParam MultiValueMap body) throws ParseException 
	 {   
		 String title = (String) body .getFirst("title");
		 String summary = (String) body .getFirst("summary");
		 String date = (String) body .getFirst("date");
		 Journal newEntry = new Journal(title,summary, date);   
		 journalService.saveJournal(newEntry);
	 }
	 
	 @GetMapping("/alljournal")
	 public String getFoos(Model model) {
		 model.addAttribute("journal", journalService.getAllJournals());
		 return "alljournal";
	 }
	 
	 @RequestMapping (value = "/journal/id/{id}")
	 public String getFoos(Model model, @PathVariable("id") String id) {
		 Long idEle = Long.parseLong(id);
		 Journal journal = journalService.getJournals(idEle).get();
		 model.addAttribute("journal", journal);
		 return "journal";
	 }
}
