package org.springframework.web.servlet;

import java.lang.reflect.Method;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;

public class WebUtil {
	public static Object getVoToParameter(Class<?> clz, HttpServletRequest req) throws Exception {
		Object target = clz.newInstance();
		Method[] mArr = clz.getDeclaredMethods();
		for (Method m : mArr) {
			String mName = m.getName();
			if (!mName.startsWith("set")) continue;
			mName = mName.substring("set".length());
			// no
			mName = Character.toLowerCase(mName.charAt(0)) + mName.substring(1);
			
			String pValue = req.getParameter(mName);
			if (pValue == null) continue;
			
			switch (m.getParameterTypes()[0].getName()) {
			case "int":
				m.invoke(target, Integer.parseInt(pValue));
				break;
			default:
				m.invoke(target, pValue);
			}
		}
		return target;
	}
}











