package com.springcloud.dao;

import com.springcloud.entity.Class1;
import java.util.List;

public interface Class1Mapper {
	/**
	 * This method was generated by MyBatis Generator. This method corresponds to
	 * the database table class1
	 *
	 * @mbg.generated Wed May 22 10:08:06 CST 2019
	 */
	int deleteByPrimaryKey(Integer class1Id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to
	 * the database table class1
	 *
	 * @mbg.generated Wed May 22 10:08:06 CST 2019
	 */
	int insert(Class1 record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to
	 * the database table class1
	 *
	 * @mbg.generated Wed May 22 10:08:06 CST 2019
	 */
	Class1 selectByPrimaryKey(Integer class1Id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to
	 * the database table class1
	 *
	 * @mbg.generated Wed May 22 10:08:06 CST 2019
	 */
	List<Class1> selectAll();

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to
	 * the database table class1
	 *
	 * @mbg.generated Wed May 22 10:08:06 CST 2019
	 */
	int updateByPrimaryKey(Class1 record);
}