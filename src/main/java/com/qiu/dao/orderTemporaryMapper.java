package com.qiu.dao;

import com.qiu.pojo.orderTemporary;
import com.qiu.pojo.orderTemporaryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface orderTemporaryMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ordertemporary
     *
     * @mbggenerated
     */
    int countByExample(orderTemporaryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ordertemporary
     *
     * @mbggenerated
     */
    int deleteByExample(orderTemporaryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ordertemporary
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ordertemporary
     *
     * @mbggenerated
     */
    int insert(orderTemporary record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ordertemporary
     *
     * @mbggenerated
     */
    int insertSelective(orderTemporary record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ordertemporary
     *
     * @mbggenerated
     */
    List<orderTemporary> selectByExample(orderTemporaryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ordertemporary
     *
     * @mbggenerated
     */
    orderTemporary selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ordertemporary
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") orderTemporary record, @Param("example") orderTemporaryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ordertemporary
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") orderTemporary record, @Param("example") orderTemporaryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ordertemporary
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(orderTemporary record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ordertemporary
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(orderTemporary record);
}