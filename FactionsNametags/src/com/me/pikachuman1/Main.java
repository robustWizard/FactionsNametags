package com.me.pikachuman1;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import org.kitteh.tag.AsyncPlayerReceiveNameTagEvent;
import com.massivecraft.factions.Rel;
import com.massivecraft.factions.entity.UPlayer;


public class Main extends JavaPlugin implements Listener{
	
	public void onEnable(){
		System.out.println(ChatColor.BLUE+"FactionsNametags Enabled");
		getServer().getPluginManager().registerEvents(this, this);
	}
	public void onDisable(){
		System.out.println(ChatColor.RED+"FactionsNametags Disabled");
		getServer().getPluginManager().registerEvents(this, this);
	}
	@EventHandler
	public void onNameTag(AsyncPlayerReceiveNameTagEvent event) {
		Player player = event.getPlayer();
		UPlayer uplayer = UPlayer.get(player);
		Player namedplayer = event.getNamedPlayer();
		UPlayer nameduplayer = UPlayer.get(namedplayer);
		Rel relation = uplayer.getFaction().getRelationTo(nameduplayer.getFaction());
		ChatColor color = relation.getColor();
		
		event.setTag(color+namedplayer.getName());
		
		
		
		}
	}