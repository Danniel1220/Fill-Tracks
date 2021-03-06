package cdg.game;

import java.util.ArrayList;
import java.util.List;

public class LevelLayout {
    private static LevelLayout single_instance = null;

    // Storing the level's layout in a List.
    public List<List<Integer>> levelLayoutList;

    // Private constructor to instantiate the list to an empty one.
    private LevelLayout()
    {
        levelLayoutList = new ArrayList<>();
    }

    // Static method to create instance of Singleton class
    public static LevelLayout getInstance()
    {
        if (single_instance == null) single_instance = new LevelLayout();
        return single_instance;
    }

    public List<List<Integer>> getLevelLayoutList() {
        return this.levelLayoutList;
    }

    public void setLevelLayoutList(List<List<Integer>> list) {
        this.levelLayoutList = list;
    }

    public int getValueFromLevelLayoutList(int x, int y) {
        return Integer.parseInt(levelLayoutList.get(x).get(y).toString());
    }

    public void setValueInLevelLayoutList(int x, int y, int value) {
        levelLayoutList.get(x).set(y, value);
    }
}
