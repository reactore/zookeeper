package com.reactore.zk

import com.typesafe.config.ConfigFactory
import org.apache.zookeeper.data.Stat
import org.apache.zookeeper.{WatchedEvent, Watcher, ZooKeeper}

/**
  * Created by yadu on 28/3/17.
  */
trait ZookeeperConfig {

  val config = ConfigFactory.load()
  val ZK_URL = config.getString("zookeeper.url")
  val MAX_CONNECT_ATTEMPT = 5

  def createZKConnection(url: String): ZooKeeper = {
    var connectAttempt: Int = 0
    val zk: ZooKeeper = new ZooKeeper(url, 200000, new Watcher() {
      def process(event: WatchedEvent) {
        println("Connecting to ZK.")
      }
    })
   /* while ((zk.getState ne ZooKeeper.States.CONNECTED) && connectAttempt < MAX_CONNECT_ATTEMPT) {
      Thread.sleep(1000)
      connectAttempt += 1
      println("==========")
      println("Unable to get zookeeper connection, retrying")
      val remainingAttempts = MAX_CONNECT_ATTEMPT-connectAttempt
      println(s"Remaining retries : $remainingAttempts")
      if(remainingAttempts == 0) {
        println("Maximum retries attempted, unable to get connection, stopping retries")
      }
    }*/
    zk
  }

  def closeZooKeeper(zk: ZooKeeper) {
    if (zk != null) {
      zk.close()
    }
  }

  def getFullPath(path: String): String = {
    val formattedPath = path.trim.replaceAll("\\.", "/")
    "/" + formattedPath
  }

  def getValue(name: String) = {
    val zk = createZKConnection(ZK_URL)
    val result = zk.getData(getFullPath(name), false, new Stat)
    closeZooKeeper(zk)
    result
  }

}
