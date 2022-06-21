package com.mount.takehomechallenge.Service;

import java.util.ArrayList;
import java.util.List;

import com.mount.takehomechallenge.model.ToyItem;

public class ToyService {

    //fake database
    private List<ToyItem> toys;

    public ToyService() {
        super();
        toys = new ArrayList<>();
        toys.add(new ToyItem( "bear", 1.00 ));
        toys.add(new ToyItem("dog", 2.00 ));
    }

    // Under the current assumption the challenge doesn't require a real database otherwise 
    // I would query the database and return the row with the matched name
    public ToyItem getItem(String name){
        for(ToyItem toy : toys){
            if(toy.getName().equals(name)){
                return toy;
            }
        }
        return null;
    }

    public boolean addToy(String name, double price){
        for(ToyItem toy : toys){
            if(toy.getName().equals(name)){
                return false;
            }
        }
        ToyItem toyToAdd = new ToyItem(name, price);
        toys.add(toyToAdd);
        return true;
    }

    public boolean deleteToy(String name){
        for(ToyItem toy : toys){
            if(toy.getName().equals(name)){
                toys.remove(toy);
                return true;
            }
        }
        return false;
    }
    
    
}
