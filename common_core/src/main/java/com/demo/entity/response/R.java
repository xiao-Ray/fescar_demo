package com.demo.entity.response;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class R extends HashMap<String,Object> implements Serializable {

    private static final long serialVersionUID = 1L;

    public R() {
        put("code", 200);
    }

    public static R error() {
        return error(500, "未知异常，请联系管理员");
    }

    public static R error(String msg) {
        return error(500, msg);
    }

    public static R error(String msg, Logger logger) {
        logger.error(msg);
        return error(500, msg);
    }

    public static R error(int code, String msg) {
        R r = new R();
        r.put("code", code);
        r.put("msg", msg);
        return r;
    }

    public static R error(int code, String msg, Object data) {
        R r = new R();
        r.put("code", code);
        r.put("msg", msg);
        r.put("data", data);
        return r;
    }

    public static R error(String code, String msg) {
        R r = new R();
        r.put("code", code);
        r.put("msg", msg);
        return r;
    }

    public static R ok(String msg) {
        R r = new R();
        r.put("msg", msg);
        return r;
    }

    public static R ok(String msg, Object data) {
        R r = new R();
        r.put("msg", msg);
        r.put("data", data);
        return r;
    }

    public static R ok(Map<String, Object> map) {
        R r = new R();
        r.putAll(map);
        return r;
    }

    public static R ok() {
        return new R();
    }

    public R put(String key, Object value) {
        super.put(key, value);
        return this;
    }

    public static <T> T getData(R r, Class<T> clazz) {

        if (null == r || !r.containsKey("data") || null == r.get("data")) {
            return null;
        }

        Object data = r.get("data");
        ObjectMapper objectMapper = new ObjectMapper();
        T result = objectMapper.convertValue(data, clazz);

//		LinkedHashMap linkedHashMap = (LinkedHashMap) r.get("data");
//		T result = JSONObject.parseObject(JSON.toJSONString(linkedHashMap), clazz);

        return result;
    }

    public static <T> List<T> getListData(R r, Class<T> clazz) {

        if (null == r || !r.containsKey("data") || null == r.get("data")) {
            return null;
        }

        Object data = r.get("data");
        ObjectMapper objectMapper = new ObjectMapper();
        List list = objectMapper.convertValue(data, new TypeReference<List<Object>>(){});
        if (list != null && list.size() >0) {
            List<T> tList = new ArrayList<>();
            for (Object o: list) {
                T result = objectMapper.convertValue(o, clazz);
                tList.add(result);
            }
            return tList;
        }
        return new ArrayList<>();
    }
}
