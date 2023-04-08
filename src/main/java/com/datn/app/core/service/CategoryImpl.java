package com.datn.app.core.service;

import com.datn.app.core.entity.Category;
import com.datn.app.core.repo.CategoryRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class CategoryImpl implements CategoryService{
    private final CategoryRepo categoryRepo;
    @Override
    public Category Save(Category category) {
        return categoryRepo.save(category);
    }

    @Override
    public Category doUpdateById(Category category, Long aLong) {
        return null;
    }

    @Override
    public Category doDeleteById(Long aLong) {
        return null;
    }

    @Override
    public Category doFindById(Long aLong) {
        return null;
    }

    @Override
    public List<Category> findAll() {
        return null;
    }

    @Override
    public Page<Category> findAll(Integer page, Integer size) {
        return null;
    }
}
