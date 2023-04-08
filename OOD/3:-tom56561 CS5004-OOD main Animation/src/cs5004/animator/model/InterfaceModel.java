package cs5004.animator.model;

import java.util.ArrayList;
import java.util.Map;

/**
 * Shape Interface defines all the supported operations for model.
 * 
 * @author eddie
 *
 */
public interface InterfaceModel {

  /**
   * Get shape from the shapeMap by passing name.
   * 
   * @param name the name of the shape
   * @return the mapping shape
   */
  InterfaceShape getShape(String name);

  /**
   * Get the shapeMap.
   * 
   * @return the new shapeMap
   */
  Map getShapeList();

  /**
   * Get the animationMap.
   * 
   * @return the new animationMap
   */
  Map getAllAnimationMap();

  /**
   * Get animation from the hashmap bu passing name.
   * 
   * @param name the name of the shape
   * @return the mapping animations
   */
  ArrayList<InterfaceAnimation> getAnimation(String name);

  /**
   * Initialize a new shape and add shape into the shapeMap and animationMap.
   * 
   * @param name       the name of the shape
   * @param shapetype  the type of the shape
   * @param x          the x position of the shape
   * @param y          the y position of the shape
   * @param r1         the red color of the shape
   * @param g1         the greeen color of the shape
   * @param b1         the blue color of the shape
   * @param width      the width of the shape
   * @param height     the height of the shape
   * @param appearT    the appear time of the shape
   * @param disappearT the disappear time of of the shape
   */
  void addShape(String name, ShapeType shapetype, double x, double y, int r1, int g1, int b1,
      double width, double height, int appearT, int disappearT);

  /**
   * Change the shape color.
   * 
   * @param name      the name of the shape
   * @param startTime the start time for changing
   * @param endTime   the end time for changing
   * @param r1        the red color of the shape
   * @param g1        the greeen color of the shape
   * @param b1        the blue color of the shape
   * @param r2        the red color of the shape after changing
   * @param g2        the greeen color of the shape after changing
   * @param b2        the blue color of the shape after changing
   */
  void changeColor(String name, int startTime, int endTime, int r1, int g1, int b1, int r2, int g2,
      int b2);

  /**
   * Change the shape scale.
   * 
   * @param name      the name of the shape
   * @param startTime the start time for changing
   * @param endTime   the end time for changing
   * @param startW    the start width of the shape
   * @param startH    the start height of the shape
   * @param endW      the end width of the shape
   * @param endH      the end height of the shape
   */
  void changeScale(String name, int startTime, int endTime, double startW, double startH,
      double endW, double endH);

  /**
   * Change the shape position.
   * 
   * @param name      the name of the shape
   * @param startTime the start time for changing
   * @param endTime   the end time for changing
   * @param startx    the start x position
   * @param endx      the end x position
   * @param starty    the start y position
   * @param endy      the end y position
   */
  void move(String name, int startTime, int endTime, double startx, double endx, double starty,
      double endy);

  /**
   * Set the bound width and Height.
   * 
   * @param w the width
   * @param h the Height
   */
  void setBoundWandH(int w, int h);

  /**
   * Get the width of bound.
   * 
   * @return the width of bound
   */
  int getBoundW();

  /**
   * Get the Height of bound.
   * 
   * @return the Height of bound
   */
  int getBoundH();

  /**
   * Get the last disappear time.
   * 
   * @return the last disappear time
   */
  int getMaxEndingTime();

  /**
   * Get the all shapes of animation.
   * 
   * @param frame the frame we want to animate
   * @return the shapesAtFrame
   */
  ArrayList<InterfaceShape> getAllShapes(int frame);

}
