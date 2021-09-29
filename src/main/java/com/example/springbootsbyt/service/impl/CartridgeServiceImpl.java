package com.example.springbootsbyt.service.impl;

import com.example.springbootsbyt.model.Cartridges;
//import com.example.springbootsbyt.entity.Cartridges;
import com.example.springbootsbyt.repository.CartridgeRepository;
import com.example.springbootsbyt.service.CartridgeService;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartridgeServiceImpl implements CartridgeService {

    private final CartridgeRepository cartridgeRepository;

    @Autowired
    public CartridgeServiceImpl(CartridgeRepository cartridgeRepository) {
        this.cartridgeRepository = cartridgeRepository;

    }

    public Cartridges findById(Integer id){
        return cartridgeRepository.findById(id).orElse(null);
    }

    public List<Cartridges> findAll(){
        return cartridgeRepository.findAll();
    }

    public Cartridges saveCartridge(Cartridges cartridge){
        return cartridgeRepository.save(cartridge);
    }

    public void deleteById(Integer id){
        cartridgeRepository.deleteById(id);
    }


//    @Override
//    public Integer countingById(Cartridges id, Cartridges cartrsIdCartrs, Cartridges count, History status) {
//
//
//        return null;
//    }

//    @Override
//    public Integer countingById(String status, String count) {
//        String str = status;
//        if(str.equalsIgnoreCase("в заправке")==true){
//            Cartridges cartridge = null;
//            List<Cartridges> cartridges = findAll();
//            for(int i = 0; i < cartridges.size(); i++){
//                cartridge = cartridges.get(i);
//                if()
//            }
//        }
//        return Integer.valueOf(count);
//    }


//        if (iterable instanceof Collection) {
//            return ((Collection<?>) iterable).size();
//        } else {
//            int count = 0;
//            Iterator iterator = iterable.iterator();
//            while (iterator.hasNext()) {
//                iterator.next();
//                count++;
//            }
//            return count;
//        }



}
