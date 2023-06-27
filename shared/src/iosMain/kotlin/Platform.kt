import platform.Foundation.NSLog

/**
 * description:
 * author: kisenhuang
 * email: Kisenhuang@163.com
 * time: 2023/6/21 12:00
 */
internal actual fun getKmpPlatform(): KmpPlatform  = object : KmpPlatform {
    override fun log(tag: String, msg: String) {
        NSLog("$tag: $msg")
    }

}