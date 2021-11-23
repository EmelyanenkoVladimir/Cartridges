package com.example.springbootsbyt.controller;

import com.example.springbootsbyt.model.*;
import com.example.springbootsbyt.service.impl.*;
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
public class PartyLotsController {
    private final CartridgeServiceImpl cartridgeServiceImpl;
    private final CartrsServiceImpl cartrsServiceImpl;
    private final HistoryServiceImpl historyServiceImpl;
    private final PrintersServiceImpl printersServiceImpl;
    private final ManufacturerServiceImpl manufacturerServiceImpl;
    private final PartyLotsServiceImpl partyLotsServiceImpl;


    public PartyLotsController(CartridgeServiceImpl cartridgeServiceImpl, CartrsServiceImpl cartrsServiceImpl, HistoryServiceImpl historyServiceImpl, PrintersServiceImpl printersServiceImpl, ManufacturerServiceImpl manufacturerServiceImpl, PartyLotsServiceImpl partyLotsServiceImpl) {
        this.cartridgeServiceImpl = cartridgeServiceImpl;
        this.cartrsServiceImpl = cartrsServiceImpl;
        this.historyServiceImpl = historyServiceImpl;
        this.printersServiceImpl = printersServiceImpl;
        this.manufacturerServiceImpl = manufacturerServiceImpl;
        this.partyLotsServiceImpl = partyLotsServiceImpl;
    }
    @GetMapping("/lots")
    public String findAllLots(Model model,History history){
        model.addAttribute("history", history);
        return "partylots";
    }

    @GetMapping("/lotsHistory/{idHistory}")
    public String findAllLots1(@PathVariable ("idHistory") int idHistory,Model model){
        History history = historyServiceImpl.findById(idHistory);
        model.addAttribute("history",history);
        return "partylotshistory";
    }
    @PostMapping("/lotsNumber/{idHistory}")
    public String CreateLotsNumber(@PathVariable ("idHistory") int idHistory,Partylots partylots){
        String str = partylots.getLotNumber();
        return "redirect:/CreateLots/{idHistory}/" + str;
    }

    @GetMapping("/CreateLots/{idHistory}/{lotNumber}")
    public String findAllLotsNumber(@PathVariable ("idHistory") int idHistory,@PathVariable ("lotNumber") String lotNumber,Model model){
        List<Cartridges> cartridges = cartridgeServiceImpl.findAll();
        History history = historyServiceImpl.findById(idHistory);
        model.addAttribute("cartridges", cartridges);
        model.addAttribute("history", history);
        model.addAttribute("partylots",new Partylots());
        return "createpartylots";
    }

    @PostMapping("/CreateLots/{idHistory}/{lotNumber}")
    public String CreateLots(@PathVariable ("idHistory") int idHistory, @PathVariable ("lotNumber") String lotNumber,Partylots partylots,BindingResult bindingResult,Model model){
        String barcode = Integer.toString(partylots.getCartridgesId());
        List<Cartridges> cartridges = cartridgeServiceImpl.findAllByInventoryNumber(barcode);
        if (cartridges.isEmpty()){
            History history = historyServiceImpl.findById(idHistory);
            model.addAttribute("history", history);
            bindingResult.rejectValue("cartridgesId", "error.cartridgesId", "Такой картридж не существует");
            return "createpartylots";
        }
        Cartridges cartridge = null;
        for (int i = 0; i < cartridges.size(); i++) {
            cartridge = cartridges.get(i);
            if (cartridge.getInventoryNumber().equals(barcode)) {
                int beryID = cartridge.getId();
                partylots.setCartridgesId(beryID);
            }
        }
        partyLotsServiceImpl.savePartylots(partylots);
        return "redirect:/CreatePartyLots/{idHistory}/{lotNumber}";
    }

    @GetMapping("/CreatePartyLots/{idHistory}/{lotNumber}")
    public String CreatePartyLots(@PathVariable ("idHistory") int idHistory,@PathVariable ("lotNumber") String lotNumber,Model model){
        List<Cartridges> cartridges = cartridgeServiceImpl.findAll();
        List<Partylots> partylots1 = partyLotsServiceImpl.findAllByLotNumber(lotNumber);
        List<Cartrs> cartrs = cartrsServiceImpl.findAll();
        History history = historyServiceImpl.findById(idHistory);
        List<Printers> printers = printersServiceImpl.findAll();
        List<Manufacturers> manufacturers = manufacturerServiceImpl.findAll();
        model.addAttribute("cartridges", cartridges);
        model.addAttribute("cartrs", cartrs);
        model.addAttribute("history", history);
        model.addAttribute("printers", printers);
        model.addAttribute("manufacturers",manufacturers);
        model.addAttribute("partylots1",partylots1);
        model.addAttribute("partylots",new Partylots());
        return "partylotsfinal";
    }

    @PostMapping("/CreatePartyLots/{idHistory}/{lotNumber}")
    public String CreatePartyLots(@PathVariable ("idHistory") int idHistory, @PathVariable ("lotNumber") String lotNumber,Partylots partylots,BindingResult bindingResult,Model model){
        String barcode = Integer.toString(partylots.getCartridgesId());
        List<Cartridges> cartridges = cartridgeServiceImpl.findAllByInventoryNumber(barcode);
        if (cartridges.isEmpty()){
            List<Cartridges> cartridges1 = cartridgeServiceImpl.findAll();
            List<Partylots> partylots1 = partyLotsServiceImpl.findAllByLotNumber(lotNumber);
            List<Cartrs> cartrs = cartrsServiceImpl.findAll();
            History history = historyServiceImpl.findById(idHistory);
            List<Printers> printers = printersServiceImpl.findAll();
            List<Manufacturers> manufacturers = manufacturerServiceImpl.findAll();
            model.addAttribute("cartridges", cartridges1);
            model.addAttribute("cartrs", cartrs);
            model.addAttribute("history", history);
            model.addAttribute("printers", printers);
            model.addAttribute("manufacturers",manufacturers);
            model.addAttribute("partylots1",partylots1);
            bindingResult.rejectValue("cartridgesId", "error.cartridgesId", "Такой картридж не существует");
            return "partylotsfinal";
        }
        Cartridges cartridge = null;
        for (int i = 0; i < cartridges.size(); i++) {
            cartridge = cartridges.get(i);
            if (cartridge.getInventoryNumber().equals(barcode)) {
                int beryID = cartridge.getId();
                partylots.setCartridgesId(beryID);
            }
        }
        partyLotsServiceImpl.savePartylots(partylots);
        return "redirect:/CreatePartyLots/{idHistory}/{lotNumber}";
    }


