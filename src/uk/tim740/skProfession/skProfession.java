package uk.tim740.skProfession;

import ch.njol.skript.Skript;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Created by tim740 on 20/10/2016
 */
public class skProfession extends JavaPlugin {

    @Override
    public void onEnable() {
        Skript.registerEffect(EffVillagerProfession.class, "spawn a (0¦zombie villager|1¦villager) with profession %profession% at %location%");
    }
}
