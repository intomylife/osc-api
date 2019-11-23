package com.zwc.log.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.zwc.base.dto.request.visit.VisitRequestMongoDBDTO;
import com.zwc.core.constants.MongoDBConstants;
import com.zwc.core.utils.MongoDBClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName VisitMongoDBService
 * @Desc TODO   访问记录表 - 与 MongoDB 交互
 * @Date 2019/11/2 4:59 PM
 * @Version 1.0
 */
@Service
public class VisitMongoDBService {

    @Autowired
    private MongoDBClient mongoDBClient;

    /*
      * @ClassName VisitMongoDBService
      * @Desc TODO  存入访问记录
      * @Date 2019/11/2 5:11 PM
      * @Version 1.0
     */
    public void insertVisitLog(String visitJson) {
        // 创建集合
        Integer createResult = mongoDBClient.createCollection(MongoDBConstants.TO_VISIT_LOG);
        // 是否创建成功
        if(createResult != -1) {
            // 创建成功或已存在，插入数据
            mongoDBClient.addObject(JSON.parseObject(visitJson, new TypeReference<VisitRequestMongoDBDTO>(){}), MongoDBConstants.TO_VISIT_LOG);
        }
    }

}
