package com.mycode.demo.services;

import java.util.List;

import com.mycode.demo.payloads.CatagoryDto;


public interface CatagoryService {
	
	//create
	public CatagoryDto createCatagory(CatagoryDto catagoryDto);
	
	//update
	public CatagoryDto updateCatagory(CatagoryDto catagoryDto, Integer CatagoryId);
	
	// Delete
	public void deleteCatagory(Integer CatagoryId);
	
	//get
	public CatagoryDto getCatagory(Integer CatagoryId);
	
	//getAll
	public List<CatagoryDto> getCatagories();
	
}
