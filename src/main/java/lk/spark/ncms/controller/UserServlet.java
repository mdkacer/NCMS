package lk.spark.ncms.controller;

import com.google.gson.JsonObject;
import lk.spark.ncms.dao.User;
import lk.spark.ncms.service.UserService;
import lk.spark.ncms.service.UserServicelmpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "UserServlet")
public class UserServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String accessType = req.getParameter("type");
        UserService userService = new UserServicelmpl();

        if (accessType.equals("signup")){

            User userInformation = new User(req.getParameter("userName"), req.getParameter("password"), req.getParameter("name"), Integer.parseInt(req.getParameter("moh")), Integer.parseInt(req.getParameter("hospital")));
            String result = userService.signupUser(userInformation);
            this.sendResponse(result, resp);

        } else if (accessType.equals("signin")){

            String result = userService.signinUser(req.getParameter("userName"), req.getParameter("password"));
            this.sendResponse(result, resp);
        }
//        super.doPost(req, resp);
    }

    private void sendResponse(String data, HttpServletResponse resp) throws IOException
    {
        resp.setContentType("application/json");
        PrintWriter writer = resp.getWriter();
        JsonObject json = new JsonObject();
        json.addProperty("Response", data);
        writer.print(json.toString());
        writer.flush();
    }
}
