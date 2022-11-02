package Kodlama.io.Devs.programmingSkills.business.abstracts;


import java.util.List;

import Kodlama.io.Devs.programmingSkills.entities.concretes.Language;

public interface LanguageService {
	
	void add(Language language) throws Exception;
	
	void delete(int id);
	
	void update(int newId, String newName) throws Exception;
	
	List<Language> getAll();
	
	Language getById(int id) throws Exception;

}
