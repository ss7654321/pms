package com.test.pms.service.impl;

import com.test.pms.mapper.SupplierMapper;
import com.test.pms.pojo.Supplier;
import com.test.pms.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class SupplierServiceImpl implements SupplierService {
    @Autowired
    private SupplierMapper supplierMapper;

    @Override
    public List<Supplier> list() {
        return supplierMapper.list();
    }

    @Override
    public void delete(Integer id) {
        supplierMapper.deleteById(id);
    }

    @Override
    public void add(Supplier supplier) {
        supplier.setLastUpdateDate(LocalDate.now());
        supplierMapper.insert(supplier);
    }

    @Override
    public void update(Supplier supplier) {
        supplier.setLastUpdateDate(LocalDate.now());
        supplierMapper.update(supplier);
    }
}
