import kotlinx.coroutines.*

/**
 * description:
 * author: kisenhuang
 * email: Kisenhuang@163.com
 * time: 2023/6/21 12:00
 */

internal expect fun getKmpPlatform(): KmpPlatform

internal interface KmpPlatform {

    //日志打印
    fun log(tag: String, msg: String)

    @OptIn(DelicateCoroutinesApi::class)
    fun asyncSum(a: Int, b: Int, block: (Int) -> Unit) {
        GlobalScope.launch {
            delay(500)
            block(a + b)
        }
    }

}

