package com.quote.domain.model;

import java.util.Date;

import lombok.Data;

@Data
public class Jewelry {
	private String cd;
    private String name;
    private Integer unit_price;
    private Date created_at;
    private String createt_user;
    private Date updated_at;
    private String updated_user;
    private Date deleted_at;
    private String deleted_user;
    private int version;

    public String commaOf1000() {
    	return String.format("%,d", unit_price);
    }
}
