package org.LacyCat.catAPI.Manager.NBT;

import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.NamespacedKey;

public class NBTManager {

    public ItemStack addNbt(ItemStack itemStack, String key, String value) {
        if (itemStack == null) {
            throw new IllegalArgumentException("아이템 스택은 null일 수 없습니다.");
        }
        if (key == null || key.isEmpty()) {
            throw new IllegalArgumentException("NBT 키는 null이거나 빈 문자열일 수 없습니다.");
        }
        if (value == null) {
            throw new IllegalArgumentException("NBT 값은 null일 수 없습니다.");
        }

        PersistentDataContainer container = itemStack.getItemMeta().getPersistentDataContainer();
        NamespacedKey nbtKey = new NamespacedKey("lacycat", key); // "lacycat"은 네임스페이스로 원하는 것으로 설정 가능
        container.set(nbtKey, PersistentDataType.STRING, value);
        itemStack.setItemMeta(itemStack.getItemMeta()); // 아이템 메타를 다시 설정

        return itemStack;
    }

    // NBT 읽기
    public String readNbt(ItemStack itemStack, String key) {
        if (itemStack == null) {
            throw new IllegalArgumentException("아이템 스택은 null일 수 없습니다.");
        }
        if (key == null || key.isEmpty()) {
            throw new IllegalArgumentException("NBT 키는 null이거나 빈 문자열일 수 없습니다.");
        }

        PersistentDataContainer container = itemStack.getItemMeta().getPersistentDataContainer();
        NamespacedKey nbtKey = new NamespacedKey("lacycat", key);
        if (container.has(nbtKey, PersistentDataType.STRING)) {
            return container.get(nbtKey, PersistentDataType.STRING);
        }
        return null;
    }
}
