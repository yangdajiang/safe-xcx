package com.cs.pojo;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

public class User implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.id
     *
     * @mbg.generated
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.open_id
     *
     * @mbg.generated
     */
    @NotNull(message = "User对象不能有空值")
    @Size(min = 25,max = 30,message = "open_id位数错误")
    private String openId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.user_name
     *
     * @mbg.generated
     */
    @NotNull(message = "User对象不能有空值")
    @Size(min = 1,max = 5,message = "姓名长度错误")
    private String userName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.user_phone
     *
     * @mbg.generated
     */
    @NotNull(message = "User对象不能有空值")
    @Size(min = 3,max = 15,message = "手机号位数错误")
    private String userPhone;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.name_1
     *
     * @mbg.generated
     */
    @NotNull(message = "User对象不能有空值")
    @Size(min = 1,max = 5,message = "姓名长度错误")
    private String name1;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.name_2
     *
     * @mbg.generated
     */
    @NotNull(message = "User对象不能有空值")
    @Size(min = 1,max = 5,message = "姓名长度错误")
    private String name2;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.name_3
     *
     * @mbg.generated
     */
    @NotNull(message = "User对象不能有空值")
    @Size(min = 1,max = 5,message = "姓名长度错误")
    private String name3;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.phone_1
     *
     * @mbg.generated
     */
    @NotNull(message = "User对象不能有空值")
    @Size(min = 3,max = 15,message = "手机号位数错误")
    private String phone1;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.phone_2
     *
     * @mbg.generated
     */
    @NotNull(message = "User对象不能有空值")
    @Size(min = 3,max = 15,message = "手机号位数错误")
    private String phone2;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.phone_3
     *
     * @mbg.generated
     */
    @NotNull(message = "User对象不能有空值")
    @Size(min = 3,max = 15,message = "手机号位数错误")
    private String phone3;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.now_place
     *
     * @mbg.generated
     */
    private String nowPlace;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table user
     *
     * @mbg.generated
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.id
     *
     * @return the value of user.id
     *
     * @mbg.generated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.id
     *
     * @param id the value for user.id
     *
     * @mbg.generated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.open_id
     *
     * @return the value of user.open_id
     *
     * @mbg.generated
     */
    public String getOpenId() {
        return openId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.open_id
     *
     * @param openId the value for user.open_id
     *
     * @mbg.generated
     */
    public void setOpenId(String openId) {
        this.openId = openId == null ? null : openId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.user_name
     *
     * @return the value of user.user_name
     *
     * @mbg.generated
     */
    public String getUserName() {
        return userName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.user_name
     *
     * @param userName the value for user.user_name
     *
     * @mbg.generated
     */
    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.user_phone
     *
     * @return the value of user.user_phone
     *
     * @mbg.generated
     */
    public String getUserPhone() {
        return userPhone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.user_phone
     *
     * @param userPhone the value for user.user_phone
     *
     * @mbg.generated
     */
    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone == null ? null : userPhone.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.name_1
     *
     * @return the value of user.name_1
     *
     * @mbg.generated
     */
    public String getName1() {
        return name1;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.name_1
     *
     * @param name1 the value for user.name_1
     *
     * @mbg.generated
     */
    public void setName1(String name1) {
        this.name1 = name1 == null ? null : name1.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.name_2
     *
     * @return the value of user.name_2
     *
     * @mbg.generated
     */
    public String getName2() {
        return name2;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.name_2
     *
     * @param name2 the value for user.name_2
     *
     * @mbg.generated
     */
    public void setName2(String name2) {
        this.name2 = name2 == null ? null : name2.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.name_3
     *
     * @return the value of user.name_3
     *
     * @mbg.generated
     */
    public String getName3() {
        return name3;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.name_3
     *
     * @param name3 the value for user.name_3
     *
     * @mbg.generated
     */
    public void setName3(String name3) {
        this.name3 = name3 == null ? null : name3.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.phone_1
     *
     * @return the value of user.phone_1
     *
     * @mbg.generated
     */
    public String getPhone1() {
        return phone1;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.phone_1
     *
     * @param phone1 the value for user.phone_1
     *
     * @mbg.generated
     */
    public void setPhone1(String phone1) {
        this.phone1 = phone1 == null ? null : phone1.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.phone_2
     *
     * @return the value of user.phone_2
     *
     * @mbg.generated
     */
    public String getPhone2() {
        return phone2;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.phone_2
     *
     * @param phone2 the value for user.phone_2
     *
     * @mbg.generated
     */
    public void setPhone2(String phone2) {
        this.phone2 = phone2 == null ? null : phone2.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.phone_3
     *
     * @return the value of user.phone_3
     *
     * @mbg.generated
     */
    public String getPhone3() {
        return phone3;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.phone_3
     *
     * @param phone3 the value for user.phone_3
     *
     * @mbg.generated
     */
    public void setPhone3(String phone3) {
        this.phone3 = phone3 == null ? null : phone3.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.now_place
     *
     * @return the value of user.now_place
     *
     * @mbg.generated
     */
    public String getNowPlace() {
        return nowPlace;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.now_place
     *
     * @param nowPlace the value for user.now_place
     *
     * @mbg.generated
     */
    public void setNowPlace(String nowPlace) {
        this.nowPlace = nowPlace == null ? null : nowPlace.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbg.generated
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", openId=").append(openId);
        sb.append(", userName=").append(userName);
        sb.append(", userPhone=").append(userPhone);
        sb.append(", name1=").append(name1);
        sb.append(", name2=").append(name2);
        sb.append(", name3=").append(name3);
        sb.append(", phone1=").append(phone1);
        sb.append(", phone2=").append(phone2);
        sb.append(", phone3=").append(phone3);
        sb.append(", nowPlace=").append(nowPlace);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}