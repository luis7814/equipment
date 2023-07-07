package co.com.company.equipment.controller;

import co.com.company.equipment.model.Company;
import co.com.company.equipment.service.CompanyService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

class CompanyControllerTest {
    @Mock
    CompanyService companyService;
    @InjectMocks
    CompanyController companyController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSave() {
        companyController.save(new Company());
    }
}

