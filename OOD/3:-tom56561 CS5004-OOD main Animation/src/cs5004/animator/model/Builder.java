package cs5004.animator.model;

import java.awt.geom.Point2D;

/**
 * The builder to handle different behavior.
 * 
 * @author eddie
 *
 */
public class Builder implements AnimationBuilder<InterfaceModel> {

  private final InterfaceModel model;

  /**
   * Initialize the model by model implement class.
   * 
   * @param model the model implement
   */
  public Builder(InterfaceModel model) {
    this.model = model;
  }

  @Override
  public InterfaceModel build() {
    return this.model;
  }

  @Override
  public AnimationBuilder<InterfaceModel> setBounds(int x, int y, int width, int height) {
    this.model.setBoundWandH(width, height);
    return this;
  }

  @Override
  public AnimationBuilder<InterfaceModel> declareShape(String name, String type) {
    if (type.equalsIgnoreCase("rectangle")) {
      model.addShape(name, ShapeType.RECTANGLE, 0, 0, 0, 0, 0, 0, 0, 0, 0);
    } else if (type.equalsIgnoreCase("ellipse")) {
      model.addShape(name, ShapeType.OVAL, 0, 0, 0, 0, 0, 0, 0, 0, 0);
    }
    return this;
  }

  @Override
  public AnimationBuilder<InterfaceModel> addMotion(String name, int t1, int x1, int y1, int w1,
      int h1, int r1, int g1, int b1, int t2, int x2, int y2, int w2, int h2, int r2, int g2,
      int b2) {
    InterfaceShape shape = model.getShape(name);

    if (shape.getAppear() == 0 && shape.getDisappear() == 0) {
      shape.setRed(r1);
      shape.setGreen(g1);
      shape.setBlue(b1);
      shape.setHeight(h1);
      shape.setWidth(w1);
      Point2D position = new Point2D.Double(x1, y1);
      shape.setPosition(position);
      shape.setAppear(t1);
      shape.setDisappear(t2);
    } else if (t2 > shape.getDisappear()) {
      shape.setDisappear(t2);
    }

    if (x1 != x2 || y1 != y2) {
      model.move(name, t1, t2, x1, x2, y1, y2);
    } else if (w1 != w2 || h1 != h2) {
      model.changeScale(name, t1, t2, w1, h1, w2, h2);
    } else if (r1 != r2 || g1 != g2 || b1 != b2) {
      model.changeColor(name, t1, t2, r1, g1, b1, r2, g2, b2);
    }

    return this;
  }

}
