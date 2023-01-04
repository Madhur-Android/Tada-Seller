package com.example.tadaseller;

import android.Manifest;
import android.accessibilityservice.AccessibilityService;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.SurfaceTexture;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraManager;
import android.hardware.camera2.CameraMetadata;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.Log;
import android.util.Size;
import android.util.SparseIntArray;
import android.view.Surface;
import android.view.TextureView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.example.tadaseller.databinding.ActivityGoLiveActivityBinding;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.single.PermissionListener;

import java.io.File;
import java.util.Arrays;

public class GoLiveActivity extends AppCompatActivity {
    ActivityGoLiveActivityBinding binding;

    public static final String TAG = "AndroidCameraApi";

    static boolean state = false;
    static boolean check = false;
    public static final int REQUEST_CAMERA_PERMISSION = 200;
    private Handler mBackgroundHandler;
    private HandlerThread mBackgroundThread;
    protected CameraDevice cameraDevice;
    private Size imageDimension;
    protected CameraCaptureSession cameraCaptureSessions;
    protected CaptureRequest.Builder captureRequestBuilder;
    private String cameraId;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityGoLiveActivityBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.cameraView.setSurfaceTextureListener(textureListener);

        Dexter.withContext(this).withPermission(Manifest.permission.CAMERA).withListener(new PermissionListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
            }

