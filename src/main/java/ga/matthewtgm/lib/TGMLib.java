package ga.matthewtgm.lib;

public class TGMLib {

    private static TGMLib INSTANCE;
    private String modName;

    public static TGMLib getInstance() {
        if (INSTANCE == null)
            INSTANCE = new TGMLib();
        return INSTANCE;
    }

    public String getModName() {
        return modName;
    }

    public void setModName(String modName) {
        this.modName = modName;
    }

}