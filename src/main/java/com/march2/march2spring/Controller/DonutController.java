package com.march2.march2spring.Controller;


import com.march2.march2spring.Model.Donut;
import com.march2.march2spring.Repository.DonutRepo;
import com.march2.march2spring.Service.DonutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class DonutController {

    @Autowired
    DonutService donutService;

    @Autowired
    DonutRepo donutRepo;


    //get method
    @CrossOrigin(origins = "http://localhost:8080")
    @GetMapping("/donuts")
    public Iterable getAllDonuts(){
        return donutService.getDonuts();
    }

    @PostMapping("/donut") // post is the HTTP method
    public Donut createDonut(@RequestBody Donut donut){ // "create" aligns with create in CRUD
        return donutService.newDonut(donut);
    }


    @PutMapping("/donut/{id}") //working put method, thank you Sofia!
    public Optional<Donut> updateDonut(@RequestBody Donut newDonut, @PathVariable Long id) {
        Optional<Donut> updatedDonut = donutRepo.findById(id).map(donut -> {
            donut.setFrosted(newDonut.isFrosted());
            donut.setName(newDonut.getName());
            return donutRepo.save(donut);
        });
        return donutRepo.findById(id);
    }


    @GetMapping("/donut/{id}")
    public Optional<Donut> getDonut(@PathVariable Long id){
        return donutService.getDonut(id);
    }

    @DeleteMapping("/donut/{id}")
    public void deleteDonut(@PathVariable Long id){
        donutService.deleteDonut(id);
    }


}