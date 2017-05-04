package com.mhy.thrift.server;

import com.mhy.thrift.gen.HelloService;

import org.apache.thrift.TProcessor;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TSimpleServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TTransportException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author mahaiyuan
 * @ClassName: HelloServer
 * @date 2017-05-04 下午2:38
 */
public class HelloServer {

  private static final int SERVER_PORT = 8888;
  private static final Logger logger = LoggerFactory.getLogger(HelloServer.class);

  public static void main(String[] args) {
    logger.info("HelloServer start server .......");
    try {

      TProcessor tprocessor = new HelloService.Processor<HelloService.Iface>(new HelloServiceHandler());
      // 简单的单线程服务模型，一般用于测试
      TServerSocket serverTransport = new TServerSocket(SERVER_PORT);
      TServer.Args tArgs = new TServer.Args(serverTransport);
      tArgs.processor(tprocessor);
      tArgs.protocolFactory(new TBinaryProtocol.Factory());
      TServer server = new TSimpleServer(tArgs);
      server.serve();
    } catch (TTransportException e) {
      logger.warn("HelloServer exception.", e);
    }
  }
}
