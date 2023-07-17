package pe.edu.cibertec.aw1.farmacia;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface MarcaRepository extends CrudRepository<Marca, Integer> {
	List<Marca> findAll();

	// select m from Marca m where nombre = ?
	List<Marca> findByNombre(String nombre);

}