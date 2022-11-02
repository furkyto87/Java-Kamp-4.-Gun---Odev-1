package Kodlama.io.Devs.programmingSkills.dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import Kodlama.io.Devs.programmingSkills.dataAccess.abstracts.LanguageRepository;
import Kodlama.io.Devs.programmingSkills.entities.concretes.Language;

@Repository
public class InMemoryLanguageRepository implements LanguageRepository {
	List<Language> languages;

	public InMemoryLanguageRepository() {
		languages = new ArrayList<Language>();
		languages.add(new Language(1, "C#"));
		languages.add(new Language(2, "Java"));
		languages.add(new Language(3, "Python"));
		languages.add(new Language(4, "PHP"));
	}

	@Override
	public void addNew(Language language) {
		languages.add(language);
	}
	

	@Override
	public void delete(int id) {
		Language language = getById(id);
		languages.remove(language);
	}
	
	@Override
	public void update(int newId, String newName) {

	}

	@Override
	public List<Language> getAll() {
		return languages;
	}

	@Override
	public Language getById(int id) {
		
		return null;
	}

}
