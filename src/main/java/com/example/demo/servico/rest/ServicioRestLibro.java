package com.example.demo.servico.rest;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.DaoLibro;
import com.example.demo.dto.DtoLibro;


@RestController
@RequestMapping("libro")
public class ServicioRestLibro {
	
	@Autowired
	private DaoLibro dao;
	
	@RequestMapping(value = "all", method = RequestMethod.GET)
	public ResponseEntity<List<DtoLibro>> getAll() throws Exception
	{
		List<DtoLibro> lista = dao.findAll();
		return ResponseEntity.ok(lista);
	}
	
	
	@DeleteMapping(value = "{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws Exception
	{
		dao.deleteById(id);
		return ResponseEntity.ok(null);
	}
	
	@PostMapping
	public ResponseEntity<DtoLibro> create(@RequestBody DtoLibro dto) throws Exception
	{
		DtoLibro newDto = dao.save(dto);
		return ResponseEntity.ok(newDto);
	}
	
	@PutMapping
	public ResponseEntity<DtoLibro> update(@RequestBody DtoLibro dto) throws Exception
	{
		try
		{
		
		DtoLibro newDto = dao.save(dto);
		return ResponseEntity.ok(newDto);
		}
		catch (Exception e)
		{
			throw e;
		}
	}


}
