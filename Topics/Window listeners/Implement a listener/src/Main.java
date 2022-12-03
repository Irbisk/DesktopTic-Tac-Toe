import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

class WindowOpeningAdapter extends WindowAdapter {
    @Override
    public void windowOpened(WindowEvent e) {
        super.windowOpened(e);
        System.out.println("Window is opened");
    }
}