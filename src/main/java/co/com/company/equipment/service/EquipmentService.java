package co.com.company.equipment.service;

import co.com.company.equipment.model.Equipment;
import co.com.company.equipment.repository.EquipmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class EquipmentService {

    @Autowired
    private EquipmentRepository equipmentRepository;

    private final static String ACTIVE = "A";
    private final static String INACTIVE = "I";


    public void save(Equipment equipment) {
        equipment.setId(UUID.randomUUID().toString());
        equipment.setNumberYears(1);
        equipment.setState(ACTIVE);
        equipmentRepository.save(equipment);
    }

    public void update(Equipment equipment) {

        if ((equipment.getPurchaseDate().plusYears(equipment.getNumberYears())).isAfter(LocalDate.now())) {
            Double valuePercentage = equipment.getPurchaseValue() * 0.4;
            equipment.setPurchaseValue(equipment.getPurchaseValue() - valuePercentage);
            equipment.setNumberYears(equipment.getNumberYears() + 1);
        }


        equipmentRepository.save(equipment);
    }

    public void delete(String equipmentId) {
        Equipment equipment = findById(equipmentId);

        if (equipment.getId() != null) {
            equipment.setState(INACTIVE);
        }
    }

    public List<Equipment> findAll() {
        List<Equipment> equipmentList = (List<Equipment>) equipmentRepository.findAll();

        return equipmentList.stream()
                .filter(a -> a.getState().equals(ACTIVE))
                .collect(Collectors.toList());
    }

    public List<Equipment> findByCompanyId(String companyId) {
        return equipmentRepository.findByCompanyId(companyId).stream()
                .filter(a -> a.getState().equals(ACTIVE))
                .collect(Collectors.toList());
    }

    public Equipment findById(String equipmentId) {

        Optional<Equipment> equipment = equipmentRepository.findById(equipmentId);

        if (equipment.isPresent()) {
            return equipment.get();
        }
        return new Equipment();
    }
}
