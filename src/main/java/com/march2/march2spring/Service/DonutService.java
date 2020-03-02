package com.march2.march2spring.Service;

import com.march2.march2spring.Model.Donut;
import com.march2.march2spring.Repository.DonutRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Service
public class DonutService {
    @Autowired
    DonutRepo donutRepo;

    public ModelAndView showDonuts() {
        ModelAndView mav = new ModelAndView("donuts");
        mav.addObject("donuts", donutRepo.findAll());
        return mav;
    }

//    public Iterable<Donut> getDonuts() {
//        return donutRepo.findAll();
//    }

    public Donut newDonut(@RequestBody Donut newDonut) {
        return donutRepo.save(newDonut);
    }


    public Optional<Donut> getDonut(Long id) {
        return donutRepo.findById(id);
    }


    public Optional<Donut> updateDonut(@RequestBody Donut newDonut, @PathVariable Long id) {
        Optional<Donut> updatedDonut = donutRepo.findById(id).map(donut -> {
            donut.setFrosted(newDonut.isFrosted());
            return donutRepo.save(donut);
        });
        return donutRepo.findById(id);
    }

    public void deleteDonut(Long id) {
        donutRepo.deleteById(id);
    }

//    public ModelAndView showDonuts() {
//    }
}
