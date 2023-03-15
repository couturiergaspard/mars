package fr.ubx.poo.td6.model;

public class GridRepoStringRLE implements GridRepo{
    final char EOL = 'x';

    public int isNextEqual(String string, int key){
        char init = string.charAt(key);
        int cpt = 0;
        for( int tmp = key + 1 ; tmp < string.length() ; tmp++){
            char compare = string.charAt(tmp);
            if ( init == compare){
                cpt ++;
            }
            else
                return cpt;
        }
        return cpt;
    }


    @Override
    public Grid load(String string) {
        return null;
    }


    @Override
    public String export(Grid grid) {
        GridRepoString Repo = new GridRepoString();
        String repString = Repo.export(grid);
        StringBuilder ret = new StringBuilder();
        int len = repString.length();
        int tmp = 0;
        for(int i = 0; i < len; i++){
            tmp = isNextEqual(repString,i);
            if(tmp == 0){
                ret.append(repString.charAt(i));
            }
            if (tmp != 0){
                ret.append(repString.charAt(i));
                ret.append(tmp + 1); // add 1 for the head
                i = i + tmp;
            }
        }
        return ret.toString();
    }
}
