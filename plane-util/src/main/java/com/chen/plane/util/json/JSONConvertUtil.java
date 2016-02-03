package com.chen.plane.util.json;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.ezmorph.object.DateMorpher;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.util.JSONUtils;
import net.sf.json.util.PropertyFilter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;


/**
 * JSON与JavaBean互相转换的工具类
 * @author 李威  (liwei17@asiainfo.com) <p>	EM CRM SRD-HQ Internet Product Dept.I/Asiainfo</p>
 * @version 1.0 2014年10月14日 下午4:50:21
 */
public class JSONConvertUtil {
	
	/**
	 * 将对象转化为JSON字符串带有对象名称
	 * @author 李威  (liwei17@asiainfo.com) <p>	EM CRM SRD-HQ Internet Product Dept.I/Asiainfo</p>
	 * @version 1.0 2014年10月14日 下午5:06:43 
	 * @param object
	 * @return
	 * @throws JsonProcessingException 
	 * String
	 */
	public static String convertObjectToJSONStringWithObjectName(String objectName,Object object) throws JsonProcessingException {
		String result = "";
		if(objectName == null || object == null){
			return result;
		}
		Map<String,Object> map = new HashMap<String,Object>();
		map.put(objectName, object);
		return new ObjectMapper().writeValueAsString(map);
	}
	
	/**
	 * 将对象转化为JSON字符串--ObjectMapper
	 * @author 李威  (liwei17@asiainfo.com) <p>	EM CRM SRD-HQ Internet Product Dept.I/Asiainfo</p>
	 * @version 1.0 2014年10月14日 下午5:06:43 
	 * @param object
	 * @return
	 * @throws JsonProcessingException 
	 * String
	 */
	public static String convertObjectToJSONString(Object object) throws JsonProcessingException{
		String result = "";
		if(object == null){
			return result;
		}
		return new ObjectMapper().writeValueAsString(object);
	}
	
	/**
	 * 将对象转化为JSON字符串(序列化单元素数组时不以数组来输出)--ObjectMapper
	 * 例如：{"user":[{"accountId":111,"accountName":"李四"}]  --> {"user":{"accountId":111,"accountName":"李四"}}
	 * @author 谢继永  (xiejy@asiainfo.com) <p>	EM CRM SRD-HQ Internet Product Dept.I/Asiainfo</p>
	 * @version 1.0 2015-1-27 下午1:56:33 
	 * @param object
	 * @return
	 * @throws JsonProcessingException 
	 * String
	 */
	public static String convertObjectToJSONStringHandleArray(Object object) throws JsonProcessingException{
		String result = "";
		if(object == null){
			return result;
		}
		ObjectMapper mapper = new ObjectMapper();
		//序列化单元素数组时不以数组来输出
		mapper.configure(SerializationFeature.WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED, true);
		result = mapper.writeValueAsString(object);
		return result;
	}
	
	
	/**
	 * 将Object对象转换成JSONObject对象
	 * @author 谢继永  (xiejy@asiainfo.com) <p>	EM CRM SRD-HQ Internet Product Dept.I/Asiainfo</p>
	 * @version 1.0 2014-10-31 下午12:34:20 
	 * @return
	 * JSONObject
	 */
	public static JSONObject convertObjecttoJsonObject(Object obj){
		JsonConfig config = new JsonConfig();
		config.registerJsonValueProcessor(Date.class, new JsonDateValueProcessor());
		  // 解决过滤空值问题
        PropertyFilter filter = new PropertyFilter() {
            public boolean apply(Object object, String fieldName,
                    Object fieldValue) {
                return null == fieldValue;
            }
        };
        config.setJsonPropertyFilter(filter);

		return JSONObject.fromObject(obj,config);
	}
	
	/**
	 * 字符串转JSONArray
	 *@param jsonMessage
	 *@return
	 * </p>Copyright(c)	Devlopment Dept/XiaoFang All Rights Reserved</p>
	 * @author 梁聃 (liangdan@66xf.com)
	 * @version 1.0 2015年10月14日 下午1:09:40
	 */
	public static JSONArray StringToJSONArray(String jsonMessage){
		return JSONArray.fromObject(jsonMessage);
	}

	/**
	 * 字符串转数组
	 *@param jsonMessage
	 *@param classObject
	 *@return
	 * </p>Copyright(c)	Devlopment Dept/XiaoFang All Rights Reserved</p>
	 * @author 梁聃 (liangdan@66xf.com)
	 * @version 1.0 2015年10月14日 下午1:27:51 
	 */
	
	
	public static List stringToList(String jsonMessage, Class classObject) {
		// TODO Auto-generated method stub
		JSONArray jsonArray = JSONConvertUtil.StringToJSONArray(jsonMessage);
		List list = (List) JSONArray.toCollection(jsonArray, classObject);
		return list;
	}
	/**
	 * 字符串转数组
	 *@param jsonMessage
	 *@param classObject
	 *@return
	 * </p>Copyright(c)	Devlopment Dept/XiaoFang All Rights Reserved</p>
	 * @author 梁聃 (liangdan@66xf.com)
	 * @version 1.0 2015年10月14日 下午1:27:51
	 */


	public static List stringToList(String jsonMessage, Class classObject, String dateFormat) {
		// TODO Auto-generated method stub
		JSONUtils.getMorpherRegistry().registerMorpher(
				new DateMorpher(new String[] { dateFormat}));
		JSONArray jsonArray = JSONConvertUtil.StringToJSONArray(jsonMessage);
		List list = (List) JSONArray.toCollection(jsonArray, classObject);
		return list;
	}
}
