package co.com.company.equipment.repository;

import co.com.company.equipment.model.Equipment;
import org.springframework.data.repository.CrudRepository;

public interface EquipmentRepository extends CrudRepository<Equipment, String> {
}
