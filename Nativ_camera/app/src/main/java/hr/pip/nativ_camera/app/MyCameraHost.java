package hr.pip.nativ_camera.app;

import android.content.Context;
import android.hardware.Camera;
import com.commonsware.cwac.camera.PictureTransaction;
import com.commonsware.cwac.camera.SimpleCameraHost;

/**
 * Created by kob4lt on 12.05.2014..
 */
public class MyCameraHost extends SimpleCameraHost {

    public MyCameraHost(Context _ctxt) {
        super(_ctxt);
    }

    @Override
    protected String getPhotoFilename() {
        return super.getPhotoFilename();
    }

    @Override
    public boolean useSingleShotMode() {
        return super.useSingleShotMode();
    }

    @Override
    public Camera.Size getPictureSize(PictureTransaction xact, Camera.Parameters parameters) {
        return getBestSize(1500, 1000, parameters);
    }

    /*

     */
    private Camera.Size getBestSize(int width, int height, Camera.Parameters parameters){
        Camera.Size result = null;

        for (Camera.Size size : parameters.getSupportedPictureSizes()){
            if (size.width <= width && size.height <= height){
                if (result == null){
                    result = size;
                } else {
                    int resultArea = result.width * result.height;
                    int newArea = size.width * size.height;
                    if (newArea > resultArea){
                        result = size;
                    }
                }
            }
        }
        return (result);
    }
}
