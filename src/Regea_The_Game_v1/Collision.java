package Regea_The_Game_v1;

import Entity.Entity;

public class Collision {
    public Game game;
    public Collision(Game g)
    {
        this.game=g;
    }
    public void checkTile(Entity entity)
    {
        //  AC----------BC
        //  |           |
        //  |           |
        //  AD__________BD

        // punctele pe harta mare


        int entity_A=entity.WorldX+entity.solidArea.x;
        int entity_B=entity.WorldX+entity.solidArea.x+entity.solidArea.width;
        int entity_C=entity.WorldY+entity.solidArea.y;
        int entity_D=entity.WorldY+entity.solidArea.y+entity.solidArea.height;
        // dpdv al tile urilor
        int entity_Tile_A=entity_A/game.Tile_Size();
        int entity_Tile_B=entity_B/game.Tile_Size();
        int entity_Tile_C=entity_C/game.Tile_Size();
        int entity_Tile_D=entity_D/game.Tile_Size();

        int tile_num1, tile_num2;
        entity.isCollision=false;
        switch (entity.direction)
        {
            case "up":
                entity_Tile_C=(entity_C-entity.speed)/game.Tile_Size();
                tile_num1=game.assets.map_matrix[game.wnd.currentMap][entity_Tile_C][entity_Tile_A];
                tile_num2=game.assets.map_matrix[game.wnd.currentMap][entity_Tile_C][entity_Tile_B];
                if(game.assets.tile[tile_num1].collision==true || game.assets.tile[tile_num2].collision==true)
                {
                    entity.isCollision=true;
                }
                break;
            case "down":
                entity_Tile_D=(entity_D+entity.speed)/game.Tile_Size();
                tile_num1=game.assets.map_matrix[game.wnd.currentMap][entity_Tile_D][entity_Tile_A];
                tile_num2=game.assets.map_matrix[game.wnd.currentMap][entity_Tile_D][entity_Tile_B];
                if(game.assets.tile[tile_num1].collision==true || game.assets.tile[tile_num2].collision==true)
                {
                    entity.isCollision=true;
                }
                break;
            case "left":
                entity_Tile_A=(entity_A-entity.speed)/game.Tile_Size();
                if(entity_Tile_A<0) {
                    entity.isCollision = true;
                    return;
                }
                tile_num1=game.assets.map_matrix[game.wnd.currentMap][entity_Tile_C][entity_Tile_A];
                tile_num2=game.assets.map_matrix[game.wnd.currentMap][entity_Tile_D][entity_Tile_A];
                if(game.assets.tile[tile_num1].collision==true || game.assets.tile[tile_num2].collision==true)
                {
                    entity.isCollision=true;
                }
                break;
            case "right":
                entity_Tile_B=(entity_B+entity.speed)/game.Tile_Size();
                tile_num1=game.assets.map_matrix[game.wnd.currentMap][entity_Tile_C][entity_Tile_B];
                tile_num2=game.assets.map_matrix[game.wnd.currentMap][entity_Tile_D][entity_Tile_B];
                if(game.assets.tile[tile_num1].collision==true || game.assets.tile[tile_num2].collision==true)
                {
                    entity.isCollision=true;
                }
                break;
        }
    }
    public void CheckFloor(Entity entity)
    {
        int tile_num1,tile_num2;
        int entity_A=entity.WorldX+entity.solidArea.x;
        int entity_B=entity.WorldX+entity.solidArea.x+entity.solidArea.width;
        int entity_D=entity.WorldY+entity.solidArea.y+entity.solidArea.height;
        // dpdv al tile urilor
        int entity_Tile_A=entity_A/game.Tile_Size();
        int entity_Tile_B=entity_B/game.Tile_Size();
        int entity_Tile_D=entity_D/game.Tile_Size();
        entity_Tile_D=(entity_D+entity.airSpeed)/game.Tile_Size();
        tile_num1=game.assets.map_matrix[game.wnd.currentMap][entity_Tile_D][entity_Tile_A];
        tile_num2=game.assets.map_matrix[game.wnd.currentMap][entity_Tile_D][entity_Tile_B];
        if(game.assets.tile[tile_num1].collision || game.assets.tile[tile_num2].collision)
        {
            entity.isCollision=true;
        }
    }

