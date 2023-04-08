package com.datn.app.endpoint;

import com.datn.app.core.entity.AttributeData;
import com.datn.app.core.service.AttributeDataService;
import com.datn.app.core.service.AttributeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("attribute-data")
public class AttributeDataController {
    private final AttributeDataService attributeDataService;
    @GetMapping("/find-all")
    public List<AttributeData> getAll(){
        return attributeDataService.findAll();
    }
    @GetMapping("/find/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        return ResponseEntity.ok(attributeDataService.doFindById(id));
    }
    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody AttributeData attributeData){
        return ResponseEntity.ok(attributeDataService.Save(attributeData));
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateById(@PathVariable Long id, @RequestBody AttributeData attributeData){
        return ResponseEntity.ok(attributeDataService.doUpdateById(attributeData,id));
    }
}
