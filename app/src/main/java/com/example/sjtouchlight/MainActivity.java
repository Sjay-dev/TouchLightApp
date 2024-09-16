package com.example.sjtouchlight;

import android.content.pm.PackageManager;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private Button toggleButton;
    private CameraManager cameraManager;
    private boolean isFlashlightOn = false;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toggleButton = findViewById(R.id.toggleButton);
        cameraManager = (CameraManager) getSystemService(CAMERA_SERVICE);

        toggleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    String cameraId = cameraManager.getCameraIdList()[0];
                    if (!isFlashlightOn) {
                        cameraManager.setTorchMode(cameraId, true);
                        isFlashlightOn = true;
                        toggleButton.setText("Turn Off Flashlight");
                    } else {
                        cameraManager.setTorchMode(cameraId, false);
                        isFlashlightOn = false;
                        toggleButton.setText("Turn On Flashlight");
                    }
                } catch (CameraAccessException e) {
                    e.printStackTrace();
                }
            }
        });

    }
}