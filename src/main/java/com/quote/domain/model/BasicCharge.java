package com.quote.domain.model;

import java.util.Date;

import lombok.Data;

@Data
public class BasicCharge {
    private Integer price;
    private String description;
    private Date created_at;
    private String createt_user;
    private Date updated_at;
    private String updated_user;
    private Date deleted_at;
    private String deleted_user;
    private int version;

    public String commaOf1000() {
    	return String.format("%,d", price);
    }
}

