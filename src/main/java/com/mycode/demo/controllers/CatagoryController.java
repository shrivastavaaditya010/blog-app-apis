package com.mycode.demo.controllers;

import java.util.List;

import javax.validation.Valid;

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

import com.mycode.demo.payloads.ApiResponse;
import com.mycode.demo.payloads.CatagoryDto;
import com.mycode.demo.services.CatagoryService;



@RestController
@RequestMapping("/api/catagories")
public class CatagoryController {

	@Autowired
	private CatagoryService catagoryService;
	

	// create

	@PostMapping("/")
	public ResponseEntity<CatagoryDto> createCatagory(@Valid @RequestBody CatagoryDto cateogDto) {
		CatagoryDto createCatagory = this.catagoryService.createCatagory(cateogDto);
		return new ResponseEntity<CatagoryDto>(createCatagory, HttpStatus.CREATED);
	}

	// update

	@PutMapping("/{catId}")
	public ResponseEntity<CatagoryDto> updateCategory(@Valid @RequestBody CatagoryDto catagoryDto,
			@PathVariable Integer catId) {
		CatagoryDto updatedCatagory = this.catagoryService.updateCatagory(catagoryDto, catId);
		return new ResponseEntity<CatagoryDto>(updatedCatagory, HttpStatus.OK);
	}

	// delete

	@DeleteMapping("/{catId}")
	public ResponseEntity<ApiResponse> deleteCategory(@PathVariable Integer catId) {
		this.catagoryService.deleteCatagory(catId);
		return new ResponseEntity<ApiResponse>(new ApiResponse("category is deleted successfully !!", true),
				HttpStatus.OK);
	}
	// get

	@GetMapping("/{catId}")
	public ResponseEntity<CatagoryDto> getCategory(@PathVariable Integer catId) {

		CatagoryDto catagoryDto = this.catagoryService.getCatagory(catId);

		return new ResponseEntity<CatagoryDto>(catagoryDto, HttpStatus.OK);

	}

	// get all
	@GetMapping("/")
	public ResponseEntity<List<CatagoryDto>> getCatagories() {

		List<CatagoryDto> catagories = this.catagoryService.getCatagories();
		return ResponseEntity.ok(catagories);
	}

}