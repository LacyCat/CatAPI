package org.LacyCat.catAPI.Manager.Utils;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;

import java.util.UUID;

public class UtilsMain {

    public static String translateColors(String input) throws IllegalArgumentException {
        if (input == null) {
            throw new IllegalArgumentException("변환할 문자열은 null일 수 없습니다.");
        }
        return ChatColor.translateAlternateColorCodes('&', input);
    }

    public static UUID getPlayerUUID(String playerName) throws NullPointerException {
        Player player = Bukkit.getPlayer(playerName);
        if (player == null) {
            throw new NullPointerException("플레이어가 존재하지 않습니다.");
        }
        return player.getUniqueId();
    }

    public static void teleportPlayer(Player player, double x, double y, double z) throws NullPointerException {
        if (player == null || player.getWorld() == null) {
            throw new NullPointerException("플레이어나 월드는 null일 수 없습니다.");
        }
        player.teleport(new Location(player.getWorld(), x, y, z));
    }
}
