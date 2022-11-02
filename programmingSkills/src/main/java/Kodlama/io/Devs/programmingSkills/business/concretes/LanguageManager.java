package Kodlama.io.Devs.programmingSkills.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Kodlama.io.Devs.programmingSkills.business.abstracts.LanguageService;
import Kodlama.io.Devs.programmingSkills.dataAccess.abstracts.LanguageRepository;
import Kodlama.io.Devs.programmingSkills.entities.concretes.Language;

@Service
public class LanguageManager implements LanguageService {
	private LanguageRepository languageRepository;

	@Autowired
	public LanguageManager(LanguageRepository languageRepository) {
		this.languageRepository = languageRepository;
	}

	@Override
	public void add(Language language) throws Exception {
		if (language.getName() == "") {
			throw new Exception("Programlama dili boş geçilemez !!!");
		}

		for (Language lang : languageRepository.getAll()) {
			if (lang.getName().equals(language.getName())) {
				throw new Exception("Programlama dili mevcuttur. Tekrar eklenemez !!!");
			}
		}

		languageRepository.addNew(language);
	}

	@Override
	public void delete(int id) {
		this.languageRepository.delete(id);
	}

	@Override
	public void update(int newId, String newName) throws Exception {
		for (Language lang : languageRepository.getAll()) {
			if (lang.getName().equals(newName)) {
				throw new Exception("Programlama dili mevcuttur. Tekrar edemez !!!");
			}
		}

		for (Language lang : languageRepository.getAll()) {
			if (lang.getId() == newId) {
				if (!lang.getName().equals(newName)) {
					lang.setName(newName);
				}
			}
		}

		for (Language lang : languageRepository.getAll()) {
			if (lang.getId() != newId) {
				if (lang.getName().equals(newName)) {
					throw new Exception("Programlama dili bulunmamaktadır !!!");
				}
			}
		}

		languageRepository.update(newId, newName);
		System.out.println("Programlama dili güncellendi");
	}

	@Override
	public List<Language> getAll() {
		return languageRepository.getAll();
	}

	@Override
	public Language getById(int id) throws Exception {
		for (Language lang : languageRepository.getAll()) {
			if (lang.getId() == id) {
				return lang;		
			}
		}
		
		for (Language lang : languageRepository.getAll()) {
			if (lang.getId() != id) {
				throw new Exception("Programlama dili bulunmamaktadır !!!");		
			}
		}	

		return this.languageRepository.getById(id);
	}

}
