
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import cs5004.animator.model.InterfaceModel;
import cs5004.animator.model.ModelImpl;
import cs5004.animator.model.ShapeType;

/**
 * Test the ModelImpl.
 * 
 * @author eddie
 *
 */
public class ModelImplTest {
  private InterfaceModel model;

  /**
   * Set up and instance variable.
   * 
   */
  @Before
  public void setUp() {

    model = new ModelImpl();
    model.addShape("A", ShapeType.RECTANGLE, 0, 0, 1, 1, 1, 10, 20, 0, 100);
    model.addShape("B", ShapeType.OVAL, 0, 0, 1, 1, 1, 10, 20, 0, 100);
  }

  /**
   * Test getShape method is work well.
   */
  @Test
  public void testGetShape() {
    assertEquals(
        "Name: A\n" + "Type: RECTANGLE\n"
            + "Min corner: (0.0,0.0), Width: 10.0, Height: 20.0, Color: (1.0, 1.0, 1.0)\n",
        model.getShape("A").toString());
    assertEquals(
        "Name: B\n" + "Type: OVAL\n"
            + "Min corner: (0.0,0.0), Width: 10.0, Height: 20.0, Color: (1.0, 1.0, 1.0)\n",
        model.getShape("B").toString());
  }

  /**
   * Test getAnimation method is work well.
   */
  @Test
  public void testGetAnimation() {
    assertEquals("[]", model.getAnimation("A").toString());
    assertEquals("[]", model.getAnimation("B").toString());
    model.changeColor("A", 10, 20, 1, 1, 1, 20, 20, 20);
    assertEquals("[Shape A changes color from (1,1,1) to (20,20,20)]",
        model.getAnimation("A").toString());
  }

  /**
   * Test getShapeList method is work well.
   */
  @Test
  public void testGetShapeList() {
    assertEquals(
        "{A=Name: A\n" + "Type: RECTANGLE\n"
            + "Min corner: (0.0,0.0), Width: 10.0, Height: 20.0, Color: (1.0, 1.0, 1.0)\n"
            + ", B=Name: B\n" + "Type: OVAL\n"
            + "Min corner: (0.0,0.0), Width: 10.0, Height: 20.0, Color: (1.0, 1.0, 1.0)\n" + "}",
        model.getShapeList().toString());
  }

  /**
   * Test changeColor method is work well.
   */
  @Test
  public void testChangeColor() {
    model.changeColor("A", 10, 20, 1, 1, 1, 20, 20, 20);
    model.changeColor("B", 10, 20, 1, 1, 1, 15, 35, 65);
    assertEquals("[Shape A changes color from (1,1,1) to (20,20,20)]",
        model.getAnimation("A").toString());
    assertEquals("[Shape B changes color from (1,1,1) to (15,35,65)]",
        model.getAnimation("B").toString());
  }

  /**
   * Test changeScale is work well.
   */
  @Test
  public void testChangeScale() {
    model.changeScale("A", 40, 50, 10, 20, 12, 22);
    model.changeScale("B", 40, 50, 10, 20, 50, 60);
    assertEquals("[Shape A scales from Width: 10.0, Height: 20.0 to Width: 12.0, Height: 22.0]",
        model.getAnimation("A").toString());
    assertEquals("[Shape B scales from Width: 10.0, Height: 20.0 to Width: 50.0, Height: 60.0]",
        model.getAnimation("B").toString());
  }

  /**
   * Test move method is work well.
   */
  @Test
  public void testMove() {
    model.move("A", 10, 20, 5, 5, 10, 10);
    model.move("B", 20, 40, 10, 10, 10, 21);
    assertEquals("[Shape A moves from (5.0,10.0) to (5.0,10.0)]",
        model.getAnimation("A").toString());
    assertEquals("[Shape B moves from (10.0,10.0) to (10.0,21.0)]",
        model.getAnimation("B").toString());
  }

}
