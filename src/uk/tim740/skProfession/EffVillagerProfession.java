package uk.tim740.skProfession;

import ch.njol.skript.lang.Effect;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.util.Kleenean;
import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Villager;
import org.bukkit.entity.Zombie;
import org.bukkit.event.Event;

/**
 * Created by tim740 on 18/02/2016
 */

public class EffVillagerProfession extends Effect {
    private Expression<Location> loca;
    private Expression<Villager.Profession> prof;
    private int ty;

    @Override
    protected void execute(Event e) {
        Location loc = loca.getSingle(e);
        if (ty == 0) {
            Zombie zom = (Zombie) loc.getWorld().spawnEntity(loc, EntityType.ZOMBIE);
            zom.setVillagerProfession(prof.getSingle(e));
        } else {
            Villager vil = (Villager) loc.getWorld().spawnEntity(loc, EntityType.VILLAGER);
            vil.setProfession(prof.getSingle(e));
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public boolean init(Expression<?>[] e, int i, Kleenean k, SkriptParser.ParseResult p) {
        prof = (Expression<Villager.Profession>) e[0];
        loca = (Expression<Location>) e[1];
        ty = p.mark;
        return true;
    }

    @Override
    public String toString(Event e, boolean b) {
        return getClass().getName();
    }
}
