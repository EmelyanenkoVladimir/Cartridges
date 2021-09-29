package com.example.springbootsbyt.service.impl;

import com.example.springbootsbyt.model.Cartridges;
import com.example.springbootsbyt.model.History;
import com.example.springbootsbyt.repository.CartridgeRepository;
import com.example.springbootsbyt.repository.HistoryRepository;
import com.example.springbootsbyt.service.HistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HistoryServiceImpl implements HistoryService {

    private final HistoryRepository historyRepository;
    private final CartridgeServiceImpl cartridgeServiceImpl;
//    private final CartridgeRepository cartridgeRepository;

    @Autowired
    public HistoryServiceImpl(HistoryRepository historyRepository, CartridgeRepository cartridgeRepository, CartridgeServiceImpl cartridgeServiceImpl) {
        this.historyRepository = historyRepository;
//        this.cartridgeRepository = cartridgeRepository;
        this.cartridgeServiceImpl = cartridgeServiceImpl;
    }

    public History findById(Integer id) {
        return historyRepository.findById(id).orElse(null);
    }

    public List<History> findAll() {
        return historyRepository.findAll();
    }

    public History saveHistory(History history) {
        String str3 = history.getStatus();
        Cartridges cartridge = null;
        List<Cartridges> cartridges = cartridgeServiceImpl.findAll();
        for(int i=0; i<cartridges.size(); i++){
            cartridge = cartridges.get(i);
            if(cartridge.getId()==history.getCartridgesId()){
                if(str3.equalsIgnoreCase("в заправке")==true){
                    Integer counting = cartridge.getCount();
                    counting++;
                    cartridge.setCount(counting);
                    cartridgeServiceImpl.saveCartridge(cartridge);
                }
            }
        }
        return historyRepository.save(history);
    }
    public History saveHistoryUpdate(History history1) {
        String str3 = history1.getStatus();
        Cartridges cartridge = null;
        List<Cartridges> cartridges = cartridgeServiceImpl.findAll();
        for(int i=0; i<cartridges.size(); i++){
            cartridge = cartridges.get(i);
            if(cartridge.getId()==history1.getCartridgesId()){
                if(str3.equalsIgnoreCase("в заправке")==true){
                    Integer counting = cartridge.getCount();
                    counting++;
                    cartridge.setCount(counting);
                    cartridgeServiceImpl.saveCartridge(cartridge);
                }else {
                    Integer counting = cartridge.getCount();
                    counting--;
                    cartridge.setCount(counting);
                    cartridgeServiceImpl.saveCartridge(cartridge);
                }
            }
        }
        return historyRepository.save(history1);
    }

    public void deleteById(Integer id, History history) {
        String str4 = history.getStatus();
        Cartridges cartridge = null;
        List<Cartridges> cartridges = cartridgeServiceImpl.findAll();
        for(int i=0; i<cartridges.size(); i++){
            cartridge = cartridges.get(i);
            if(cartridge.getId()==history.getCartridgesId()){
                if(str4.equalsIgnoreCase("в заправке")==true){
                    Integer counting = cartridge.getCount();
                    counting--;
                    cartridge.setCount(counting);
                    cartridgeServiceImpl.saveCartridge(cartridge);
                }
            }
        }
        historyRepository.deleteById(id);
    }
}
