package top.funsite.springboot.web.filter;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Li Yuqing
 * @date 2020-05-26 15:11:00
 */
@Component
public class RequestFilter extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        /*Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String headerName = headerNames.nextElement();
            System.out.printf("%s: %S\n", headerName, request.getHeader(headerName));
        }*/
        // jquery ajax请求头
        if ("XMLHttpRequest".equals(request.getHeader("X-Requested-With"))) {
            // 设置需要跳转
            // response.setHeader("visit", "false");
            response.flushBuffer();
            return false;
        } else {
            return super.preHandle(request, response, handler);
        }
    }
}
