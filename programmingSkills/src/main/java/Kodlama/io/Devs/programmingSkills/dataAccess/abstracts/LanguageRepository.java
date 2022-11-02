package Kodlama.io.Devs.programmingSkills.dataAccess.abstracts;

import java.util.List;

import Kodlama.io.Devs.programmingSkills.entities.concretes.Language;

public interface LanguageRepository {
	
	void addNew(Language language);
	
	void delete(int id);
	
	void update(int newId, String newName);

	List<Language> getAll();
	
	Language getById(int id);
	
}
