

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import customTools.DBUser;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String useremail = request.getParameter("email");
		String userpassword = request.getParameter("password");
        String action = request.getParameter("action");
        String nextURL = "/home.jsp";
        System.out.println(useremail);
        
        HttpSession session = request.getSession();

        
        if (action.equals("logout")){
            session.invalidate();
            nextURL = "/Login.jsp";
            
        }else{
            user = DBUser.getUserByEmail(useremail);

            System.out.println(user.getBhuserid());
            if (DBUser.isValidUser(user)){
                session.setAttribute("user", user);
                int size = 30;
                String gravatarURL = DBUser.getGravatarURL(useremail, size);
                System.out.println(gravatarURL);
                session.setAttribute("gravatarURL", gravatarURL);
                nextURL = "/home.jsp";
            }else{
                nextURL = "/Login.jsp";
            }
            
        }
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
