package com.cloud.study.mvc;

import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.serializer.JSONSerializer;
import com.alibaba.fastjson.serializer.ObjectSerializer;
import com.alibaba.fastjson.serializer.SerializerFeature;

import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.Date;

/**
 * Created by yuanyouz on 2017/6/25.
 */
public class FastJsonData implements Serializable {

    @JSONField
    private String name;
    @JSONField(format = "yyyy年MM月dd日")
    private Date birthday;
    @JSONField(serializeUsing = AgeSerializer.class)
    private int age;
    @JSONField(serialize = false)
    private int gender;
    //    @JSONField(serialzeFeatures = {SerializerFeature.WriteMapNullValue})
    @JSONField(serialzeFeatures = {SerializerFeature.WriteNullStringAsEmpty})
    private String description;

    public FastJsonData(String name, Date birthday, int age, int gender, String description) {
        this.name = name;
        this.birthday = birthday;
        this.age = age;
        this.gender = gender;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public static class AgeSerializer implements ObjectSerializer {

        @Override
        public void write(JSONSerializer serializer, Object object,
                          Object fieldName, Type fieldType, int features) throws IOException {
            Integer value = (Integer) object;
            String text = value + "岁";
            serializer.write(text);
        }
    }
}
