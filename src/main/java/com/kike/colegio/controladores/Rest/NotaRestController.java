package com.kike.colegio.controladores.Rest;




import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.kike.colegio.dao.NotaDAO;
import com.kike.colegio.entities.AsignaturaEntity;
import com.kike.colegio.entities.NotaEntity;
import com.kike.colegio.repositorios.NotaRepository;

@RestController
@RequestMapping("/v1")
public class NotaRestController {
	
	@Autowired
	private NotaRepository notaRepository;
	
	@Autowired
	private NotaDAO notaDAO;
	
	
	//Insertar notas
	
		@PostMapping(value = "/notas")
		public ResponseEntity <String> insertarAlumno(@RequestBody NotaEntity nota){
			
			
			notaRepository.save(nota);
			
			return new ResponseEntity<>("Inserción correcta!", HttpStatus.OK);			
		}
		
		
	//Obtener todos los notas
		
		@GetMapping(value = "/notas")
		public Iterable<NotaEntity> listarTodasNotas() {
			return notaRepository.findAll();
		}

	//Obtener notas por id
		
		@GetMapping(value = "/notas/{id}")
		public Optional<NotaEntity> buscarNotaPorId(@PathVariable("id") Integer id) {
			return notaRepository.findById(id);
		}
		
	
	//Obtener notas por idAlumno, nombreAlumno, asignatura, nota y fecha
		
//		@GetMapping(value = "/asignaturas"), params = {"idAlumno", "nombreAlumno", "asignatura", "nota", "fecha"})
//		public Optional<NotaEntity> buscarNotaPorIdNombreAsignaturaNotaFecha(@RequestParam("idAlumno") Integer idAlumno, @RequestParam("nombreAlumno") String nombreAlumno)
		
		
		
	//Actualizar asignatura
		
		@PutMapping(value = "/notas")
		public ResponseEntity<String> actulizarNota(@RequestBody NotaEntity nota){
			
			notaRepository.save(nota);
			return new ResponseEntity<>("Actualizacion correcta!", HttpStatus.OK);
		}
		
		//BorrarAlumnos
		
		@DeleteMapping(value = "notas/{id}")
		public ResponseEntity<String> MostrarFormularioBorrarAlumnos(@PathVariable("id") Integer id){
			
			notaRepository.deleteById(id);
			return new ResponseEntity<>("Borrado correctamente!", HttpStatus.OK);
		}
}
