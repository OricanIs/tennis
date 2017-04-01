import com.tennis.util.common.DateUtil;

import org.junit.Test;

import java.util.Date;



/**
 * All rights Reserved, Designed By  lixiao
 * Copyright (c) 2017 by Shanghai lixiao
 *
 * @PROJECT_NAME: tennis
 * @author: lixiao
 * @version: V1.0
 * @Date: 2017/4/1
 * @Description:
 */
public class TestDate
{
	@Test
	public  void test1(){
		Date startDayOfWeek = DateUtil.getMondayOfThisWeek(new Date());
		System.out.println(DateUtil.getStringDate(startDayOfWeek,DateUtil.DATE_YY_MM_DD_HH_MM_SS));
		Date endDayOfWeek =DateUtil.getSundayOfThisWeek(new Date());
		System.out.println(DateUtil.getStringDate(endDayOfWeek,DateUtil.DATE_YY_MM_DD_HH_MM_SS));
		System.out.println(DateUtil.DateToTimestamp(startDayOfWeek));
	}



}
