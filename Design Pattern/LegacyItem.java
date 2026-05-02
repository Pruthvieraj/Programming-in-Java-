public class LegacyItem {

    private int itemId;
    private String description;

    public LegacyItem(int itemId, String description) {
        this.itemId = itemId;
        this.description = description;
    }

    public void print() {
        System.out.println("[Legacy Item]");
        System.out.println("Item ID      : " + itemId);
        System.out.println("Description  : " + description);
    }
}