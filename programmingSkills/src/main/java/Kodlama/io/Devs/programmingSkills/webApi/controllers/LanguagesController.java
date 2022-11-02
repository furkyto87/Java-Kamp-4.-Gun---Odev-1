package Kodlama.io.Devs.programmingSkills.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import Kodlama.io.Devs.programmingSkills.business.abstracts.LanguageService;
import Kodlama.io.Devs.programmingSkills.entities.concretes.Language;

@RestController
@RequestMapping("/api/languages")
public class LanguagesController {
	private LanguageService languageService;

	@Autowired
	public LanguagesController(LanguageService languageService) {
		this.languageService = languageService;
	}

	@PostMapping("/add")
	public void add(@RequestBody Language language) throws Exception {
		this.languageService.add(language);
	}
	
	@DeleteMapping("/delete")
	public void delete(@RequestParam int id) {
		this.languageService.delete(id);
	}
	
	@PutMapping ("/update")
	public void update(int newId, String newName) throws Exception {
		this.languageService.update(newId, newName);
	}

	@GetMapping("/getall")
	public List<Language> getAll() {
		return this.languageService.getAll();
	}

	@GetMapping("/getbyid")
	public Language getById(@RequestParam int id) throws Exception {
		return this.languageService.getById(id);
	}
}
	

