package services;

import models.Dictionary;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DictionaryServiceImpl {
    private static Map<Integer, Dictionary> dictionaryMap = new HashMap<>();

    static {
        dictionaryMap.put(1, new Dictionary("duck", "le hong duc"));
        dictionaryMap.put(2, new Dictionary("cat", "con mew"));
        dictionaryMap.put(3, new Dictionary("phone", "dien thoai"));
        dictionaryMap.put(4, new Dictionary("water", "nuoc"));
        dictionaryMap.put(5, new Dictionary("image", "anh"));
    }

    public List<Dictionary> findAll() {
        return new ArrayList<>(dictionaryMap.values());
    }
}