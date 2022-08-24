package com.example.gmrestapi.service;

import com.example.gmrestapi.dto.ApiResponce;
import com.example.gmrestapi.dto.GmDto;
import com.example.gmrestapi.entity.Address;
import com.example.gmrestapi.entity.Gm;
import com.example.gmrestapi.repository.AddressRepository;
import com.example.gmrestapi.repository.GmRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GmService {

    AddressRepository addressRepository;
    GmRepository gmRepository;

    public ApiResponce add(GmDto dto){
        Address address=new Address();
        address.setCity(dto.getCity());
        address.setHome(dto.getHome());
        address.setStreet(dto.getStreet());
        Address save=addressRepository.save(address);

        Gm gm=new Gm();
        gm.setDirector(dto.getDirector());
        gm.setCorpName(dto.getCorpName());
        gm.setAddress(save);
        gmRepository.save(gm);
        return new ApiResponce("Added",true);
    }

    public ApiResponce edit(Integer id, GmDto dto){
        Optional<Gm> byId=gmRepository.findById(id);
        if (byId.isEmpty())return new ApiResponce("GM not found",false);

        Gm gm=byId.get();
        gm.setDirector(dto.getDirector());
        gm.setCorpName(dto.getCorpName());
        Address gmAddress=gm.getAddress();
        gmAddress.setStreet(dto.getStreet());
        gmAddress.setCity(dto.getCity());
        gmAddress.setHome(dto.getHome());
        gm.setAddress(gmAddress);
        gmRepository.save(gm);
        return new ApiResponce("Edited",true);
    }
}
