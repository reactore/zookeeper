package com.reactore.zk

import com.typesafe.config.ConfigFactory

/**
  * Created by yadu on 28/3/17.
  */
object ZookeeperHelper extends ZookeeperConfig with ZookeeperConverters {

  def getString(path: String) = {
    getValue(path).asString
  }

  def getInt(path: String) = {
    getValue(path).asInt
  }

}