            @Override
            public void onPermissionDenied(PermissionDeniedResponse permissionDeniedResponse) {
                Toast.makeText(GoLiveActivity.this, "Camera Permission Required", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onPermissionRationaleShouldBeShown(PermissionRequest permissionRequest, PermissionToken permissionToken) {

            }
        }).check();


    }

    private final CameraDevice.StateCallback stateCallback = new CameraDevice.StateCallback() {
        @Override
        public void onOpened(@NonNull CameraDevice camera) {

            //This is called when the camera is open
            Log.e(TAG, "onOpened");
            cameraDevice = camera;
            createCameraPreview();

        }

        @Override
        public void onDisconnected(@NonNull CameraDevice camera) {
            cameraDevice.close();

        }

        @Override
        public void onError(@NonNull CameraDevice camera, int error) {
            cameraDevice.close();
            cameraDevice = null;
        }
    };

    TextureView.SurfaceTextureListener textureListener = new TextureView.SurfaceTextureListener() {
        @Override
        public void onSurfaceTextureAvailable(@NonNull SurfaceTexture surface, int width, int height) {
            openCamera();
        }

        @Override
        public void onSurfaceTextureSizeChanged(@NonNull SurfaceTexture surface, int width, int height) {

        }

        @Override
        public boolean onSurfaceTextureDestroyed(@NonNull SurfaceTexture surface) {
            return false;
        }

        @Override
        public void onSurfaceTextureUpdated(@NonNull SurfaceTexture surface) {

        }
    };

    private void openCamera() {

        CameraManager manager = (CameraManager) getSystemService(Context.CAMERA_SERVICE);

        Log.e(TAG, "is Camera Open...");
        try {
            cameraId = manager.getCameraIdList()[0];

            //  toggleFlashLightOnOff = findViewById(R.id.torch_btn);
            state = true;
            binding.torchBtn.setOnClickListener(v -> {
                if (state) {
                    captureRequestBuilder.set(CaptureRequest.FLASH_MODE, CaptureRequest.FLASH_MODE_TORCH);
                    try {
                        cameraCaptureSessions.stopRepeating();
                    } catch (CameraAccessException e) {
                        e.printStackTrace();
                    }
                    try {
                        cameraCaptureSessions.setRepeatingRequest(captureRequestBuilder.build(), null, null);
                        state = false;

                    } catch (CameraAccessException e) {
                        e.printStackTrace();
                    }
                } else {
                    captureRequestBuilder.set(CaptureRequest.FLASH_MODE, CaptureRequest.FLASH_MODE_OFF);

                    try {
                        cameraCaptureSessions.stopRepeating();
                    } catch (CameraAccessException e) {
                        e.printStackTrace();
                    }
                    try {
                        cameraCaptureSessions.setRepeatingRequest(captureRequestBuilder.build(), null, null);
                        state = true;
                    } catch (CameraAccessException e) {
                        e.printStackTrace();
                    }
                }
            });

            binding.switchCamera.setOnClickListener(v -> {
                CameraManager manager2 = (CameraManager) getSystemService(Context.CAMERA_SERVICE);
                if (!check) {

                    try {
                        cameraId = manager2.getCameraIdList()[1];
                    } catch (CameraAccessException e) {
                        e.printStackTrace();
                    }
                    CameraCharacteristics characteristics = null;
                    try {
                        characteristics = manager2.getCameraCharacteristics(cameraId);
                    } catch (CameraAccessException e) {
                        e.printStackTrace();
                    }
                    StreamConfigurationMap map = characteristics.get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP);
                    assert map != null;
                    imageDimension = map.getOutputSizes(SurfaceTexture.class)[1];
                    //add permission for camera and let user grant the permission
                    if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CAMERA) !=
                            PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this,
                            Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                    }
                    try {
                        manager2.openCamera(cameraId, stateCallback, null);
                    } catch (CameraAccessException e) {
                        e.printStackTrace();
                    }

                    check = true;
                } else {


                    try {
                        cameraId = manager2.getCameraIdList()[0];
                    } catch (CameraAccessException e) {
                        e.printStackTrace();
                    }
                    CameraCharacteristics characteristics = null;
                    try {
                        characteristics = manager2.getCameraCharacteristics(cameraId);
                    } catch (CameraAccessException e) {
                        e.printStackTrace();
                    }
                    StreamConfigurationMap map = characteristics.get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP);
                    assert map != null;
                    imageDimension = map.getOutputSizes(SurfaceTexture.class)[0];
                    //add permission for camera and let user grant the permission
                    if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CAMERA) !=
                            PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this,
                            Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                    }
                    try {
                        manager2.openCamera(cameraId, stateCallback, null);
                    } catch (CameraAccessException e) {
                        e.printStackTrace();
                    }

                    check = false;
                }
            });


            CameraCharacteristics characteristics = manager.getCameraCharacteristics(cameraId);
            StreamConfigurationMap map = characteristics.get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP);
            assert map != null;
            imageDimension = map.getOutputSizes(SurfaceTexture.class)[1];
            //add permission for camera and let user grant the permission
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CAMERA) !=
                    PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this,
                    Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(GoLiveActivity.this, new String[]{Manifest.permission.CAMERA,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE}, REQUEST_CAMERA_PERMISSION);
                return;
            }
            manager.openCamera(cameraId, stateCallback, null);
        } catch (CameraAccessException e) {
            e.printStackTrace();
        }
        Log.e(TAG, "openCamera X");


    }


    protected void createCameraPreview() {
        try {
            SurfaceTexture texture = binding.cameraView.getSurfaceTexture();
            assert texture != null;
            texture.setDefaultBufferSize(imageDimension.getWidth(), imageDimension.getHeight());
            Surface surface = new Surface(texture);
            captureRequestBuilder = cameraDevice.createCaptureRequest(CameraDevice.TEMPLATE_PREVIEW);
            captureRequestBuilder.addTarget(surface);
            cameraDevice.createCaptureSession(Arrays.asList(surface), new CameraCaptureSession.StateCallback() {
                @Override
                public void onConfigured(@NonNull CameraCaptureSession cameraCaptureSession) {
                    //The Camera is already close
                    if (null == cameraDevice) {
                        return;
                    }
                    cameraCaptureSessions = cameraCaptureSession;
                    updatePreview();
//                    if (null == cameraDevice) {
//                        Log.e (TAG, "updatePreview error ,return");
//                    }
//                    captureRequestBuilder.set (CaptureRequest.CONTROL_MODE, CameraMetadata.CONTROL_MODE_AUTO);
//                    try {

//                        cameraCaptureSession.setRepeatingRequest(captureRequestBuilder.build(), null, mBackgroundHandler);
//                    } catch (CameraAccessException e) {
//                        e.printStackTrace();
//                    }
                }

                @Override
                public void onConfigureFailed(@NonNull CameraCaptureSession cameraCaptureSession) {
                    Toast.makeText(GoLiveActivity.this, "Configuration change", Toast.LENGTH_SHORT).show();
                }

            }, null);
        } catch (CameraAccessException e) {
            e.printStackTrace();
        }
    }

    protected void updatePreview() {

        if (null == cameraDevice) {
            Log.e(TAG, "updatePreview error, return");
        }
        captureRequestBuilder.set(CaptureRequest.CONTROL_MODE, CameraMetadata.CONTROL_MODE_AUTO);
        try {
            cameraCaptureSessions.setRepeatingRequest(captureRequestBuilder.build(), null, mBackgroundHandler);
        } catch (CameraAccessException e) {
            e.printStackTrace();
        }

    }


}