    @GetMapping("/lots-delete/{idPartylots}/{idHistory}/{lotNumber}")
    public String deletePartyLots(@PathVariable("idPartylots") int idPartylots,@PathVariable ("idHistory") int idHistory,@PathVariable ("lotNumber") String lotNumber) {
        partyLotsServiceImpl.deleteById(idPartylots);
        return "redirect:/CreatePartyLots/{idHistory}/{lotNumber}";
    }

    @GetMapping("/lots1-delete/{idPartylots}/{idHistory}/{lotNumber}")
    public String deletePartyLotsView(@PathVariable("idPartylots") int idPartylots,@PathVariable ("idHistory") int idHistory,@PathVariable ("lotNumber") String lotNumber) {
        partyLotsServiceImpl.deleteById(idPartylots);
        return "redirect:/view-lots/{lotNumber}/{idHistory}";
    }

    @GetMapping("/lots-look")
    public String findAllLots(Model model){
        List<Partylots> partylots1 = partyLotsServiceImpl.findDsLotNumber();
        List<History> histories = historyServiceImpl.findAll();
        model.addAttribute("partylots1",partylots1);
        model.addAttribute("history",histories);
        return "partylots-selector";
    }

    @GetMapping("/view-lots/{lotNumber}/{idHistory}")
    public String viewLots(@PathVariable ("lotNumber") String lotNumber,@PathVariable ("idHistory") int idHistory,Model model){
        List<Cartridges> cartridges = cartridgeServiceImpl.findAll();
        List<Partylots> partylots1 = partyLotsServiceImpl.findAllByLotNumber(lotNumber);
        List<Cartrs> cartrs = cartrsServiceImpl.findAll();
        List<History> history = historyServiceImpl.findAll();
        List<Printers> printers = printersServiceImpl.findAll();
        List<Manufacturers> manufacturers = manufacturerServiceImpl.findAll();
        model.addAttribute("cartridges", cartridges);
        model.addAttribute("cartrs", cartrs);
        model.addAttribute("history", history);
        model.addAttribute("printers", printers);
        model.addAttribute("manufacturers",manufacturers);
        model.addAttribute("partylots1",partylots1);
        model.addAttribute("partylots",new Partylots());
        return "partylots-list";
    }

    @PostMapping("/view-lots/{lotNumber}/{idHistory}")
    public String CreatePartyLotsView(@PathVariable ("idHistory") int idHistory, @PathVariable ("lotNumber") String lotNumber,Partylots partylots,BindingResult bindingResult,Model model){
        String barcode = Integer.toString(partylots.getCartridgesId());
        List<Cartridges> cartridges = cartridgeServiceImpl.findAllByInventoryNumber(barcode);
        if (cartridges.isEmpty()){
            List<Cartridges> cartridges1 = cartridgeServiceImpl.findAll();
            List<Partylots> partylots1 = partyLotsServiceImpl.findAllByLotNumber(lotNumber);
            List<Cartrs> cartrs = cartrsServiceImpl.findAll();
            History history = historyServiceImpl.findById(idHistory);
            List<Printers> printers = printersServiceImpl.findAll();
            List<Manufacturers> manufacturers = manufacturerServiceImpl.findAll();
            model.addAttribute("cartridges", cartridges1);
            model.addAttribute("cartrs", cartrs);
            model.addAttribute("history", history);
            model.addAttribute("printers", printers);
            model.addAttribute("manufacturers",manufacturers);
            model.addAttribute("partylots1",partylots1);
            bindingResult.rejectValue("cartridgesId", "error.cartridgesId", "Такой картридж не существует");
            return "partylots-list";
        }
        Cartridges cartridge = null;
        for (int i = 0; i < cartridges.size(); i++) {
            cartridge = cartridges.get(i);
            if (cartridge.getInventoryNumber().equals(barcode)) {
                int beryID = cartridge.getId();
                partylots.setCartridgesId(beryID);
            }
        }
        partyLotsServiceImpl.savePartylots(partylots);
        return "redirect:/view-lots/{lotNumber}/{idHistory}";
    }

    @GetMapping("/lots-look-history")
    public String findAllLotsHistory(Model model){
        List<Partylots> partylots = partyLotsServiceImpl.findDsHistory();
        List<History> histories = historyServiceImpl.findAll();
        model.addAttribute("partylots",partylots);
        model.addAttribute("history",histories);
        return "partylots-history-selector";
    }

    @GetMapping("/view-lots-history/{idHistory}")
    public String viewLotsHistory(@PathVariable ("idHistory") int idHistory,Model model){
        List<History> history = historyServiceImpl.findAll();
        List<Partylots> partylots1 = partyLotsServiceImpl.findDsHistoryKeyword(idHistory);
        model.addAttribute("history",history);
        model.addAttribute("partylots1",partylots1);
        return "partylots-list-history";
    }
}
