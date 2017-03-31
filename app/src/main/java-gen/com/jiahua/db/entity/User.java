package com.jiahua.db.entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.NotNull;

import java.util.Date;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by jhhuang on 2017/3/9
 * QQ:781913268
 * Description：xxx
 */
@Entity
public class User
{
    @Id(autoincrement = true)
    private Long id;

    private Integer version;

    private String remark;

    private String nickName;

    private String realName;

    private Boolean sex;

    private String avatar;
    @NotNull
    private String mobile;

    private String email;

    private String password;

    private String identity;

    private Date birthday;

    private Integer creditScore;

    private Integer operationPersion;

    private Integer status;

    private Integer companyId;

    private String companyName;

    private String identityUrl;

    private String cardWork;

    private String token;

    private Integer province;

    private Integer city;

    private Integer area;

    @Generated(hash = 337475688)
    public User(Long id, Integer version, String remark, String nickName,
            String realName, Boolean sex, String avatar, @NotNull String mobile,
            String email, String password, String identity, Date birthday,
            Integer creditScore, Integer operationPersion, Integer status,
            Integer companyId, String companyName, String identityUrl,
            String cardWork, String token, Integer province, Integer city,
            Integer area) {
        this.id = id;
        this.version = version;
        this.remark = remark;
        this.nickName = nickName;
        this.realName = realName;
        this.sex = sex;
        this.avatar = avatar;
        this.mobile = mobile;
        this.email = email;
        this.password = password;
        this.identity = identity;
        this.birthday = birthday;
        this.creditScore = creditScore;
        this.operationPersion = operationPersion;
        this.status = status;
        this.companyId = companyId;
        this.companyName = companyName;
        this.identityUrl = identityUrl;
        this.cardWork = cardWork;
        this.token = token;
        this.province = province;
        this.city = city;
        this.area = area;
    }

    @Generated(hash = 586692638)
    public User() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getVersion() {
        return this.version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getRemark() {
        return this.remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getNickName() {
        return this.nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getRealName() {
        return this.realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public Boolean getSex() {
        return this.sex;
    }

    public void setSex(Boolean sex) {
        this.sex = sex;
    }

    public String getAvatar() {
        return this.avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getMobile() {
        return this.mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getIdentity() {
        return this.identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    public Date getBirthday() {
        return this.birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Integer getCreditScore() {
        return this.creditScore;
    }

    public void setCreditScore(Integer creditScore) {
        this.creditScore = creditScore;
    }

    public Integer getOperationPersion() {
        return this.operationPersion;
    }

    public void setOperationPersion(Integer operationPersion) {
        this.operationPersion = operationPersion;
    }

    public Integer getStatus() {
        return this.status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getCompanyId() {
        return this.companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return this.companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getIdentityUrl() {
        return this.identityUrl;
    }

    public void setIdentityUrl(String identityUrl) {
        this.identityUrl = identityUrl;
    }

    public String getCardWork() {
        return this.cardWork;
    }

    public void setCardWork(String cardWork) {
        this.cardWork = cardWork;
    }

    public String getToken() {
        return this.token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Integer getProvince() {
        return this.province;
    }

    public void setProvince(Integer province) {
        this.province = province;
    }

    public Integer getCity() {
        return this.city;
    }

    public void setCity(Integer city) {
        this.city = city;
    }

    public Integer getArea() {
        return this.area;
    }

    public void setArea(Integer area) {
        this.area = area;
    }


}
