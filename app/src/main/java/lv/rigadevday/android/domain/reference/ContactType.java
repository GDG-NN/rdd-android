package lv.rigadevday.android.domain.reference;


import java.util.HashMap;
import java.util.Map;

public enum ContactType {
    TWITTER(0),
    BLOG(1);

    private static final Map<Integer, ContactType> byId = new HashMap<>();

    static {
        for (ContactType e : ContactType.values()) {
            byId.put(e.getId(), e);
        }
    }

    private final Integer id;

    private ContactType(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public static ContactType getById(int id) {
        return byId.get(id);
    }
}
