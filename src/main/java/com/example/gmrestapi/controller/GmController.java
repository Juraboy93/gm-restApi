package com.example.gmrestapi.controller;

import com.example.gmrestapi.dto.ApiResponce;
import com.example.gmrestapi.dto.GmDto;
import com.example.gmrestapi.entity.Gm;
import com.example.gmrestapi.repository.CarRepository;
import com.example.gmrestapi.repository.GmRepository;
import com.example.gmrestapi.service.GmService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;
import java.util.Optional;

@RestController
@RequestMapping("/api/gm")
@RequiredArgsConstructor

public class GmController {

    final GmRepository gmRepository;
    final CarRepository carRepository;
    final GmService gmService;
    @GetMapping
    public HttpEntity<?> getOne(@PathVariable Integer id){
        Optional<Gm> byId=gmRepository.findById(id);
        return ResponseEntity.status(byId.isEmpty()? 404:200)
                .body(byId.orElse(new Gm()));
    }
    @PostMapping
    public HttpEntity<?> add(@RequestBody GmDto dto){
        ApiResponce responce=gmService.add(dto);
        return ResponseEntity.status(responce.isSuccess() ? 201:400)
                .body(responce);
    }
    @PutMapping
    public HttpEntity<?> edit(@PathVariable Integer id,@RequestBody GmDto gmDto){
        ApiResponce responce=gmService.edit(id, gmDto);
        return ResponseEntity.status(responce.isSuccess() ? 200:409)
                .body(responce);
    }
    @DeleteMapping
    public HttpResponse<?> delete(@PathVariable Integer id){
        Optional<Gm> byId=gmRepository.findById(id);
        if (byId.isEmpty())return (HttpResponse<?>) ResponseEntity.status(404).body("not found");
        Gm gm=byId.get();
        gmRepository.save(gm);
        return (HttpResponse<?>) ResponseEntity.ok().body("Deleted");
    }
}
