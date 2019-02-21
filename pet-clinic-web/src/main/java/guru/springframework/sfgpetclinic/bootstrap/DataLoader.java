package guru.springframework.sfgpetclinic.bootstrap;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.model.Vet;
import guru.springframework.sfgpetclinic.services.OwnerService;
import guru.springframework.sfgpetclinic.services.VetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

	private final OwnerService ownerService;
	private final VetService vetService;

	@Autowired
	public DataLoader(OwnerService ownerService, VetService vetService) {
		this.ownerService = ownerService;
		this.vetService = vetService;
	}

	@Override
	public void run(String... args) throws Exception {
		Owner owner = new Owner();
		owner.setFirstName("Michael");
		owner.setLastName("Schumacher");

		ownerService.save(owner);

		Owner owner1 = new Owner();
		owner1.setFirstName("Maria");
		owner1.setLastName("Antonina");

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
