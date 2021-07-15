package me.jaydusk.dusklightpunishments.GUI;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class GUIListener implements Listener {

    public String playerName;

    @EventHandler
    public void onGUIInteract(InventoryClickEvent e){

        Player player = (Player) e.getWhoClicked();
        ItemStack item = e.getCurrentItem();

        if(item != null && item.getType() != null && e.getView().getTitle().contains("Online Players Page - ")){

            int page = Integer.parseInt(e.getClickedInventory().getItem(0).getItemMeta().getLocalizedName());

            if(e.getRawSlot() == 0 && item.getType().equals(Material.LIME_STAINED_GLASS_PANE)){
                new GUI(player, page - 1);
            }else if(e.getRawSlot() == 8 && item.getType().equals(Material.LIME_STAINED_GLASS_PANE)){
                new GUI(player, page + 1);
            }else if(item.getType().equals(Material.PLAYER_HEAD) && item.hasItemMeta()){
                playerName = item.getItemMeta().getDisplayName();
            }

            e.setCancelled(true);

        }


    }
}
