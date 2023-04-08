package cs5004.animator.model;

import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * A class ModelImpl that implements all methods from the InterfaceModel.
 * 
 * @author eddie
 *
 */
public class ModelImpl implements InterfaceModel {

  private Map<String, InterfaceShape> shapeMap;
  private Map<String, ArrayList<InterfaceAnimation>> animationMap;

  private int w;
  private int h;

  /**
   * Initialize the two map to store the shape and animation information.
   */
  public ModelImpl() {
    this.shapeMap = new LinkedHashMap<>();
    this.animationMap = new HashMap<>();
  }

  @Override
  public InterfaceShape getShape(String name) {
    return shapeMap.get(name);
  }

  @Override
  public ArrayList<InterfaceAnimation> getAnimation(String name) {
    return animationMap.get(name);
  }

  @Override
  public Map getShapeList() {
    Map<String, InterfaceShape> newShapeMap = new LinkedHashMap<>();
    for (String name : this.shapeMap.keySet()) {
      newShapeMap.put(name, shapeMap.get(name));
    }
    return newShapeMap;
  }

  @Override
  public Map getAllAnimationMap() {
    Map<String, ArrayList<InterfaceAnimation>> newAnimationMap = new HashMap<>();
    for (String name : this.animationMap.keySet()) {
      newAnimationMap.put(name, this.animationMap.get(name));
    }
    return newAnimationMap;

  }

  @Override
  public void addShape(String name, ShapeType shapetype, double x, double y, int r1, int g1, int b1,
      double width, double height, int appearT, int disappearT) {

    InterfaceShape shape = null;
    Point2D position = new Point2D.Double(x, y);
    if (shapetype == ShapeType.RECTANGLE) {
      shape = new Rectangle(name, shapetype, position, r1, g1, b1, width, height, appearT,
          disappearT);
    } else if (shapetype == ShapeType.OVAL) {
      shape = new Oval(name, shapetype, position, r1, g1, b1, width, height, appearT, disappearT);
    }
    if (shape != null) {
      this.shapeMap.put(name, shape);
      this.animationMap.put(name, new ArrayList<>());
    }

  }

  @Override
  public void changeColor(String name, int startTime, int endTime, int r1, int g1, int b1, int r2,
      int g2, int b2) {
    ChangeColor newColor = new ChangeColor(this.shapeMap, AnimationType.COLOR, name, startTime,
        endTime, r1, g1, b1, r2, g2, b2);
    animationMap.get(name).add(newColor);

  }

  @Override
  public void changeScale(String name, int startTime, int endTime, double startW, double startH,
      double endW, double endH) {
    Scale newScale = new Scale(this.shapeMap, AnimationType.SCALE, name, startTime, endTime, startW,
        startH, endW, endH);
    animationMap.get(name).add(newScale);

  }

  @Override
  public void move(String name, int startTime, int endTime, double startX, double endX,
      double startY, double endY) {
    Move newMove = new Move(this.shapeMap, AnimationType.SCALE, name, startTime, endTime, startX,
        startY, endX, endY);
    animationMap.get(name).add(newMove);

  }

  @Override
  public void setBoundWandH(int w, int h) {
    this.w = w;
    this.h = h;
  }

  @Override
  public int getBoundW() {
    return this.w;
  }

  @Override
  public int getBoundH() {
    return this.h;
  }

  @Override
  public int getMaxEndingTime() {
    int maxDisappears = 0;
    for (InterfaceShape shape : this.shapeMap.values()) {
      int currentDisappears = shape.getDisappear();
      if (currentDisappears > maxDisappears) {
        maxDisappears = currentDisappears;
      }
    }

    return maxDisappears;
  }

  @Override
  public ArrayList<InterfaceShape> getAllShapes(int frame) {
    for (ArrayList<InterfaceAnimation> animationList : animationMap.values()) {
      for (InterfaceAnimation animation : animationList) {
        if (frame >= animation.getStartTime() && frame <= animation.getEndTime()) {
          animation.performAction(frame);
        }
      }
    }
    ArrayList<InterfaceShape> shapesAtFrame = new ArrayList<>();
    for (String shapeName : shapeMap.keySet()) {
      if (frame >= shapeMap.get(shapeName).getAppear()
          && frame <= shapeMap.get(shapeName).getDisappear()) {
        shapesAtFrame.add(shapeMap.get(shapeName));
      }
    }
    return shapesAtFrame;
  }

}
