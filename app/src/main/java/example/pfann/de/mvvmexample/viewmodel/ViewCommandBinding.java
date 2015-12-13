package example.pfann.de.mvvmexample.viewmodel;

import android.view.View;

public class ViewCommandBinding implements Binding<View, Void>, CommandListener,
        View.OnClickListener {
    private Command<Void> mCommand;
    private View mView;

    @Override
    public void bind(View view, Command<Void> command) {
        mCommand = command;
        mView = view;

        mCommand.setListener(this);
        mView.setOnClickListener(this);
    }

    @Override
    public void onIsAvailableChanged(boolean newValue) {
        mView.setVisibility(newValue ? View.VISIBLE : View.GONE);
    }

    @Override
    public void onIsExecutableChanged(boolean newValue) {
        mView.setEnabled(newValue);
    }

    @Override
    public void onClick(View v) {
        if (mCommand.isExecutable()) {
            mCommand.execute(null);
        }
    }
}