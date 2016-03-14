package com.chen.plane.cache.redis;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * Redis客户端
 *
 * @author 李威 (liwei17@asiainfo.com) <p> EM CRM SRD-HQ Internet Product Dept.I/Asiainfo</p>
 * @version 1.0 2014年10月27日 上午11:45:37
 */
@Component
public class RedisClient {

	private static final Logger log = Logger.getLogger(RedisClient.class);

	@Autowired
	private RedisTemplate<Serializable, Serializable> template;

	/**
	 * 设置Key-Value,简单类型和string
	 *
	 * @param key
	 * @param value void
	 * @author 李威 (liwei17@asiainfo.com) <p> EM CRM SRD-HQ Internet Product Dept.I/Asiainfo</p>
	 * @version 1.0 2014年10月27日 上午11:41:48
	 */
	public void setSimpleValue(String key, String value) {
		log.debug("setSimpleValue: key-[" + key + "], value-[" + value + "].");
		template.opsForValue().set(key, value);
	}

	/**
	 * 设置Key-Value,简单类型和string
	 *
	 * @param key
	 * @param value         void
	 * @param validTimeLong 有效时长
	 * @author 李威 (liwei17@asiainfo.com) <p> EM CRM SRD-HQ Internet Product Dept.I/Asiainfo</p>
	 * @version 1.0 2014年10月27日 上午11:41:48
	 */
	public void setSimpleValue(String key, String value, int validTimeLong) {
		log.debug("setSimpleValue: key-[" + key + "], value-[" + value + "], validTimeLong-[\" + validTimeLong + \"].");
		template.opsForValue().set(key, value,validTimeLong);
		template.expire(key,validTimeLong,TimeUnit.SECONDS);
	}

	/**
	 * 删除Key
	 *
	 * @param key void
	 * @author 李威 (liwei17@asiainfo.com) <p> EM CRM SRD-HQ Internet Product Dept.I/Asiainfo</p>
	 * @version 1.0 2014年10月27日 上午11:51:21
	 */
	public void delete(String key) {
		log.debug("delete: key-[" + key + "].");
		if (template.hasKey(key)) {
			template.delete(key);
		}
	}

	/**
	 * 获取Value,简单类型和string
	 *
	 * @param key
	 * @return String
	 * @author 李威 (liwei17@asiainfo.com) <p> EM CRM SRD-HQ Internet Product Dept.I/Asiainfo</p>
	 * @version 1.0 2014年10月27日 上午11:52:39
	 */
	public String getSimpleValue(String key) {
		log.debug("getSimpleValue: key-[" + key + "].");
		return (String) template.opsForValue().get(key);
	}

	/**
	 * 为redis保存一个map（map名为key）中的键值对（key：hashKey，value：value）
	 *
	 * @param key
	 * @param hashKey
	 * @param value   void
	 * @author 梁聃(liangdan@asiainfo.com) <p>	EM CRM SRD-HQ Internet Product Dept.I/Asiainfo</p>
	 * @version 1.0 2014-10-29 上午10:55:44
	 */
	public void setMapValue(String key, String hashKey, Object value) {
		log.debug("setMapValue: key-[" + key + "], hashKey-[" + hashKey + "], value-[" + value + "].");
		template.opsForHash().put(key, hashKey, value);
	}

	/**
	 * 读取redis中的一个map（map名为key）中的键值对（key：hashKey，value：value）
	 *
	 * @param key
	 * @param hashKey
	 * @return Object
	 * @author 梁聃(liangdan@asiainfo.com) <p>	EM CRM SRD-HQ Internet Product Dept.I/Asiainfo</p>
	 * @version 1.0 2014-10-29 上午10:59:45
	 */
	public Object getMapValue(String key, String hashKey) {
		log.debug("getMapValue:  key-[" + key + "], hashKey-[" + hashKey + "].");
		return template.opsForHash().get(key, hashKey);
	}

	/**
	 * 读取redis中的一个map（map名为key）
	 *
	 * @param key
	 * @return Map<Object,Object>
	 * @author 梁聃(liangdan@asiainfo.com) <p>	EM CRM SRD-HQ Internet Product Dept.I/Asiainfo</p>
	 * @version 1.0 2014-10-29 上午11:03:34
	 */
	public Map<Object, Object> getHashMap(String key) {
		log.debug("getHashMap: key-[" + key + "].");
		return template.opsForHash().entries(key);
	}

	/**
	 * 设置Redis中Key的有效时间
	 *
	 * @param key
	 * @param timeout void
	 * @author 谢继永  (xiejy@asiainfo.com) <p>	EM CRM SRD-HQ Internet Product Dept.I/Asiainfo</p>
	 * @version 1.0 2014-11-14 下午12:11:13
	 */
	public void setKeyExpireTime(String key, long timeout) {
		log.debug("setKeyExpireTime: key-[" + key + "], timeout-[" + timeout + "].");
		template.expire(key, timeout, TimeUnit.SECONDS);
	}

	/**
	 * 移除redis中MapValue中的值
	 *
	 * @param key
	 * @param hashKey void
	 * @author 谢继永  (xiejy@asiainfo.com) <p>	EM CRM SRD-HQ Internet Product Dept.I/Asiainfo</p>
	 * @version 1.0 2014-12-3 上午11:53:23
	 */
	public void removeMapValue(String key, String hashKey) {
		log.debug("removeMapValue：key-[" + key + "], hashKey-[" + hashKey + "]");
		template.opsForHash().delete(key, hashKey);
	}

	/**
	 * 保存serializable类型的value值
	 *
	 * @param key
	 * @param value void
	 * @author 谢继永  (xiejy@asiainfo.com) <p>	EM CRM SRD-HQ Internet Product Dept.I/Asiainfo</p>
	 * @version 1.0 2015-2-2 下午6:49:05
	 */
	public void setSerializableValue(String key, Serializable value) {
		log.debug("setSerializableValue：key-[" + key + "] ,value-[" + value + "]");
		template.opsForValue().set(key, value);
	}

	/**
	 * 读取serializable类型数据
	 *
	 * @param key
	 * @return Serializable
	 * @author 谢继永  (xiejy@asiainfo.com) <p>	EM CRM SRD-HQ Internet Product Dept.I/Asiainfo</p>
	 * @version 1.0 2015-2-2 下午6:56:11
	 */
	public Serializable getSerializableValue(String key) {
		log.debug("getSerializableValue：key-[" + key + "]");
		return template.opsForValue().get(key);
	}

}