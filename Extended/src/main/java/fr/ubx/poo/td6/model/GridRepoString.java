package fr.ubx.poo.td6.model;

import static fr.ubx.poo.td6.model.Entity.*;

public class GridRepoString implements GridRepo {
    final char EOL = 'x';
    private static int countOccurrences(String str) {
        int counter = 0;
        for (int i = 0; i < str.length(); i++){
            if (str.charAt(i) == 'x') {
                counter++;
            }
        }
        return counter;
    }

    @Override
    public Grid load(String name) {
        int cptH = countOccurrences(name) ;
        int cptW = name.length()/cptH;
        int x = 0;
        int y = 0;
        Grid maGrille = new Grid(cptW,cptH);
        for (int i = 0; i < name.length()-1; i++){
            Entity ent = fromCode(name.charAt(i));
            if (ent ==  null){
                y++;
                x = 0;
            }
            if(ent != null) {
                maGrille.set(x, y, ent);
                x++;
            }
        }
        return maGrille;
    }

    @Override
    public String export(Grid grid) {
        StringBuilder monSBS = new StringBuilder();
        int longueur = grid.getHeight() * grid.getWidth();
        for (int cptH = 0; cptH < grid.getHeight(); cptH++){
            for (int cptW = 0; cptW < grid.getWidth(); cptW++) {
                if (grid.get(cptW, cptH) == ROCK) {
                    monSBS.append("R");
                }
                if (grid.get(cptW, cptH) == BIGROCK) {
                    monSBS.append("B");
                }
                if (grid.get(cptW, cptH) == GROUND) {
                    monSBS.append("G");
                }
                if (grid.get(cptW, cptH) == CRACK) {
                    monSBS.append("C");
                }
                if (grid.get(cptW, cptH) == ENERGY) {
                    monSBS.append("E");
                }
                if (grid.get(cptW, cptH) == DUST) {
                    monSBS.append("D");
                }
                if (cptW == grid.getWidth() - 1) {
                    monSBS.append(EOL);
                }
            }
        }
        return monSBS.toString();
    }
}
