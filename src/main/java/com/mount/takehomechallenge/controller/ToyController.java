package com.mount.takehomechallenge.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mount.takehomechallenge.Service.ToyService;
import com.mount.takehomechallenge.model.ToyItem;

@RestController
public class ToyController implements ItemController{


    public ToyService service = new ToyService();

    //Here I could use exception handling annotation from spring but seeing as im using an in memory db
    // I think it will be ok to just return a response like this
    @Override
    @PostMapping("/item/create")
    public Response<String> itemsPost(@RequestParam String name, @RequestParam Double price) {
        if(service.addToy(name, price)){
            return new ToyResponse<String>(200, "Success");
        }
        return new ToyResponse<String>(404, "Toy already exists");
    }

    @GetMapping("/api/foos")
    @ResponseBody
    public String getFoos(@RequestParam String id) {
        return "ID: " + id;
    }

    // @Override
    @GetMapping("/item/get")
    @ResponseBody
    public String itemsGets(@RequestParam String name) {
        ToyItem toyToGet = service.getItem(name);
        if(toyToGet instanceof ToyItem){
            return new ToyResponse<ToyItem>(200, toyToGet).toString();
        }
        return new ToyResponse<ToyItem>(404, null).toString();
    }
    

    @Override
    @DeleteMapping("/item/delete")
    public Response<String> itemDelete(@RequestParam String name) {
        if(service.deleteToy(name)){
            return new ToyResponse<String>(200, "Success");
        }
        return new ToyResponse<String>(404, "Could not find toy");
    }

    @Override
    public Response<ToyItem> itemsGet(String name) {
        // TODO Auto-generated method stub
        return null;
    }

}
