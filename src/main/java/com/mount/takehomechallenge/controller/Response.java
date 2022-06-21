package com.mount.takehomechallenge.controller;

public interface Response<T> {
    public int statusCode();
    public T body();
}
