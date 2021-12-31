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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

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

//    @GetMapping("/create-model")
//    public String createModelsForm(@ModelAttribute("NewManufacturers") Manufacturers manufacturers) {
//        return "printers-list";
//    }

    @PostMapping("/create-model")
    public String createModel(@Valid @ModelAttribute("NewManufacturers") Manufacturers manufacturers, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()){
            List<Printers> printers1 = printersServiceImpl.findAll();
            List<Manufacturers> manufacturers1 = manufacturerServiceImpl.findAll();
            model.addAttribute("printers", printers1);
            model.addAttribute("manufacturers1", manufacturers1);
            return "printers-list";
        }
        Manufacturers NewManufacturers = null;
        List<Manufacturers> manufacturers1 = manufacturerServiceImpl.findAll();
        List<Printers> printers1 = printersServiceImpl.findAll();
        model.addAttribute("printers", printers1);
        model.addAttribute("manufacturers1", manufacturers1);
        String str = manufacturers.getModelFromPrinters();
        for(int i=0; i<manufacturers1.size(); i++){
            NewManufacturers = manufacturers1.get(i);
            if(str.equalsIgnoreCase(NewManufacturers.getModelFromPrinters())==true){
                bindingResult.rejectValue("modelFromPrinters", "error.modelFromPrinters", "Такой производитель уже есть");
                return "printers-list";
            }
        }
        manufacturerServiceImpl.saveModels(manufacturers);
        return "redirect:/printers";
    }

    @GetMapping("/models-delete/{idModels}")
    public String deleteModels(@PathVariable("idModels") long id) {
        manufacturerServiceImpl.deleteById(id);
        return "redirect:/printers";
    }
}

