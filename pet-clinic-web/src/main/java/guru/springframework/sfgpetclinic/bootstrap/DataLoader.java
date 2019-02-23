package guru.springframework.sfgpetclinic.bootstrap;

import guru.springframework.sfgpetclinic.model.*;
import guru.springframework.sfgpetclinic.services.OwnerService;
import guru.springframework.sfgpetclinic.services.PetTypeService;
import guru.springframework.sfgpetclinic.services.SpecialityService;
import guru.springframework.sfgpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

	private final OwnerService ownerService;
	private final VetService vetService;
	private final PetTypeService petTypeService;
	private final SpecialityService specialityService;

	public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialityService specialityService) {
		this.ownerService = ownerService;
		this.vetService = vetService;
		this.petTypeService = petTypeService;
		this.specialityService = specialityService;
	}

	@Override
	public void run(String... args) throws Exception {
		int count = petTypeService.findAll().size();

		if (count == 0)
			loadData();
	}

	private void loadData() {
		PetType dog = new PetType();
		dog.setName("Dog");

		PetType savedDogType = petTypeService.save(dog);

		PetType cat = new PetType();
		cat.setName("Cat");

		PetType savedCatType = petTypeService.save(cat);

		Speciality surgery = new Speciality();
		surgery.setDescription("surgery");
		Speciality savedSurgery = specialityService.save(surgery);

		Speciality dentistry = new Speciality();
		dentistry.setDescription("dentistry");
		Speciality savedDentistry = specialityService.save(dentistry);

		Speciality radiology = new Speciality();
		radiology.setDescription("radiology");
		Speciality savedRadiology = specialityService.save(radiology);

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
		vet.getSpecialities().add(savedRadiology);

		vetService.save(vet);

		Vet vet1 = new Vet();
		vet1.setFirstName("Another");
		vet1.setLastName("Doctor");
		vet1.getSpecialities().add(savedSurgery);

		vetService.save(vet1);

		System.out.println("Loaded vets...");
	}
}
