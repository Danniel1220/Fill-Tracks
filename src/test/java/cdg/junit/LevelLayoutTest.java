package cdg.junit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LevelLayoutTest {
    private static LevelLayoutTest single_instance = null;

    private static List<List<Integer>> levelLayoutList;

    // Private constructor to instantiate the list to an empty one.
    private LevelLayoutTest()
    {
        levelLayoutList = new ArrayList<>();

        // Level 2's layout
        levelLayoutList.add(Arrays.asList(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0));
        levelLayoutList.add(Arrays.asList(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0));
        levelLayoutList.add(Arrays.asList(0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0));
        levelLayoutList.add(Arrays.asList(0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0));
        levelLayoutList.add(Arrays.asList(0, 0, 0, 0, 0, 1, 1, 3, 1, 1, 0, 0, 0, 0, 0, 0));
        levelLayoutList.add(Arrays.asList(0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0));
        levelLayoutList.add(Arrays.asList(0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0));
        levelLayoutList.add(Arrays.asList(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0));
        levelLayoutList.add(Arrays.asList(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0));
    }

    // Static method to create instance of Singleton class
    public static LevelLayoutTest getInstance()
    {
        if (single_instance == null) single_instance = new LevelLayoutTest();
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
