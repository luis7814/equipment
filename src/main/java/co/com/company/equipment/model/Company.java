package co.com.company.equipment.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.io.Serializable;

@Entity
@Data
public class Company implements Serializable {

    @Id
    private String id;
    private String name;
    private String description;
}
