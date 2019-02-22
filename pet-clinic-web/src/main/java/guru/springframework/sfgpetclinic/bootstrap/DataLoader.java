package guru.springframework.sfgpetclinic.bootstrap;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.model.Pet;
import guru.springframework.sfgpetclinic.model.PetType;
import guru.springframework.sfgpetclinic.model.Vet;
import guru.springframework.sfgpetclinic.services.OwnerService;
import guru.springframework.sfgpetclinic.services.PetTypeService;
import guru.springframework.sfgpetclinic.services.VetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

	private final OwnerService ownerService;
	private final VetService vetService;
	private final PetTypeService petTypeService;

	public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
		this.ownerService = ownerService;
		this.vetService = vetService;
		this.petTypeService = petTypeService;
	}

	@Override
	public void run(String... args) throws Exception {
		PetType dog = new PetType();
		dog.setName("Dog");

		PetType savedDogType = petTypeService.save(dog);

		PetType cat = new PetType();
		cat.setName("Cat");

		PetType savedCatType = petTypeService.save(cat);

		Owner owner = new Owner();
		owner.setFirstName("Michael");
		owner.setLastName("Schumacher");
		owner.setAddress("123 Blair");
		owner.setCity("Chicago");
		owner.setTelephone("75696311542");

		Pet mikesPet = new Pet();
		mikesPet.setPetType(savedDogType);
		mikesPet.setOwner(owner);
		mikesPet.setBirthDate(LocalDate.now());
		mikesPet.setName("Rosco");

		owner.getPets().add(mikesPet);

		ownerService.save(owner);

		Owner owner1 = new Owner();
		owner1.setFirstName("Maria");
		owner1.setLastName("Antonina");
		owner1.setAddress("123 MiamiStreet");
		owner1.setCity("Miami");
		owner1.setTelephone("12312312333");

		Pet mariasPet = new Pet();
		mariasPet.setPetType(savedCatType);
		mariasPet.setOwner(owner1);
		mariasPet.setBirthDate(LocalDate.now());
		mariasPet.setName("Kitty");

		owner1.getPets().add(mariasPet);

		ownerService.save(owner1);

		System.out.println("Loaded owners...");

		Vet vet = new Vet();
		vet.setFirstName("Dr");
		vet.setLastName("Doolittle");

		vetService.save(vet);

		Vet vet1 = new Vet();
		vet1.setFirstName("Another");
		vet1.setLastName("Doctor");

		vetService.save(vet1);

		System.out.println("Loaded vets...");
	}
}
