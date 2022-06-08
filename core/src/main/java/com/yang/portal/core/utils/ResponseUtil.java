package com.yang.portal.core.utils;

import com.yang.portal.core.CoreConstant;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ResponseUtil {

    public static void setResponse(HttpServletResponse response,String json) throws IOException {
        response.setCharacterEncoding(CoreConstant.CHAR_SET);
        response.getWriter().write(json);
    }
}
