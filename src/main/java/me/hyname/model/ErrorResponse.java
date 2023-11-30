package me.hyname.model;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "error")
public class ErrorResponse {


    @XmlElement(name = "status")
    private int id;

    @XmlElement(name = "description")
    private String description;

    @XmlElement(name = "causedBy")
    private String causedBy;

    public ErrorResponse(int id, String description) {
        this.id = id;
        this.description = description;
    }

    public ErrorResponse(int id, String description, String causedBy) {
        this.id = id;
        this.description = description;
        this.causedBy = causedBy;
    }

    public ErrorResponse() {

    }
}
