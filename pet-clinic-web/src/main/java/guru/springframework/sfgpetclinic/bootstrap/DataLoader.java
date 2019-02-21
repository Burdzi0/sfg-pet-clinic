package guru.springframework.sfgpetclinic.bootstrap;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.model.Vet;
import guru.springframework.sfgpetclinic.services.OwnerService;
import guru.springframework.sfgpetclinic.services.PetService;
import guru.springframework.sfgpetclinic.services.VetService;
import guru.springframework.sfgpetclinic.services.map.OwnerServiceMap;
import guru.springframework.sfgpetclinic.services.map.PetServiceMap;
import guru.springframework.sfgpetclinic.services.map.VetServiceMap;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

	private final OwnerService ownerService;
	private final VetService vetService;

	public DataLoader() {
		this.ownerService = new OwnerServiceMap();
		this.vetService = new VetServiceMap();
	}

	@Override
	public void run(String... args) throws Exception {
		Owner owner = new Owner();
		owner.setId(1L);
		owner.setFirstName("Michael");
		owner.setLastName("Schumacher");

		ownerService.save(owner);

		Owner owner1 = new Owner();
		owner1.setId(2L);
		owner1.setFirstName("Maria");
		owner1.setLastName("Antonina");

		ownerService.save(owner1);

		System.out.println("Loaded owners...");

		Vet vet = new Vet();
		vet.setId(1L);
		vet.setFirstName("Dr");
		vet.setLastName("Doolittle");

		vetService.save(vet);

		System.out.println("Loaded vets...");
	}
}
