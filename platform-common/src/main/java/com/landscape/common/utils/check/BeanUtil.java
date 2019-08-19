package com.landscape.common.utils.check;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @author eddie
 * @createTime 2019-03-18
 * @description
 */
public class BeanUtil {

    /**
     * Bean对象是否包含空Field
     *
     * @param obj
     * @return
     */
    public static boolean hasNull(Object obj) {
        for (Field f : obj.getClass().getDeclaredFields()) {
            f.setAccessible(true);
            try {
                if (f.get(obj) == null) {
                    return true;
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    /**
     * 哪个Field值为null
     *
     * @param obj
     * @return
     */
    private static List<String> whereIsNull(Object obj) {
        List<String> fields = new ArrayList<>();
        for (Field f : obj.getClass().getDeclaredFields()) {
            f.setAccessible(true);
            try {
                Object o = f.get(obj);
                if (o == null) {
                    String fieldName = f.getName();
                    fields.add(fieldName);
                }
                if (o instanceof String) {
                    if (StringUtils.isBlank((String) o)) {
                        String fieldName = f.getName();
                        fields.add(fieldName);
                    }
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return fields;
    }

    /**
     * 哪个Field值为null
     *
     * @param obj
     * @param notNullField
     * @return
     */
    public static List<String> whereJsonIsNull(JSONObject obj, List<String> notNullField) {
        Set<String> keys = obj.keySet();
        notNullField.removeAll(keys);
        return notNullField;
    }

    /**
     * 空值中是否包含必填项
     *
     * @param object       需要被校验的实体
     * @param notNullField 不能为空的字段名
     * @return
     */
    public static List<String> notNullField(Object object, List<String> notNullField) {
        List<String> nullFields = whereIsNull(object);
        nullFields.retainAll(notNullField);
        return nullFields;
    }

}
