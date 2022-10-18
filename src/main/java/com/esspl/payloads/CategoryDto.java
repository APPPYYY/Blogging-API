package com.esspl.payloads;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CategoryDto {

	private Integer categoryId;
	
	@NotEmpty
	@Size(min = 4,message = "Title should have min 4 charecters !")
	private String categoryTitle;
	
	@NotEmpty
	@Size(min = 10,max = 200,message = "Description should have min 10 charecters and max 200 !")
	private String categoryDescription;
}
