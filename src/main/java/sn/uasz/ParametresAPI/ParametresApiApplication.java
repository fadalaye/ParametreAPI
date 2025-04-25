package sn.uasz.ParametresAPI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import sn.uasz.ParametresAPI.entities.Formation;
import sn.uasz.ParametresAPI.repository.FormationRepository;

import java.util.List;

@SpringBootApplication
public class ParametresApiApplication {

	@Autowired
	private FormationRepository formationRepository;

	public static void main(String[] args) {
		SpringApplication.run(ParametresApiApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner() {
		return args -> {
			Formation formation1 = new Formation();
			formation1.setLibelle("INFO");

			Formation formation2 = new Formation();
			formation2.setLibelle("MATHS");

			Formation formation3 = new Formation();
			formation3.setLibelle("PHYSIQUE");

			formationRepository.save(formation1);
			formationRepository.save(formation2);
			formationRepository.save(formation3);

			//  Affichage des formations
			List<Formation> formations = formationRepository.findAll();
			System.out.println("=== Liste des formations ===");
			formations.forEach(f -> System.out.println("ID: " + f.getId() + " | Libellé: " + f.getLibelle()));
		};
	}
}
