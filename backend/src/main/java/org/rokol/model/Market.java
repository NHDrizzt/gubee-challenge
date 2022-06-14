package org.rokol.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import org.yaml.snakeyaml.error.Mark;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Market extends PanacheEntity {

    private String name;
    private String description;

    public Market() {
    }

    public Market(String name, String description) {
        this.description = description;
        this.name = name;
    }

    public Market id(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Market name(String name) {
        this.name = name;
        return this;
    }

    public Market surname(String description) {
        this.description = description;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Market)) return false;
        Market market = (Market) o;
        return Objects.equals(getName(), market.getName()) && Objects.equals(getDescription(), market.getDescription());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getDescription());
    }
}