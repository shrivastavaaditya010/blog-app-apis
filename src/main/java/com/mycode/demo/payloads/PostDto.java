package com.mycode.demo.payloads;

import java.util.Date;
import com.mycode.demo.payloads.UserDto;
import com.mycode.demo.payloads.CatagoryDto;




import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PostDto {
	
	private String title;
	private String content;
	private String imageName;
	private Date addedDate;
	private CatagoryDto catagory;
	private UserDto user;
}
