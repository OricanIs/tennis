package com.tennis.util.common;


import com.tennis.handler.wechat.MyX509TrustManager;

import net.sf.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.math.BigInteger;
import java.net.URL;
import java.net.URLConnection;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Map;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;


public class CommonUtil
{
	private static final double EARTH_RADIUS = 6378137;

	/**
	 * 根据两个经纬度获得之间的距离
	 */
	private static double rad(double d)
	{
		return d * Math.PI / 180.0;
	}

	public static double getDistance(double lat1, double lng1, double lat2, double lng2)
	{
		double radLat1 = rad(lat1);
		double radLat2 = rad(lat2);
		double a       = radLat1 - radLat2;
		double b       = rad(lng1) - rad(lng2);
		double s       = 2 * Math.asin(Math.sqrt(Math.pow(Math.sin(a / 2), 2) + Math.cos(radLat1) * Math.cos(radLat2) * Math.pow(Math.sin(b / 2), 2)));
		s = s * EARTH_RADIUS;
		s = Math.round(s * 10000) / 10000;
		return s;
	}

	/**
	 * 模糊查询算法
	 */
	public static String getSortString(String s)
	{
		String replaceAll = s.replaceAll("%", "/%").replaceAll("\\+", "\\\\+");
		String bf         = new String("");
		for (int i = 0; i < replaceAll.length(); i++)
		{
			if (replaceAll.charAt(i) == '/')
			{
				if (i == 0)
				{
					bf = "%" + replaceAll.charAt(i);
				}
				else
				{
					bf += replaceAll.charAt(i);
				}
			}
			else
			{
				if (i == 0)
				{
					bf = "%" + replaceAll.charAt(i) + "%";
				}
				else
				{
					bf += replaceAll.charAt(i) + "%";
				}
			}
		}
		return bf;
	}

	/**
	 * MD5加密
	 */
	public static String getSecretByMd5(String plainText)
	{
		byte[] secretBytes = null;
		try
		{
			secretBytes = MessageDigest.getInstance("md5").digest(plainText.getBytes());
		} catch (NoSuchAlgorithmException e)
		{
			throw new RuntimeException("没有md5这个算法！");
		}
		String md5code = new BigInteger(1, secretBytes).toString(16);// 16进制数字
		// 如果生成数字未满32位，需要前面补0
		for (int i = 0; i < 32 - md5code.length(); i++)
		{
			md5code = "0" + md5code;
		}
		return md5code;
	}


	//相似度查询
	public static float levenshtein(String str1, String str2)
	{
		//计算两个字符串的长度。
		int len1 = str1.length();
		int len2 = str2.length();
		//建立上面说的数组，比字符长度大一个空间
		int[][] dif = new int[len1 + 1][len2 + 1];
		//赋初值，步骤B。
		for (int a = 0; a <= len1; a++)
		{
			dif[a][0] = a;
		}
		for (int a = 0; a <= len2; a++)
		{
			dif[0][a] = a;
		}
		//计算两个字符是否一样，计算左上的值
		int temp;
		for (int i = 1; i <= len1; i++)
		{
			for (int j = 1; j <= len2; j++)
			{
				if (str1.charAt(i - 1) == str2.charAt(j - 1))
				{
					temp = 0;
				}
				else
				{
					temp = 1;
				}
				//取三个值中最小的
				dif[i][j] = min(dif[i - 1][j - 1] + temp, dif[i][j - 1] + 1, dif[i - 1][j] + 1);
			}
		}
		float similarity = 1 - (float) dif[len1][len2] / Math.max(str1.length(), str2.length());
		return similarity;
	}

	//得到最小值
	private static int min(int... is)
	{
		int min = Integer.MAX_VALUE;
		for (int i : is)
		{
			if (min > i)
			{
				min = i;
			}
		}
		return min;
	}


