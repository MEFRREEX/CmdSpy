package theoni.spy.listener;

import cn.nukkit.event.EventHandler;
import cn.nukkit.Player;
import cn.nukkit.event.player.PlayerCommandPreprocessEvent;
import cn.nukkit.utils.Config;
import theoni.spy.Main;
import cn.nukkit.event.Listener;

public class EventListener implements Listener {
    
    private Main plugin;
    private Config config;
    private boolean enableLog;
    
    public EventListener(Main plugin) {
        this.config = plugin.getConfig();
        this.enableLog = config.getBoolean("enable-logger");
        this.plugin = plugin;
    }
    
    @EventHandler
    public void onCommand(PlayerCommandPreprocessEvent event) {
        for (Player spyer : plugin.spyer) {
            spyer.sendMessage(config.getString("spy-message-format")
                .replace("&", "§")
                .replace("{prefix}", plugin.getPrefix())
                .replace("{sender}", event.getPlayer().getName())
                .replace("{tag}", event.getPlayer().getNameTag())
                .replace("{command}", event.getMessage().toLowerCase()));
            }
        if (enableLog) {
            plugin.getServer().getLogger().info(config.getString("logger-format")
                .replace("&", "§")
                .replace("{prefix}", plugin.getConsolePrefix())
                .replace("{sender}", event.getPlayer().getName())
                .replace("{tag}", event.getPlayer().getNameTag())
                .replace("{command}", event.getMessage().toLowerCase()));
        }
    }
}
