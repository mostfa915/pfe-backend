package com.formation.demo.controller;

import com.formation.demo.dao.ProductReposetory;
import com.formation.demo.entites.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Pageable;
import java.util.HashMap;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductReposetory pr;

    @GetMapping("/pagination")
    Page<Product> ProductByPage (int page ,int size){
    return pr.pagination(PageRequest.of(page, size)) ;

    }

    @GetMapping("/pagination2")
    Page<Product> ProductDescriptinByPage ( String mc , int page,int  size){
        return pr.chercher2("%"+mc+"%",PageRequest.of(page,size));
    }
    @GetMapping("/findbymc")
    List<Product> ChercherParMc(String mc){
        return pr.chercher("%"+mc+"%");
    }
    @GetMapping("/all")
    public List<Product> Getall() {
        return pr.findAll();
    }


    @GetMapping("/getone/{id}")
    Product findbyId(@PathVariable Long id){
        return pr.getOne(id);
       }
    @PostMapping("/save")
    public Product ajouter(@RequestBody Product c) {
        return pr.save(c);
    }

    @PutMapping("/update/{id}")
    public Product update(@RequestBody Product c, @PathVariable Long id) {
        c.setId(id);
        return pr.saveAndFlush(c);
    }

    @DeleteMapping("/delete/{Id}")
    public HashMap<String, String> delete(@PathVariable Long Id) {
        HashMap hashmap = new HashMap();
        try {
            pr.deleteById(Id);
            hashmap.put("etat", "suprimer");

        } catch (Exception e) {
            hashmap.put("etat", " non  suprimer");
        }
    return hashmap;
    }
}
