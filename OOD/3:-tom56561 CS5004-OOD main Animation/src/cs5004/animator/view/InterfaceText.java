package cs5004.animator.view;

/**
 * The interface of text view.
 * 
 * @author eddie
 *
 */
public interface InterfaceText {

  /**
   * Render the the text content following by shape list and animation list.
   * 
   * @return the text content in view
   */
  String render();

  /**
   * Get the view type.
   * 
   * @return the view type
   */
  ViewType getViewType();

  /**
   * Print the text using system out print.
   */
  void printRender();
}
