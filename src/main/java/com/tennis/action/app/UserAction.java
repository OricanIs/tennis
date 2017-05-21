package com.tennis.action.app;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.tennis.em.EM_GLOBAL_RESULT;
import com.tennis.em.EM_USER_LEVEL;
import com.tennis.model.db.Match;
import com.tennis.model.db.User;
import com.tennis.model.db.UserRelation;
import com.tennis.model.response.user.SimpleUserInfo;
import com.tennis.model.response.user.UserCenter;
import com.tennis.model.response.user.UserInfoModel;
import com.tennis.model.wechat.OpenidModel;
import com.tennis.service.match.IMatchService;
import com.tennis.service.user.IUserService;
import com.tennis.util.common.CommonUtil;
import com.tennis.util.common.DateUtil;
import com.tennis.util.wechat.WechatCommonUtil;

import org.apache.struts2.ServletActionContext;

import java.util.Date;
import java.util.List;

import static com.tennis.util.common.HttpPrintWriter.responseWrite;

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
public class UserAction extends ActionSupport implements ModelDriven<User>
{
	//设置model
	private User             user      = new User();
	private EM_GLOBAL_RESULT SuccessEM = EM_GLOBAL_RESULT.getEmByCode(0);
	private String code;

	public User getModel()
	{
		return user;
	}

	private IUserService  userService;
	private IMatchService matchService;
	private String        openid;
	private int           partnerId;
	private int           relationId;


	public void setOpenid(String openid)
	{
		this.openid = openid;
	}

	public void setRelationId(int relationId)
	{
		this.relationId = relationId;
	}

	public void setPartnerId(int partnerId)
	{
		this.partnerId = partnerId;
	}


	public void setCode(String code)
	{
		this.code = code;
	}

	public void setUserService(IUserService userService)
	{
		this.userService = userService;
	}

	public void setMatchService(IMatchService matchService)
	{
		this.matchService = matchService;
	}


	private int matchId;


	public String login()
	{

		OpenidModel openidModel = WechatCommonUtil.getOpenId(code);
		if (openidModel != null)
		{
			User findUser = userService.getUserByOpenid(openidModel.getOpenid());
			if (findUser == null)
			{
				findUser = new User();
				findUser.setStatus(0);
				findUser.setOpenid(openidModel.getOpenid());
				Integer createAt = DateUtil.DateToTimestamp(new Date());
				findUser.setRegisterTime(createAt);
				findUser.setName("");
				findUser.setPinyin("");
				findUser.setSex(2);
				findUser.setAge(0);
				findUser.setHeight(0);
				findUser.setWeight(0);
				findUser.setNation(0);
				findUser.setNationFlag("");
				findUser.setProvince(0);
				findUser.setCity(0);
				findUser.setAvatar("");
				findUser.setBackhand(0);
				findUser.setForehand(0);
				findUser.setLevel(0);
				findUser.setIntegral(0);
				findUser.setMobile("");
				findUser.setBirthday(0);
				userService.saveUser(findUser);

			}
			ServletActionContext.getRequest().getSession().setAttribute("user", findUser);
			responseWrite(ServletActionContext.getResponse(), SuccessEM, findUser);
			return SUCCESS;
		}
		else
		{
			responseWrite(ServletActionContext.getResponse(), EM_GLOBAL_RESULT.getEmByCode(10002), null);
			return SUCCESS;
		}

	}


	/**
	 * getUserInfo 获取用户详情
	 *
	 * @return
	 */
	public String myInfo()
	{
		//从session里面拿值
		User sessionUser = (User) ServletActionContext.getRequest().getSession().getAttribute("user");
		//		sessionUser.setId(1);
		UserInfoModel userInfo = userService.getUserInfo(sessionUser.getId());
		if (userInfo == null)
		{
			responseWrite(ServletActionContext.getResponse(), EM_GLOBAL_RESULT.getEmByCode(10002), null);
		}
		if (userInfo.getMobile() == null)
		{

			responseWrite(ServletActionContext.getResponse(), EM_GLOBAL_RESULT.getEmByCode(10006), null);
		}
		responseWrite(ServletActionContext.getResponse(), SuccessEM, userInfo);
		return SUCCESS;
	}

