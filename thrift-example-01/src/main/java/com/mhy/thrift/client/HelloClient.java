package com.mhy.thrift.client;

import com.mhy.thrift.gen.HelloService;

import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author mahaiyuan
 * @ClassName: HelloClient
 * @date 2017-05-04 下午2:48
 */
public class HelloClient {

  private static final Logger logger = LoggerFactory.getLogger(HelloClient.class);

  public static final String SERVER_IP = "localhost"; //服务端地址
  public static final int SERVER_PORT = 8888; //服务端端口
  public static final int TIMEOUT = 30000;  //超时时间

  public static void main(String[] args) {
    String username = "张三";

    TTransport transport = null;
    try {
      transport = new TSocket(SERVER_IP, SERVER_PORT, TIMEOUT);
      // 协议要和服务端一致
      TProtocol protocol = new TBinaryProtocol(transport);
      HelloService.Client client = new HelloService.Client(
          protocol);
      transport.open();
      logger.info("call sayHello username={}", username);
      String result = client.sayHello(username);
      logger.info("call sayHello result={}", result);
    } catch (TTransportException e) {
      e.printStackTrace();
    } catch (TException e) {
      e.printStackTrace();
    } finally {
      if (null != transport) {
        transport.close();
      }
    }
  }
}
