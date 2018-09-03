package com.adoph.test.spring;

import com.adoph.framework.util.BeanUtils;
import com.adoph.framework.util.SysUtils;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * TODO
 *
 * @author Adoph
 * @version v1.0
 * @since 2018/9/3
 */
public class BeanUtilsTest {

    public static void main(String[] args) {
        Computer computer = new Computer();
        Map<String, Object> map = new HashMap<>();
        map.put("sex", 1);
        map.put("name", "abc");
        map.put("birthday", new Date());
        BeanUtils.copy(map, computer);
        System.out.println(computer.getBirthday());
        SysUtils.print(computer);
    }


}

class Computer {
    private Integer sex;
    private String name;
    private Date birthday;

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
