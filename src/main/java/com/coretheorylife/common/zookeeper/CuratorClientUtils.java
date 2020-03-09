package com.coretheorylife.common.zookeeper;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.springframework.stereotype.Component;

/**
 * @author Connor
 * zookeeper封装类，交给spring管理可以直接静态变量并执行init方法
 * 也可以用@PostConstruct方式
 * 使用的时候用@Autowired的方式，但是没有自己实现单例这么方便，所以就直接用官方的这种方式即可
 */
@Component
public class CuratorClientUtils {

    // 集群连接地址 多个用英文逗号隔开 支持域名加端口方式
    private final static String CONNECT_STRING = "47.102.133.136:2181";

    // LOCK_ROOT节点的用户名和密码 中间用英文分号分隔，如果没有密码可以省去authorization这部分
    private static String auth = "root:root1234.";

    // private static String auth = "root:DX2IZVeotrPL5bDru2a74swIOfY=";

    // 这个节点不建议更改，默认这样就可以了
    private static final String LOCK_ROOT = "coretheorylife/lock";//根节点

    public static CuratorFramework instance;

    static {
        // 这里提供了静态变量避免造成多个无用连接
        init();
    }

    public static CuratorFramework getInstance() {
        return instance;
    }

    private static void init() {
        CuratorFramework curatorFramework =
                CuratorFrameworkFactory.builder()
                        //.aclProvider(aclProvider)
                        .connectString(CONNECT_STRING)
                        .authorization("digest", auth.getBytes()) //使用用户名/密码进行连接 如果节点没设置用户名密码这行注释
                        .retryPolicy(new ExponentialBackoffRetry(100, 3))  //重试策略
                        .build();
        curatorFramework.start();
        curatorFramework.usingNamespace(LOCK_ROOT);
        instance = curatorFramework;
    }
}