package org.victor.raphael.desafio_1.manager;

import org.victor.raphael.desafio_1.models.PolygonModel;
import org.victor.raphael.desafio_1.service.PolygonService;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class PolygonManager {

    private final PolygonService polygonService = new PolygonService();
    private final List<PolygonModel> polygons = new ArrayList<>();

    private static final double ROUNDING_FACTOR = 100.0;


    public void run() {

        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
                System.out.println("Digite o número de lados de um polígono, ou '0' para calcular as áreas: ");
                double sideNumber = scanner.nextDouble();

                // Verify if the polygons list is empty and request to insert at least one number
                if (sideNumber == 0 && polygons.isEmpty()) {
                    throw new RuntimeException("Por favor, insira pelo menos um polígono antes de calcular as devidas áreas");
                }

                // Verify if the value is 0 after a polygon has been inserted
                if (sideNumber == 0) {
                    break;
                }

                System.out.println("Digite o valor dos lados: ");
                double sideValue = scanner.nextDouble();

                // Use the new method to validate the side values
                validateSideValuesAndSideNumbers(sideValue, sideNumber);

                PolygonModel polygon = new PolygonModel();
                polygon.setSideValue(sideValue);
                polygon.setSideNumber(sideNumber);
                polygonService.calculatePolygonArea(polygon);
                polygons.add(polygon);

            }
            // Verify if the input is different from a double
            catch (InputMismatchException e) {
                System.out.println("Erro: Entrada inválida. Por favor, insira um número válido.");
                scanner.next();

                // Return the error to the user
            } catch (RuntimeException e) {
                System.out.println("Error: " + e.getMessage());

                // Return an expected result to the user
            } catch (Exception e) {
                System.out.println("Ocorreu um erro inesperado: " + e.getMessage());
            }
        }

        displayAreas();
    }

    //method to validate side values and side numbers
    private void validateSideValuesAndSideNumbers(double sideValue, double sideNumber) {
        if (sideValue <= 0 || sideNumber <= 0) {
            throw new RuntimeException("Por favor, digite um valor válido que esteja acima de 0");
        }
    }

    // Method to calculate the areas from each polygon and the total area
    private void displayAreas() {
        double totalArea = 0;

        for (PolygonModel polygon : polygons) {
            double area = polygon.getPolygonArea();
            totalArea += area;

            System.out.println(polygon.getPolygonType() + " de lado " + polygon.getSideValue() + "cm e área " + area + "cm²");
        }

        totalArea = Math.round(totalArea * ROUNDING_FACTOR) / ROUNDING_FACTOR;
        System.out.println("Área total: " + totalArea + "cm²");
    }
}
