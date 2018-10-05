package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class AnswerRepository extends CrudRepository {

    private HashMap<Integer,String> dbLocal;

    public AnswerRepository() {
        this.dbLocal = new HashMap<>();

        this.dbLocal.put(1, "Reponse 1");
        this.dbLocal.put(2, "Reponse 2");
        this.dbLocal.put(3, "Reponse 3");
        this.dbLocal.put(4, "Reponse 4");
        this.dbLocal.put(5, "Reponse 5");
        this.dbLocal.put(6, "Reponse 6");
    }

    public List<String> getAll() {
        return new ArrayList<>(this.dbLocal.values()) ;
    }

    public void create (String answer) {
        dbLocal.put(dbLocal.keySet().size() + 1, answer);
    }
}
