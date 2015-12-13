package example.pfann.de.mvvmexample;


import android.util.Log;

import javax.inject.Inject;

import example.pfann.de.mvvmexample.viewmodel.Command;


public class MainActivityViewModel {


    private Listener mListener;

    public MainActivityViewModel(){
        // Default
    }

    private Command<Void> mOnButtonClickedCommand = new Command<Void>() {
        @Override
        public void execute(Void aParameter) {
            if(mListener != null){
                Log.i("","mOnButtonClickedCommand");
            }
        }
    };

    public Command<Void> getOnButtonClickedCommand(){
        return mOnButtonClickedCommand;
    }

    public void setListener(Listener aListener){
        mListener = aListener;
    }



    public interface Listener{

        void onButtonClicked();
        String getInput();
    }
}
