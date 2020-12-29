package com.test.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.test.demo.domain.Card;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;


public interface CardMapper extends BaseMapper<Card> {

    @Update("UPDATE card SET codemark=#{codemark}, content=#{content}, card_type=#{cardType}, " +
            "version=#{version}, created_by=#{createdBy}, created_time=#{createdTime}, updated_by=#{updatedBy}, " +
            "updated_time=#{updatedTime} WHERE id=#{id} AND version=#{version} AND is_deleted=0")
    Boolean updateByIdTest(@Param("Card") Card card);
}
