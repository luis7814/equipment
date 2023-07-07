package co.com.company.equipment.service;

import co.com.company.equipment.model.Company;
import co.com.company.equipment.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    public void save(Company company) {
        company.setId(UUID.randomUUID().toString());
        companyRepository.save(company);
    }
}
