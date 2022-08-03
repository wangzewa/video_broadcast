
import 'dart:async';

import 'package:flutter/services.dart';

class VideoBroadcast {
  static const MethodChannel _channel = MethodChannel('video_broadcast');

  static Future<String?>  clickBack() async {
    final String? version = await _channel.invokeMethod('clickBack');
    return version;
  }
  static Future<String?> clickOn() async {
    final String? version = await _channel.invokeMethod('clickOn');
    return version;
  }
}
