package com.test.demo.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class Card extends BaseEntity{

    /*
        lombok插件的安装和使用：
        1：File-->Settings-->Plugins-->Browse repositories...-->搜索lombok-->Install（需重启idea）
        @EqualsAndHashCode 此注解会生成equals(Object other) 和 hashCode()方法。
        @Data注解是lombok.jar包下的注解，该注解通常用在实体bean上，不需要写出set和get方法，但是具备实体bean所具备的方法，简化编程提高变成速度。注意：项目中一定要引入lombok.jar!!
    */

    private static final long serialVersionUID = 1L;

    /**
     * 卡编号
     */
    private String codeMark;

    /**
     * 卡内容
     */
    private String content;

    /**
     * 卡券类型
     */
    private Integer cardType;
}