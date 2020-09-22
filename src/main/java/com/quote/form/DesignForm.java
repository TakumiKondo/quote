package com.quote.form;


import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

import lombok.Data;

@Data
public class DesignForm {

	@NotBlank
	@Length(min=1, max=100)
	@Pattern(regexp = "^[a-zA-Z0-9]*$")
	private String cd;

	@NotBlank
	@Length(min=1, max=100)
	private String name;

	@NotNull
	@Min(0)
	@Max(9999999)
	private Integer unitPrice;

	@NotNull
	private int version;
}
