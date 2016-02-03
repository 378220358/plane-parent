package com.chen.plane.util.json;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;

import net.sf.json.JsonConfig;
import net.sf.json.processors.JsonValueProcessor;
/**
 * Json日期转换
 * @author 谢继永  (xiejy@asiainfo.com) <p>	EM CRM SRD-HQ Internet Product Dept.I/Asiainfo</p>
 * @version 1.0 2014-10-31 下午2:52:32
 */
public class JsonDateValueProcessor implements JsonValueProcessor {

	private static final Logger log = Logger.getLogger(JsonDateValueProcessor.class);
	
	private String format = "yyyy-MM-dd HH:mm:ss";

	public JsonDateValueProcessor() {
		super();
	}

	public JsonDateValueProcessor(String format) {
		this.format = format;
	}

	@Override
	public Object processArrayValue(Object value, JsonConfig conf) {
		log.debug(">>>processArrayValue ---- value:"+value);
		String[] obj = {};
		if (value instanceof Date[]) {
			SimpleDateFormat sf = new SimpleDateFormat(format);
			Date[] dates = (Date[]) value;
			obj = new String[dates.length];
			for (int i = 0; i < dates.length; i++) {
				obj[i] = sf.format(dates[i]);
			}
		}
		log.debug("<<<processArrayValue ---- obj:"+obj);
		return obj;
	}

	@Override
	public Object processObjectValue(String key, Object value, JsonConfig conf) {
		log.debug("processObjectValue --- key:"+key+" -----value:"+value);
		if(value == null ){
			value = "";
		}
		if (value instanceof Date) {
			String str = new SimpleDateFormat(format).format((Date) value);
			return str;
		}
		return value.toString();
	}

	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}
	
}