	/**
	 * getUpdateUserInfo 获取更改的用户信息
	 *
	 * @return
	 */
	public String getUpdateUserInfo()
	{
		User sessionUser = (User) ServletActionContext.getRequest().getSession().getAttribute("user");
		user = userService.getUser(sessionUser.getId());
		responseWrite(ServletActionContext.getResponse(), SuccessEM, user);
		return SUCCESS;

	}

	/**
	 * saveUserInfo 保存用户详情
	 *
	 * @return
	 */
	public String saveUserInfo()
	{
		userService.saveUser(user);
		responseWrite(ServletActionContext.getResponse(), SuccessEM, null);
		return SUCCESS;
	}

	/**
	 * updateUserInfo 更改用户信息
	 *
	 * @return
	 */
	public String updateUserInfo()
	{
		User findUser = (User) ServletActionContext.getRequest().getSession().getAttribute("user");
		findUser = userService.getUser(findUser.getId());
		if (user.getAge() != null)
			findUser.setAge(user.getAge());

		if (user.getAvatar() != null)
			findUser.setAvatar(user.getAvatar());

		if (user.getCity() != null)
			findUser.setCity(user.getCity());

		if (user.getForehand() != null)
			findUser.setForehand(user.getForehand());

		if (user.getHeight() != null)
			findUser.setHeight(user.getHeight());

		if (user.getMobile() != null)
			findUser.setMobile(user.getMobile());

		if (user.getName() != null)
		{
			findUser.setName(user.getName());
		}


		if (user.getProvince() != null)
			findUser.setProvince(user.getProvince());

		if (user.getSex() != null)
			findUser.setSex(user.getSex());

		if (user.getWeight() != null)
			findUser.setWeight(user.getWeight());

		if (user.getNation() != null)
			findUser.setNation(user.getNation());

		if (user.getNationFlag() != null)
			findUser.setNationFlag(user.getNationFlag());

		if (user.getBackhand() != null)
			findUser.setBackhand(user.getBackhand());
		if (user.getStatus() != null && (user.getStatus().equals(0) || user.getStatus().equals(1)))
		{
			findUser.setStatus(user.getStatus());
		}
		if (findUser.getLevel() == null || findUser.getLevel().equals(0))
		{
			if (user.getLevel() != null && !user.getLevel().equals(0))
			{
				System.out.println("===========!!!!");
				EM_USER_LEVEL emByIndex = EM_USER_LEVEL.getEmByIndex(user.getLevel());
				findUser.setLevel(user.getLevel());
				findUser.setIntegral(emByIndex.getInitial());
			}
		}

		//保存
		userService.updateUser(findUser);

		responseWrite(ServletActionContext.getResponse(), SuccessEM, null);

		return SUCCESS;
	}

	/**
	 * otherUserinfo 获取他人用户信息
	 *
	 * @return
	 */
	public String otherUserinfo()
	{
		UserInfoModel userInfo = userService.getUserInfo(user.getId());
		if (userInfo == null)
		{
			responseWrite(ServletActionContext.getResponse(), EM_GLOBAL_RESULT.getEmByCode(10002), null);
			return SUCCESS;
		}
		userInfo.setMobile(CommonUtil.telHandle(userInfo.getMobile()));
		if (matchId != 0)
		{
			Match match = matchService.get(matchId);
			if (match.getState() >= 1)
				userInfo.setMobile(userInfo.getMobile());
		}


		responseWrite(ServletActionContext.getResponse(), SuccessEM, userInfo);
		return SUCCESS;
	}

