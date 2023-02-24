package fr.ubx.poo.td2.view;

import fr.ubx.poo.td2.model.Vehicule;
import javafx.scene.image.ImageView;

public class SpriteVehicule extends Sprite{
    public SpriteVehicule(ImageView img, Vehicule vehicule) {
        super(img);
        this.vehicule = vehicule;
        updateLocation(vehicule.getPosition());
    }
}
