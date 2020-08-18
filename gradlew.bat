<?xml version="1.0" encoding="utf-8"?>
<!-- Copyright (C) 2006 The Android Open Source Project

     Licensed under the Apache License, Version 2.0 (the "License");
     you may not use this file except in compliance with the License.
     You may obtain a copy of the License at
  
          http://www.apache.org/licenses/LICENSE-2.0
  
     Unless required by applicable law or agreed to in writing, software
     distributed under the License is distributed on an "AS IS" BASIS,
     WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
     See the License for the specific language governing permissions and
     limitations under the License.
-->

<!-- Layout for a visually child-like Preference in a PreferenceActivity. -->
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android" 
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:minHeight="?android:attr/listPreferredItemHeight"
    android:gravity="center_vertical"
    android:paddingStart="16dip"
    android:paddingEnd="?android:attr/scrollbarSize">

    <LinearLayout
        android:layout_width="wrap_content"
        android:layout_height="match_parent"
        android:minWidth="@dimen/preference_widget_width"
        android:gravity="center"
        android:orientation="horizontal">
        <ImageView
            android:id="@+android:id/icon"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_gravity="center"
            />
    </LinearLayout>

    <RelativeLayout
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginEnd="6dip"
        android:layout_marginTop="6dip"
        android:layout_marginBottom="6dip"
        android:layout_weight="1">

        <TextView android:id="@+android:id/title"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:singleLine="true"
            android:textAppearance="?android:attr/textAppearanceMedium"
            android:ellipsize="marquee"
            android:fadingEdge="horizontal" />
            
        <TextView android:id="@+android:id/summary"
        