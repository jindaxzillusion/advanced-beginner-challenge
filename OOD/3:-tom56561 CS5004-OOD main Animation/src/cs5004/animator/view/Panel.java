package cs5004.animator.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;

import cs5004.animator.model.InterfaceShape;
import cs5004.animator.model.ShapeType;

/**
 * Panel extends JPanel and add drawShapes method.
 * 
 * @author eddie
 *
 */
public class Panel extends JPanel {

  private ArrayList<InterfaceShape> shapes = new ArrayList<InterfaceShape>();

  /**
   * Initialize panel by given width and height.
   * 
   * @param w the width of the panel
   * @param h the height of panel
   */
  public Panel(int w, int h) {
    super();
    setBackground(Color.WHITE);
    setPreferredSize(new Dimension(w, h));
  }

  /**
   * Add new shape to shapes array list.
   * 
   * @param shape the shape being add
   */
  public void drawShapes(InterfaceShape shape) {
    shapes.add(shape);
  }

  /**
   * Set color to every shape.
   */
  @Override
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    
    if (!this.shapes.isEmpty()) {
      for (InterfaceShape shape : this.shapes) {
        Color color = new Color((int)shape.getRed(),
            (int)shape.getGreen() , (int)shape.getBlue());
        
        ShapeType shapeType = shape.getType();
        
        if (shapeType == ShapeType.RECTANGLE) {
          g.setColor(color);
          g.fillRect((int)shape.getPosition().getX(), (int)shape.getPosition().getY(),
              (int)shape.getWidth(), (int)shape.getHeight());
        } else if (shapeType == ShapeType.OVAL) {
          g.setColor(color);
          g.fillOval((int)shape.getPosition().getX(), (int)shape.getPosition().getY(),
              (int)shape.getWidth(), (int)shape.getHeight());
        }
      }
    }
  }

}