	/**
	 * 通过手机号获取用户
	 *
	 * @return
	 */
	public String findParnter()
	{
		User findUser = userService.getUserByMobile(user.getMobile());
		if (findUser == null)
		{
			responseWrite(ServletActionContext.getResponse(), EM_GLOBAL_RESULT.getEmByCode(10003), null);
			return SUCCESS;
		}

		if (findUser.getLevel() <= 0)
		{
			responseWrite(ServletActionContext.getResponse(), EM_GLOBAL_RESULT.getEmByCode(10003), null);
			return SUCCESS;
		}
		//构建成功的返回结果
		SimpleUserInfo userInfo = new SimpleUserInfo();
		userInfo.setId(findUser.getId());
		userInfo.setName(findUser.getName());
		userInfo.setMobil(findUser.getMobile());
		userInfo.setAvatar(findUser.getAvatar());
		responseWrite(ServletActionContext.getResponse(), SuccessEM, userInfo);

		return SUCCESS;
	}


	/**
	 * get friends
	 */
	public String getParnters()
	{

		User       findUser = (User) ServletActionContext.getRequest().getSession().getAttribute("user");
		List<User> friends  = userService.getFriends(findUser.getId());
		responseWrite(ServletActionContext.getResponse(), SuccessEM, friends);
		return SUCCESS;
	}

	/**
	 * save parnter
	 *
	 * @return
	 */
	public String saveParnter()
	{
		User findUser = (User) ServletActionContext.getRequest().getSession().getAttribute("user");
		if (partnerId <= 0)
		{
			responseWrite(ServletActionContext.getResponse(), EM_GLOBAL_RESULT.getEmByCode(10003), null);
			return SUCCESS;
		}
		if (findUser.getId()==partnerId){
			responseWrite(ServletActionContext.getResponse(), EM_GLOBAL_RESULT.getEmByCode(10003), null);
			return SUCCESS;
		}
		UserRelation relation = new UserRelation();
		relation.setFriendId(partnerId);
		relation.setUserId(findUser.getId());
		userService.SaveUserRelation(relation);
		responseWrite(ServletActionContext.getResponse(), SuccessEM, null);

		return SUCCESS;
	}

	/**
	 * del user parnter
	 * @return
	 */
	public String delParnter()
	{
		User findUser = (User) ServletActionContext.getRequest().getSession().getAttribute("user");

		if (partnerId <= 0)
		{
			responseWrite(ServletActionContext.getResponse(), EM_GLOBAL_RESULT.getEmByCode(10003), null);
		}

		UserRelation userRelation = new UserRelation();
		userRelation.setUserId(findUser.getId());
		userRelation.setFriendId(partnerId);
		userService.delRelation(userRelation);
		responseWrite(ServletActionContext.getResponse(), SuccessEM, null);
		return SUCCESS;
	}

	/**
	 * 用户个人中心
	 *
	 * @return
	 */
	public String center()
	{
		User          user       = (User) ServletActionContext.getRequest().getSession().getAttribute("user");
		int           userId     = user.getId();
		UserInfoModel userInfo   = userService.getUserInfo(userId);
		UserCenter    userCenter = new UserCenter();
		userCenter.setAvatar(userInfo.getAvatar());
		userCenter.setId(userInfo.getId());
		userCenter.setIntegral(userInfo.getIntegral());
		userCenter.setRank(userInfo.getRank());
		userCenter.setMyMatchsNum(userInfo.getMyMatchsNum());
		userCenter.setPendingMatchsNum(userInfo.getPendingMatchsNum());
		if (userInfo.getState() == null || userInfo.getState().equals("正常"))
		{
			userCenter.setStatus(0);
		}
		else
		{
			userCenter.setStatus(1);
		}
		userCenter.setUsername(userInfo.getName());

		responseWrite(ServletActionContext.getResponse(), SuccessEM, userCenter);
		return SUCCESS;
	}


	//sets


	public void setMatchId(int matchId)
	{
		this.matchId = matchId;
	}

	public void setUser(User user)
	{
		this.user = user;
	}
}
