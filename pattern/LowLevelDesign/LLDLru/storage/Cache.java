package storage;

import policies.EvictionPolicy;

import java.util.HashMap;
public class Cache<Key,Value>{

    private final EvictionPolicy<Key> evictionPolicy;
    private final Storage<Key,Value> storage;

    public Cache(EvictionPolicy<Key> evictionPolicy,Storage<Key,Value> storage)  {
        this.evictionPolicy =  evictionPolicy;
        this.storage = storage;
    }

    private  void put(Key key,Value value){
        try{

        }catch (Exception e){

        }
    }

}
