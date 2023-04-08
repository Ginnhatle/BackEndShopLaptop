package com.datn.app.core.service;

import com.datn.app.core.entity.Attribute;
import com.datn.app.core.repo.AttributeRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
@RequiredArgsConstructor
public class AttributeServiceImpl implements AttributeService{
    private final AttributeRepo attributeRepo;
    @Override
    public Attribute Save(Attribute attribute) {
        return attributeRepo.save(attribute);
    }

    @Override
    public Attribute doUpdateById(Attribute attribute, Long aLong) {
        Attribute attribute1 = attributeRepo.findById(aLong).get();
        attribute1.setName(attribute.getName());
        attribute1.setCreated(attribute.getCreated());
        attribute1.setType(attribute.getType());
        return attributeRepo.save(attribute1);
    }

    @Override
    public Attribute doDeleteById(Long aLong) {
        Attribute attribute = attributeRepo.findById(aLong).get();
        attributeRepo.delete(attribute);
        return null;
    }

    @Override
    public Attribute doFindById(Long aLong) {
        return attributeRepo.findById(aLong).orElse(null);
    }

    @Override
    public List<Attribute> findAll() {
        return attributeRepo.findAll();
    }

    @Override
    public Page<Attribute> findAll(Integer page, Integer size) {
        Pageable pageable = Pageable.ofSize(size).withPage(page);
        return attributeRepo.findAll(pageable);
    }
}
