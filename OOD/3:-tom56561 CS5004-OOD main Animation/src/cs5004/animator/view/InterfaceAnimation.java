package cs5004.animator.view;

import cs5004.animator.model.InterfaceShape;

/**
 * The interface of animation view.
 * 
 * @author eddie
 *
 */
public interface InterfaceAnimation {

  /**
   * Render the shape on the panel.
   * 
   * @param shape the shape we want to show
   */
  void drawShape(InterfaceShape shape);

  /**
   * Get the view type.
   * 
   * @return the view type
   */
  ViewType getViewType();

  /**
   * Refresh the panel.
   */
  void refresh();

}
