package io.yang.themis;

import android.app.Application;
import com.sensorsdata.analytics.android.sdk.SensorsDataAPI;

/**
 * Created by yangtian on 2018/12/25.
 * E-Mail Address: 443275705@qq.com
 */
public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        String saServerUrl = "https://xingkongjihua.cloud.sensorsdata.cn:4006/sa?project=default&token=545233b2e46ef312";
        SensorsDataAPI.DebugMode debugMode = SensorsDataAPI.DebugMode.DEBUG_AND_TRACK;
        SensorsDataAPI.sharedInstance(this, saServerUrl, debugMode);
    }
}
