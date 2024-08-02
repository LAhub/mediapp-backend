package com.mitocode.controller;

import com.mitocode.dto.PatientDTO;
import com.mitocode.exception.ModelNotFoundException;
import com.mitocode.model.Patient;
import com.mitocode.model.Signos;
import com.mitocode.service.ISignosService;
import com.mitocode.util.MapperUtil;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/signos")
@RequiredArgsConstructor
public class SignosController {

    private final ISignosService service;
    private final MapperUtil mapperUtil;
    @GetMapping
    public ResponseEntity<List<Signos>> listar(){
        List<Signos> lista = service.findAll();
        return new ResponseEntity<List<Signos>>(lista, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Signos> listarPorId(@PathVariable("id") Integer id){
        Signos pac = service.findById(id);
        if(pac.getIdSignos() == null) {
            throw new ModelNotFoundException("ID NO ENCONTRADO " + id);
        }
        return new ResponseEntity<Signos>(pac, HttpStatus.OK);
    }

    @GetMapping("/pageable")
    public ResponseEntity<Page<Signos>> listarPageable(Pageable pageable) {
        Page<Signos> signos = service.listarPageable(pageable);
        return new ResponseEntity<Page<Signos>>(signos, HttpStatus.OK);
    }

    @CrossOrigin(exposedHeaders = {"Location"})
    @PostMapping
    public ResponseEntity<Object> registrar(@RequestBody Signos signos) {
        Signos sig = service.save(signos);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(sig.getIdSignos()).toUri();
        return ResponseEntity.created(location).build();
    }


    @PutMapping("/{id}")
    public ResponseEntity<Signos> update(@Valid @PathVariable("id") Integer id, @RequestBody Signos dto) {
        dto.setIdSignos(id);

        Signos obj = service.update(id, mapperUtil.map(dto, Signos.class));


        return ResponseEntity.ok(mapperUtil.map(obj, Signos.class));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> eliminar(@PathVariable("id") Integer id){
        Signos sig = service.findById(id);
        if(sig.getIdSignos() == null) {
            throw new ModelNotFoundException("ID NO ENCONTRADO " + id);
        }
        service.delete(id);
        return new ResponseEntity<Object>(HttpStatus.OK);
    }
}
