package example.pfann.de.mvvmexample.viewmodel;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.EditText;

public class EditTextCommandBinding implements Binding<EditText, String>, TextWatcher {
    private Command<String> mCommand;

    @Override
    public void bind(EditText aEditText, Command<String> aCommand) {
        mCommand = aCommand;
        aEditText.addTextChangedListener(this);
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        Log.i("","EditTextCommandBinding beforeTextChanged: " + s.toString());
    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        Log.i("","EditTextCommandBinding onTextChanged: " + s.toString());
    }

    @Override
    public void afterTextChanged(Editable s) {
        if (mCommand.isExecutable()) {
            mCommand.execute(s.toString());
        }
    }
}
