package desafio_1_test.unit_tests;

import org.junit.Before;
import org.junit.Test;
import org.victor.raphael.desafio_1.models.PolygonModel;
import org.victor.raphael.desafio_1.service.PolygonService;

import static org.junit.Assert.assertEquals;

public class PolygonsTest {

    private PolygonService polygonService;
    private PolygonModel polygon;


    @Before
    public void setUp() {
        polygonService = new PolygonService();
        polygon = new PolygonModel();
    }

    @Test
    public void testCalculateTriangleArea() {
        polygon.setSideNumber(3);
        polygon.setSideValue(15);

        polygonService.calculatePolygonArea(polygon);

        assertEquals("Triângulo", polygon.getPolygonType());
        assertEquals(97.43, polygon.getPolygonArea(), 0.01);
    }

    @Test
    public void testCalculateSquareArea() {
        polygon.setSideNumber(4);
        polygon.setSideValue(10);

        polygonService.calculatePolygonArea(polygon);

        assertEquals("Quadrado", polygon.getPolygonType());
        assertEquals(100.00, polygon.getPolygonArea(), 0.01);
    }

    @Test
    public void testCalculatePolygon() {
        polygon.setSideNumber(5);
        polygon.setSideValue(10);

        polygonService.calculatePolygonArea(polygon);

        assertEquals("Polígono com 5 lados", polygon.getPolygonType());
        assertEquals(172.05, polygon.getPolygonArea(), 0.01);
    }

    @Test
    public void testNegativeSideValue() {
        try {
            polygon.setSideNumber(-3);
            polygon.setSideValue(-15);

            polygonService.calculatePolygonArea(polygon);
        } catch (RuntimeException e) {
            assertEquals("por favor, digite um valor válido que esteja acima de 0", e.getMessage());
        }
    }


}
