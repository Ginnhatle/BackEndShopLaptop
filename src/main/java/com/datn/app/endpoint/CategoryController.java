package com.datn.app.endpoint;

import com.datn.app.core.entity.Category;
import com.datn.app.core.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/category")
public class CategoryController {
    private final CategoryService categoryService;
    @PostMapping
    public ResponseEntity<Category> add(@RequestBody Category category){
        return ResponseEntity.ok(categoryService.Save(category));
    }
}
