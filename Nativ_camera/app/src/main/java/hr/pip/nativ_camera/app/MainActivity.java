package hr.pip.nativ_camera.app;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.ImageButton;
import com.commonsware.cwac.camera.CameraFragment;


public class MainActivity extends ActionBarActivity {

    ImageButton btnOkidac;
    private final String TAG_CAMERA_FRAGMENT = "camera_fragment";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CameraFragment f = new CameraFragment();
        getFragmentManager().beginTransaction().add(R.id.container, f, TAG_CAMERA_FRAGMENT).commit();
        MyCameraHost s = new MyCameraHost(getBaseContext());
        f.setHost(s);

        btnOkidac = (ImageButton) findViewById(R.id.shutter);
        btnOkidac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                takePicture();
            }
        });
    }


    private void takePicture() {
        CameraFragment f = (CameraFragment) getFragmentManager().findFragmentByTag(TAG_CAMERA_FRAGMENT);
        if (f != null && f.isVisible()) {
            try {
                f.takePicture();
            } catch (IllegalStateException e) {

            }
        }
    }
}
