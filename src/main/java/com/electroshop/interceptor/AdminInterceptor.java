package com.electroshop.interceptor;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.lang.NonNull;
import com.electroshop.entity.AppUser;

public class AdminInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(@NonNull HttpServletRequest request, @NonNull HttpServletResponse response, @NonNull Object handler) throws IOException {
        HttpSession session = request.getSession(false);
        AppUser user = session == null ? null : (AppUser) session.getAttribute("currentUser");
        if (user != null && "ADMIN".equals(user.getRole())) return true;
        response.sendRedirect(request.getContextPath() + "/error/403");
        return false;
    }
}
