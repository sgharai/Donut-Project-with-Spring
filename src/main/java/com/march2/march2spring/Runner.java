package com.march2.march2spring;

import com.march2.march2spring.Model.Donut;
import com.march2.march2spring.Model.Type;
import com.march2.march2spring.Repository.DonutRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Runner implements CommandLineRunner {

    @Autowired
    private DonutRepo donutRepo;

    @Override
    public void run(String... args) throws Exception {
        donutRepo.save(new Donut(1, "Boston Creme", true, Type.CAKE));
        donutRepo.save(new Donut(2, "Jelly", false, Type.CAKE));

    }
}