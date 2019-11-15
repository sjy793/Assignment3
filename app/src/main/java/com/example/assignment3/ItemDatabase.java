package com.example.assignment3;

import java.util.HashMap;
import java.util.List;

public class ItemDatabase {

    public static HashMap<String, Item> items = new HashMap<>();

    public static HashMap<String, Image> images = new HashMap<>();


    public static Item getItemById(String itemID) {
        return items.get(itemID);
    }

    public static List<Item> getAllItems() {
        return (List) items.values();
    }

    public static void saveItemToFakeDatabase(List<Item> articlesToSave) {
        for(int i = 0; i < articlesToSave.size(); i++) {
            Item item = articlesToSave.get(i);
            items.put(item.getId(), item);
        }
    }



    // Following are methods that do the same but for books
    public static Image getImageByIsbn(String id) {
        return images.get(id);
    }

    public static void saveBooksToFakeDatabase(List<Image> booksToSave) {
        for(int i = 0; i < booksToSave.size(); i++) {
            Image image = booksToSave.get(i);
            images.put(image.getId(), image);
        }
        System.out.println(images);
    }


}