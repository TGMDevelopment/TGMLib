package ga.matthewtgm.lib.gui;

public interface IToast<T> {

    Object NO_TOKEN = new Object();

    IToast.Visibility draw(GuiToast toastGui, long delta);

    default Object getType() {
        return NO_TOKEN;
    }

    enum Visibility {
        SHOW(),
        HIDE();

        Visibility() {
        }
    }

}