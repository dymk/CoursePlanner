package com.courseplanner;
import java.io.IOException;

import javax.servlet.http.*;

import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;
@SuppressWarnings("serial")

public class CollegeDatastoreBuilderServlet extends HttpServlet {

		public void doGet(HttpServletRequest req, HttpServletResponse resp)
				throws IOException {
	        CollegeDatastoreBuilder test = new CollegeDatastoreBuilder();
	        test.insertMuirInfo();
	        test.insertMarshallInfo();
	        test.insertERCInfo();
	        test.insertRevelleInfo();
	        test.insertSixthInfo();
	        test.insertWarrenInfo();
	        
			UserService userService = UserServiceFactory.getUserService();
	        User user = userService.getCurrentUser();

	        if (user != null) {
	            resp.setContentType("text/html");
	            resp.getWriter().println("Hello, " + user.getNickname());
	            resp.getWriter().println("<a href='" + userService.createLogoutURL("/") + "'>Log Out</a>");
	        } else {
	            resp.sendRedirect(userService.createLoginURL(req.getRequestURI()));
	        }
		}
}