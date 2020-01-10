package com.zwc.base.service;

import com.alibaba.fastjson.JSON;
import com.zwc.base.domain.Visit;
import com.zwc.base.dto.request.visit.VisitRequestMongoDBDTO;
import com.zwc.base.mapper.VisitMapper;

import com.zwc.core.constants.KafkaConstants;
import com.zwc.core.constants.RedisConstants;
import com.zwc.core.utils.RedisClient;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;

/*
  * @ClassName VisitService
  * @Desc TODO  访问记录表 - 服务实现类
  * @Date 2019/11/1 5:29 PM
  * @Version 1.0
 */
@Service
public class VisitService extends ServiceImpl<VisitMapper, Visit>{

    @Resource
    private VisitMapper visitMapper;

    @Autowired
    private RedisClient redisClient;
    @Autowired
    private KafkaTemplate kafkaTemplate;

    /*
      * @ClassName VisitService
      * @Desc TODO  记录用户访问信息
      * @Date 2019/11/1 5:34 PM
      * @Version 1.0
     */
    @Transactional
    public String toVisit(String sessionId) {
        // 返回结果
        String result = "success";

        // 插入的对象
        Visit visit = new Visit();
        // 设置 sessionID
        visit.setSessionId(sessionId);
        // 创建时间 / 更改时间
        visit.setCreateDatetime(new Date());
        visit.setUpdateDatetime(new Date());

        // 插入到 MySQL
        boolean save = super.save(visit);
        // 是否插入成功
        if(save) {
            // 存入 redis 中
            redisClient.set(RedisConstants.TO_VISIT, sessionId);

            // 转换类型
            VisitRequestMongoDBDTO visitRequestMongoDBDTO = new VisitRequestMongoDBDTO();
            // 复值
            BeanUtils.copyProperties(visit, visitRequestMongoDBDTO);
            // 给 log-service 发送消息
            kafkaTemplate.send(KafkaConstants.TO_VISIT, JSON.toJSONString(visitRequestMongoDBDTO));
        }else {
            // 返回失败
            result = "fail";
        }

        // 返回
        return result;
    }

}