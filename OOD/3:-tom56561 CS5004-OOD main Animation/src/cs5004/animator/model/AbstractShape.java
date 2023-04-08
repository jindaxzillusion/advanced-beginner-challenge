package cs5004.animator.model;

import java.awt.geom.Point2D;

/**
 * AbstractShape is abstract class for shape and implement all method in shape
 * interface. The class will be extended by rectangle and oval.
 * 
 * @author eddie
 *
 */
public class AbstractShape implements InterfaceShape {

  protected String name;
  protected ShapeType shapetype;
  protected Point2D position;
  protected double width;
  protected double height;
  protected int appearT;
  protected int disappearT;
  protected double green;
  protected double red;
  protected double blue;

  /**
   * Construct that initialize the field by given arguments.
   * 
   * @param name       the name of this shape
   * @param shapetype  the shapetype of the shape
   * @param position   the position of the shape
   * @param color      the color of the shape
   * @param width      the width of the shape
   * @param height     the height of the shape
   * @param appearT    the appearT of the shape
   * @param disappearT the disappearT of the shape
   * @throws IllegalArgumentException if the width and height is negative number
   *                                  or position is null
   */
  protected AbstractShape(String name, ShapeType shapetype, Point2D position, double red,
      double green, double blue, double width, double height, int appearT, int disappearT)
      throws IllegalArgumentException {
    if (position == null || width < 0 || height < 0) {
      throw new IllegalArgumentException("Input data is invalid, cannot build a shape");
    }
    this.name = name;
    this.shapetype = shapetype;
    this.position = position;
    this.green = green;
    this.red = red;
    this.blue = blue;
    this.width = width;
    this.height = height;
    this.appearT = appearT;
    this.disappearT = disappearT;
  }

  /**
   * Construct that initialize the field without argument passed in.
   */
  protected AbstractShape() {
    this("default", ShapeType.RECTANGLE, new Point2D.Double(0, 0), 0, 0, 0, 0, 0, 0, 0);
  }

  @Override
  public String getName() {
    return this.name;
  }

  @Override
  public ShapeType getType() {
    return this.shapetype;
  }

  @Override
  public double getWidth() {
    return this.width;
  }

  @Override
  public double getHeight() {
    return this.height;
  }

  @Override
  public Point2D getPosition() {
    return this.position;
  }

  @Override
  public int getAppear() {
    return this.appearT;
  }

  @Override
  public int getDisappear() {
    return this.disappearT;
  }

  @Override
  public void setPosition(Point2D point) {
    this.position = point;
  }

  @Override
  public void setRed(double newRed) {
    this.red = newRed;
  }

  @Override
  public void setGreen(double newGreen) {
    this.green = newGreen;
  }

  @Override
  public void setBlue(double newBlue) {
    this.blue = newBlue;
  }

  @Override
  public void setWidth(double w) {
    if (w < 0) {
      throw new IllegalArgumentException("Can not pass a negative width");
    }
    this.width = w;
  }

  @Override
  public void setHeight(double h) {
    if (h < 0) {
      throw new IllegalArgumentException("Can not pass a negative height");
    }
    this.height = h;
  }

  @Override
  public String toString() {
    return "Name: " + this.getName() + "\nType: " + this.getType().toString() + "\nMin corner: ("
        + this.position.getX() + "," + this.position.getY() + "), Width: " + this.getWidth()
        + ", Height: " + this.getHeight() + ", Color: (" + this.red + ", " + this.green + ", "
        + this.blue + ")\n";
  }

  @Override
  public void setAppear(int t) {
    this.appearT = t;
  }

  @Override
  public void setDisappear(int t) {
    this.disappearT = t;
  }

  @Override
  public double getGreen() {
    return this.green;
  }

  @Override
  public double getRed() {
    return this.red;
  }

  @Override
  public double getBlue() {
    return this.blue;
  }

}
