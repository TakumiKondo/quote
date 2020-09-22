package com.quote.domain.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.quote.domain.model.Jewelry;

@Mapper
public interface JewelryMapper {

	public List<Jewelry> getList();

//	@Insert("INSERT INTO designs VALUES("
//			+ "#{cd}, #{name}, #{unit_price}"
//			+ ", #{created_at}, #{created_user}"
//			+ ", #{updated_at}, #{created_user}"
//			+ ", null, null, 1)")
//	public void insert(Design design);
//
//	@Select("SELECT * FROM designs WHERE cd = #{cd} AND deleted_at IS NULL")
//	public Design selectOne(String cd);
//
//	@Update("UPDATE designs SET "
//			+ "name = #{name}, unit_price = #{unit_price}"
//			+ ", updated_at = #{updated_at}, updated_user = #{updated_user} "
//			+ ", version = #{version}+1 "
//			+ "WHERE cd = #{cd} AND version = #{version}")
//	public int update(Design design);
//
//	@Select("SELECT count(cd) FROM designs WHERE cd = #{cd} AND version = #{version}")
//	public int isUpdate(Design design);
//
//
//	@Delete("UPDATE designs "
//			+ "SET deleted_at = #{deleted_at}, deleted_user = #{deleted_user} "
//			+ "WHERE cd = #{cd} ")
//	public void delete(Design design);
//
//
//	@Select("SELECT COUNT(cd) FROM designs WHERE cd = #{cd}")
//	public int countRow(String cd);
}
