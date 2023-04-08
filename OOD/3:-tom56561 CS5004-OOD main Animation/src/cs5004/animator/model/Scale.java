package cs5004.animator.model;

import java.util.Map;

/**
 * The class represent scale animation.
 * 
 * @author eddie
 *
 */
public class Scale extends AbstractAnimation {
  private double startW;
  private double startH;
  private double endW;
  private double endH;

  /**
   * Construct that initialize the field by given arguments.
   * 
   * @param shapeMap  map name : shape
   * @param aniType   the animation type of shape
   * @param name      the name of shape
   * @param startTime the animation start time
   * @param endTime   the animation end time
   * @param startW    the original width
   * @param startH    the original height
   * @param endW      the end width
   * @param endH      the end height
   */
  public Scale(Map shapeMap, AnimationType aniType, String name, int startTime, int endTime,
      double startW, double startH, double endW, double endH) {
    super(shapeMap, aniType, name, startTime, endTime);
    this.startW = startW;
    this.startH = startH;
    this.endW = endW;
    this.endH = endH;
  }

  /**
   * Change the scale.
   */
  public void setScale() {
    this.shape.setHeight(this.endH);
    this.shape.setWidth(this.endW);
  }

  @Override
  public void performAction(int frame) {

    InterfaceShape shape = (InterfaceShape) this.shapeMap.get(this.name);
    shape.setHeight(
        tweening(this.startH, this.endH, this.startTime, this.endTime, frame));
    shape.setWidth(
        tweening(this.startW, this.endW, this.startTime, this.endTime, frame));

  }

  @Override
  public String toString() {

    return "Shape " + this.name + " scales from Width: " + this.startW + ", Height: " + this.startH
        + " to Width: " + this.endW + ", Height: " + this.endH;
  }
}
