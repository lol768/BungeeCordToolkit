package me.lol768.bct;

import java.util.Collection;

import net.md_5.bungee.BungeeCord;
import net.md_5.bungee.ChatColor;
import net.md_5.bungee.Permission;
import net.md_5.bungee.UserConnection;
import net.md_5.bungee.command.Command;
import net.md_5.bungee.command.CommandSender;
import net.md_5.bungee.command.ConsoleCommandSender;

public class commandSend extends Command
{
	@Override
    public void execute(CommandSender sender, String[] args)
    {
		if (!(sender instanceof ConsoleCommandSender) && getPermission(sender) != Permission.MODERATOR && getPermission(sender) != Permission.ADMIN)
		{
			sender.sendMessage(ChatColor.RED + "You must be a moderator for this command");
		}
		else
		{
			Collection<String> servers = BungeeCord.instance.config.servers.keySet();
			UserConnection player = BungeeCord.instance.connections.get(args[0]);
			if (args.length != 2 || !servers.contains(args[1]) || player == null)
			{
				sender.sendMessage(ChatColor.RED + "Usage: /send <full player name> <valid server name>");
			}
			else
			{
				player.connect(args[1]);
			}
		}
    }
}
