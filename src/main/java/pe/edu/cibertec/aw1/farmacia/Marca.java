package pe.edu.cibertec.aw1.farmacia;

import jakarta.persistence.Entity;
import jakarta.persistence.GenerationType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Marca {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
    Integer id;
	String nombre;
	String descripcion;
	String logo;

	Marca(Integer id, String nombre) {
		this.id = id;
		this.nombre = nombre;
	}

	Marca() {}

	public Integer getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	// var marca = new Marca("Pantene");
	// marca.nombre
	// marca.getNombre()

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


}
