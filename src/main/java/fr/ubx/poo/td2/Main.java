package fr.ubx.poo.td2;

import fr.ubx.poo.td2.view.*;
import fr.ubx.poo.td2.model.*;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage){

        // Creation des robots et du drone
        Vehicule[] mesVehicules = new Vehicule[3];
        mesVehicules[0] = new Robot("Curiosity",new Position(8,5),200, 2);
        mesVehicules[1] = new Robot("Opportunity",new Position(8,1),200, 2);
        mesVehicules[2] = new Drone("Ingenuity",new Position(5,7),200, 2);

        Sprite[] mesSprites = new Sprite[3];
        mesSprites[0] = new SpriteRobot((Robot) mesVehicules[0]);
        mesSprites[1] = new SpriteRobot((Robot) mesVehicules[1]);
        mesSprites[2] = new SpriteDrone((Drone) mesVehicules[2]);

        // Modelisation du terrain
        Sprite[] mesDecors = new Sprite[2];
        mesDecors[0] = new SpriteDust(new Position(6,6));
        mesDecors[1] = new SpriteRock(new Position(7,9));
        
        // Affiche la fenetre
        View view = new View(20, 20);
        stage.setTitle("Pepsi");
        stage.setScene(view.getPane().getScene());
        stage.show();

        view.getPane().setOnMouseClicked(e -> {
            Position target = view.getPosition(e);
            for(int i = 0 ; i < mesVehicules.length ; i ++){
                if (mesVehicules[i].canMove(target)) {
                    mesSprites[i].animateMove(target);
                }
            }
            System.out.println("\n");
        });
        for (Sprite mesSprite : mesSprites) {
            view.getPane().getChildren().addAll(mesSprite.getImg());
        }
        for (Sprite mesDecor : mesDecors) {
            view.getPane().getChildren().addAll(mesDecor.getImg());
        }
    }
    public static void main(String[] args) {
        launch();
    }
}