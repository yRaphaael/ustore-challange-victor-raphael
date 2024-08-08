package org.victor.raphael.desafio_1.service;

import org.victor.raphael.desafio_1.models.PolygonModel;

public class PolygonService {

    private static final double ROUNDING_FACTOR = 100.0;
    private static final double PI = Math.PI;


    public void calculatePolygonArea(PolygonModel polygon) {

        //pickup sideNumber and sideValue to use after
        double sideValue = polygon.getSideValue();
        double sideNumber = polygon.getSideNumber();


        //calculate polygonArea using Math lib
        double polygonArea = (sideNumber * Math.pow(sideValue, 2)) / (4 * Math.tan(PI / sideNumber));

        double roundResult = Math.round(polygonArea * ROUNDING_FACTOR) / ROUNDING_FACTOR;

        polygon.setPolygonArea(roundResult);

        determinePolygonType(polygon);
    }

    //verify the polygon type
    public void determinePolygonType(PolygonModel polygon) {
        double sideNumber = polygon.getSideNumber();
        if (sideNumber == 3) {
            polygon.setPolygonType("Triângulo");
        } else if (sideNumber == 4) {
            polygon.setPolygonType("Quadrado");
        } else {
            polygon.setPolygonType("Polígono com " + (int) sideNumber + " lados");
        }
    }

}
