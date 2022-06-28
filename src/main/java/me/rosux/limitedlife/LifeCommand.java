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
        player.sendMessage(ChatColor.WHITE + "/limitedlife lives");
        player.sendMessage(ChatColor.WHITE + "/limitedlife set <player> <lives>");
        player.sendMessage(ChatColor.WHITE + "/limitedlife add <player> <lives>");
        player.sendMessage(ChatColor.WHITE + "/limitedlife remove <player> <lives>");
        player.sendMessage(ChatColor.DARK_RED + "------------------------------------------");
    }
    public static void cantFindPlayer(Player player) {
        player.sendMessage(ChatColor.DARK_RED + "---------------limited♥Life---------------");
        player.sendMessage(ChatColor.WHITE + "Couldn't find the player you specified (perhaps never joined)");
        player.sendMessage(ChatColor.DARK_RED + "------------------------------------------");
    }
    public static void success(Player player) {
        player.sendMessage(ChatColor.DARK_RED + "---------------limited♥Life---------------");
        player.sendMessage(ChatColor.WHITE + "Success");
        player.sendMessage(ChatColor.DARK_RED + "------------------------------------------");
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
                        return false;
                    }
                    try {
                        lives = Integer.parseInt(args[2]);
                    } catch (NumberFormatException e) {
                        lives = 50;
                    } // string to int for third arg
                    if(target != null){
                        LimitedLife.mapLives.put(target.getUniqueId(), lives);
                    }else{
                        cantFindPlayer(player);
                    }
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
                    if(target != null){
                        LimitedLife.mapLives.put(target.getUniqueId(), LimitedLife.mapLives.get(target.getUniqueId()) + lives);
                    }else{
                        cantFindPlayer(player);
                    }
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
                    if(target != null){
                        LimitedLife.mapLives.put(target.getUniqueId(), LimitedLife.mapLives.get(target.getUniqueId()) - lives);
                    }else{
                        cantFindPlayer(player);
                    }
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
























