 package penowl.plugin.oreunlock;
 
 import java.util.ArrayList;
 import org.bukkit.ChatColor;
 import org.bukkit.Bukkit;
 import org.bukkit.Material;
 import org.bukkit.enchantments.Enchantment;
 import org.bukkit.entity.Player;
 import org.bukkit.inventory.Inventory;
 import org.bukkit.inventory.ItemFlag;
 import org.bukkit.inventory.ItemStack;
 import org.bukkit.inventory.meta.ItemMeta;
 import org.bukkit.plugin.Plugin;
 
 
 public class InvManagement
 {
   static Plugin plugin;
   
   public InvManagement(Main plugin)
   {
     this.plugin = plugin;
   }
   
   public static ItemStack mmai(Material type, int amount, short dmg, String name) {
     ItemStack item = new ItemStack(type, amount, dmg);
     setName(item, name);
     return item;
   }
   
   public static ItemStack setName(ItemStack items, String name) {
     ItemMeta meta = items.getItemMeta();
     meta.setDisplayName(name);
     items.setItemMeta(meta);
     return items;
   }
   /* Might be useful for later projects
   public static ItemStack setOwner(String name) {
	   //Unused Function - Returns Skull Of Player - Fix Deprecated Method(meta.setOwner)
     ItemStack skull = new ItemStack(Material.SKULL_ITEM, 1, (short)SkullType.PLAYER.ordinal());
     SkullMeta meta = (SkullMeta)skull.getItemMeta();
     meta.setOwner(name);
     meta.setDisplayName(ChatColor.GREEN + "Owner: " + ChatColor.RESET + name);
     skull.setItemMeta(meta);
     return skull;
   }*/
   
   public static ItemStack tfwool(boolean bln) {
     if (bln) {
       return mmai(Material.WOOL, 1, (short)5, ChatColor.RESET + "" + ChatColor.GREEN + "TRUE");
     }
     return mmai(Material.WOOL, 1, (short)14, ChatColor.RESET + "" + ChatColor.RED + "FALSE");
   }
   
   public static ItemStack sbwool(boolean bln) {
     if (bln) {
       return mmai(Material.WOOL, 1, (short)4, ChatColor.RESET + "" + ChatColor.YELLOW + "BUY");
     }
     return mmai(Material.WOOL, 1, (short)10, ChatColor.RESET + "" + ChatColor.DARK_PURPLE + "SELL");
   }
   
   public static ItemStack conLE(ItemStack item, String name, String s1, Boolean ench)
   {
     String dname = ChatColor.RESET + "" + ChatColor.AQUA + name;
     ItemMeta meta = item.getItemMeta();
     ArrayList<String> lore = new ArrayList<String>();
     lore.add(ChatColor.RESET + "" + ChatColor.GRAY + s1);
     meta.setLore(lore);
     meta.setDisplayName(dname);
     //Nice Idea for Giving a hidden Enchant Effect
     if (ench.booleanValue()) {
       meta.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
       meta.addEnchant(Enchantment.FROST_WALKER, 1, true);
     }
     //---------------------------------------------------------------
     item.setItemMeta(meta);
     return item;
   }
   
   //Create OreUnlock Buy Inventory
   public static Inventory createInventory(Player player) {
     String configloc = "players." + player.getUniqueId().toString() + ".";
     if (!plugin.getConfig().contains(configloc + "rank"))
    	 plugin.getConfig().set(configloc + "rank", 0);
     String ranka = plugin.getConfig().getString(configloc + "rank");
     plugin.getConfig().set(configloc + "name", player.getName());
     if ((ranka == "") || (ranka == null)) {
       plugin.getConfig().set(configloc + "rank", Integer.valueOf(plugin.getConfig().getInt("starting-rank")));
     }
     int rank = plugin.getConfig().getInt(configloc + "rank");
     Inventory inventory = Bukkit.createInventory(new FakeHolderM(null), 9, "Ore Unlock");
     inventory.setItem(1, conLE(mmai(Material.STONE, 1, (short)0, ""), ChatColor.RESET + "" + ChatColor.AQUA + "Stone", ChatColor.RESET + "" + ChatColor.GREEN + "$" + plugin.getConfig().getString("prices.stone"), Boolean.valueOf(rank > -1)));
     inventory.setItem(2, conLE(mmai(Material.COAL_ORE, 1, (short)0, ""), ChatColor.RESET + "" + ChatColor.AQUA + "Coal", ChatColor.RESET + "" + ChatColor.GREEN + "$" + plugin.getConfig().getString("prices.coal"), Boolean.valueOf(rank > 0)));
     inventory.setItem(3, conLE(mmai(Material.IRON_ORE, 1, (short)0, ""), ChatColor.RESET + "" + ChatColor.AQUA + "Iron", ChatColor.RESET + "" + ChatColor.GREEN + "$" + plugin.getConfig().getString("prices.iron"), Boolean.valueOf(rank > 1)));
     inventory.setItem(4, conLE(mmai(Material.GOLD_ORE, 1, (short)0, ""), ChatColor.RESET + "" + ChatColor.AQUA + "Gold", ChatColor.RESET + "" + ChatColor.GREEN + "$" + plugin.getConfig().getString("prices.gold"), Boolean.valueOf(rank > 2)));
     inventory.setItem(5, conLE(mmai(Material.REDSTONE_ORE, 1, (short)0, ""), ChatColor.RESET + "" + ChatColor.AQUA + "Redstone and Lapis", ChatColor.RESET + "" + ChatColor.GREEN + "$" + plugin.getConfig().getString("prices.redstone"), Boolean.valueOf(rank > 3)));
     inventory.setItem(6, conLE(mmai(Material.DIAMOND_ORE, 1, (short)0, ""), ChatColor.RESET + "" + ChatColor.AQUA + "Diamond", ChatColor.RESET + "" + ChatColor.GREEN + "$" + plugin.getConfig().getString("prices.diamond"), Boolean.valueOf(rank > 4)));
     inventory.setItem(7, conLE(mmai(Material.EMERALD_ORE, 1, (short)0, ""), ChatColor.RESET + "" + ChatColor.AQUA + "Emerald", ChatColor.RESET + "" + ChatColor.GREEN + "$" + plugin.getConfig().getString("prices.emerald"), Boolean.valueOf(rank > 5)));
     return inventory;
   }
 }