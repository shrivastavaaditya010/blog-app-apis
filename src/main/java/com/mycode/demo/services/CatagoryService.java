package com.mycode.demo.services;

import java.util.List;

import com.mycode.demo.payloads.CatagoryDto;

public interface CatagoryService {

	// create
	CatagoryDto createCatagory(CatagoryDto catagoryDto);

	// update
	CatagoryDto updateCatagory(CatagoryDto catagoryDto, Integer catagoryId);

	// delete
	void deleteCatagory(Integer catagoryId);

	// get
	CatagoryDto getCatagory(Integer catagoryId);

	// get All

	List<CatagoryDto> getCatagories();

}