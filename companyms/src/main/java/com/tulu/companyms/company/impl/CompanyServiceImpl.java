package com.tulu.companyms.company.impl;

import com.tulu.companyms.company.Company;
import com.tulu.companyms.company.CompanyRepository;
import com.tulu.companyms.company.CompanyService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyServiceImpl implements CompanyService {
//    private List<Company> companies = new ArrayList<>();
    CompanyRepository companyRepository;
//    private Long id = 1L;

    public CompanyServiceImpl(CompanyRepository companyRepository){
        this.companyRepository = companyRepository;
    }

    public List<Company> findAll() {
        return companyRepository.findAll();
    }

    public Company findById(Long id){
//        for(int i=0;i<companies.size();i++){
//            if(companies.get(i).getId().equals(id)){
//                return companies.get(i);
//            }
//        }
//        return null;

        return companyRepository.findById(id).orElse(null);
    }

    public boolean addCompany(Company company){
//        company.setId(id++);
        companyRepository.save(company);
        return true;
    }

    public boolean deleteById(Long id){
//        Iterator<Company> iterator = companies.iterator();
//
//        while(iterator.hasNext()){
//            if(iterator.next().getId().equals(id)){
//                iterator.remove();
//                return true;
//            }
//        }
//        return false;
        try {
            companyRepository.deleteById(id);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public boolean updateById(Long id, Company company) {
//        Iterator<Company> iterator = companies.iterator();
//        company.setId(id);
//
//        for(int i=0;i<companies.size();i++){
//            if(companies.get(i).getId().equals(id)){
//                companies.set(i, company);
//                return true;
//            }
//        }
//        return false;
//    }

        Optional<Company> foundCompany = companyRepository.findById(id);
        if (foundCompany.isPresent()) {
            Company comp = foundCompany.get();
            comp.setName(company.getName());
            comp.setDescription(company.getDescription());
            companyRepository.save(comp);
            return true;
        }
        return false;
    }
}
