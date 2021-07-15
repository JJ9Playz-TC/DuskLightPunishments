package me.jaydusk.dusklightpunishments.GUI;

import me.jaydusk.dusklightpunishments.Util.PageUtil;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.ArrayList;
import java.util.List;

public class GUI {
    public GUI(Player player, int page) {

        Inventory gui = Bukkit.createInventory(null, 54, "Online Players Page - " + page);

        List<ItemStack> allItems = new ArrayList<>();
        for(Player p : Bukkit.getOnlinePlayers()){

            ItemStack head = new ItemStack(Material.PLAYER_HEAD);
            SkullMeta meta = (SkullMeta) head.getItemMeta();
            meta.setOwningPlayer(p);
            meta.setDisplayName(p.getDisplayName());
            head.setItemMeta(meta);

            allItems.add(head);
        }
        ItemStack left;
        ItemMeta leftMeta;
        if(PageUtil.isPageValid(allItems, page - 1, 52)){
            left = new ItemStack(Material.LIME_STAINED_GLASS_PANE);
            leftMeta = left.getItemMeta();
            leftMeta.setDisplayName(ChatColor.GREEN + "GO TO NEXT PAGE");
        }else{
            left = new ItemStack(Material.RED_STAINED_GLASS_PANE);
            leftMeta = left.getItemMeta();
            leftMeta.setDisplayName(ChatColor.DARK_RED + "NO PAGE AVAILABLE");
        }
        leftMeta.setLocalizedName(page + "");
        left.setItemMeta(leftMeta);

        gui.setItem(0, left);

        ItemStack right;
        ItemMeta rightMeta;
        if(PageUtil.isPageValid(allItems, page - 1, 52)){
            right = new ItemStack(Material.LIME_STAINED_GLASS_PANE);
            rightMeta = right.getItemMeta();
            rightMeta.setDisplayName(ChatColor.GREEN + "GO TO NEXT PAGE");
        }else{
            right = new ItemStack(Material.RED_STAINED_GLASS_PANE);
            rightMeta = right.getItemMeta();
            rightMeta.setDisplayName(ChatColor.DARK_RED + "NO PAGE AVAILABLE");
        }
        right.setItemMeta(rightMeta);

        gui.setItem(8, right);

        for(ItemStack item : PageUtil.getPageItems(allItems, page, 52)) {
            gui.setItem(gui.firstEmpty(), item);
        }

        player.openInventory(gui);

    }
}
