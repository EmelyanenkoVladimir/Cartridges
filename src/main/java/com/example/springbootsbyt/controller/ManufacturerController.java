package com.example.springbootsbyt.controller;

import com.example.springbootsbyt.model.Cartrs;
import com.example.springbootsbyt.model.Manufacturers;
import com.example.springbootsbyt.model.Printers;
import com.example.springbootsbyt.service.impl.CartrsServiceImpl;
import com.example.springbootsbyt.service.impl.ManufacturerServiceImpl;
import com.example.springbootsbyt.service.impl.PrintersServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
public class ManufacturerController {
    private final ManufacturerServiceImpl manufacturerServiceImpl;
    private final CartrsServiceImpl cartrsServiceImpl;
    private final PrintersServiceImpl printersServiceImpl;

    public ManufacturerController(ManufacturerServiceImpl manufacturerServiceImpl, CartrsServiceImpl cartrsServiceImpl, PrintersServiceImpl printersServiceImpl) {
        this.manufacturerServiceImpl = manufacturerServiceImpl;
        this.cartrsServiceImpl = cartrsServiceImpl;
        this.printersServiceImpl = printersServiceImpl;
    }

    @GetMapping("/manufacturers")
    public String findAllManufacturers(Model model){
        List<Manufacturers> manufacturers = manufacturerServiceImpl.findAll();
        model.addAttribute("manufacturers", manufacturers);
        return "printers-list";
    }

    @GetMapping("/manufacturers-create")
    public String createManufacturersForm(Manufacturers manufacturers) {
        return "printers-list";
    }

    @PostMapping("/manufacturers-create")
    public String createManufacturers(@Valid Manufacturers manufacturers) {
        manufacturerServiceImpl.saveModels(manufacturers);
        return "redirect:/printers";
    }

    @GetMapping("manufacturers-update/{idModels}")
    public String updateManufacturersForm(@PathVariable("idModels") int id, Model model) {
        Manufacturers manufacturers = manufacturerServiceImpl.findById(id);
        model.addAttribute("manufacturers", manufacturers);
        return "/manufacturers-update";
    }

    @PostMapping("/manufacturers-update/{idModels}")
    public String updateManufacturers(@PathVariable("idModels") int id, @Valid Manufacturers manufacturers, BindingResult bindingResult,Model model) {
        if(bindingResult.hasErrors()){
            List<Manufacturers> manufacturers1 = manufacturerServiceImpl.findAll();
            model.addAttribute("manufacturers1", manufacturers1);
            return "manufacturers-update";
        }
        manufacturerServiceImpl.saveModels(manufacturers);
        return "redirect:/printers";
    }

    @GetMapping("/manufacturers-delete/{idModels}")
    public String deleteModels(@PathVariable("idModels") Integer id) {
        manufacturerServiceImpl.deleteById(id);
        return "redirect:/printers";
    }
}

