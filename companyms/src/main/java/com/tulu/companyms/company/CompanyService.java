package com.tulu.companyms.company;

import java.util.List;

public interface CompanyService {
    List<Company> findAll();
    Company findById(Long id);
    boolean addCompany(Company company);
    boolean deleteById(Long id);
    boolean updateById(Long id, Company company);
}
