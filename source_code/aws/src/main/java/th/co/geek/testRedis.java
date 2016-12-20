package th.co.geek;

import redis.clients.jedis.Jedis;

public class testRedis {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		Jedis jedis = new Jedis("localhost");
		System.out.println(jedis.ping());
	}

}
