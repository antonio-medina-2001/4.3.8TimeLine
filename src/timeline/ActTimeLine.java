
package timeline;


import javafx.animation.KeyFrame;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Bounds;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.animation.Timeline;

public class ActTimeLine extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Pane pane = new Pane();
        Scene scene = new Scene(pane, 300, 300);
        
        
        // Creo el circulo
        Circle circulo = new Circle(10, Color.BEIGE);
        circulo.relocate(5, 5);
        
        // Los añado al panel
        pane.getChildren().add(circulo);
        
        // Creo timeline
        Timeline tl = new javafx.animation.Timeline(2, new KeyFrame(Duration.millis(2),new EventHandler<ActionEvent>()
        {
            double x = Math.random();
            double y = Math.random();
            
        @Override
        public void handle(ActionEvent e)
        {
            // Muevo el circulo
            circulo.setLayoutX(circulo.getLayoutX()+x);
            circulo.setLayoutY(circulo.getLayoutY()+y);
            
            Bounds bounds = pane.getBoundsInLocal();
            
            
            if(circulo.getLayoutX() <= (bounds.getMinX() + circulo.getRadius()) || 
                circulo.getLayoutX() >= (bounds.getMaxX() - circulo.getRadius()) ){
                x = -x;
            }
                //If the ball reaches the bottom or top border make the step negative
            if((circulo.getLayoutY() >= (bounds.getMaxY() - circulo.getRadius())) || 
                (circulo.getLayoutY() <= (bounds.getMinY() + circulo.getRadius()))){
                y = -y;
            }
        }
        }));
        
        tl.setCycleCount(Timeline.INDEFINITE);
        tl.play();
       
        primaryStage.setTitle("TimeLine");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
