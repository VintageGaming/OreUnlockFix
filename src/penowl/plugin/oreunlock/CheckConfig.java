package penowl.plugin.oreunlock;

import java.io.File;

import org.bukkit.plugin.Plugin;

public class CheckConfig {

	Plugin plugin;
	File file;
		public CheckConfig(Main plugin)
		{
			this.plugin = plugin;
			try{
				if(!plugin.getDataFolder().exists()){
					plugin.getDataFolder().mkdirs();
				}
				file = new File(plugin.getDataFolder(), "config.yml");
				if(!file.exists()){
					plugin.getLogger().info("Creating Config.yml.....");
					plugin.saveDefaultConfig();
				}else{
					plugin.getLogger().info("Loading Config.yml......");
				}
			} catch(Exception e){
				e.printStackTrace();
			}
		}
}
