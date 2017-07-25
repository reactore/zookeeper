package com.reactore.zk

import com.typesafe.config.ConfigFactory

/**
  * Created by yadu on 28/3/17.
  */
trait ZookeeperConverters {

  implicit class ZookeeperDataConverter(val nodeValue: Array[Byte]) {
    def asString: String = new String(nodeValue)

    def asInt: Int = new String(nodeValue).toInt
  }

}
