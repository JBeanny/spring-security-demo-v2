package com.example.demo_spring_security.dto.base;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder(value = {"code","message","description","data"})
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Response {
    @JsonProperty("code")
    private String code;

    @JsonProperty("message")
    private String message;

    @JsonProperty("description")
    private String description;

    @JsonProperty("data")
    private Object data;

    private Response(String code, String message, String description, Object data) {
        this.code = code;
        this.message = message;
        this.description = description;
        this.data = data;
    }

    private Response(String code, String message, String description) {
        this.code = code;
        this.message = message;
        this.description = description;
    }

    public static Response success(String message,String description,Object data) {
        return new Response("200",message,description,data);
    }

    public static Response success(String message,String description) {
        return new Response("200",message,description);
    }

    public static Response error(String code, String message, String description) {
        return new Response(code, message, description);
    }

    public static Response error(String code, String message, String description, Object data) {
        return new Response(code, message, description, data);
    }

    // Common error responses
    public static Response badRequest(String message, String description) {
        return new Response("400", message, description);
    }

    public static Response unauthorized(String message, String description) {
        return new Response("401", message, description);
    }

    public static Response forbidden(String message, String description) {
        return new Response("403", message, description);
    }

    public static Response notFound(String message, String description) {
        return new Response("404", message, description);
    }

    public static Response internalServerError(String message, String description) {
        return new Response("500", message, description);
    }
}
