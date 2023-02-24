package fr.ubx.poo.td2.view;

import fr.ubx.poo.td2.model.Position;
import javafx.scene.image.ImageView;

public class SpriteDecor extends Sprite{
    public SpriteDecor(ImageView img, Position position) {
        super(img);
        updateLocation(position);
    }
}
