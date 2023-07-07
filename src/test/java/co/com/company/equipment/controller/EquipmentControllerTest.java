package co.com.company.equipment.controller;

import co.com.company.equipment.model.Equipment;
import co.com.company.equipment.service.EquipmentService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.mockito.Mockito.*;

class EquipmentControllerTest {
    @Mock
    EquipmentService equipmentService;
    @InjectMocks
    EquipmentController equipmentController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSave() {
        equipmentController.save(new Equipment());
    }

    @Test
    void testUpdate() {
        equipmentController.update(new Equipment());
    }

    @Test
    void testFindByCompanyId() {
        when(equipmentService.findByCompanyId(anyString())).thenReturn(List.of(new Equipment()));

        List<Equipment> result = equipmentController.findByCompanyId("1");
        Assertions.assertEquals(List.of(new Equipment()), result);
    }

    @Test
    void testFindAll() {
        when(equipmentService.findAll()).thenReturn(List.of(new Equipment()));

        List<Equipment> result = equipmentController.findAll();
        Assertions.assertEquals(List.of(new Equipment()), result);
    }

    @Test
    void testFindById() {
        when(equipmentService.findById(anyString())).thenReturn(new Equipment());

        Equipment result = equipmentController.findById("1");
        Assertions.assertEquals(new Equipment(), result);
    }

    @Test
    void testDelete() {
        equipmentController.delete("1");
    }
}
