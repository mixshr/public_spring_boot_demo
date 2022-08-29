package com.project.integrated.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Objects;
import java.util.UUID;

@Data
@Table(name = "quantity_in_warehouse")
@Entity(name = "quantity_in_warehouse")
public class Quantity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double quantity;

    private UUID nomenclature;

    private UUID warehouse;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "nomenclature", insertable = false, updatable = false, referencedColumnName = "id")
    private Nomenclature nomenclatureObject;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "warehouse", insertable = false, updatable = false, referencedColumnName = "id")
    private Warehouse warehouseObject;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Quantity quantity = (Quantity) o;
        return nomenclature.equals(quantity.nomenclature) && warehouse.equals(quantity.warehouse);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nomenclature, warehouse);
    }
}