import Regea_The_Game_v1.Game;

public class Main {
    public static void main(String[] args) {
        try{
            Game g = null;
            g.InitiateGame();

        }catch (Exception i)
        {
            i.printStackTrace();
        }
        //Game g =new Game("The Redemption");
        //g.StartGame();
    }
}