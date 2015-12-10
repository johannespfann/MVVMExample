package example.pfann.de.mvvmexample.viewmodel;


public abstract class Command<T> {

    private CommandListener mCommandListener;
    private boolean mIsAvailable = true;
    private boolean mIsExecutable = true;

    public void setListener(CommandListener aCommandListener) {
        mCommandListener = aCommandListener;
    }

    public boolean isAvailable() {
        return mIsAvailable;
    }

    public void setIsAvailable(boolean aIsAvailable) {
        if (aIsAvailable != mIsAvailable) {
            mIsAvailable = aIsAvailable;
            if (mCommandListener != null) {
                mCommandListener.onIsAvailableChanged(aIsAvailable);
            }
        }
    }

    public boolean isExecutable() {
        return mIsExecutable && isAvailable();
    }

    public void setIsExecutable(boolean aIsExecutable) {
        if (aIsExecutable != mIsExecutable) {
            mIsExecutable = aIsExecutable;
            if (mCommandListener != null) {
                mCommandListener.onIsExecutableChanged(aIsExecutable);
            }
        }
    }

    public abstract void execute(T aParameter);
}