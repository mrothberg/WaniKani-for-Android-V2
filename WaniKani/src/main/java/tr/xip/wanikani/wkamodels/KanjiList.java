package tr.xip.wanikani.wkamodels;

public class KanjiList extends ItemsList {

    @Override
    protected BaseItem.ItemType getType() {
        return BaseItem.ItemType.KANJI;
    }
}
