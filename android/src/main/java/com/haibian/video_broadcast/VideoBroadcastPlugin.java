package com.haibian.video_broadcast;

import android.content.Context;
import android.content.Intent;

import androidx.annotation.NonNull;
import android.content.ComponentName;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.MethodChannel.MethodCallHandler;
import io.flutter.plugin.common.MethodChannel.Result;

/** VideoBroadcastPlugin */
public class VideoBroadcastPlugin implements FlutterPlugin, MethodCallHandler {
  /// The MethodChannel that will the communication between Flutter and native Android
  ///
  /// This local reference serves to register the plugin with the Flutter Engine and unregister it
  /// when the Flutter Engine is detached from the Activity
  private MethodChannel channel;
  private Context context;

  @Override
  public void onAttachedToEngine(@NonNull FlutterPluginBinding flutterPluginBinding) {
    context = flutterPluginBinding.getApplicationContext();
    channel = new MethodChannel(flutterPluginBinding.getBinaryMessenger(), "video_broadcast");
    channel.setMethodCallHandler(this);
  }

  @Override
  public void onMethodCall(@NonNull MethodCall call, @NonNull Result result) {
    if (call.method.equals("clickBack")) {
      send("BACK_HAIBIAN");
      result.success("Android " + android.os.Build.VERSION.RELEASE);
    } else if (call.method.equals("clickOn")) {
      send("LEAVE_HAIBIAN");
      result.success("Android " + android.os.Build.VERSION.RELEASE);
    }else {
      result.notImplemented();
    }


  }
  private void send(String action){
    Intent intent = new Intent();
    intent.setAction(action);
    intent.setComponent(new ComponentName("com.example.myapplication","com.example.myapplication.MyReceiver"));
    context.sendBroadcast(intent);
    System.out.println(context);
  }

  @Override
  public void onDetachedFromEngine(@NonNull FlutterPluginBinding binding) {
    channel.setMethodCallHandler(null);
  }
}
