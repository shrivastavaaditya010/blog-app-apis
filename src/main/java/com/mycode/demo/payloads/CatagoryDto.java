package com.mycode.demo.payloads;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CatagoryDto {

	private Integer catagoryId;

	@NotBlank
	@Size(min=4,message = "Min size of category title is 4")
	private String catagoryTitle;
	
	@NotBlank
	@Size(min=10, message = "min size of cateogry desc is 10")
	private String catagoryDescription;

}
