
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import cs5004.animator.model.InterfaceModel;
import cs5004.animator.model.ModelImpl;
import cs5004.animator.model.ShapeType;
import cs5004.animator.view.InterfaceText;
import cs5004.animator.view.TextView;

/**
 * Test text view.
 * 
 * @author eddie
 *
 */
public class TextViewTest {
  private InterfaceText view;
  private InterfaceModel model;

  /**
   * Set up and instance variable.
   * 
   */
  @Before
  public void setUp() {
    model = new ModelImpl();
    model.addShape("R", ShapeType.RECTANGLE, 0, 0, 100, 100, 20, 20, 0, 100, 100);
    int speed = 10;
    view = new TextView(model, speed);
  }

  /**
   * Test render method.
   */
  @Test
  public void testRender() {
    assertEquals("Shape: \n" + "Name: R\n" + "Type: RECTANGLE\n"
        + "Min corner: (0.0,0.0), Width: 20.0, Height: 0.0, Color: (100.0, 100.0, 20.0)\n"
        + "Appears at time t=10 and disappears at time t=10\n", view.render());
  }

  /**
   * Test render method with certain speed.
   */
  @Test
  public void testRenderSpeed() {
    view = new TextView(model, 50);
    assertEquals("Shape: \n" + "Name: R\n" + "Type: RECTANGLE\n"
        + "Min corner: (0.0,0.0), Width: 20.0, Height: 0.0, Color: (100.0, 100.0, 20.0)\n"
        + "Appears at time t=2 and disappears at time t=2\n", view.render());
  }

  /**
   * Test render method with animation.
   */
  @Test
  public void testRenderAnimation() {
    model.move("R", 3, 10, 0, 0, 200, 200);
    assertEquals(
        "Shape: \n" + "Name: R\n" + "Type: RECTANGLE\n"
            + "Min corner: (0.0,0.0), Width: 20.0, Height: 0.0, Color: (100.0, 100.0, 20.0)\n"
            + "Appears at time t=10 and disappears at time t=10\n"
            + "Shape R moves from (0.0,200.0) to (0.0,200.0), from time t=0 to t=1\n",
        view.render());
  }

}
