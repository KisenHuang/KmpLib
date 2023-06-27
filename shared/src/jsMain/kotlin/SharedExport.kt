@file:Suppress("OPT_IN_IS_NOT_ENABLED")

/**
 * description:
 * author: kisenhuang
 * email: Kisenhuang@163.com
 * time: 2023/6/27 10:26
 */

@OptIn(ExperimentalJsExport::class)
@JsExport
fun consoleLog(tag: String, msg: String) {
    getKmpPlatform().log(tag, msg)
}

@OptIn(ExperimentalJsExport::class)
@JsExport
class ExportClass {
    fun print() {
        consoleLog("ExportClass", "print")
    }
}