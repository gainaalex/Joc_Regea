package Entity;

import Regea_The_Game_v1.Game;

public interface Entity_Factory {
    public void PlaceEntity(int x, int y);
    public Entity CreateEntity(int type, Game g);
}
