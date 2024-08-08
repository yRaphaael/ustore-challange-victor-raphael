package org.victor.raphael.desafio_1.models;

public class PolygonModel {

    //Variables declaration
    private double sideNumber;
    private double sideValue;
    private String polygonType;
    private double polygonArea;

    //Getters and setters
    public Double getPolygonArea() {
        return polygonArea;
    }

    public void setPolygonArea(Double polygonArea) {
        this.polygonArea = polygonArea;
    }

    public double getSideNumber() {
        return sideNumber;
    }

    public void setSideNumber(double sideNumber) {
        this.sideNumber = sideNumber;
    }

    public double getSideValue() {
        return sideValue;
    }

    public void setSideValue(double sideValue) {
        this.sideValue = sideValue;
    }

    public String getPolygonType() {
        return polygonType;
    }

    public void setPolygonType(String polygonType) {
        this.polygonType = polygonType;
    }
}