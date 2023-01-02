package theoni.spy;

import theoni.spy.commands.SpyCommand;
import java.util.ArrayList;
import theoni.spy.listener.EventListener;
import cn.nukkit.Player;
import java.util.List;
import cn.nukkit.utils.Config;
import cn.nukkit.plugin.PluginBase;

public class Main extends PluginBase {

    public Config config;
    public List<Player> spyer;
    
    public void onEnable() {
        this.saveDefaultConfig();
        config = getConfig();
        this.spyer = new ArrayList<Player>();
        this.getServer().getPluginManager().registerEvents(new EventListener(this), this);
        this.getServer().getCommandMap().register("help", new SpyCommand(this));
    }

    public String getPrefix() {
        return config.getString("spy-prefix");
    }
    public String getConsolePrefix() {
        return config.getString("log-prefix");
    }
}
