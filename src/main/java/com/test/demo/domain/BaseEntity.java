package com.test.demo.domain;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class BaseEntity implements Serializable {

    /**
     * 主键编号
     * @TableId(主键)：
     *   属性：value，type
     *   value(主键字段名):默认值""，类型string
     *   type(主键类型)：默认值 IdType.NONE ，类型Enum
     *         Auto：数据库自增
     *         Input：自行输入
     *         ID_Worker：分布式全局唯一ID 长整型类型
     *         UUID：32位UUID字符串
     *         NONE：无状态
     *         ID_WORKER_STR：分布式全局唯一ID 字符串类型
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 是否删除 1 表示删除，0 表示未删除。
     *  @TableLogic（表逻辑处理注解，逻辑删除）
     */
    @TableLogic
    private Integer isDeleted;

    /**
     * 乐观锁
     * @Version:可以在实体 bean 中使用@Version 注解,通过这种方式可添加对乐观锁定的支持
     *           一个类中只能有一个@Version注解,注意此属性 不能用 String  可取值 int Integer Long
     * @TableField
     *        属性：value      |    字段值（驼峰命名方式，该值可无）
     *              update     |    预处理 set 字段自定义注入
     *              condition  |    预处理 WHERE 实体条件自定义运算规则
     *              el         |    详看注释说明
     *              exist      |    是否为数据库表字段（ 默认 true 存在，false 不存在 ）
     *              strategy   |    字段验证 （ 默认 非 null 判断，查看 com.baomidou.mybatisplus.enums.FieldStrategy ）
     *              fill(常用) |    字段填充标记 （ FieldFill, 配合自动填充使用 ）
     *                         |    DEFAULT         | 默认不处理
     *                              INSERT          | 插入填充字段
     *                              UPDATE          | 更新填充字段
     *                              INSERT_UPDATE   | 插入和更新填充字段
     */
    @Version
    @TableField(fill = FieldFill.INSERT)
    private Integer version;

    /**
     * 创建人
     */
    @TableField(fill = FieldFill.INSERT)
    private String createdBy;

    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createdTime;

    /**
     * 更新人
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private String updatedBy;

    /**
     * 更新时间
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private LocalDateTime updatedTime;

}
