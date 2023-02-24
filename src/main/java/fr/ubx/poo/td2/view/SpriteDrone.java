package fr.ubx.poo.td2.view;

import fr.ubx.poo.td2.model.Drone;
import javafx.scene.image.ImageView;

public class SpriteDrone extends SpriteVehicule {
    public SpriteDrone(Drone drone) {
        super(new ImageView(ImageResource.imageDrone),drone);
    }
}

