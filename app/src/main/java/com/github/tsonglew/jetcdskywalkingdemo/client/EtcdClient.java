package com.github.tsonglew.jetcdskywalkingdemo.client;

import io.etcd.jetcd.Client;
import io.etcd.jetcd.KV;

/**
 * @author tsonglew
 */
public class EtcdClient {

  private final Client client;

  private final KV kvClient;

  public EtcdClient() {
    var addr = System.getenv("ETCD_ADDR");
    client = Client.builder().endpoints(addr).build();
    kvClient = client.getKVClient();


  }

  public KV getKvClient() {
    return client.getKVClient();
  }

  public void close() {
    kvClient.close();
    client.close();
  }
}
