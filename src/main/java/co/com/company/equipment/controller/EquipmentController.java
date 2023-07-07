package co.com.company.equipment.controller;

import co.com.company.equipment.model.Equipment;
import co.com.company.equipment.service.EquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EquipmentController {

    @Autowired
    private EquipmentService equipmentService;

    @PostMapping("/equipment")
    public void save(Equipment equipment) {
        equipmentService.save(equipment);
    }

    @PutMapping("/equipment")
    public void update(Equipment equipment) {
        equipmentService.update(equipment);
    }

    @GetMapping("/equipment/company")
    public List<Equipment> findByCompanyId(@RequestParam("companyId") String companyId) {
        return equipmentService.findByCompanyId(companyId);
    }

    @GetMapping("/equipment")
    public List<Equipment> findAll() {
        return equipmentService.findAll();
    }

    @GetMapping("/equipment/{id}")
    public Equipment findById(@PathVariable String id) {
        return equipmentService.findById(id);
    }

    @DeleteMapping("/equipment/{id}")
    public void delete(@PathVariable String id) {
        equipmentService.delete(id);
    }

}
