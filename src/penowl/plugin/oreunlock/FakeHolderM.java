/*    */ package penowl.plugin.oreunlock;
/*    */ 
/*    */ import org.bukkit.Location;
/*    */ import org.bukkit.inventory.Inventory;
/*    */ import org.bukkit.inventory.InventoryHolder;
/*    */ 
/*    */ public class FakeHolderM implements InventoryHolder
/*    */ {
/*  9 */   public Location grl = null;
/* 10 */   public String dis = "Sd";
/*    */   
/*    */   public Inventory getInventory()
/*    */   {
/* 14 */     return null;
/*    */   }
/*    */   
/*    */   public void setLoc(Location loc) {
/* 18 */     this.grl = loc;
/*    */   }
/*    */   
/*    */   public Location getLoc() {
/* 22 */     return this.grl;
/*    */   }
/*    */   
/*    */   public FakeHolderM(Location loc) {
/* 26 */     this.grl = loc;
/*    */   }
/*    */ }


/* Location:              C:\Users\JamesHammerel\Downloads\OreUnlock.jar!\penowl\plugin\oreunlock\FakeHolderM.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */