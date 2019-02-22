package guru.springframework.sfgpetclinic.services;

import java.util.Set;

public interface CrudService<T, R> {
	Set<T> findAll();

	T findById(R id);

	T save(T object);

	void delete(T object);

	void deleteById(R id);
}
