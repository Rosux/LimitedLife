package me.rosux.limitedlife;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class LifeCommand implements CommandExecutor {
    public static void sendUsage(Player player, String usage){
        player.sendMessage(ChatColor.DARK_RED + "---------------limited♥Life---------------");
        switch (usage.toLowerCase()){
            case "set":
                player.sendMessage(ChatColor.WHITE + "/limitedlife set <player> <lives>");
            case "add":
                player.sendMessage(ChatColor.WHITE + "/limitedlife add <player> <lives>");
            case "remove":
                player.sendMessage(ChatColor.WHITE + "/limitedlife remove <player> <lives>");
        }
        player.sendMessage(ChatColor.DARK_RED + "---------------------------------------");
    }
    public static void noLifes(Player player){
        player.sendMessage(ChatColor.DARK_RED + "---------------limited♥Life---------------");
        player.sendMessage(ChatColor.WHITE + "You've got no lives left!");
        player.sendMessage(ChatColor.DARK_RED + "---------------------------------------");
    }
    public static void sendLives(Player player, int lives) {
        player.sendMessage(ChatColor.DARK_RED + "---------------limited♥Life---------------");
        player.sendMessage(ChatColor.WHITE + "You currently have " + ChatColor.DARK_RED + String.valueOf(lives) + ChatColor.WHITE + " lives left!");
        player.sendMessage(ChatColor.DARK_RED + "---------------------------------------");
    }
    public static void sendHelp(Player player) {
        player.sendMessage(ChatColor.DARK_RED + "---------------limited♥Life---------------");
        player.sendMessage(ChatColor.WHITE + "/limitedlife (brings up this)");
        player.sendMessage(ChatColor.WHITE + "/limitedlife lives");
        player.sendMessage(ChatColor.WHITE + "/limitedlife set <player> <lives>");
        player.sendMessage(ChatColor.WHITE + "/limitedlife add <player> <lives>");
        player.sendMessage(ChatColor.WHITE + "/limitedlife remove <player> <lives>");
        player.sendMessage(ChatColor.DARK_RED + "---------------------------------------");
    }
    public static void cantFindPlayer(Player player) {
        player.sendMessage(ChatColor.DARK_RED + "---------------limited♥Life---------------");
        player.sendMessage(ChatColor.WHITE + "Couldn't find the player you specified (perhaps never joined)");
        player.sendMessage(ChatColor.DARK_RED + "---------------------------------------");
    }
    public static void setSuccess(Player player, String target, String lives) {
        player.sendMessage(ChatColor.DARK_RED + "---------------limited♥Life---------------");
        player.sendMessage(ChatColor.WHITE + "Successfully set " + target + " lives to " + lives);
        player.sendMessage(ChatColor.DARK_RED + "---------------------------------------");
    }
    public static void addSuccess(Player player, String target, String lives) {
        player.sendMessage(ChatColor.DARK_RED + "---------------limited♥Life---------------");
        player.sendMessage(ChatColor.WHITE + "Successfully added " + lives + " to " + target + "'s total lives");
        player.sendMessage(ChatColor.DARK_RED + "---------------------------------------");
    }
    public static void removeSuccess(Player player, String target, String lives) {
        player.sendMessage(ChatColor.DARK_RED + "---------------limited♥Life---------------");
        player.sendMessage(ChatColor.WHITE + "Successfully removed " + lives + " from " + target + "'s total lives");
        player.sendMessage(ChatColor.DARK_RED + "---------------------------------------");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender; // user of the command
            Player target;
            int lives; // lives to add/remove
            if (args.length == 0) {
                sendHelp(player);
                return false;
            }
            if(args.length > 2){
                target = Bukkit.getPlayer(args[1]); // targeted user in the second argument
            }else{
                target = null;
            }
            switch (args[0].toLowerCase()) {
                case "lives":
                    sendLives(player, LimitedLife.mapLives.get(player.getUniqueId()));
                    break;
                case "set":
                    if (args.length != 3) {
                        sendUsage(player, "set");
                        break;
                    }
                    try {
                        lives = Integer.parseInt(args[2]);
                    } catch (NumberFormatException e) {
                        lives = LimitedLife.defaultLives;
                    } // string to int for third arg
                    if(target != null){
                        LimitedLife.mapLives.put(target.getUniqueId(), lives);
                    }else{
                        cantFindPlayer(player);
                        break;
                    }
                    setSuccess(player, target.getName(), String.valueOf(lives));
                    saveHashToConfig(target);
                    break;
                case "add":
                    if (args.length != 3) {
                        sendUsage(player, "add");
                        break;
                    }
                    try {
                        lives = Integer.parseInt(args[2]);
                    } catch (NumberFormatException e) {
                        lives = 0;
                    } // string to int for third arg
                    if(target != null){
                        LimitedLife.mapLives.put(target.getUniqueId(), LimitedLife.mapLives.get(target.getUniqueId()) + lives);
                    }else{
                        cantFindPlayer(player);
                        break;
                    }
                    addSuccess(player, target.getName(), String.valueOf(args[2]));
                    saveHashToConfig(target);
                    break;
                case "remove":
                    if (args.length != 3) {
                        sendUsage(player, "remove");
                        break;
                    }
                    try {
                        lives = Integer.parseInt(args[2]);
                    } catch (NumberFormatException e) {
                        lives = 0;
                    } // string to int for third arg
                    if(target != null){
                        LimitedLife.mapLives.put(target.getUniqueId(), LimitedLife.mapLives.get(target.getUniqueId()) - lives);
                    }else{
                        cantFindPlayer(player);
                        break;
                    }
                    removeSuccess(player, target.getName(), String.valueOf(args[2]));
                    saveHashToConfig(target);
                    break;
                default:
                    sendHelp(player);
                    break;
            }
        }
        return false;
    }

    public static void saveHashToConfig(Player target){
        LimitedLife.instance.getConfig().set("player." + target.getUniqueId().toString(), LimitedLife.mapLives.get(target.getUniqueId()));
    }
}
