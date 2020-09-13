package com.quote.domain.repository;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

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

	@Select("SELECT * FROM designs WHERE cd = #{cd} AND deleted_at IS NULL")
	public Design selectOne(String cd);

	@Update("UPDATE designs SET "
			+ "name = #{name}, unit_price = #{unit_price}"
			+ ", updated_at = #{updated_at}, updated_user = #{updated_user} "
			+ "WHERE cd = #{cd}")
	public void update(Design design);

	@Select("SELECT count(cd) FROM designs WHERE cd = #{cd} AND updated_at = #{updated_at}")
	public int isUpdate(Design design);
}
