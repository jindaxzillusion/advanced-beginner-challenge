package cs5004.animator.model;

import java.awt.geom.Point2D;

/**
 * The oval shape.
 * 
 * @author eddie
 *
 */
public class Oval extends AbstractShape {

  /**
   * Initialize a rectangle by given arguments.
   * 
   * @param name       the name of this shape
   * @param shapetype  the type of the shape
   * @param position   the position of the shape
   * @param width      the width of the shape
   * @param height     the height of the shape
   * @param appearT    the appearT of the shape
   * @param disappearT the disappearT of the shape
   * @throws IllegalArgumentException if the width and height is negative number
   *                                  or position is null
   */
  public Oval(String name, ShapeType shapetype, Point2D position, double red, double green,
      double blue, double width, double height, int appearT, int disappearT)
      throws IllegalArgumentException {
    super(name, shapetype, position, red, green, blue, width, height, appearT, disappearT);
  }

  /**
   * Initialize a rectangle without argument.
   */
  public Oval() {
    super();
  }

}
