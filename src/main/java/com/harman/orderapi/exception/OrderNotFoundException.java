package com.harman.orderapi.exception;
public class OrderNotFoundException extends Exception {
private String id;
public OrderNotFoundException(Long id) {
        super(String.format("Order is not found with id : '%s'", id));
        }
}