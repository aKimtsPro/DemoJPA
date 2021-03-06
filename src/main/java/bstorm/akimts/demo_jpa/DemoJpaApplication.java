package bstorm.akimts.demo_jpa;

import bstorm.akimts.demo_jpa.data.CoursRepository;
import bstorm.akimts.demo_jpa.data.ProfesseurRepository;
import bstorm.akimts.demo_jpa.data.SectionRepository;
import bstorm.akimts.demo_jpa.data.SimpleCrudRepository;
import bstorm.akimts.demo_jpa.models.entities.Cours;
import bstorm.akimts.demo_jpa.models.entities.Professeur;
import bstorm.akimts.demo_jpa.models.entities.Section;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootApplication
public class DemoJpaApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(DemoJpaApplication.class, args);

		SectionRepository dao = context.getBean(SectionRepository.class);
//
//		Section section = dao.getOne(1010);
//		System.out.println(section);
//
//		Section toAdd = new Section(10000, "ma section", 1L);
//		if( dao.insert(toAdd) ){
//			System.out.println(" -- il a été ajouté -- ");
//		}
//		else {
//			System.out.println(" -- il n'a pas été ajouté -- ");
//		}

//		Section toUpdate = dao.getOne(10000);
//
//		toUpdate.setName("au final tu seras pas delete");
//		toUpdate.setDelegateId(1L);
//
//		toUpdate = dao.update(toUpdate.getId(), toUpdate);

//		List<Section> list = dao.getAll();
//
//		list.forEach( System.out::println );



		// TEST - CoursRepo

		CoursRepository repo = context.getBean( CoursRepository.class );

		// GET ONE
//		Cours c = repo.getOne("EG1010");
//		System.out.println(c);

		// GET ALL
//		List<Cours> list = repo.getAll();
//		list.forEach( System.out::println );

		// INSERT
//		Cours c1 = new Cours("GG0000", "toDelete", 0, 1);
//		repo.insert(c1);

		// DELETE
//		Cours c2 = repo.delete("GG0000");
//		System.out.println(c2);

		// UPDATE
//		c1.setName("nom modifié");
//		Cours coursModifie = repo.update(c1);
//		System.out.println(coursModifie);


		SimpleCrudRepository<Professeur, Long> repoProf = context.getBean(ProfesseurRepository.class);

		// GET ONE
//		repoProf.getOne(11L).ifPresentOrElse(
//				System.out::println,
//				() -> System.out.println("le prof d'id 11 n'existe pas")
//		);

		// GET ALL
		repoProf.getAll().forEach( System.out::println );

		// INSERT
		Professeur toInsert = new Professeur(
				10,
				"test",
				"test_",
				"email",
				1010,
				400,
				LocalDateTime.now(),
				2000
		);
//		repoProf.insert(toInsert);

		// UPDATE
//		toInsert.setEmail("encore un autre email");
//		repoProf.update(toInsert);

		// DELETE
		Professeur deleted = repoProf.delete(10L);
		System.out.println(deleted);

		repoProf.insert(toInsert);


	}

}
