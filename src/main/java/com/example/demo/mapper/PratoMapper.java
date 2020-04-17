package com.example.demo.mapper;

import com.example.demo.dto.EditarPratoDTO;
import com.example.demo.model.Prato;

public class PratoMapper {

	
	public static Prato mapper(EditarPratoDTO dto, Prato prato) {
		if(!dto.getNome().equals(null)) {
			prato.setNome(dto.getNome());
		}
		if(dto.getPreco().equals(null) ) {
			prato.setPreço(dto.getPreco());
		}
		return prato;
	}
}
