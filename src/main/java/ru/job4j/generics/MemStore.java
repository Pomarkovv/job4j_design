package ru.job4j.generics;

import java.util.HashMap;
import java.util.Map;

public final class MemStore<T extends Base> implements Store<T> {

    private final Map<String, T> storage = new HashMap<>();

    @Override
    public void add(T model) {
        storage.putIfAbsent(model.getId(), model);
    }

    @Override
    public boolean replace(String id, T model) {
        T mod = findById(id);
        Boolean rsl = mod != null;
        if (rsl) {
            storage.put(id, model);
        }
        return rsl;
    }

    @Override
    public boolean delete(String id) {
       T mod = findById(id);
       Boolean rsl = mod != null;
       if (rsl) {
           storage.remove(id);
       }
       return rsl;
    }

    @Override
    public T findById(String id) {
        return storage.getOrDefault(id, null);
    }
}