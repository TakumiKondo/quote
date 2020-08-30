package com.quote.domain.model;

import java.util.Date;

import lombok.Data;

//@Table(name="basic_charge")
//@Entity
@Data
public class BasicCharge {
    private Integer price;
    private String discription;
    private Date created_at;
    private String createt_user;
    private Date updated_at;
    private String updated_user;
    private Date deleted_at;
    private String deleted_user;

    public String commaOf1000() {
    	return String.format("%,d", price);
    }
}

