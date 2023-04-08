package com.datn.app.endpoint;

import com.datn.app.core.entity.Attribute;
import com.datn.app.core.service.AttributeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("attribute")
public class AttributeController {
    private final AttributeService attributeService;
    @GetMapping("/find-all")
    public List<Attribute> getAll(){
        return attributeService.findAll();
    }
    @PostMapping("/add")
    public ResponseEntity<Attribute> add(@RequestBody Attribute attribute){
        return ResponseEntity.ok(attributeService.Save(attribute));
    }
    @PutMapping("/update")
    public ResponseEntity<Attribute> update(@PathVariable Long id, @RequestBody Attribute attribute){
        return ResponseEntity.ok(attributeService.doUpdateById(attribute,id));
    }
    @DeleteMapping("/delete")
    public ResponseEntity<?> delete(@PathVariable Long id){
        return ResponseEntity.ok(attributeService.doDeleteById(id));
    }
}
