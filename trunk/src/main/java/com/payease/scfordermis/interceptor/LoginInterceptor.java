package com.payease.scfordermis.interceptor;

import com.alibaba.fastjson.JSON;
import com.payease.scfordermis.bo.ResultBo;
import com.payease.scfordermis.bo.responseBo.RespLoginPCBean;
import org.apache.commons.lang.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @Author : zhangwen
 * @Data : 2018/1/15
 * @Description :
 */
public class LoginInterceptor extends HttpServlet implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse
        httpServletResponse, Object o) throws Exception {
        HttpSession session = httpServletRequest.getSession();
        httpServletResponse.setHeader("Content-type", "text/html;charset=UTF-8");
        //TODO session中的key待定义
        RespLoginPCBean bean = (RespLoginPCBean) session.getAttribute("userInfo");
        String buttonCode = httpServletRequest.getParameter("buttonCode");
        ResultBo result = ResultBo.build();

        if(null==bean){
            result.setCodeId(-1);
            result.setMessage("登录状态已失效，请重新登录");
            httpServletResponse.getWriter().print(JSON.toJSONString(result));
            return false;
        }else{

            if(StringUtils.isNotBlank(buttonCode)&&StringUtils.isNotBlank(bean.getfMenus())){
                String[] arr = bean.getfMenus().split(",");
                int count = 0;
                for(String str:arr){
                    if(str.equals(buttonCode)){
                        count++;
                    }
                }
                if(count==0){
                    result.setCodeId(-1);
                    result.setMessage("没有当前菜单权限");
                    httpServletResponse.getWriter().print(JSON.toJSONString(result));
                    return false;
                }

            }else if(StringUtils.isNotBlank(buttonCode)&&StringUtils.isBlank(bean.getfMenus())){
                result.setCodeId(-1);
                result.setMessage("该用户没有菜单权限");
                httpServletResponse.getWriter().print(JSON.toJSONString(result));
                return false;
            }
            return true;
        }
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse
        httpServletResponse, Object o, Exception e) throws Exception {

    }
}