    public void CheckRoof(Entity entity)
    {
        int tile_num1,tile_num2;
        int entity_A=entity.WorldX+entity.solidArea.x;
        int entity_B=entity.WorldX+entity.solidArea.x+entity.solidArea.width;
        int entity_C=entity.WorldY+entity.solidArea.y;
        // dpdv al tile urilor
        int entity_Tile_A=entity_A/game.Tile_Size();
        int entity_Tile_B=entity_B/game.Tile_Size();
        int entity_Tile_C=entity_C/game.Tile_Size();

        entity_Tile_C=(entity_C)/game.Tile_Size();
        tile_num1=game.assets.map_matrix[game.wnd.currentMap][entity_Tile_C][entity_Tile_A];
        tile_num2=game.assets.map_matrix[game.wnd.currentMap][entity_Tile_C][entity_Tile_B];
        if(game.assets.tile[tile_num1].collision==true || game.assets.tile[tile_num2].collision==true)
        {
            entity.isCollision=true;
        }
    }
    public void CheckSides(Entity entity)
    {
        int tile_num1,tile_num2;
        int entity_A=entity.WorldX+entity.solidArea.x;
        int entity_B=entity.WorldX+entity.solidArea.x+entity.solidArea.width;
        int entity_C=entity.WorldY+entity.solidArea.y;
        int entity_D=entity.WorldY+entity.solidArea.y+entity.solidArea.height-16;
        // dpdv al tile urilor
        int entity_Tile_A=entity_A/game.Tile_Size();
        int entity_Tile_B=entity_B/game.Tile_Size();
        int entity_Tile_C=entity_C/game.Tile_Size();
        int entity_Tile_D=entity_D/game.Tile_Size();
        entity.isCollision=false;
        switch (entity.direction)
        {
            case "left":
                entity_Tile_A=(entity_A-entity.speed)/game.Tile_Size();
                tile_num1=game.assets.map_matrix[game.wnd.currentMap][entity_Tile_C][entity_Tile_A];
                tile_num2=game.assets.map_matrix[game.wnd.currentMap][entity_Tile_D][entity_Tile_A];
                if(game.assets.tile[tile_num1].collision==true || game.assets.tile[tile_num2].collision==true)
                {
                    entity.isCollision=true;
                }
                break;
            case "right":
                entity_Tile_B=(entity_B+entity.speed)/game.Tile_Size();
                tile_num1=game.assets.map_matrix[game.wnd.currentMap][entity_Tile_C][entity_Tile_B];
                tile_num2=game.assets.map_matrix[game.wnd.currentMap][entity_Tile_D][entity_Tile_B];
                if(game.assets.tile[tile_num1].collision==true || game.assets.tile[tile_num2].collision==true)
                {
                    entity.isCollision=true;
                }
                break;
        }
    }

    public int checkObj(Entity entity, boolean isPlayer)
    {
        int ret=-1;
        for (int i=0;i<game.obj_list[game.wnd.currentMap].length;i++)
        {
            if(game.obj_list[game.wnd.currentMap][i]!=null)
            {
                entity.solidArea.x=entity.WorldX+entity.solidArea.x;
                entity.solidArea.y=entity.WorldY+entity.solidArea.y;

                game.obj_list[game.wnd.currentMap][i].solidArea.x=game.obj_list[game.wnd.currentMap][i].worldX+game.obj_list[game.wnd.currentMap][i].solidArea.x;
                game.obj_list[game.wnd.currentMap][i].solidArea.y=game.obj_list[game.wnd.currentMap][i].worldY+game.obj_list[game.wnd.currentMap][i].solidArea.y;

                switch (entity.direction)
                {
                    case "up":
                        entity.solidArea.y-=entity.speed;
                        if (entity.solidArea.intersects(game.obj_list[game.wnd.currentMap][i].solidArea)) {
                            if (game.obj_list[game.wnd.currentMap][i].collision == true)
                                entity.isCollision = true;
                            if (isPlayer=true)
                            {
                                ret=i;
                            }
                        }
                        break;
                    case "down":
                        entity.solidArea.y+=entity.speed;
                        if (entity.solidArea.intersects(game.obj_list[game.wnd.currentMap][i].solidArea)) {
                            if (game.obj_list[game.wnd.currentMap][i].collision == true)
                                entity.isCollision = true;
                            if (isPlayer=true)
                            {
                                ret=i;
                            }
                        }
                        break;
                    case "left":
                        entity.solidArea.x-=entity.speed;
                        if (entity.solidArea.intersects(game.obj_list[game.wnd.currentMap][i].solidArea)) {
                            if (game.obj_list[game.wnd.currentMap][i].collision == true)
                                entity.isCollision = true;
                            if (isPlayer=true)
                            {
                                ret=i;
                            }
                        }
                        break;
                    case "right":
                        entity.solidArea.x+=entity.speed;
                        if (entity.solidArea.intersects(game.obj_list[game.wnd.currentMap][i].solidArea)) {
                            if (game.obj_list[game.wnd.currentMap][i].collision == true)
                                entity.isCollision = true;
                            if (isPlayer==true)
                            {
                                ret=i;
                            }
                        }
                        break;
                }
                entity.solidArea.x= entity.solidArea_defaultX;
                entity.solidArea.y=entity.solidArea_defaultY;
                game.obj_list[game.wnd.currentMap][i].solidArea.x=game.obj_list[game.wnd.currentMap][i].solidArea_defaultX;
                game.obj_list[game.wnd.currentMap][i].solidArea.y=game.obj_list[game.wnd.currentMap][i].solidArea_defaultY;
            }
        }
        return ret;
    }
    //coliziunea jucatorului cu alte npc_uri
    public int checkEntity(Entity entity, Entity[][] entities_list)
    {
        int ret=-1;
        for (int i=0;i<entities_list.length;i++)
        {
            if(entities_list[game.wnd.currentMap][i]!=null)
            {
                entity.solidArea.x=entity.WorldX+entity.solidArea.x;
                entity.solidArea.y=entity.WorldY+entity.solidArea.y;

                entities_list[game.wnd.currentMap][i].solidArea.x=entities_list[game.wnd.currentMap][i].WorldX+entities_list[game.wnd.currentMap][i].solidArea.x;
                entities_list[game.wnd.currentMap][i].solidArea.y=entities_list[game.wnd.currentMap][i].WorldY+entities_list[game.wnd.currentMap][i].solidArea.y;

                switch (entity.direction)
                {
                    case "up":
                        entity.solidArea.y-=entity.speed;
                        if (entity.solidArea.intersects(entities_list[game.wnd.currentMap][i].solidArea)) {
                            entity.isCollision = true;
                            ret=i;
                        }
                        break;
                    case "down":
                        entity.solidArea.y+=entity.speed;
                        if (entity.solidArea.intersects(entities_list[game.wnd.currentMap][i].solidArea)) {
                            entity.isCollision = true;
                            ret=i;
                        }
                        break;
                    case "left":
                        entity.solidArea.x-=entity.speed;
                        if (entity.solidArea.intersects(entities_list[game.wnd.currentMap][i].solidArea)) {
                            entity.isCollision = true;
                            ret=i;
                        }
                        break;
                    case "right":
                        entity.solidArea.x+=entity.speed;
                        if (entity.solidArea.intersects(entities_list[game.wnd.currentMap][i].solidArea)) {
                            entity.isCollision = true;
                            ret=i;
                        }
                        break;
                }
                entity.solidArea.x= entity.solidArea_defaultX;
                entity.solidArea.y=entity.solidArea_defaultY;
                entities_list[game.wnd.currentMap][i].solidArea.x=entities_list[game.wnd.currentMap][i].solidArea_defaultX;
                entities_list[game.wnd.currentMap][i].solidArea.y=entities_list[game.wnd.currentMap][i].solidArea_defaultY;
            }
        }
        return ret;
    }

