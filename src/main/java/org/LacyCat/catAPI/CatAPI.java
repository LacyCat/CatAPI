package org.LacyCat.catAPI;

import org.bukkit.plugin.java.JavaPlugin;

public class CatAPI extends JavaPlugin {
    @Override
    public void onEnable() {
        // API 초기화
        MainAPI.initialize(this);

        // 확인 로그
        getLogger().info("LacyCat API 플러그인이 활성화되었습니다.");
    }

    @Override
    public void onDisable() {
        getLogger().info("LacyCat API 플러그인이 비활성화되었습니다.");
    }
}
