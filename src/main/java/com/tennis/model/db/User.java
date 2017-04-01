package com.tennis.model.db;

/**
 * All rights Reserved, Designed By  lixiao
 * Copyright (c) 2017 by Shanghai lixiao
 *
 * @PROJECT_NAME: tennis
 * @author: lixiao
 * @version: V1.0
 * @Date: 2017/3/29
 * @Description:
 */
public class User
{

	private int id;
	private String name;
	private String pinyin;
	private Integer sex;
	private Integer age;
	private Integer height;
	private Integer weight;
	private Integer nation;
	private String nationFlag;
	private Integer province;
	private Integer city;
	private String avatar;
	private Integer backhand;
	private Integer forehand;
	private Integer level;
	private Integer integral;
	private String openid;
	private String mobile;
	private Integer registerTime;
	private Integer status;
	private Integer birthday;

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getPinyin()
	{
		return pinyin;
	}

	public void setPinyin(String pinyin)
	{
		this.pinyin = pinyin;
	}

	public Integer getSex()
	{
		return sex;
	}

	public void setSex(Integer sex)
	{
		this.sex = sex;
	}

	public Integer getAge()
	{
		return age;
	}

	public void setAge(Integer age)
	{
		this.age = age;
	}

	public Integer getHeight()
	{
		return height;
	}

	public void setHeight(Integer height)
	{
		this.height = height;
	}

	public Integer getWeight()
	{
		return weight;
	}

	public void setWeight(Integer weight)
	{
		this.weight = weight;
	}


	public Integer getNation()
	{
		return nation;
	}

	public void setNation(Integer nation)
	{
		this.nation = nation;
	}

	public String getNationFlag()
	{
		return nationFlag;
	}

	public void setNationFlag(String nationFlag)
	{
		this.nationFlag = nationFlag;
	}

	public Integer getProvince()
	{
		return province;
	}

	public void setProvince(Integer province)
	{
		this.province = province;
	}

	public Integer getCity()
	{
		return city;
	}

	public void setCity(Integer city)
	{
		this.city = city;
	}

	public String getAvatar()
	{
		return avatar;
	}

	public void setAvatar(String avatar)
	{
		this.avatar = avatar;
	}

	public Integer getBackhand()
	{
		return backhand;
	}

	public void setBackhand(Integer backhand)
	{
		this.backhand = backhand;
	}

	public Integer getForehand()
	{
		return forehand;
	}

	public void setForehand(Integer forehand)
	{
		this.forehand = forehand;
	}

	public Integer getLevel()
	{
		return level;
	}

	public void setLevel(Integer level)
	{
		this.level = level;
	}

	public Integer getIntegral()
	{
		return integral;
	}

	public void setIntegral(Integer integral)
	{
		this.integral = integral;
	}

	public String getOpenid()
	{
		return openid;
	}

	public void setOpenid(String openid)
	{
		this.openid = openid;
	}

	public String getMobile()
	{
		return mobile;
	}

	public void setMobile(String mobile)
	{
		this.mobile = mobile;
	}

	public Integer getRegisterTime()
	{
		return registerTime;
	}

	public void setRegisterTime(Integer registerTime)
	{
		this.registerTime = registerTime;
	}

	public Integer getStatus()
	{
		return status;
	}

	public void setStatus(Integer status)
	{
		this.status = status;
	}

	public Integer getBirthday()
	{
		return birthday;
	}

	public void setBirthday(Integer birthday)
	{
		this.birthday = birthday;
	}

	@Override
	public int hashCode()
	{
		int result = id;
		result = 31 * result + (name != null ? name.hashCode() : 0);
		result = 31 * result + (pinyin != null ? pinyin.hashCode() : 0);
		result = 31 * result + (sex != null ? sex.hashCode() : 0);
		result = 31 * result + (age != null ? age.hashCode() : 0);
		result = 31 * result + (height != null ? height.hashCode() : 0);
		result = 31 * result + (weight != null ? weight.hashCode() : 0);
		result = 31 * result + (nation != null ? nation.hashCode() : 0);
		result = 31 * result + (nationFlag != null ? nationFlag.hashCode() : 0);
		result = 31 * result + (province != null ? province.hashCode() : 0);
		result = 31 * result + (avatar != null ? avatar.hashCode() : 0);
		result = 31 * result + (backhand != null ? backhand.hashCode() : 0);
		result = 31 * result + (forehand != null ? forehand.hashCode() : 0);
		result = 31 * result + (level != null ? level.hashCode() : 0);
		result = 31 * result + (integral != null ? integral.hashCode() : 0);
		result = 31 * result + (openid != null ? openid.hashCode() : 0);
		result = 31 * result + (mobile != null ? mobile.hashCode() : 0);
		result = 31 * result + (registerTime != null ? registerTime.hashCode() : 0);
		return result;
	}

	@Override
	public boolean equals(Object o)
	{
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		User user = (User) o;

		if (id != user.id)
			return false;
		if (name != null ? !name.equals(user.name) : user.name != null)
			return false;
		if (pinyin != null ? !pinyin.equals(user.pinyin) : user.pinyin != null)
			return false;
		if (sex != null ? !sex.equals(user.sex) : user.sex != null)
			return false;
		if (age != null ? !age.equals(user.age) : user.age != null)
			return false;
		if (height != null ? !height.equals(user.height) : user.height != null)
			return false;
		if (weight != null ? !weight.equals(user.weight) : user.weight != null)
			return false;
		if (nation != null ? !nation.equals(user.nation) : user.nation != null)
			return false;
		if (nationFlag != null ? !nationFlag.equals(user.nationFlag) : user.nationFlag != null)
			return false;
		if (province != null ? !province.equals(user.province) : user.province != null)
			return false;
		if (avatar != null ? !avatar.equals(user.avatar) : user.avatar != null)
			return false;
		if (backhand != null ? !backhand.equals(user.backhand) : user.backhand != null)
			return false;
		if (forehand != null ? !forehand.equals(user.forehand) : user.forehand != null)
			return false;
		if (level != null ? !level.equals(user.level) : user.level != null)
			return false;
		if (integral != null ? !integral.equals(user.integral) : user.integral != null)
			return false;
		if (openid != null ? !openid.equals(user.openid) : user.openid != null)
			return false;
		if (mobile != null ? !mobile.equals(user.mobile) : user.mobile != null)
			return false;
		if (registerTime != null ? !registerTime.equals(user.registerTime) : user.registerTime != null)
			return false;

		return true;
	}
}
