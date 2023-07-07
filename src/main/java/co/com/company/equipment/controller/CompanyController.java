package co.com.company.equipment.controller;

import co.com.company.equipment.model.Company;
import co.com.company.equipment.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CompanyController {

    @Autowired
    private CompanyService companyService;


    @PostMapping("/company")
    public void save(@RequestBody Company company) {
        companyService.save(company);
    }
}
