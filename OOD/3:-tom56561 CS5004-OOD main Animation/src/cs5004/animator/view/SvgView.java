package cs5004.animator.view;

import java.util.ArrayList;
import java.util.Map;

import cs5004.animator.model.InterfaceAnimation;
import cs5004.animator.model.InterfaceModel;
import cs5004.animator.model.InterfaceShape;

/**
 * The SVG view.
 * 
 * @author eddie
 *
 */
public class SvgView implements InterfaceText {
  Appendable out;
  private InterfaceModel model;
  private int speed;
  private ViewType viewType;
  private StringBuilder output;

  /**
   * Initialize the the model, speed, and view type.
   * 
   * @param model the model of shape and animation
   * @param speed the speed
   */
  public SvgView(InterfaceModel model, int speed) {
    this.model = model;
    this.viewType = ViewType.SVG;
    this.speed = speed;
    output = new StringBuilder();
  }

  @Override
  public ViewType getViewType() {
    return this.viewType;
  }

  @Override
  public String render() {
    output.append("<svg width=\"" + model.getBoundW() + "\" height=\"" + model.getBoundH()
        + "\" version=\"1.1\"\n    " + "xmlns=\"http://www.w3.org/2000/svg\">\n");

    String content = this.getContent();
    output.append(content);
    output.append("</svg>");

    String res = String.valueOf(output);
    return res;
  }

  @Override
  public void printRender() {
    String res = String.valueOf(output);
    System.out.print(res);
  }

  private String getContent() {
    StringBuilder content = new StringBuilder();
    content.append("Shape: \n");
    for (Object name : model.getShapeList().keySet()) {
      InterfaceShape currentShape = model.getShape((String) name);
      content.append(currentShape.toString()).append("Appears at time t=")
          .append(currentShape.getAppear() / this.speed).append(" and disappears at time t=")
          .append(currentShape.getDisappear() / this.speed).append("\n");
    }
    Map<String, ArrayList<InterfaceAnimation>> animationMap = model.getAllAnimationMap();
    for (ArrayList<InterfaceAnimation> animationList : animationMap.values()) {
      for (InterfaceAnimation animation : animationList) {
        content.append(animation.toString()).append(", from time t=")
            .append(animation.getStartTime() / this.speed).append(" to t=")
            .append(animation.getEndTime() / this.speed).append("\n");
      }
    }
    String res = String.valueOf(content);
    return res;
  }

}
