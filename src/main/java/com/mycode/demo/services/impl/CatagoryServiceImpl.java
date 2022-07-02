package com.mycode.demo.services.impl;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycode.demo.entities.Catagory;
import com.mycode.demo.exceptions.ResourceNotFoundException;
import com.mycode.demo.payloads.CatagoryDto;
import com.mycode.demo.repositories.CatagoryRepo;
import com.mycode.demo.services.CatagoryService;

@Service
public class CatagoryServiceImpl implements CatagoryService {

	@Autowired
	private CatagoryRepo catagoryRepo;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public CatagoryDto createCatagory(CatagoryDto catagoryDto) {
		Catagory cat = this.modelMapper.map(catagoryDto, Catagory.class);
		Catagory addedCat = this.catagoryRepo.save(cat);
		return this.modelMapper.map(addedCat, CatagoryDto.class);
	}

	@Override
	public CatagoryDto updateCatagory(CatagoryDto catagoryDto, Integer catagoryId) {

		Catagory cat = this.catagoryRepo.findById(catagoryId)
				.orElseThrow(() -> new ResourceNotFoundException("Catagory ", "Catagory Id", catagoryId));

		cat.setCatagoryTitle(catagoryDto.getCatagoryTitle());
		cat.setCatagoryDescription(catagoryDto.getCatagoryDescription());

		Catagory updatedcat = this.catagoryRepo.save(cat);

		return this.modelMapper.map(updatedcat, CatagoryDto.class);
	}

	@Override
	public void deleteCatagory(Integer catagoryId) {

		Catagory cat = this.catagoryRepo.findById(catagoryId)
				.orElseThrow(() -> new ResourceNotFoundException("Catagory ", "catagory id", catagoryId));
		this.catagoryRepo.delete(cat);
	}

	@Override
	public CatagoryDto getCatagory(Integer catagoryId) {
		Catagory cat = this.catagoryRepo.findById(catagoryId)
				.orElseThrow(() -> new ResourceNotFoundException("Catagory", "catagory id", catagoryId));

		return this.modelMapper.map(cat, CatagoryDto.class);
	}

	@Override
	public List<CatagoryDto> getCatagories() {

		List<Catagory> catagories = this.catagoryRepo.findAll();
		List<CatagoryDto> catDtos = catagories.stream().map((cat) -> this.modelMapper.map(cat, CatagoryDto.class))
				.collect(Collectors.toList());

		return catDtos;
	}

}