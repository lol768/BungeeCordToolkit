package me.lol768.bct;

import java.util.Collection;

import net.md_5.bungee.BungeeCord;
import net.md_5.bungee.ChatColor;
import net.md_5.bungee.Permission;
import net.md_5.bungee.UserConnection;
import net.md_5.bungee.command.Command;
import net.md_5.bungee.command.CommandSender;
import net.md_5.bungee.command.ConsoleCommandSender;

public class commandSendAll extends Command
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
			if (args.length != 1 || !servers.contains(args[0]))
			{
				sender.sendMessage(ChatColor.RED + "Usage: /sendall <valid server name>");
			}
			else
			{
				for (UserConnection con : BungeeCord.instance.connections.values())
				{
					con.connect(args[0]);
				}
			}
		}
    }
}
