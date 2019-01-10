package io.yang.themis;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "MainActivity";

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView tvBrand = findViewById(R.id.tv_brand);
        TextView tvModel = findViewById(R.id.tv_model);
        TextView tvMemory = findViewById(R.id.tv_memory);
        TextView tvAvailMemory = findViewById(R.id.tv_avail_memory);
        TextView tvCpuName = findViewById(R.id.tv_cpu_name);
        TextView tvCpuFre = findViewById(R.id.tv_cpu_fre);
        TextView tvLevel = findViewById(R.id.tv_level);

        tvBrand.setText("厂商:" + Themis.getBrand());
        tvModel.setText("机型:" + Themis.getModel());
        long totalMemoryMB = Themis.getTotalMemory(this) / (1024 * 1024);
        tvMemory.setText("RAM:" + totalMemoryMB);
        long availMemoryMB = Themis.getAvailMemory(this) / (1024 * 1024);
        tvAvailMemory.setText("有效内存:" + availMemoryMB);
        tvCpuName.setText("CPU型号:" + Themis.getHardWare());
        long mHz = Themis.getCPUMaxFreqKHz() / 1024;
        tvCpuFre.setText("CPU频率:" + mHz);

        String level;
        switch (Themis.judgeDeviceLevel(this)) {
            case Themis.DEVICE_LEVEL_LOW:
                level = "低端";
                break;
            case Themis.DEVICE_LEVEL_MID:
                level = "中端";
                break;
            case Themis.DEVICE_LEVEL_HIGH:
                level = "高端";
                break;
            default:
                level = "未知";
        }
        tvLevel.setText("机型判断:" + level);

    }
}
