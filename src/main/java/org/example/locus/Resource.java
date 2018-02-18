package org.example.locus;


import com.fasterxml.jackson.annotation.JsonValue;

public enum Resource {
    A(1),
    B(2),
    C(3);

    private int id;

    private Resource(int id) {
        this.id = id;
    }

    public static Resource getType(Integer id) {

        if (id == null) {
            return null;
        }

        for (Resource position : Resource.values()) {
            if (id.equals(position.getId())) {
                return position;
            }
        }
        throw new IllegalArgumentException("No matching type for id " + id);
    }

    public int getId() {
        return id;
    }

    @JsonValue
    public String getType() {
        return this.name();
    }
}
