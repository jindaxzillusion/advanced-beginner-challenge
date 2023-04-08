package cs5004.animator.model;

/**
 * Animation Interface defines all the supported operations for each animation.
 * 
 * @author eddie
 *
 */
public interface InterfaceAnimation {

  /**
   * Get the name of the shape.
   * 
   * @return the name of the shape
   */
  String getName();

  /**
   * Get the type of the shape.
   * 
   * @return the type of the shape
   */
  AnimationType getType();

  /**
   * Get the start time of the shape.
   * 
   * @return the start time of the shape
   */
  int getStartTime();

  /**
   * Get the end time of the shape.
   * 
   * @return the end time of the shape
   */
  int getEndTime();

  /**
   * Perform the action in the frame.
   * 
   * @param frame the frame we want to perform
   */
  void performAction(int frame);

  /**
   * Compute the intermediate state of R at any time 𝑡𝑎≤𝑡≤𝑡𝑏.
   * 
   * @param changeFrom the original value
   * @param changeTo   the changing value
   * @param startTime  the start time
   * @param endTime    the end time
   * @param t          the time
   * @return the intermediate state of R
   */
  double tweening(double changeFrom, double changeTo, int startTime, int endTime, double t);

}
