package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.shape.*;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.paint.Color;

/**
 * This program creates window filled with randomly generated snowflakes
 * <p>
 * Date Last Modified: 02/12/2021
 *
 * @author Dominika Bobik
 */

public class RandomSnowflake extends Application {


    @Override
    public void start(Stage stage) {
        stage.setTitle("Blizzard");
        Group group = new Group();
        int sceneSize = 500;
        Scene scene = new Scene(group, sceneSize, sceneSize, Color.WHITE);
        int numberOfSnowflakes = 500;

        //Creating snowflakes
        for (int i = 0; i < numberOfSnowflakes; i++) {
            double flakeCenterX = (int) (Math.random() * (sceneSize + 1));
            double flakeCenterY = (int) (Math.random() * (sceneSize + 1));
            double flakeRadius = (int) (Math.random() * ((sceneSize / 25) + 1));
            double flakeStroke = (int) (Math.random() * 3) + 1;

            //Getting different shades of blue
            int red = 0;
            int green = (int) ((Math.random() * 255 + 1));
            int blue = 255;

            //Calculations for x lines
            //Angles
            double alpha = 360 / 8;
            double beta = (180 - alpha) / 2;
            double gamma = 90 - beta;

            //Right angle length (offset for the coordinates)
            double a = Math.sin(gamma * (Math.PI) / 180) * 2 * Math.cos(beta * (Math.PI) / 180) * flakeRadius;
            double b = Math.cos(gamma * (Math.PI) / 180) * 2 * Math.cos(beta * (Math.PI) / 180) * flakeRadius;

            //Building snowflake
            Line line0 = new Line(flakeCenterX, flakeCenterY, flakeCenterX, flakeCenterY - flakeRadius);
            Line line1 = new Line(flakeCenterX, flakeCenterY, flakeCenterX + b, flakeCenterY - (flakeRadius - a));

            Line line2 = new Line(flakeCenterX, flakeCenterY, flakeCenterX + flakeRadius, flakeCenterY);
            Line line3 = new Line(flakeCenterX, flakeCenterY, flakeCenterX + b, flakeCenterY + (flakeRadius - a));

            Line line4 = new Line(flakeCenterX, flakeCenterY, flakeCenterX, flakeCenterY + flakeRadius);
            Line line5 = new Line(flakeCenterX, flakeCenterY, flakeCenterX - b, flakeCenterY - (flakeRadius - a));

            Line line6 = new Line(flakeCenterX, flakeCenterY, flakeCenterX - flakeRadius, flakeCenterY);
            Line line7 = new Line(flakeCenterX, flakeCenterY, flakeCenterX - b, flakeCenterY + (flakeRadius - a));

            //Applying properties
            line0.setStrokeWidth(flakeStroke);
            line0.setStroke(Color.rgb(red, green, blue));
            line1.setStrokeWidth(flakeStroke);
            line1.setStroke(Color.rgb(red, green, blue));
            line2.setStrokeWidth(flakeStroke);
            line2.setStroke(Color.rgb(red, green, blue));
            line3.setStrokeWidth(flakeStroke);
            line3.setStroke(Color.rgb(red, green, blue));
            line4.setStrokeWidth(flakeStroke);
            line4.setStroke(Color.rgb(red, green, blue));
            line5.setStrokeWidth(flakeStroke);
            line5.setStroke(Color.rgb(red, green, blue));
            line6.setStrokeWidth(flakeStroke);
            line6.setStroke(Color.rgb(red, green, blue));
            line7.setStrokeWidth(flakeStroke);
            line7.setStroke(Color.rgb(red, green, blue));

            //Adding all the lines to the group
            group.getChildren().add(line0);
            group.getChildren().add(line1);
            group.getChildren().add(line2);
            group.getChildren().add(line3);
            group.getChildren().add(line4);
            group.getChildren().add(line5);
            group.getChildren().add(line6);
            group.getChildren().add(line7);

        }
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
