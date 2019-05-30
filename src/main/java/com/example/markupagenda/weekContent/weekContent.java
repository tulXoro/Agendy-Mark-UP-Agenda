package com.example.markupagenda.weekContent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class weekContent {

    public static final List<dayItem> ITEMS = new ArrayList<dayItem>();

    /**
     * A map of sample (dummy) items, by ID.
     */
    public static final Map<String, dayItem> ITEM_MAP = new HashMap<String, dayItem>();

    private static final int COUNT = 7;

    static {
        // Add some sample items.
        for (int i = 1; i <= COUNT; i++) {
            addItem(createDay(i));
        }
    }

    private static void addItem(dayItem item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }

    //helper method to return day... Maybe implement dynamic?
    private static String custDay(int position){
        switch(position) {
            case 1:
                return "Sunday";
            case 2:
                return "Monday";
            case 3:
                return "Tuesday";
            case 4:
                return "Wednesday";
            case 5:
                return "Thursday";
            case 6:
                return "Friday";
            case 7:
                return "Saturday";
            default: return "Error, you should not see this";

        }
    }

    private static dayItem createDay(int date) {
        return new dayItem(String.valueOf(date), custDay(date), makeDetails());
    }

    private static String makeDetails() {
        StringBuilder builder = new StringBuilder();
        /*
         * TODO: insert different text depending on day..
         * Could insert dynamic updates...?
         */
        builder.append("\nYou don't have anything added for this day!");
        return builder.toString();
    }

    /**
     * A dummy item representing a piece of content.
     */
    public static class dayItem {
        public final String id;
        public final String content;
        public final String details;

        public dayItem(String id, String content, String details) {
            this.id = id;
            this.content = content;
            this.details = details;
        }

        @Override
        public String toString() {
            return content;
        }
    }
}
