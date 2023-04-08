package cs5004.animator.model;

import java.awt.geom.Point2D;

/**
 * Shape Interface defines all the supported operations for each shape.
 * 
 * @author eddie
 *
 */
public interface InterfaceShape {

  /**
   * Return the name.
   * 
   * @return name
   */
  String getName();

  /**
   * Return the shape type.
   * 
   * @return the shape type
   */
  ShapeType getType();

  /**
   * Get the width of the shape.
   * 
   * @return the width of the shape
   */
  double getWidth();

  /**
   * Get height of the shape.
   * 
   * @return height of the shape
   */
  double getHeight();

  /**
   * Get the position of the shape.
   * 
   * @return the position of the shape
   */
  Point2D getPosition();

  /**
   * Get the time of shape will appear.
   * 
   * @return the time of shape will appear
   */
  int getAppear();

  /**
   * Get the time of shape will disappear.
   * 
   * @return the time of shape will disappear
   */
  int getDisappear();

  /**
   * Set the position of the shape by given Point2D.
   * 
   * @param point include x y of the position as a Point2D type
   */
  void setPosition(Point2D point);

  /**
   * Set the width of the shape by given width.
   * 
   * @param w the width that the shape should be changed to
   */
  void setWidth(double w);

  /**
   * Set the height of the shape by given height.
   * 
   * @param h the height that the shape should be changed to
   */
  void setHeight(double h);

  /**
   * Set the appear time of the shape by given time.
   * 
   * @param t the time that the shape should be appear.
   */
  void setAppear(int t);

  /**
   * Set the disappear time of the shape by given time.
   * 
   * @param t the time that the shape should be disappear.
   */
  void setDisappear(int t);

  /**
   * Get the green of shape.
   * 
   * @return the green of shape
   */
  double getGreen();

  /**
   * Get the red of shape.
   * 
   * @return the red of shape
   */
  double getRed();

  /**
   * Get the blue of shape.
   * 
   * @return the blue of shape
   */
  double getBlue();

  /**
   * Set the red value of the shape.
   * 
   * @param newRed the red value that shape should be change
   */
  void setRed(double newRed);

  /**
   * Set the green value of the shape.
   * 
   * @param newGreen the green value that shape should be change
   */
  void setGreen(double newGreen);

  /**
   * Set the blue value of the shape.
   * 
   * @param newBlue the blue value that shape should be change
   */
  void setBlue(double newBlue);

}
