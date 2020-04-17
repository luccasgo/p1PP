package com.example.demo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.EditarPratoDTO;
import com.example.demo.model.Prato;
import com.example.demo.service.PratoService;

@RestController
@RequestMapping("pratos")
public class PratoEndPoint {

	@Autowired
	private PratoService service;
	
	@PostMapping
	public ResponseEntity<Prato> cadastrarPrato(@RequestBody Prato prato){
		service.cadastrarPrato(prato);
		return new ResponseEntity<Prato>(HttpStatus.CREATED);
	}
	

	@PutMapping
	public ResponseEntity<EditarPratoDTO> editarPrat(@RequestBody EditarPratoDTO dto,@RequestParam Long id) throws NotFoundException{
		service.editarPratoPorId(dto, id);
		return new ResponseEntity<EditarPratoDTO>(HttpStatus.OK);
	}
	
	
	@GetMapping
	public ResponseEntity<List<Prato>> buscarTodos(){
		return new ResponseEntity<List<Prato>>(service.buscarTodos(), HttpStatus.OK);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<Prato> excluirPorId(@RequestParam Long id){
		service.excluirPrato(id);
		return new ResponseEntity<Prato>(HttpStatus.OK);
	}
	
	
}
