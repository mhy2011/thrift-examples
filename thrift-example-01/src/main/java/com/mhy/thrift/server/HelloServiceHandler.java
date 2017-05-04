package com.mhy.thrift.server;

import com.mhy.thrift.gen.HelloService;

import org.apache.thrift.TException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author mahaiyuan
 * @ClassName: HelloServiceHandler
 * @date 2017-05-04 下午2:29
 */
public class HelloServiceHandler implements HelloService.Iface {

  private static final Logger logger = LoggerFactory.getLogger(HelloServiceHandler.class);

  @Override
  public String sayHello(String username) throws TException {
    logger.info("HelloServiceHandler.sayHello username={}", username);
    return "Hello " + username;
  }
}
