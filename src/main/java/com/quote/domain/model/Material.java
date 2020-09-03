package com.quote.domain.model;

import java.util.Date;

import lombok.Data;

@Data
public class Material {
	private String cd;
	private String name;
	private Integer unit_price;
    private Date created_at;
    private String createt_user;
    private Date updated_at;
    private String updated_user;
    private Date deleted_at;
    private String deleted_user;
}
