package example.pfann.de.mvvmexample.util;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import example.pfann.de.mvvmexample.MainActivity;
import example.pfann.de.mvvmexample.MainActivityViewModel;

@SuppressWarnings("unused")
@Module(
        injects = {MainActivity.class}
)
public class ModelModule {

    private MainActivityViewModel mMainActivityViewModel;

    public ModelModule(){
        mMainActivityViewModel = new MainActivityViewModel();
    }

    @Provides
    MainActivityViewModel provideMainActivityViewModel(){
        return mMainActivityViewModel;
    }
}
