package co.com.company.equipment.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Data
public class Equipment implements Serializable {

    @Id
    private String id;
    private String name;
    private String description;
    private String serial;
    private LocalDate purchaseDate;
    private Integer purchaseValue;
    private String state;

}
