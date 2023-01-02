package theoni.spy.commands;

import cn.nukkit.Player;
import cn.nukkit.command.CommandSender;
import cn.nukkit.command.PluginCommand;
import cn.nukkit.utils.Config;
import theoni.spy.Main;


public class SpyCommand extends PluginCommand<Main> {

    private Main plugin;
    private Config config;
    
    public SpyCommand(Main plugin) {
        super(plugin.getConfig().getString("command.name"), plugin);
        this.setDescription(plugin.getConfig().getString("command.description"));
        this.setAliases(plugin.getConfig().getStringList("command.aliases").toArray(new String[]{}));
        this.setPermission("spy.use");
        this.plugin = plugin;
        this.config = plugin.getConfig();
    }
    
    public boolean execute(CommandSender sender, String label, String[] args) {
    
        if (!(sender instanceof Player)) {
            sender.sendMessage(config.getString("only-ingame")
                .replace("&", "§")
                .replace("{prefix}", plugin.getPrefix()));
            return false;
        }
        if (!sender.hasPermission("spy.use")) {
            sender.sendMessage(config.getString("no-permission")
                .replace("&", "§")
                .replace("{prefix}", plugin.getPrefix()));
            return false;
        }

        Player player = (Player)sender;
        if (this.getPlugin().spyer.contains(player)) {
            this.getPlugin().spyer.remove(player);
            player.sendMessage(config.getString("spy-off")
                .replace("&", "§")
                .replace("{prefix}", plugin.getPrefix()));
        } else {
            this.getPlugin().spyer.add(player);
            player.sendMessage(config.getString("spy-on")
                .replace("&", "§")
                .replace("{prefix}", plugin.getPrefix()));
        }
        return true;
    }
}
