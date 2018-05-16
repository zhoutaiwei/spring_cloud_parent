package com.spring.cloud.config;

import java.util.List;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;

public class MyRule extends AbstractLoadBalancerRule{
	int nextServerIndex = 0;
	int table = 0;

	public Server choose(ILoadBalancer lb, Object key) {
		if (lb == null) {
			return null;
		}

		Server server = null;
		int count = 0;
		while (server == null && count++ < 10) {
			List<Server> reachableServers = lb.getReachableServers();// 获取有效的服务
			List<Server> allServers = lb.getAllServers();// 获取所有额服务
			int upCount = reachableServers.size();
			int serverCount = allServers.size();

			if ((upCount == 0) || (serverCount == 0)) {
				return null;
			}
			if (table < 5) {
				server = allServers.get(nextServerIndex);
				table++;
			}else{
				table=0;
				nextServerIndex++;
				if(nextServerIndex>=upCount){
					nextServerIndex=0;
				}
				continue;
			}

			if (server == null) {
				/* Transient. */
				Thread.yield();
				continue;
			}

		}
		return server;
	}

	@Override
	public Server choose(Object key) {
		return choose(getLoadBalancer(), key);
	}

	@Override
	public void initWithNiwsConfig(IClientConfig arg0) {
		// TODO Auto-generated method stub

	}
}
