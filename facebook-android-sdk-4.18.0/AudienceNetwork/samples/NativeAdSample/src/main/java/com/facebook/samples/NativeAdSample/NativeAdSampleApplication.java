package com.facebook.samples.NativeAdSample;

import android.app.Application;
import android.os.StrictMode;

import com.facebook.samples.ads.debugsettings.DebugSettings;

public class NativeAdSampleApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        DebugSettings.initialize(this);

        if (BuildConfig.DEBUG) {
            StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder()
                    .detectAll()
                    .penaltyLog()
                    .build());
            StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder()
                    .detectAll()
                    .penaltyLog()
                    .build());
        }
    }
}
