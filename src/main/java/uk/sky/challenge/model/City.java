package uk.sky.challenge.model;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class City {

    @Id
    private String name;

    public City() {}

    public City(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof City) {
            return ((City) obj).getName().equals(this.getName());
        }
        return false;
    }
}
