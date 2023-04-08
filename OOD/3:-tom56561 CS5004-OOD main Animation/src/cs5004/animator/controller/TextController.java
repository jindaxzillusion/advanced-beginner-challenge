package cs5004.animator.controller;

import java.io.IOException;

import cs5004.animator.model.InterfaceModel;
import cs5004.animator.view.InterfaceText;
import cs5004.animator.view.ViewType;

/**
 * The text controller to control the model and text view.
 * 
 * @author eddie
 *
 */
public class TextController implements InterfaceController {

  private InterfaceText view;
  private Appendable out;

  /**
   * Initialize the view, output.
   * 
   * @param view  the text view
   * @param model the model we implement
   * @param a     the StringBuilder help us to test
   */
  public TextController(InterfaceText view, InterfaceModel model, Appendable a) {
    this.out = a;
    this.view = view;
  }

  @Override
  public void start() {
    if (this.view.getViewType() == ViewType.TEXT) {
      this.view.printRender();
      try {
        this.out.append(this.view.render());
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }

}
