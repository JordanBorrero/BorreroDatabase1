/** Project:LAB 3 Database
 * Purpose Details:Redis Class to perform CRUD
 * Course: IST242
 * Author:Jordan Borrero
 * Date Developed:2/20/24
 * Last Date Changed:2/21/24
 * Rev:1

 */
import redis.clients.jedis.Jedis;
import redis.clients.jedis.exceptions.JedisConnectionException;

//Redis are localhost and port 6379

public class RedisCRUD {
    public static void main(String[] args) {
        try {
            Jedis jedis = new Jedis("localhost");
            //Create (Set a key-value pair)
            jedis.set("key", "value");

            //Read (Get the value of a key)
            String value = jedis.get("key");
            System.out.println(value);

            //Update (Update the value of a key)
            jedis.set("key", "newValue");

            //Delete (Delete a key-value pair)
            jedis.del("key");

            jedis.close();
        } catch (JedisConnectionException e) {
            System.out.println("Could not connect to Redis: " + e.getMessage());
        }
    }
}