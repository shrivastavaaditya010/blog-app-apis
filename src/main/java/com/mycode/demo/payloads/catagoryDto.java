package com.mycode.demo.payloads;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class catagoryDto {
	private Integer catagoryId;
	private String catagoryTitle;
	private String catagoryDescription;
}
