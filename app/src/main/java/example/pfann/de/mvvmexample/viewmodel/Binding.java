package example.pfann.de.mvvmexample.viewmodel;


public interface Binding<View, CommandParameter> {
    void bind(View view, Command<CommandParameter> command);
}
