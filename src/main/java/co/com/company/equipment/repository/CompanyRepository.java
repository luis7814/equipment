package co.com.company.equipment.repository;

import co.com.company.equipment.model.Company;
import org.springframework.data.repository.CrudRepository;

public interface CompanyRepository extends CrudRepository<Company, String> {
}
