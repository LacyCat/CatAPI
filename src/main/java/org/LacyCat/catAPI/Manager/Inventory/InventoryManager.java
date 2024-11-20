package org.LacyCat.catAPI.Manager.Inventory;

import org.bukkit.Bukkit;
import org.bukkit.inventory.Inventory;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import java.util.List;

public class InventoryManager {
    /**
     * 인벤토리 생성
     * @param size 인벤토리 칸의 갯수
     * @param title 인벤토리의 이름
     * @return 정확히 파악되지는 않았으나, 생성된 인벤토리를 반환
     * @throws IllegalArgumentException 인자 오류
     * <ul>
     *     <li>인벤토리가 0이나 그 이하인 경우</li>
     *     <li>인벤토리의 이름이 null일 때</li>
     * </ul>
     */
    public Inventory createMenu(int size, String title) throws IllegalArgumentException {
        if (size <= 0) {
            throw new IllegalArgumentException("인벤토리는 적어도 0칸보다 커야 합니다");
        }
        if (title == null || title.isEmpty()) {
            throw  new IllegalArgumentException("인벤토리 이름은 null이 될 수 없습니다");
        }
        return Bukkit.createInventory(null, size, ChatColor.translateAlternateColorCodes('&', title));
    }

    /**
     * 인벤토리에 아이템 추가
     * @param inventory 적용할 인벤토리
     * @param slot 슬롯 수 (각 슬롯마다 지정 가능)
     * @param material 넣을 재료
     * @param name 아이템 이름
     * @param lore 아이템 설명
     * @apiNote 참고로 지금은 이름, 설명만 지정이 가능하다
     * @throws IllegalArgumentException 아이템 재료가 null일 때
     * @throws IndexOutOfBoundsException 아이템 칸이 초과했을때
     */
    public void addItemToMenu(Inventory inventory, int slot, Material material, String name, String... lore) throws IllegalArgumentException, IndexOutOfBoundsException {
        if (material == null) {
            throw new IllegalArgumentException("아이템 재료는 null이 될 수 없습니다");
        }
        if (slot < 0 || slot >= inventory.getSize()) {
            throw new IndexOutOfBoundsException("칸 번호를 초과하였습니다");
        }
        ItemStack item = new ItemStack(material);
        ItemMeta meta = item.getItemMeta();
        if (meta != null) {
            meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', name));
            meta.setLore(List.of(lore));
            item.setItemMeta(meta);
        }
        inventory.setItem(slot, item);
    }

    /**
     * 인벤토리 열기
     * @param player 열 플레이어를 지정한다
     * @param inventory player 에게 무슨 inventory를 열지 정한다
     * @throws NullPointerException 플레이어가 null 인 경우
     * @throws IllegalArgumentException 인벤토리가 null 인 경우
     */
    public void openMenu(Player player, Inventory inventory) throws NullPointerException, IllegalArgumentException {
        if (player == null) {
            throw new NullPointerException("플레이어는 null이 될 수 없습니다");
        }
        if (inventory == null) {
            throw new IllegalArgumentException("인벤토리는 null이 될 수 없습니다");
        }
        player.openInventory(inventory);
    }

}
