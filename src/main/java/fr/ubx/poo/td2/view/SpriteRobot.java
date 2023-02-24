package fr.ubx.poo.td2.view;

import fr.ubx.poo.td2.model.Robot;
import javafx.scene.image.ImageView;

public class SpriteRobot extends SpriteVehicule {
    public SpriteRobot(Robot robot) {
        super(new ImageView(ImageResource.imageRobot),robot);
    }
}
