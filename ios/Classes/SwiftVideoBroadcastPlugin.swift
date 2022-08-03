import Flutter
import UIKit

public class SwiftVideoBroadcastPlugin: NSObject, FlutterPlugin {
  public static func register(with registrar: FlutterPluginRegistrar) {
    let channel = FlutterMethodChannel(name: "video_broadcast", binaryMessenger: registrar.messenger())
    let instance = SwiftVideoBroadcastPlugin()
    registrar.addMethodCallDelegate(instance, channel: channel)
  }

  public func handle(_ call: FlutterMethodCall, result: @escaping FlutterResult) {
    let noT = NSNotification.Name(rawValue: "videoBroadcast")
    let isBack = call.method == "clickBack"
    let data = ["value":isBack ? "BACK_HAIBIAN":"LEAVE_HAIBIAN"]
    NotificationCenter.default.post(name: noT, object: nil, userInfo:data)
    result("iOS " + UIDevice.current.systemVersion)
  }
}
