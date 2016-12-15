package com.jiahua.db.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by jhhuang on 2016/12/14.
 * QQ:781913268
 * Description：User
 */
@Entity
public class User
{
    @Id
    private String id;
    private int age;
    private String name;
    @Generated(hash = 699262129)
    public User(String id, int age, String name) {
        this.id = id;
        this.age = age;
        this.name = name;
    }
    @Generated(hash = 586692638)
    public User() {
    }
    public String getId() {
        return this.id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public int getAge() {
        return this.age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }

}