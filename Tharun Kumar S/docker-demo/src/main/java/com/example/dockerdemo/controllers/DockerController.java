package com.example.dockerdemo.controllers;


import com.example.dockerdemo.model.Stud;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

@RestController
@RequestMapping("/api/")
public class DockerController {
    List<Stud> list=new ArrayList<>();
    @GetMapping
    public List<Stud> getStudentDetails()
    {
        for(int i=0;i<10;i++)
        {
            list.add(Stud.builder()
                    .sid(UUID.randomUUID().toString())
                    .sname("Student "+i)
                    .marks(new Random().nextInt(100))
                    .build());
        }
        return list;
    }

}
