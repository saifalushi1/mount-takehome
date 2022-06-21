package com.mount.takehomechallenge.controller;

import com.mount.takehomechallenge.model.ToyItem;

public interface ItemController {
    public Response<String> itemsPost(String name, Double price);
    public Response<ToyItem> itemsGet(String name);
    public Response<String> itemDelete(String name);
}