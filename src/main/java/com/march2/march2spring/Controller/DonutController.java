package com.march2.march2spring.Controller;

import com.march2.march2spring.Model.Donut;
import com.march2.march2spring.Repository.DonutRepo;
import com.march2.march2spring.Service.DonutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;


@RestController
public class DonutController {
    @Autowired
    DonutRepo donutRepo;

    @Autowired
    DonutService donutService;

    @PostMapping("/donuts")
    Donut newDonut(@RequestBody Donut newDonut) {
        return donutService.newDonut(newDonut);
    }

    @RequestMapping(value = "/donuts", method = RequestMethod.GET)
    ModelAndView showDonuts() { return donutService.showDonuts(); }

//    @GetMapping("/donuts")
//    public Iterable<Donut> getDonuts(){
//        return donutService.getDonuts();
//    }


    @GetMapping("/donut/{id}")
    public Optional<Donut> getDonut(@PathVariable Long id){
        return donutService.getDonut(id);
    }

    @PutMapping("/donut/{id}")
    public Optional<Donut> updateDonut(@RequestBody Donut newDonut, @PathVariable Long id) {
        return donutService.updateDonut(newDonut, id);
    }

    @DeleteMapping
    public void deleteDonut(@PathVariable Long id) {
        donutService.deleteDonut(id);
    }


}
