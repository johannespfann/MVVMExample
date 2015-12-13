package example.pfann.de.mvvmexample;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import dagger.ObjectGraph;
import example.pfann.de.mvvmexample.util.ModelModule;

public class MainActivity extends Activity implements MainActivityViewModel.Listener {

    public static final String APPNAME = "appname";
    private ObjectGraph mObjectGraph;


    @Bind(R.id.textView_result)
    public TextView mTextViewResult;
    @Bind(R.id.editText_input)
    public EditText mEditTextInput;
    @Bind(R.id.button_show_result)
    public Button mButton;


    @Inject
    public MainActivityViewModel mViewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.testview);
        ButterKnife.bind(this);

        mObjectGraph = ObjectGraph.create(getModules().toArray());
        mObjectGraph.inject(this);



        mViewModel.setListener(this);
     }


    private List<Object> getModules() {
        return Arrays.<Object>asList(new ModelModule());
    }

    public void inject(Object object) {
        mObjectGraph.inject(object);
    }


    @Override
    public void onButtonClicked() {
        Log.i(APPNAME,"Button is clicked");
    }

    @Override
    public String getInput() {
        return mEditTextInput.getText().toString();
    }
}
