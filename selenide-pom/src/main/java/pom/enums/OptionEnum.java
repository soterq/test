package pom.enums;

import java.util.HashMap;
import java.util.Map;

public enum OptionEnum {
    OPTION_1("Delete"),
    OPTION_6("Delete"),
    OPTION_5("Delete"),
    OPTION_4("Delete");


    private String name;
    private static Map<String, OptionEnum> map = new HashMap<>();

    static {
        for (OptionEnum item : OptionEnum.values()) {
            map.putIfAbsent(item.getName(), item);
        }
    }


    OptionEnum(String displayName) {
        this.name = displayName;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }

    public static OptionEnum of(String name) {
        OptionEnum columnSelectorButtons = map.get(name);
        if (columnSelectorButtons == null) {
            throw new IllegalStateException("Unknown button name: " + name);
        }
        return columnSelectorButtons;
    }
}
