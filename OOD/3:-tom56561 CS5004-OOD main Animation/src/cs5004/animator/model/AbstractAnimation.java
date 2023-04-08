package cs5004.animator.model;

import java.util.Map;

/**
 * AbstractShape is abstract class for animation and implement all method in
 * shape interface. The class will be extended by Scale, Move, and ChangeColor.
 * 
 * @author eddie
 *
 */
public class AbstractAnimation implements InterfaceAnimation {

  protected int startTime;
  protected int endTime;
  protected String name;
  protected AnimationType aniType;
  protected InterfaceShape shape;
  protected Map shapeMap;

  /**
   * Construct that initialize the field by given arguments.
   * 
   * @param shapeMap  map name : shape
   * @param aniType   the animation type of shape
   * @param name      the name of shape
   * @param startTime the animation start time
   * @param endTime   the animation end time
   */
  public AbstractAnimation(Map shapeMap, AnimationType aniType, String name, int startTime,
      int endTime) {
    this.shapeMap = shapeMap;
    this.aniType = aniType;
    this.name = name;
    this.startTime = startTime;
    this.endTime = endTime;
    this.shape = (InterfaceShape) this.shapeMap.get(this.name);
  }

  @Override
  public String getName() {
    return this.name;
  }

  @Override
  public AnimationType getType() {
    return this.aniType;
  }

  @Override
  public int getStartTime() {
    return this.startTime;
  }

  @Override
  public int getEndTime() {
    return this.endTime;
  }

  @Override
  public void performAction(int frame) {
    return;
  }

  @Override
  public double tweening(double changeFrom, double changeTo, int startTime, int endTime, double t) {
    return changeFrom * ((endTime - t) / (endTime - startTime))
        + changeTo * ((t - startTime) / (this.endTime - startTime));
  }
  
}
