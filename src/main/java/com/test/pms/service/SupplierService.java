package com.test.pms.service;

import com.test.pms.pojo.Supplier;

import java.util.List;

public interface SupplierService {
    List<Supplier> list();

    void delete(Integer id);

    void add(Supplier supplier);

    void update(Supplier supplier);
}
