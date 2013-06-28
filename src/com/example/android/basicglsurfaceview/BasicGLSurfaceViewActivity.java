/*
 * Copyright (C) 2011 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.basicglsurfaceview;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ConfigurationInfo;
import android.opengl.GLSurfaceView;
import android.os.Bundle;


public class BasicGLSurfaceViewActivity extends Activity {

    private BasicGLSurfaceView mView;
    private GLSurfaceView mGLSurfaceView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
    	 mGLSurfaceView = new GLSurfaceView(this);	
    	 
    	    // Check if the system supports OpenGL ES 2.0.
    	    final ActivityManager activityManager = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
    	    final ConfigurationInfo configurationInfo = activityManager.getDeviceConfigurationInfo();
    	    final boolean supportsEs2 = configurationInfo.reqGlEsVersion >= 0x20000;
    	 
    	    if (supportsEs2)
    	    {
    	        // Request an OpenGL ES 2.0 compatible context.
    	        mGLSurfaceView.setEGLContextClientVersion(2);
    	 
    	        // Set the renderer to our demo renderer, defined below.
    	        mGLSurfaceView.setRenderer(new LessonOneRenderer());
    	    }
    	    else
    	    {
    	        // This is where you could create an OpenGL ES 1.x compatible
    	        // renderer if you wanted to support both ES 1 and ES 2.
    	        return;
    	    }
    	    super.onCreate(savedInstanceState);
    	    setContentView(mGLSurfaceView);
    }

    @Override
    protected void onPause() {
        super.onPause();
        mGLSurfaceView.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mGLSurfaceView.onResume();
    }
}
