package com.vietshop.security;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.vietshop.util.SecurityUtils;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

// Nơi xử lý Authoziration ( phân quyền admin và user sau khi authentication thành công)

@Component // Để class có thể thực hiện cơ chế DI và IOC
public class CustomSuccessHandler extends SimpleUrlAuthenticationSuccessHandler{
	private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
			throws IOException {
		String targetUrl = determineTargetUrl(authentication);// Hàm định tuyến URL sẽ được trả về
		if (response.isCommitted()) {
			return;
		}
		redirectStrategy.sendRedirect(request, response, targetUrl);
	}
	// Hàm định tuyến URL sẽ được trả về
	private String determineTargetUrl(Authentication authentication) {
			String url="";
			
			List<String> roles = SecurityUtils.getAuthorities();
			// Nếu roles là ADMIN thì trả về url:"admin/trang-chu"
			if(isAdmin(roles)) {
				url = "/admin/trang-chu";
			}
			// Nếu roles là USER thì trả về url:"trang-chu"
			else if(isUser(roles)) {
				url = "/trang-chu";
			}
			
				return url;
	}
// Kiểm tra roles chứa ADMIN HOẶC USER
	private boolean isAdmin(List<String> roles) {
		if (roles.contains("ADMIN")) {
			return true;
		}
		return false;
	}
	
	private boolean isUser(List<String> roles) {
		if (roles.contains("acc")) {
			return true;
		}
		return false;
	}
}
