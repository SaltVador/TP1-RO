import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TP1 {

    private char[][] labyrinthe;
    private int starti,startj;


    public static void main(String[] args) {
        System.out.println("HELLO");
    }

    public TP1(){
        labyrinthe = init();
    }


    public char[][] init(){

        try {
            BufferedReader br = new BufferedReader(new FileReader("../data/labExemple.lab"));
            char[][] res = new char[20][20];
            String lecture;
            int i = 0;
            while ((lecture = br.readLine()) != null){
                char[] tab = lecture.toCharArray();
                int j = 0;
                for (char var : tab) {
                    res[i][j] = var;
                    if (var == 'e'){
                        this.starti=i;
                        this.startj=j;
                    }
                    j++;
                }
                i++;
            }

            br.close();
            return res;

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }



}