package com.gainztracker.controllers;

import com.gainztracker.utils.Response;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
// import com.google.gson.Gson;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/hello")
public class HelloServlet extends HttpServlet {
    // private Gson gson = new Gson();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String, Object> data = new HashMap<String, Object>();
        data.put("message", "Hello, world!");
        Response response = new Response();
        response.setData(data);
        response.sendJsonResponse(resp);
    }
}
