package com.cn.wanxi.entity.user;

import java.util.Date;

/**
 * @author LeesonWong
 * @date 2019/11/19 19:03
 */
public class UserEntity {
    private Integer id;
    private String username;
    private String password;
    private String phone;
    private String email;
    private Date created;
    private Date updated;
    private String sourceType;
    private String nickName;
    private String name;
    private String status;
    private String headPic;
    private String qq;
    private String isMobileCheck;
    private String isMailCheck;
    private String sex;
    private Integer userLevel;
    private Integer points;
    private Integer experienceValue;
    private Date birthday;
    private Date lastLoginTime;

    public UserEntity() {
    }

    public UserEntity(Integer id, String username, String password, String phone, String email, Date created, Date updated, String sourceType, String nickName, String name, String status, String headPic, String qq, String isMobileCheck, String isMailCheck, String sex, Integer userLevel, Integer points, Integer experienceValue, Date birthday, Date lastLoginTime) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.phone = phone;
        this.email = email;
        this.created = created;
        this.updated = updated;
        this.sourceType = sourceType;
        this.nickName = nickName;
        this.name = name;
        this.status = status;
        this.headPic = headPic;
        this.qq = qq;
        this.isMobileCheck = isMobileCheck;
        this.isMailCheck = isMailCheck;
        this.sex = sex;
        this.userLevel = userLevel;
        this.points = points;
        this.experienceValue = experienceValue;
        this.birthday = birthday;
        this.lastLoginTime = lastLoginTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    public String getSourceType() {
        return sourceType;
    }

    public void setSourceType(String sourceType) {
        this.sourceType = sourceType;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getHeadPic() {
        return headPic;
    }

    public void setHeadPic(String headPic) {
        this.headPic = headPic;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getIsMobileCheck() {
        return isMobileCheck;
    }

    public void setIsMobileCheck(String isMobileCheck) {
        this.isMobileCheck = isMobileCheck;
    }

    public String getIsMailCheck() {
        return isMailCheck;
    }

    public void setIsMailCheck(String isMailCheck) {
        this.isMailCheck = isMailCheck;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getUserLevel() {
        return userLevel;
    }

    public void setUserLevel(Integer userLevel) {
        this.userLevel = userLevel;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    public Integer getExperienceValue() {
        return experienceValue;
    }

    public void setExperienceValue(Integer experienceValue) {
        this.experienceValue = experienceValue;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", created=" + created +
                ", updated=" + updated +
                ", sourceType='" + sourceType + '\'' +
                ", nickName='" + nickName + '\'' +
                ", name='" + name + '\'' +
                ", status='" + status + '\'' +
                ", headPic='" + headPic + '\'' +
                ", qq='" + qq + '\'' +
                ", isMobileCheck='" + isMobileCheck + '\'' +
                ", isMailCheck='" + isMailCheck + '\'' +
                ", sex='" + sex + '\'' +
                ", userLevel=" + userLevel +
                ", points=" + points +
                ", experienceValue=" + experienceValue +
                ", birthday=" + birthday +
                ", lastLoginTime=" + lastLoginTime +
                '}';
    }
}