	//发送http get请求
	public static String sendGet(String url, String param)
	{
		String         result = "";
		BufferedReader in     = null;
		try
		{
			String urlNameString = url + "?" + param;
			URL    realUrl       = new URL(urlNameString);
			// 打开和URL之间的连接
			URLConnection connection = realUrl.openConnection();
			// 设置通用的请求属性
			connection.setRequestProperty("accept", "*/*");
			connection.setRequestProperty("connection", "Keep-Alive");
			connection.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
			// 建立实际的连接
			connection.connect();
			// 获取所有响应头字段
			Map<String, List<String>> map = connection.getHeaderFields();
			// 遍历所有的响应头字段
			for (String key : map.keySet())
			{
			}
			// 定义 BufferedReader输入流来读取URL的响应
			in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String line;
			while ((line = in.readLine()) != null)
			{
				result += line;
			}
		} catch (Exception e)
		{
			System.out.println("发送GET请求出现异常！" + e);
			e.printStackTrace();
		}
		// 使用finally块来关闭输入流
		finally
		{
			try
			{
				if (in != null)
				{
					in.close();
				}
			} catch (Exception e2)
			{
				e2.printStackTrace();
			}
		}
		return result;
	}

	/**
	 * 发送https请求
	 *
	 * @param requestUrl    请求地址
	 * @param requestMethod 请求方式（GET、POST）
	 * @param outputStr     提交的数据
	 * @return JSONObject(通过JSONObject.get(key)的方式获取json对象的属性值)
	 */
	public static JSONObject httpsRequest(String requestUrl, String requestMethod, String outputStr)
	{
		JSONObject jsonObject     = null;
		String     jsonHttpString = getJsonHttpString(requestUrl, requestMethod, outputStr);
		if (jsonHttpString == null)
			return null;
		jsonObject = JSONObject.fromObject(jsonHttpString.toString());
		return jsonObject;
	}

	/**
	 * 发送https请求
	 *
	 * @param requestUrl    请求地址
	 * @param requestMethod 请求方式（GET、POST）
	 * @param outputStr     提交的数据
	 * @return JSONObject(通过JSONObject.get(key)的方式获取json对象的属性值)
	 */
	public static byte[] httpsImageRequest(String requestUrl, String requestMethod, String outputStr)
	{
		String jsonHttpString = getJsonHttpString(requestUrl, requestMethod, outputStr);

		return jsonHttpString.getBytes();
	}

	private static String getJsonHttpString(String requestUrl, String requestMethod, String outputStr)
	{
		String result = "";
		try
		{
			// 创建SSLContext对象，并使用我们指定的信任管理器初始化
			TrustManager[] tm         = {new MyX509TrustManager()};
			SSLContext     sslContext = SSLContext.getInstance("SSL", "SunJSSE");
			sslContext.init(null, tm, new java.security.SecureRandom());
			// 从上述SSLContext对象中得到SSLSocketFactory对象
			SSLSocketFactory ssf = sslContext.getSocketFactory();

			URL                url  = new URL(requestUrl);
			HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
			conn.setSSLSocketFactory(ssf);

			conn.setDoOutput(true);
			conn.setDoInput(true);
			conn.setUseCaches(false);
			// 设置请求方式（GET/POST）
			conn.setRequestMethod(requestMethod);

			// 当outputStr不为null时向输出流写数据
			if (null != outputStr)
			{
				OutputStream outputStream = conn.getOutputStream();
				// 注意编码格式
				outputStream.write(outputStr.getBytes("UTF-8"));
				outputStream.close();
			}


			// 从输入流读取返回内容
			InputStream       inputStream       = conn.getInputStream();
			InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");
			BufferedReader    bufferedReader    = new BufferedReader(inputStreamReader);
			String            str               = null;
			StringBuffer      buffer            = new StringBuffer();
			while ((str = bufferedReader.readLine()) != null)
			{
				buffer.append(str);
			}

			// 释放资源
			bufferedReader.close();
			inputStreamReader.close();
			inputStream.close();
			inputStream = null;
			conn.disconnect();

			result = buffer.toString();
		} catch (Exception e)
		{
			return null;
		}

		return result;
	}


	public static String telHandle(String tel){
		String result = "暂无";
		if(tel.length()>7){
			result = tel.substring(0,3)+"XXXX"+tel.substring(tel.length()-4,tel.length());
		}

		return result;

	}

	public static boolean isEqualsEachOther(int ... objects)
	{
		for( int i = 0; i < objects.length-1; i ++)
		{
			for(int j = i+1; j < objects.length; j++){

				if(objects[i]==objects[j]){
					return true;
				}

			}

		}
		return false;


	}

}