package co.com.company.equipment.service;

import co.com.company.equipment.model.Equipment;
import co.com.company.equipment.repository.EquipmentRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

class EquipmentServiceTest {
    @Mock
    EquipmentRepository equipmentRepository;
    @InjectMocks
    EquipmentService equipmentService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSave() {
        equipmentService.save(new Equipment());
    }

    @Test
    void testUpdate() {
        equipmentService.update(equipmentData());
    }

    @Test
    void testDelete() {
        equipmentService.delete("1");
    }

    @Test
    void testFindAll() {
        List<Equipment> result = equipmentService.findAll();
        Assertions.assertNotNull(result);
    }

    @Test
    void testFindByCompanyId() {
        when(equipmentRepository.findByCompanyId(anyString())).thenReturn(equipmentDataList());

        List<Equipment> result = equipmentService.findByCompanyId("1");
        Assertions.assertNotNull(result);
        Assertions.assertEquals("1", equipmentDataList().get(0).getId());
    }

    @Test
    void testFindById() {
        Equipment result = equipmentService.findById("1");
        Assertions.assertEquals(new Equipment(), result);
    }

    private Equipment equipmentData() {

        Equipment equipment = new Equipment();
        equipment.setId("1");
        equipment.setState("A");
        equipment.setNumberYears(1);
        equipment.setPurchaseValue(120.0);
        equipment.setName("CAR");
        equipment.setDescription("CAR");
        equipment.setSerial("123-9");
        equipment.setCompanyId("1");
        equipment.setPurchaseDate(LocalDate.now());

        return equipment;
    }

    private List<Equipment> equipmentDataList() {
        List<Equipment> equipmentList = new ArrayList<>();
        equipmentList.add(equipmentData());
        return equipmentList;
    }
}