package me.lol768.bct;

import net.md_5.bungee.plugin.JavaPlugin;
import me.lol768.bct.commandSend;

public class main extends JavaPlugin
{
	public void onEnable()
	{
		registerCommand("send", new commandSend());
		registerCommand("sendall", new commandSendAll());
	}
	
	
}
