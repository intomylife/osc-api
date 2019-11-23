package com.zwc.base.dto.request.visit;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;


/*
  * @ClassName VisitRequestDTO
  * @Desc TODO  访问记录表 MongoDB 实体类
  * @Date 2019/11/1 5:23 PM
  * @Version 1.0
 */
@ApiModel("访问记录表 MongoDB 实体类")
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class VisitRequestMongoDBDTO implements Serializable {

    private static final long serialVersionUID = 1L;

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

}
