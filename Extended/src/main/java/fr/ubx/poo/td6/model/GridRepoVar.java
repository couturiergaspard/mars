package fr.ubx.poo.td6.model;

import java.lang.reflect.Field;

import static fr.ubx.poo.td6.model.Entity.*;

public class GridRepoVar implements GridRepo {

    private final Entity[][] sample1 = {
            {GROUND, GROUND, GROUND, GROUND, DUST, GROUND, GROUND, GROUND, GROUND},
            {GROUND, GROUND, GROUND, GROUND, GROUND, GROUND, DUST, GROUND, GROUND},
            {GROUND, GROUND, ROCK, CRACK, GROUND, GROUND, BIGROCK, GROUND, GROUND},
            {GROUND, ROCK, GROUND, ROCK, GROUND, GROUND, GROUND, GROUND, GROUND},
            {GROUND, GROUND, GROUND, GROUND, GROUND, GROUND, GROUND, GROUND, GROUND},
            {GROUND, GROUND, GROUND, GROUND, GROUND, GROUND, GROUND, CRACK, GROUND},
            {GROUND, DUST, GROUND, DUST, GROUND, GROUND, GROUND, GROUND, GROUND},
            {GROUND, GROUND, GROUND, CRACK, GROUND, DUST, BIGROCK, GROUND, GROUND},
            {GROUND, ROCK, GROUND, GROUND, GROUND, GROUND, GROUND, GROUND, GROUND},
    };
    private final Entity[][] sample2 = {
            {GROUND, ROCK, DUST, ROCK, GROUND},
            {GROUND, CRACK, BIGROCK, CRACK, DUST},
            {GROUND, CRACK, CRACK, GROUND, BIGROCK},
            {ROCK, DUST, DUST, GROUND, DUST},
    };

    @Override
    public Grid load(String name) {
        Entity[][] entities = getEntities(name);
        if (entities == null)
            return null;
        Grid maGrille = new Grid(entities[0].length,entities.length );
        for(int h = 0; h < maGrille.getHeight(); h++){
            for(int w = 0; w< maGrille.getWidth(); w++){
                maGrille.set(w,h,entities[h][w]);
            }
        }
        return maGrille;
    }

    @Override
    public String export(Grid grid) {
        /*  Retourne sous forme de chaîne de caractères la déclaration Java correspondant aux
            tableau d'entités de l'objet grid.
            Le résultat produit doit être de la forme: private final Entity[][] sample1 = {....};
            Le code produit peut être utilisé pour remplacer la déclaration de sample1 plus haut.
        */
        StringBuilder monSB = new StringBuilder();
        monSB.append("private final Entity[][] sample1 = {\n");
        for (int cptH = 0; cptH < grid.getHeight(); cptH++){
            monSB.append("{");
            for (int cptW = 0; cptW < grid.getWidth(); cptW++){
                if(grid.get(cptW,cptH) == ROCK){
                    monSB.append("ROCK");
                }
                if(grid.get(cptW,cptH) == BIGROCK){
                    monSB.append("BIGROCK");
                }
                if(grid.get(cptW,cptH) == GROUND){
                    monSB.append("GROUND");
                }
                if(grid.get(cptW,cptH) == CRACK){
                    monSB.append("CRACK");
                }
                if(grid.get(cptW,cptH) == ENERGY){
                    monSB.append("ENERGY");
                }
                if(grid.get(cptW,cptH) == DUST){
                    monSB.append("DUST");
                }
                if(cptW != grid.getWidth()-1){
                    monSB.append(", ");
                }
            }
            monSB.append("},\n");
        }
        monSB.append("};");
        return monSB.toString();
    }
    private Entity[][] getEntities(String name) {
        try {
            Field field = this.getClass().getDeclaredField(name);
            return (Entity[][]) field.get(this);
        } catch (IllegalAccessException e) {
            return null;
        } catch (NoSuchFieldException e) {
            return null;
        }
    }
}
