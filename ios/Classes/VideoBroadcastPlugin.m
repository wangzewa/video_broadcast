#import "VideoBroadcastPlugin.h"
#if __has_include(<video_broadcast/video_broadcast-Swift.h>)
#import <video_broadcast/video_broadcast-Swift.h>
#else
// Support project import fallback if the generated compatibility header
// is not copied when this plugin is created as a library.
// https://forums.swift.org/t/swift-static-libraries-dont-copy-generated-objective-c-header/19816
#import "video_broadcast-Swift.h"
#endif

@implementation VideoBroadcastPlugin
+ (void)registerWithRegistrar:(NSObject<FlutterPluginRegistrar>*)registrar {
  [SwiftVideoBroadcastPlugin registerWithRegistrar:registrar];
}
@end
