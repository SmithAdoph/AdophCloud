package com.adoph.test;

import com.adoph.framework.web.response.BaseResponse;
import com.adoph.test.vo.UserVo;
import com.adoph.framework.util.SysUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.junit.Test;

import java.io.*;
import java.net.URL;
import java.util.Map;

/**
 * 序列化测试
 *
 * @author Adoph
 * @version v1.0
 * @since 2018/6/12
 */
public class SerializeTest {

    @Test
    public void testJSON() {
        UserVo vo = new UserVo();
        vo.setId(1L);
////        String s = JSON.toJSONString(vo, SerializerFeature.WriteNullStringAsEmpty, SerializerFeature.WriteNullNumberAsZero);
////        System.out.println(s);
//        String t = "{\"name\":112}";
//        System.out.println(t);
//        BaseResponse response = new BaseResponse<>();
//        response.setMsg("aa");
//        response.setData(vo);
//        response.setData(JSON.toJSONString(vo));
//        System.out.println(JSON.toJSONString(response));

        String str1 = "{\"data\":\"{\"id\":1}\",\"msg\":\"aa\",\"status\":\"success\",\"success\":true}";
        Map map = JSON.parseObject(str1, Map.class);
        Object data = map.get("data");
        System.out.println(data);
        System.out.println(JSON.toJSONString(data));
        UserVo userVo = JSON.parseObject(JSON.toJSONString(data), UserVo.class);
        System.out.println(JSON.toJSONString(userVo));
    }

    @Test
    public void testWrite() {
        UserVo u = new UserVo();
        u.setId(1L);
        u.setSex("男");
        u.setUserName("神马科技");
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(
                    new FileOutputStream(UserVo.class.getResource("").getPath() + "/test"));
            oos.writeObject(u);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (oos != null) {
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void testRead() {
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream(UserVo.class.getResource("").getPath() + "/test"));
            try {
                UserVo o = (UserVo) ois.readObject();
                SysUtils.print(o);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (ois != null) {
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void testFilePath() {
        //方式一
        System.out.println("1:" + System.getProperty("user.dir"));
        //方式二
        File directory = new File("");//设定为当前文件夹
        try {
            System.out.println("2:" + directory.getCanonicalPath());//获取标准的路径
            System.out.println("3:" + directory.getAbsolutePath());//获取绝对路径
        } catch (Exception e) {
            e.printStackTrace();
        }
        //方式三
        System.out.println("4:" + SerializeTest.class.getResource("/"));
        System.out.println("5:" + SerializeTest.class.getResource(""));
        //方式4
        System.out.println("6:" + SerializeTest.class.getClassLoader().getResource(""));
        System.out.println("7:" + SerializeTest.class.getClassLoader().getResource("Vehicle.java"));
    }
}
