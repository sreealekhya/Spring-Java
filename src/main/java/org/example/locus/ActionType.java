package org.example.locus;


import com.fasterxml.jackson.annotation.JsonValue;

import java.io.Serializable;

public enum ActionType implements Serializable{
    WRITE(1),
    READ(2),
    DELETE(3);

    private int id;

    private ActionType(int id) {
        this.id = id;
    }

    public static ActionType getType(Integer id) {

        if (id == null) {
            return null;
        }

        for (ActionType position : ActionType.values()) {
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
