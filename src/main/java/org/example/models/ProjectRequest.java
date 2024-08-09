package org.example.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ProjectRequest {
        private String name;
        private int value;
        private int clientId;

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

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    @JsonCreator
        public ProjectRequest(
                @JsonProperty("name") String name,
                @JsonProperty("value") int value,
                @JsonProperty("client")int clientId) {
            this.name = name;
            this.value = value;
            this.clientId = clientId;
        }
}
