package com.gainztracker.utils;

import jakarta.servlet.http.HttpServletResponse;
import com.google.gson.Gson;
import java.io.IOException;
import java.util.ArrayList;

public class Response {
    private boolean success;
    private ArrayList<String> messages;

    private Object data;

    public Response() {
        this.success = true;
        this.data = null;
        this.messages = new ArrayList<String>();
    }

    public Response(Object data) {
        this.success = true;
        this.data = data;
        this.messages = new ArrayList<String>();
    }

    public Response(boolean success, Object data) {
        this.success = success;
        this.data = data;
        this.messages = new ArrayList<String>();
    }

    public Response(boolean success, Object data, ArrayList<String> messages) {
        this.success = success;
        this.data = data;
        this.messages = messages;
    }

    public ArrayList<String> getMessages() {
        return this.messages;
    }

    public void setMessages(ArrayList<String> messages) {
        this.messages = messages;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public void sendJsonResponse(HttpServletResponse response) throws IOException {
        Gson gson = new Gson();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        String json = gson.toJson(this);
        response.getWriter().write(json);
    }

    public void sendJsonResponse(HttpServletResponse response, int status) throws IOException {
        Gson gson = new Gson();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.setStatus(status);
        String json = gson.toJson(this);
        response.getWriter().write(json);
    }
}