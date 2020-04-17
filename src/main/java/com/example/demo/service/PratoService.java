package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.dao.PratoDAO;
import com.example.demo.dto.EditarPratoDTO;
import com.example.demo.mapper.PratoMapper;
import com.example.demo.model.Prato;

@Service
public class PratoService {

	@Autowired
	private PratoDAO dao;

	public Prato cadastrarPrato(Prato prato) {
		return dao.save(prato);
	}

	public Prato editarPratoPorId(EditarPratoDTO dto, Long id) throws NotFoundException {
		Prato prato = dao.findById(id).orElseThrow(() -> new NotFoundException());
		Prato pratoTemp = PratoMapper.mapper(dto, prato);
		return dao.save(pratoTemp);
	}

	public List<Prato> buscarTodos() {
		return dao.findAll();
	}

	public void excluirPrato(Long id) {
		dao.deleteById(id);
	}

	
}