    public void checkEntity(Entity entity, Entity target)
    {
        if(target!=null)
        {
            entity.solidArea.x=entity.WorldX+entity.solidArea.x;
            entity.solidArea.y=entity.WorldY+entity.solidArea.y;

            target.solidArea.x=target.WorldX+target.solidArea.x;
            target.solidArea.y=target.WorldY+target.solidArea.y;

            switch (entity.direction)
            {
                case "up":
                    entity.solidArea.y-=entity.speed;
                    if (entity.solidArea.intersects(target.solidArea)) {
                        entity.isCollision = true;
                    }
                    break;
                case "down":
                    entity.solidArea.y+=entity.speed;
                    if (entity.solidArea.intersects(target.solidArea)) {
                        entity.isCollision = true;
                    }
                    break;
                case "left":
                    entity.solidArea.x-=entity.speed;
                    if (entity.solidArea.intersects(target.solidArea)) {
                        entity.isCollision = true;
                    }
                    break;
                case "right":
                    entity.solidArea.x+=entity.speed;
                    if (entity.solidArea.intersects(target.solidArea)) {
                        entity.isCollision = true;
                    }
                    break;
            }
        }
    }
    public void check_interaction_w_player(Entity entity)
    {
        entity.solidArea.x=entity.WorldX+entity.solidArea.x;
        entity.solidArea.y=entity.WorldY+entity.solidArea.y;

        game.player1.solidArea.x=game.player1.WorldX+game.player1.solidArea.x;
        game.player1.solidArea.y=game.player1.WorldY+game.player1.solidArea.y;

        switch (entity.direction)
        {
            case "up":
                entity.solidArea.y-=entity.speed;
                if (entity.solidArea.intersects(game.player1.solidArea)) {
                    entity.isCollision = true;
                }
                break;
            case "down":
                entity.solidArea.y+=entity.speed;
                if (entity.solidArea.intersects(game.player1.solidArea)) {
                    entity.isCollision = true;
                }
                break;
            case "left":
                entity.solidArea.x-=entity.speed;
                if (entity.solidArea.intersects(game.player1.solidArea)) {
                    entity.isCollision = true;
                }
                break;
            case "right":
                entity.solidArea.x+=entity.speed;
                if (entity.solidArea.intersects(game.player1.solidArea)) {
                    entity.isCollision = true;
                }
                break;
        }
        entity.solidArea.x= entity.solidArea_defaultX;
        entity.solidArea.y=entity.solidArea_defaultY;
        game.player1.solidArea.x=game.player1.solidArea_defaultX;
        game.player1.solidArea.y=game.player1.solidArea_defaultY;
    }
}
