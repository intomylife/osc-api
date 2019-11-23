package com.zwc.base.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/*
  * @ClassName Visit
  * @Desc TODO  访问记录表
  * @Date 2019/11/1 5:28 PM
  * @Version 1.0
 */
@ApiModel("访问记录表")
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Visit extends Model<Visit> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键 ID
     */
    @ApiModelProperty(value = "主键 ID")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /**
     * sessionID
     */
    @ApiModelProperty(value = "sessionID")
    private String sessionId;
    /**
     * 添加时间
     */
    @ApiModelProperty(value = "添加时间")
    private Date createDatetime;
    /**
     * 更新时间
     */
    @ApiModelProperty(value = "更新时间")
    private Date updateDatetime;


    public static final String ID = "id";

    public static final String SESSION_ID = "session_id";

    public static final String CREATE_DATETIME = "create_datetime";

    public static final String UPDATE_DATETIME = "update_datetime";

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
