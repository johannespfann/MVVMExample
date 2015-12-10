package example.pfann.de.mvvmexample.viewmodel;

public interface CommandListener {

    void onIsAvailableChanged(boolean newValue);

    void onIsExecutableChanged(boolean newValue);
}
