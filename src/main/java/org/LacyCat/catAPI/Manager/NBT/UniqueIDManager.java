package org.LacyCat.catAPI.Manager.NBT;

import java.util.UUID;

public class UniqueIDManager {

    public UUID generateUniqueId() {
        return UUID.randomUUID();
    }

    public UUID fromString(String uuidString) throws IllegalArgumentException {
        if (uuidString == null || uuidString.isEmpty()) {
            throw new IllegalArgumentException("UUID 문자열은 null이거나 빈 문자열일 수 없습니다.");
        }
        try {
            return UUID.fromString(uuidString);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("UUID 문자열 형식이 잘못되었습니다: " + uuidString, e);
        }
    }

    public boolean compareUuids(UUID uuid1, UUID uuid2) throws NullPointerException {
        if (uuid1 == null || uuid2 == null) {
            throw new NullPointerException("UUID는 null일 수 없습니다.");
        }
        return uuid1.equals(uuid2);
    }
}
