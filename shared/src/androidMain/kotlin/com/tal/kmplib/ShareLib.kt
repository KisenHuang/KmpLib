package com.tal.kmplib

import getKmpPlatform

/**
 * description:
 * author: kisenhuang
 * email: Kisenhuang@163.com
 * time: 2023/6/21 12:06
 */
object ShareLib {

    fun shareLog(tag: String, msg: String) {
        getKmpPlatform().log(tag, msg)
    }

}