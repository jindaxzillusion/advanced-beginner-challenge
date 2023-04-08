# MVC
In this project, I used the MVC software architectural pattern to develop the animation.
There are three packages which are model, view, and controller. The model handles the three main motions: changing color, moving, and changing size. The View generates three types of view: text, visual, and SVG. The controller plays a middle role in handling which page needs to be rendered.

# Model
### Shape
There are two types of shapes, rectangle and oval, and each shape has a name, type, position, color, size, appearance time, and disappearance time. InterfaceShape.java class define all operation of shape.

### Animation
There are three animations that can be used, which are changing color, moving, and changing size. ChangeColor, Move, Scale these classes represent each motion. InterfaceAnimation class define all operation of animation.

### ModelImplement
InterfaceModel class define all operation of the model implement. Including adding motion and add shape. Using two HashMap to record all shapes and all animations.

### AnimationReader
AnimationReader to handle reading the shape and animation into the modelImpl as a txt file. Builder is a class to handle different behavior.


# View
### Animation View
InterfaceAnimation class define all operation of animation view. Render the animation view by executing the animation map and shape map in the model using java swing library.

### Text View
InterfaceText class defines all operations of the text view. Render the text view by iterating the animation map and shape map in the model.

# Controller
### Animation Controller
AnimationController to handle when the animation should be rendered by using Timer.

### Text Controller
TextController to handle when should the text view should be rendered.

# Main and Jar
EasyAnimator is the main function to run the whole program. Export the jar file as animation.jar in the jar folder. To run the program, download the animation.jar and execute the jar file using java - jar animation.jar. And input the command line like below to choose each option.  
-in "name-of-animation.txt-file"  
-view "type-of-view"  
-speed "integer-ticks-per-second"  
-out "where-output-show-go"  
For exmaple:  
`java -jar animation.jar -in buildings.txt -speed 20 -view visual -out out.txt`  
`java -jar animation.jar -in hanoi.txt -speed 50 -view text -out out.txt`

