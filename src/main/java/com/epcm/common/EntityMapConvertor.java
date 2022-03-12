package com.epcm.common;

import com.epcm.enunn.StatusEnum;
import com.epcm.exception.StatusException;
import org.apache.commons.beanutils.BeanUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EntityMapConvertor {
    public static Map<String, Object> entity2Map (Object entity) {
        if (entity == null) {
            return new HashMap<>();
        }
        try {
            Map<String, Object> map = BeanUtils.describe(entity);
            // 移除key=class
            map.remove("class");
            return map;
        } catch (Exception e) {
            throw new StatusException(StatusEnum.ENTITY_CONVERT_FAILED);
        }
    }

    public static <T> List<Map<String,Object>> entityList2MapList (List<T> entities) {
        List<Map<String,Object>> mapList = new ArrayList<>();
        for(T entity : entities){
            mapList.add(entity2Map(entity));
        }
        return mapList;
    }
}