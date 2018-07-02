package com.adoph.test.generic;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * TODO
 *
 * @author Adoph
 * @version v1.0
 * @since 2018/6/29
 */
public class Test {
    public static void main(String[] args) {
        Test t = new Test();
//        Tool tool = t.get(Tool.class, "1");
//        Bar bar = t.get(Bar.class, "1");
        R<Bar> uri = t.exchangeForList("uri", Bar.class);
    }

    public <T> T get(Class<T> clazz, Serializable id) {
        return null;
    }

    public <T> R<T> exchangeForList(String uri, Class<T> clazz) {
        ParameterizedTypeReference<List<T>> type = new ParameterizedTypeReference<>();
        return post("url", "params", clazz);

    }

    public <T> R<T> post(String url, String params, Class<T> clazz) {
        return new R<>();
    }
}

//public <T> List<T> exchangeForList(String uri, Map<String,Object> param,Class<T> clazz, ParameterizedTypeReference type){
//        ParameterizedTypeReference<List<T>> type1 = new ParameterizedTypeReference<List<T>>(){};
//        String url = rootUrl + uri;
//        String p = JSONObject.toJSONString(param);
//        log.info("---->Url={},param={}",url,p);
//        HttpEntity httpEntity = new HttpEntity(p);
//        ResponseEntity<List<T>> result = getRestTemplate().exchange(url,HttpMethod.POST,httpEntity,type);
//        return result.getBody();
//        }

class ParameterizedTypeReference<T> {

}

class R<T> {
    private T data;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}

class Tool<T> {

}

class Bar {

}
