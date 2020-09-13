package com.quote.form;


import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

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

	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date updatedAt;

	public String updatedAtToString() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(getUpdatedAt());
	}
}
