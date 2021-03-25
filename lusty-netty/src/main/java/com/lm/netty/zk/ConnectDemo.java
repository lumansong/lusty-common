package com.lm.netty.zk;

import org.apache.curator.CuratorZookeeperClient;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;

public class ConnectDemo {


    public void connect(String namespace,String connect,int sessionTimeout,int connectTimeout){
        CuratorFramework client = CuratorFrameworkFactory.builder().namespace(namespace).
                sessionTimeoutMs(sessionTimeout).connectionTimeoutMs(connectTimeout).connectString(connect)
                .retryPolicy(new ExponentialBackoffRetry(1000, 10))
                .build();
        client.start();
    }

    public static void main(String[] args) {
        ConnectDemo demo=new ConnectDemo();
        demo.connect("lm-zk-demo","127.0.0.1:2181",5000,5000);
    }
}
