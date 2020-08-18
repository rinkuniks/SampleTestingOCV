package com.nik.sampletesting

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.SurfaceView
import android.view.View
import android.widget.Toast
import org.opencv.android.*
import org.opencv.core.Mat
import org.opencv.imgproc.Imgproc
import org.opencv.android.BaseLoaderCallback;
import org.opencv.android.CameraBridgeViewBase;
import org.opencv.android.JavaCameraView;
import org.opencv.android.OpenCVLoader;
import org.opencv.core.Core;
import org.opencv.*;
import org.opencv.core.Point;
import org.opencv.core.Size;
import java.util.Random;


class MainActivity : AppCompatActivity(), CameraBridgeViewBase.CvCameraViewListener2 {

  var cameraBridgeViewBase : CameraBridgeViewBase? = null
  var baseLoaderCallback : BaseLoaderCallback? = null
  var counter : Int? = 0
  var startCanny: Boolean = false

  fun Canny(Button: View?) {
    startCanny = startCanny == false
  }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    cameraBridgeViewBase = findViewById<JavaCameraView>(R.id.cameraView)
    (cameraBridgeViewBase)?.visibility = SurfaceView.VISIBLE
    (cameraBridgeViewBase)?.setCvCameraViewListener(this)

    //System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
    //System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
    baseLoaderCallback = object : BaseLoaderCallback(this) {
      override fun onManagerConnected(status: Int) {
        super.onManagerConnected(status)
        when (status) {
          SUCCESS -> (cameraBridgeViewBase as JavaCameraView?)?.enableView()
          else -> super.onManagerConnected(status)
        }
      }
    }
  }

  override fun onCameraViewStarted(width: Int, height: Int) {

  }

  override fun onCameraViewStopped() {
  }

  override fun onCameraFrame(inputFrame: CameraBridgeViewBase.CvCameraViewFrame?): Mat? {
    val frame = inputFrame!!.rgba()

    //For Checking the Fame rate Of Camera with Counter
//    if (counter!! % 2 == 0) {
//      Core.flip(frame, frame, 1)
//      Imgproc.cvtColor(frame, frame, Imgproc.COLOR_RGBA2GRAY)
//    }
//    counter = counter!! + 1

    //For Edge Detection using Boolean
    if (startCanny) {
      Imgproc.cvtColor(frame, frame, Imgproc.COLOR_RGBA2GRAY);
      Imgproc.Canny(frame, frame, 100.0, 80.0);
    }
    return frame
  }

  override fun onResume() {
    super.onResume()
    if (!OpenCVLoader.initDebug()) {
      Toast.makeText(applicationContext, "There's a problem, yo!", Toast.LENGTH_SHORT).show()
    } else {
      baseLoaderCallback!!.onManagerConnected(LoaderCallbackInterface.SUCCESS)
    }
  }

  override fun onPause() {
    super.onPause()
    if (cameraBridgeViewBase != null) {
      cameraBridgeViewBase!!.disableView()
    }
  }


  override fun onDestroy() {
    super.onDestroy()
    if (cameraBridgeViewBase != null) {
      cameraBridgeViewBase!!.disableView()
    }
  }
}