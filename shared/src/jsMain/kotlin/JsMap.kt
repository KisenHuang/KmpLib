/**
 * description: 由于js中不支持Map，将Map转换成JsMap
 * author: kisenhuang
 * email: Kisenhuang@163.com
 * time: 2023/6/6 14:42
 */

@OptIn(ExperimentalJsExport::class)
@JsExport
class JsMap<K,V> {

    internal val map = mutableMapOf<K, V>()

    @JsName("get")
    fun get(key: K): V? {
        return map[key]
    }

    internal operator fun set(key: K, value: V) {
        map[key] = value
    }

    override fun toString() : String{
        return map.toString()
    }

}

/**
 * Map 转 JsMap
 */
fun <K,V> Map<K,V>.toJsMap(): JsMap<K,V> {
    val jsMap = JsMap<K,V>()
    forEach { (key, value) ->
        jsMap[key] = value
    }
    return jsMap
}

/**
 * JSMap 转 Map
 */
fun <K,V> JsMap<K,V>.toMap(): Map<K,V> {
    val map = mutableMapOf<K,V>()
    map.putAll(this.map)
    return map
}