package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.dto.DtoLibro;
public interface DaoLibro extends JpaRepository<DtoLibro, Integer> {

}
