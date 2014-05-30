package staffchat.codechimps.co.uk;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class main extends JavaPlugin{

	public void onEnable(){
	
	}

	String staffPrefix = ChatColor.DARK_GRAY + "[" + ChatColor.DARK_RED + "STAFF" + ChatColor.DARK_GRAY + "] " + ChatColor.RED;

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){	
			if(cmd.getName().equalsIgnoreCase("sc")){
				String message;
				StringBuilder builder = new StringBuilder();
				for(int i = 0; i < args.length; i++)
				{
				builder.append(args[i]).append(" ");
				}
				message = builder.toString();
			
				Player player = (Player) sender;
				if(sender instanceof Player){	
					if(player.hasPermission("staffchat.chat")){
						String playerName = player.getDisplayName();
			        	 for(Player p : Bukkit.getOnlinePlayers()){
			        	 
			            	 if(p.hasPermission("staffchat.chat")){
			               	  p.sendMessage(staffPrefix + playerName + ChatColor.RESET + ChatColor.DARK_GRAY + ": " + ChatColor.AQUA + message);
			           	  }
			  
			       	  } 		
					}
				}
				else
				{
					sender.sendMessage(ChatColor.RED + "Cannot currently talk from console!");	
				}	
		}
	return false;
}
}
