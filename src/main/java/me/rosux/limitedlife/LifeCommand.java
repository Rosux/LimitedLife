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
        player.sendMessage(ChatColor.DARK_RED + "------------------------------------------");
    }
    public static void noLifes(Player player){
        player.sendMessage(ChatColor.DARK_RED + "---------------limited♥Life---------------");
        player.sendMessage(
                ChatColor.WHITE + "——————No Lifes?——————\n",
                ChatColor.WHITE + "⠀⣞⢽⢪⢣⢣⢣⢫⡺⡵⣝⡮⣗⢷⢽⢽⢽⣮⡷⡽⣜⣜⢮⢺⣜⢷⢽⢝⡽⣝\n",
                ChatColor.WHITE + "⠸⡸⠜⠕⠕⠁⢁⢇⢏⢽⢺⣪⡳⡝⣎⣏⢯⢞⡿⣟⣷⣳⢯⡷⣽⢽⢯⣳⣫⠇\n",
                ChatColor.WHITE + "⠀⠀⢀⢀⢄⢬⢪⡪⡎⣆⡈⠚⠜⠕⠇⠗⠝⢕⢯⢫⣞⣯⣿⣻⡽⣏⢗⣗⠏⠀\n",
                ChatColor.WHITE + "⠀⠪⡪⡪⣪⢪⢺⢸⢢⢓⢆⢤⢀⠀⠀⠀⠀⠈⢊⢞⡾⣿⡯⣏⢮⠷⠁⠀⠀  \n",
                ChatColor.WHITE + "⠀⠀⠀⠈⠊⠆⡃⠕⢕⢇⢇⢇⢇⢇⢏⢎⢎⢆⢄⠀⢑⣽⣿⢝⠲⠉⠀⠀⠀⠀\n",
                ChatColor.WHITE + "⠀⠀⠀⠀⠀⡿⠂⠠⠀⡇⢇⠕⢈⣀⠀⠁⠡⠣⡣⡫⣂⣿⠯⢪⠰⠂⠀⠀⠀⠀\n",
                ChatColor.WHITE + "⠀⠀⠀⠀⡦⡙⡂⢀⢤⢣⠣⡈⣾⡃⠠⠄⠀⡄⢱⣌⣶⢏⢊⠂⠀⠀⠀⠀⠀⠀\n",
                ChatColor.WHITE + "⠀⠀⠀⠀⢝⡲⣜⡮⡏⢎⢌⢂⠙⠢⠐⢀⢘⢵⣽⣿⡿⠁⠁⠀⠀⠀⠀⠀⠀⠀\n",
                ChatColor.WHITE + "⠀⠀⠀⠀⠨⣺⡺⡕⡕⡱⡑⡆⡕⡅⡕⡜⡼⢽⡻⠏⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n",
                ChatColor.WHITE + "⠀⠀⠀⠀⣼⣳⣫⣾⣵⣗⡵⡱⡡⢣⢑⢕⢜⢕⡝⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n",
                ChatColor.WHITE + "⠀⠀⠀⣴⣿⣾⣿⣿⣿⡿⡽⡑⢌⠪⡢⡣⣣⡟⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n",
                ChatColor.WHITE + "⠀⠀⠀⡟⡾⣿⢿⢿⢵⣽⣾⣼⣘⢸⢸⣞⡟⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n",
                ChatColor.WHITE + "⠀⠀⠀⠀⠁⠇⠡⠩⡫⢿⣝⡻⡮⣒⢽⠋⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n",
                ChatColor.WHITE + "—————————————————————"
        );
        player.sendMessage(ChatColor.DARK_RED + "------------------------------------------");
    }
    public static void deathMessage(Player player, int lives) {
        player.sendMessage(ChatColor.DARK_RED + "---------------limited♥Life---------------");
        player.sendMessage(ChatColor.WHITE + "Aww you died :( and now only have " + ChatColor.DARK_RED + String.valueOf(lives) + ChatColor.WHITE + " lives left!");
        player.sendMessage(ChatColor.DARK_RED + "------------------------------------------");
    }
    public static void sendLives(Player player, int lives) {
        player.sendMessage(ChatColor.DARK_RED + "---------------limited♥Life---------------");
        player.sendMessage(ChatColor.WHITE + "You have " + ChatColor.DARK_RED + String.valueOf(lives) + ChatColor.WHITE + " lives left!");
        player.sendMessage(ChatColor.DARK_RED + "------------------------------------------");
    }
    public static void sendHelp(Player player) {
        player.sendMessage(ChatColor.DARK_RED + "---------------limited♥Life---------------");
        player.sendMessage(ChatColor.WHITE + "/limitedlife (brings up this)");
        player.sendMessage(ChatColor.WHITE + "/limitedlife lives <player>");
        player.sendMessage(ChatColor.WHITE + "/limitedlife set <player> <lives>");
        player.sendMessage(ChatColor.WHITE + "/limitedlife add <player> <lives>");
        player.sendMessage(ChatColor.WHITE + "/limitedlife remove <player> <lives>");
        player.sendMessage(ChatColor.DARK_RED + "------------------------------------------");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender; // user of the command
            int lives; // lives to add/remove
            if (args.length <= 1 && !args[0].equalsIgnoreCase("lives")) {
                sendHelp(player);
                return false;
            }
            Player target = Bukkit.getPlayer(args[1]); // targeted user in the second argument
            switch (args[0].toLowerCase()) {
                case "lives":
                    if (args.length != 3) {
                        sendLives(player, LimitedLife.mapLives.get(player));
                    }else{
                        sendLives(player, LimitedLife.mapLives.get(target));
                    }
                    break;
                case "set":
                    if (args.length != 3) {
                        sendUsage(player, "set");
                        return false;
                    }
                    try {
                        lives = Integer.parseInt(args[2]);
                    } catch (NumberFormatException e) {
                        lives = 50;
                    } // string to int for third arg
                    LimitedLife.mapLives.put(target, lives);
                    break;
                case "add":
                    if (args.length != 3) {
                        sendUsage(player, "add");
                        return false;
                    }
                    try {
                        lives = Integer.parseInt(args[2]);
                    } catch (NumberFormatException e) {
                        lives = 0;
                    } // string to int for third arg
                    LimitedLife.mapLives.put(target, LimitedLife.mapLives.get(target) + lives);
                    break;
                case "remove":
                    if (args.length != 3) {
                        sendUsage(player, "remove");
                        return false;
                    }
                    try {
                        lives = Integer.parseInt(args[2]);
                    } catch (NumberFormatException e) {
                        lives = 0;
                    } // string to int for third arg
                    LimitedLife.mapLives.put(target, LimitedLife.mapLives.get(target) - lives);
                    break;
                default:
                    sendHelp(player);
                    break;
            }
            return false;
        }
        return false;
    }
}
























