package project.commerce.stockcontrol.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.hibernate.annotations.CreationTimestamp;


import java.time.LocalDateTime;

@Entity
@Table(name = "ingredient")
public class Ingredient {
    @Id
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    private String name;
    private double quantityInStock;
    private String unity;
    private String slug;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @CreationTimestamp
    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;


    public Ingredient(Long id, String name, double quantityInStock, String unity, String slug) {
        this.id = id;
        this.name = name;
        this.quantityInStock = quantityInStock;
        this.unity = unity;
        this.slug = slug;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    public Ingredient() {

    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setUnity(String unity) {
        this.unity = unity;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getQuantityInStock() {
        return quantityInStock;
    }

    public String getUnity() {
        return unity;
    }

    public void setQuantityInStock(double quantityInStock) {
        this.quantityInStock = quantityInStock;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public void setUpdatedAt() {
        this.updatedAt = LocalDateTime.now();
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public String getSlug() {
        return slug;
    }


//    @Override
//    public boolean equals(Object obj) {
//        if (this == obj) return true;
//        if (obj == null || getClass() != obj.getClass()) return false;
//        Ingredient ingredient = (Ingredient) obj;
//        return Double.compare(ingredient.quantityInStock, quantityInStock) == 0 &&
//                id.equals(ingredient.id) &&
//                name.equals(ingredient.name);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(id, name, quantityInStock);
//    }
}

