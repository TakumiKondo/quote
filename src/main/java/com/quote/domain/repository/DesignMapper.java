package com.quote.domain.repository;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.quote.domain.model.Design;

@Mapper
public interface DesignMapper {

	@Select("SELECT * FROM designs WHERE deleted_at IS NULL")
	public List<Design> getList();

	@Insert("INSERT INTO designs VALUES("
			+ "#{cd}, #{name}, #{unit_price}"
			+ ", #{created_at}, #{created_user}"
			+ ", #{updated_at}, #{created_user}"
			+ ", null, null)")
	public void insert(Design design);
}
