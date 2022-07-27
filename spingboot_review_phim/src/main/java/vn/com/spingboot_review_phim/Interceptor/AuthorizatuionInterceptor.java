package vn.com.spingboot_review_phim.Interceptor;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.logging.Handler;

public class AuthorizatuionInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();

        //kiểm tra nếu chưa đăng nhập thì yêu cầu phải xác thực đăng nhập trước
        if (session != null && session.getAttribute("UserOnline") != null) {
//            System.out.println("Bạn đang đăng nhập với tài khoản: " + session.getAttribute("UserOnline"));
            return true;
        } else {
            response.sendRedirect("../dang-nhap");
        }
        return false;
    }
}
