 package penowl.plugin.oreunlock;
 
 import org.bukkit.ChatColor;
 import org.bukkit.entity.Player;
 import org.bukkit.event.EventHandler;
 import org.bukkit.event.Listener;
 import org.bukkit.event.inventory.InventoryClickEvent;
 import org.bukkit.plugin.Plugin;
  
 
 
 public final class ClickListener
   implements Listener
 {
   private static Plugin plugin;
   
   public ClickListener(Plugin plugin)
   {
     this.plugin = plugin;
   }
   
   @EventHandler
   public void someoneKnocked(InventoryClickEvent event) {
     if ((event.getInventory().getHolder() != null) && 
       ((event.getInventory().getHolder() instanceof FakeHolderM))) {
       Player player = (Player)event.getWhoClicked();
       int slot = event.getSlot();
       String configloc = "players." + player.getUniqueId().toString() + ".";
       event.setCancelled(true);
       int rank = plugin.getConfig().getInt(configloc + "rank");
       if ((slot == 1) && 
         (rank == -1) && (Main.economy.getBalance(player) >= plugin.getConfig().getInt("prices.stone"))) {
    	 plugin.getConfig().set(configloc + "rank", 0);
         plugin.saveConfig();
         player.closeInventory();
         Main.economy.withdrawPlayer(player, plugin.getConfig().getDouble("prices.stone"));
         player.sendMessage(ChatColor.YELLOW + "Unlocked " + ChatColor.BOLD + "Stone");
       }
       
       if ((slot == 2) && 
         (rank == 0) && (Main.economy.getBalance(player) >= plugin.getConfig().getInt("prices.coal"))) {
         plugin.getConfig().set(configloc + "rank", 1);
         plugin.saveConfig();
         player.closeInventory();
         Main.economy.withdrawPlayer(player, plugin.getConfig().getDouble("prices.coal"));
         player.sendMessage(ChatColor.YELLOW + "Unlocked " + ChatColor.BOLD + "Coal");
       }
       
       if ((slot == 3) && 
         (rank == 1) && (Main.economy.getBalance(player) >= plugin.getConfig().getInt("prices.iron"))) {
         plugin.getConfig().set(configloc + "rank", 2);
         plugin.saveConfig();
         player.closeInventory();
         Main.economy.withdrawPlayer(player, plugin.getConfig().getDouble("prices.iron"));
         player.sendMessage(ChatColor.YELLOW + "Unlocked " + ChatColor.BOLD + "Iron");
       }
       
       if ((slot == 4) && 
         (rank == 2) && (Main.economy.getBalance(player) >= plugin.getConfig().getInt("prices.gold"))) {
         plugin.getConfig().set(configloc + "rank", 3);
         plugin.saveConfig();
         player.closeInventory();
         Main.economy.withdrawPlayer(player, plugin.getConfig().getDouble("prices.gold"));
         player.sendMessage(ChatColor.YELLOW + "Unlocked " + ChatColor.BOLD + "Gold");
       }
       
       if ((slot == 5) && 
         (rank == 3) && (Main.economy.getBalance(player) >= plugin.getConfig().getInt("prices.redstone"))) {
         plugin.getConfig().set(configloc + "rank", 4);
         plugin.saveConfig();
         player.closeInventory();
         Main.economy.withdrawPlayer(player, plugin.getConfig().getDouble("prices.redstone"));
         player.sendMessage(ChatColor.YELLOW + "Unlocked " + ChatColor.BOLD + "Redstone and Lapis");
       }
       
       if ((slot == 6) && 
         (rank == 4) && (Main.economy.getBalance(player) >= plugin.getConfig().getInt("prices.diamond"))) {
         plugin.getConfig().set(configloc + "rank", 5);
         plugin.saveConfig();
         player.closeInventory();
         Main.economy.withdrawPlayer(player, plugin.getConfig().getDouble("prices.diamond"));
         player.sendMessage(ChatColor.YELLOW + "Unlocked " + ChatColor.BOLD + "Diamond");
       }
       
       if ((slot == 7) && 
         (rank == 5) && (Main.economy.getBalance(player) >= plugin.getConfig().getInt("prices.emerald"))) {
         plugin.getConfig().set(configloc + "rank", 6);
         plugin.saveConfig();
         player.closeInventory();
         Main.economy.withdrawPlayer(player, plugin.getConfig().getDouble("prices.emerald"));
         player.sendMessage(ChatColor.YELLOW + "Unlocked " + ChatColor.BOLD + "Emerald");
      }
     }
   }
 }
