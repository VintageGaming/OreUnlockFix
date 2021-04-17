 package penowl.plugin.oreunlock;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

import net.milkbowl.vault.economy.Economy;

public class Main
   extends JavaPlugin
 {
   private final ClickListener clickListener = new ClickListener(this);
   private final InvManagement invManagement = new InvManagement(this);
   private final ProtectListener protectListener = new ProtectListener(this);
   public static CheckConfig Sconfig;
           public static InvManagement InvManage;
           public static Plugin plugin;
   
   public static Economy economy = null;
   
   private Boolean setupEconomy()
   {
     RegisteredServiceProvider<Economy> economyProvider = getServer().getServicesManager().getRegistration(Economy.class);
     if (economyProvider != null) {
       economy = (Economy)economyProvider.getProvider();
     }
     if (economyProvider != null) return Boolean.valueOf(true); return Boolean.valueOf(false);
   }
/*    */   
/*    */   public void onEnable()
/*    */   {
	         //Bug Fix By: VintageGaming
	         //Also removed some Useless Functions lol
/* 49 */     getConfig();
/* 50 */     PluginManager pm = getServer().getPluginManager();
/* 51 */     pm.registerEvents(this.clickListener, this);
/* 52 */     pm.registerEvents(this.protectListener, this);
/* 53 */     PluginDescriptionFile pdfFile = getDescription();
/* 54 */     getLogger().info("A wild " + pdfFile.getName() + " version " + pdfFile.getVersion() + " appeared!");
/* 55 */     setupEconomy();
             InvManage = invManagement;
             Sconfig = new CheckConfig(this);
             getLogger().info(ChatColor.GREEN + "Bug Fix by: VintageGaming");
/*    */   }
/*    */   
/*    */   public void onDisable()
/*    */   {
/* 63 */     //nothing to do. sad.
/*    */   }
/*    */   
/*    */   public boolean onCommand(CommandSender sender, Command command, String flag, String[] args) {
/* 67 */     Boolean perm = Boolean.valueOf(false);
/* 68 */     Boolean perm1 = Boolean.valueOf(false);
/* 69 */     Player player = null;
/* 70 */     if ((sender instanceof Player)) {
/* 71 */       player = (Player)sender;
/* 72 */       perm = Boolean.valueOf(player.hasPermission("oreunlock.admin"));
/* 73 */       perm1 = Boolean.valueOf(player.hasPermission("oreunlock.use"));
/*    */     }
/* 75 */     if ((command.getName().equalsIgnoreCase("oreunlock")) || (command.getName().equalsIgnoreCase("oreu")) || (command.getName().equalsIgnoreCase("ou"))) {
/* 76 */       if ((sender instanceof Player)) {
/* 77 */         if ((perm1.booleanValue()) && (args.length == 0)) {
/* 78 */           player.openInventory(InvManagement.createInventory(player));
/* 79 */           return true;
/*    */         }
/* 81 */         if ((perm.booleanValue()) && (args.length == 2) && (args[0].compareTo("get") == 0)) {
/* 82 */           player.sendMessage(getConfig().getString("players." + Bukkit.getPlayer(args[1]).getUniqueId().toString() + ".rank"));
/* 83 */           return true;
/*    */         }
/* 85 */         if ((perm.booleanValue()) && (args.length == 3) && (args[0].compareTo("set") == 0)) {
/* 86 */           getConfig().set("players." + Bukkit.getPlayer(args[1]).getUniqueId().toString() + ".rank", Integer.valueOf(args[2]));
/* 87 */           player.sendMessage("Mining level set!");
/* 88 */           return true;
/*    */         }
/*    */       }
/* 91 */       return false;
/*    */     }
/* 93 */     return true;
/*    */   }
/*    */ }