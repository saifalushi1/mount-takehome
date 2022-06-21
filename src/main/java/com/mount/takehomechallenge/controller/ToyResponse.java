package com.mount.takehomechallenge.controller;

public class ToyResponse<T> implements Response<T>{
    private int status;

    private T body;

    public ToyResponse(int status, T body) {
        super();
        this.status = status;
        this.body = body;
    }

    @Override
    public int statusCode() {
        return this.status;
    }

    @Override
    public T body() {
        return this.body;
    }

    @Override
    public String toString() {
        return "body=" + body + ", status=" + status + "";
    }
    
}
