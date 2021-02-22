package com.kike.colegio.controladores.Rest;



import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kike.colegio.dao.AlumnoDAO;
import com.kike.colegio.dao.ComboDAO;
import com.kike.colegio.dtos.AlumnoDTO;
import com.kike.colegio.entities.AlumnoEntity;
import com.kike.colegio.repositorios.AlumnoRepository;

@RestController
@RequestMapping("/v1")
public class AlumnoRestController {
	
	@Autowired
	private AlumnoRepository alumnoRepository;
	
	@Autowired
	private AlumnoDAO alumnoDAO;
	
	//Insertar alumnos
		
	@PostMapping(value = "/alumnos")
	public ResponseEntity <String> insertarAlumno(@RequestBody AlumnoEntity alumno){
		
		
		alumnoRepository.save(alumno);
		
		return new ResponseEntity<>("Inserción correcta!", HttpStatus.OK);	
		
	}
	
	//Obtener todos los alumnos
	
	@GetMapping(value = "/alumnos")
	public Iterable<AlumnoEntity> listarTodosAlumnos() {
		return alumnoRepository.findAll();
	}
	
	//Obtener alumnos por id
	
	@GetMapping(value = "/alumnos/{id}")
	public Optional<AlumnoEntity> buscarAlumnoPorId(@PathVariable("id") Integer id) {
		return alumnoRepository.findById(id);
	}
	
	
	//Obtener alumnos por id y nombre
	
	@GetMapping(value = "/alumnos", params = {"id", "nombre"})
	public List<AlumnoDTO> listarAlumnoPorIdNombre(@RequestParam("id") Integer id, @RequestParam("nombre") String nombre) {
		
		return alumnoDAO.obtenerAlumnosporIdyNombre(id, nombre);
	}
	
	
	//Actualizar alumno
	
	@PutMapping(value = "/alumnos")
	public ResponseEntity<String> actulizarAlumno(@RequestBody AlumnoEntity alumno){
		
		alumnoRepository.save(alumno);
		return new ResponseEntity<>("Actualizacion correcta!", HttpStatus.OK);
	}
	
	//BorrarAlumnos
	
	@DeleteMapping(value = "alumnos/{id}")
	public ResponseEntity<String> MostrarFormularioBorrarAlumnos(@PathVariable("id") Integer id){
		
		alumnoRepository.deleteById(id);
		return new ResponseEntity<>("Borrado correctamente!", HttpStatus.OK);
	}
	
	
	
}
