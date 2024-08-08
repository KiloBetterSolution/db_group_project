package org.example.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ProjectRequest {
        private String name;
        private int value;
        private int client_id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getClient_id() {
        return client_id;
    }

    public void setClient_id(int client_id) {
        this.client_id = client_id;
    }

    @JsonCreator
        public ProjectRequest(
                @JsonProperty("name") String name,
                @JsonProperty("value") int value,
                @JsonProperty("client")int client_id) {
            this.name = name;
            this.value = value;
            this.client_id = client_id;
        }
}
