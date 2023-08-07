package pe.edu.cibertec.aw1.farmacia.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import pe.edu.cibertec.aw1.farmacia.entities.Marca;

public interface MarcaRepository extends CrudRepository<Marca, Integer> {
	List<Marca> findAll();

	// select m from Marca m where nombre = ?
	List<Marca> findByNombre(String nombre);

}