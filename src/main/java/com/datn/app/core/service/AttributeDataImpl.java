package com.datn.app.core.service;

import com.datn.app.core.entity.Attribute;
import com.datn.app.core.entity.AttributeData;
import com.datn.app.core.repo.AttributeDataRepo;
import com.datn.app.core.repo.AttributeRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
@RequiredArgsConstructor
public class AttributeDataImpl implements AttributeDataService {
    private final AttributeDataRepo attributeRepo;

    @Override
    public AttributeData Save(AttributeData attribute) {
        return attributeRepo.save(attribute);
    }

    @Override
    public AttributeData doUpdateById(AttributeData attribute, Long aLong) {
        AttributeData attribute1 = attributeRepo.findById(aLong).get();
        attribute1.setType(attribute.getType());
        attribute1.setName(attribute.getName());
        attribute1.setAttribute(attribute.getAttribute());
        attribute1.setProductDetail(attribute.getProductDetail());
        return attributeRepo.save(attribute1);
    }

    @Override
    public AttributeData doDeleteById(Long aLong) {
        AttributeData attribute = attributeRepo.findById(aLong).get();
        attributeRepo.delete(attribute);
        return null;
    }

    @Override
    public AttributeData doFindById(Long aLong) {
        return attributeRepo.findById(aLong).orElse(null);
    }

    @Override
    public List<AttributeData> findAll() {
        return attributeRepo.findAll();
    }

    @Override
    public Page<AttributeData> findAll(Integer page, Integer size) {
        return null;
    }
}
