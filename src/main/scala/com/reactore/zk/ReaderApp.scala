package com.reactore.zk

/**
  * Created by yadu on 5/5/17.
  */
object ReaderApp extends App {

  val emailId = ZookeeperReaderUtility.getRecipientEmailId()
  println("Recipient Email Address : " + emailId)

}
