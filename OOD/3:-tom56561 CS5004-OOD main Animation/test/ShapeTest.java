
import static org.junit.Assert.assertEquals;

import java.awt.geom.Point2D;

import org.junit.Before;
import org.junit.Test;

import cs5004.animator.model.Oval;
import cs5004.animator.model.Rectangle;
import cs5004.animator.model.ShapeType;

/**
 * Test shape class.
 * 
 * @author eddie
 *
 */
public class ShapeTest {

  private Rectangle rectangle;
  private Oval oval;

  /**
   * Set up and instance variable.
   * 
   */
  @Before
  public void setUp() {
    rectangle = new Rectangle("A", ShapeType.RECTANGLE, new Point2D.Double(200, 200), 50, 100, 1.0,
        6.0, 6.0, 10, 50);
    oval = new Oval("B", ShapeType.OVAL, new Point2D.Double(500, 100), 60, 30, 0.0, 5.0, 5.0, 0,
        100);
  }

  /**
   * Test the get type method.
   */
  @Test
  public void testGetType() {
    assertEquals(rectangle.getType(), ShapeType.RECTANGLE);
    assertEquals(oval.getType(), ShapeType.OVAL);
  }

  /**
   * Test get name method.
   */
  @Test
  public void testGetName() {
    assertEquals(rectangle.getName(), "A");
    assertEquals(oval.getName(), "B");
  }

  /**
   * Test get width method.
   */
  @Test
  public void testGetWidth() {
    assertEquals(rectangle.getWidth(), 6.0, 0.001);
    assertEquals(oval.getWidth(), 5.0, 0.001);
  }

  /**
   * Test get height method.
   */
  @Test
  public void testGetHeight() {
    assertEquals(rectangle.getHeight(), 6.0, 0.001);
    assertEquals(oval.getHeight(), 5.0, 0.001);
  }

  /**
   * Test get position method.
   */
  @Test
  public void testGetPosition() {
    assertEquals(rectangle.getPosition(), new Point2D.Double(200, 200));
    assertEquals(oval.getPosition(), new Point2D.Double(500, 100));
  }

  /**
   * Test get appear method.
   */
  @Test
  public void testGetAppear() {
    assertEquals(rectangle.getAppear(), 10, 0.001);
    assertEquals(oval.getAppear(), 0, 0.001);
  }

  /**
   * Test get disappear method.
   */
  @Test
  public void testGetDisappear() {
    assertEquals(rectangle.getDisappear(), 50, 0.001);
    assertEquals(oval.getDisappear(), 100, 0.001);
  }

  /**
   * Test set position method.
   */
  @Test
  public void testSetPosition() {
    rectangle.setPosition(new Point2D.Double(600, 400));
    oval.setPosition(new Point2D.Double(10, 20));
    assertEquals(rectangle.getPosition(), new Point2D.Double(600, 400));
    assertEquals(oval.getPosition(), new Point2D.Double(10, 20));
  }

  /**
   * Test to String method.
   */
  @Test
  public void testToString() {
    assertEquals(rectangle.toString(), "Name: A\n" + "Type: RECTANGLE\n"
        + "Min corner: (200.0,200.0), Width: 6.0, Height: 6.0, Color: (50.0, 100.0, 1.0)\n");
    assertEquals(oval.toString(), "Name: B\n" + "Type: OVAL\n"
        + "Min corner: (500.0,100.0), Width: 5.0, Height: 5.0, Color: (60.0, 30.0, 0.0)\n");

  }

}
