package com.gainztracker.controllers;

import java.util.Map;
import java.util.List;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
// import com.google.gson.Gson;
import com.gainztracker.utils.Response;
import com.gainztracker.daos.UserDao;
import com.gainztracker.models.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebServlet("/user")
public class UserRoutes extends HttpServlet {
    // private Gson gson = new Gson();
    private static final Logger logger = LoggerFactory.getLogger(UserRoutes.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            UserDao user = new UserDao();
            List<User> users;
            users = user.getAllUsers();
            Response response = new Response();
            response.setData(users);
            ArrayList<String> Messages = new ArrayList<String>();
            Messages.add("apple");
            response.setMessages(Messages);
            response.sendJsonResponse(resp, 200);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
