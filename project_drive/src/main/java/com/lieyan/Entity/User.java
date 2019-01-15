package com.lieyan.Entity;

//用户实体，对应表为user
public class User {
    //
    //这是通过微信官方获取的
    private String openid;//微信唯一open-id，主键
    private String nickName;//昵称
    private Integer gender;//性别
    private String language;//语言
    private String city;//城市
    private String province;//省
    private String country;//国家
    private String avatarUrl;//头像地址
    //这是平台获取的
    private Integer bindteacher;//绑定教练的ID号
    private Integer Issign;//是否报名
    private Integer signitem;//报名类型
    private Integer moneybalance;//余额
    private Integer Integralnum;//积分数
    private Integer couponnum;//优惠券数


    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public void setBindteacher(Integer bindteacher) {
        this.bindteacher = bindteacher;
    }

    public void setIssign(Integer issign) {
        Issign = issign;
    }

    public void setSignitem(Integer signitem) {
        this.signitem = signitem;
    }

    public void setMoneybalance(Integer moneybalance) {
        this.moneybalance = moneybalance;
    }

    public void setIntegralnum(Integer integralnum) {
        Integralnum = integralnum;
    }

    public void setCouponnum(Integer couponnum) {
        this.couponnum = couponnum;
    }

    public String getOpenid() {

        return openid;
    }

    public String getNickName() {
        return nickName;
    }

    public Integer getGender() {
        return gender;
    }

    public String getLanguage() {
        return language;
    }

    public String getCity() {
        return city;
    }

    public String getProvince() {
        return province;
    }

    public String getCountry() {
        return country;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public Integer getBindteacher() {
        return bindteacher;
    }

    public Integer getIssign() {
        return Issign;
    }

    public Integer getSignitem() {
        return signitem;
    }

    public Integer getMoneybalance() {
        return moneybalance;
    }

    public Integer getIntegralnum() {
        return Integralnum;
    }

    public Integer getCouponnum() {
        return couponnum;
    }


}