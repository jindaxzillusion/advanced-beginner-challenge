package cs5004.animator.model;

import java.awt.Color;
import java.util.Map;

/**
 * The class represent color change animation.
 * 
 * @author eddie
 *
 */
public class ChangeColor extends AbstractAnimation implements InterfaceAnimation {

  private Color oldColor;
  private Color newColor;

  /**
   * Construct that initialize the field by given arguments.
   * 
   * @param shapeMap  map name : shape
   * @param aniType   the animation type of shape
   * @param name      the name of shape
   * @param startTime the animation start time
   * @param endTime   the animation end time
   * @param r1        the red color of original color
   * @param g1        the green color of original color
   * @param b1        the blue color of original color
   * @param r2        the red color after changing
   * @param g2        the green color after changing
   * @param b2        the blue color after changing
   */
  public ChangeColor(Map shapeMap, AnimationType aniType, String name, int startTime, int endTime,
      int r1, int g1, int b1, int r2, int g2, int b2) {
    super(shapeMap, aniType, name, startTime, endTime);

    this.oldColor = new Color(r1, g1, b1);
    this.newColor = new Color(r2, g2, b2);
  }

  /**
   * Set the color by manual.
   */
  public void setColor() {
    this.shape.setRed(this.newColor.getRed());
    this.shape.setBlue(this.newColor.getBlue());
    this.shape.setGreen(this.newColor.getGreen());

  }

  @Override
  public void performAction(int frame) {

    InterfaceShape shape = (InterfaceShape) this.shapeMap.get(this.name);
    shape.setGreen(tweening(this.oldColor.getGreen(), this.newColor.getGreen(), this.startTime,
        this.endTime, frame));
    shape.setBlue(tweening(this.oldColor.getBlue(), this.newColor.getBlue(), this.startTime,
        this.endTime, frame));
    shape.setRed(tweening(this.oldColor.getRed(), this.newColor.getRed(), this.startTime,
        this.endTime, frame));

  }

  @Override
  public String toString() {

    return "Shape " + this.name + " changes color from (" + this.oldColor.getRed() + ","
        + this.oldColor.getGreen() + "," + this.oldColor.getBlue() + ") to ("
        + this.newColor.getRed() + "," + this.newColor.getGreen() + "," + this.newColor.getBlue()
        + ")";
  }
}
