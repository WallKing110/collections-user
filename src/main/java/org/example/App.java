//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package org.example;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.UUID;

public class App {
    public App() {
    }

    public static void main(String[] args) {
        String[] strArr = new String[]{"password1", "password2", "banana", " valley", "dog"};
        String[] arr = new String[5];
        HashCreator hc = new HashCreator();

        int i;
        for(i = 0; i < 5; ++i) {
            arr[i] = HashCreator.md5ByteToString(hc.createMD5Hash(strArr[i]));
        }

        for(i = 0; i < 5; ++i) {
            System.out.println(i + " " + strArr[i] + " " + arr[i]);
        }

    }

    public static void printList(List<User> coll) {
        for(int i = 0; i < coll.size(); ++i) {
            System.out.print(((User)coll.get(i)).GetUsername() + " " + ((User)coll.get(i)).GetEmail() + " " + HashCreator.md5ByteToString(((User)coll.get(i)).GetPasswordHash()));
            System.out.println();
        }

    }

    public static ArrayList<User> randomColl(int capacity) {
        ArrayList<User> coll = new ArrayList(capacity);

        for(int i = 0; i < capacity; ++i) {
            User user = new User(usingUUID().substring(0, 10), usingUUID().substring(0, 8) + "@mail.ru", usingUUID());
            coll.add(user);
        }

        return coll;
    }

    public static ArrayList<User> createDuplicates(ArrayList<User> targetList, ArrayList<User> pastList, int duplicates) {
        ArrayList<User> coll = new ArrayList(pastList);

        for(int i = 0; i < duplicates; ++i) {
            int min = 0;
            int max = 100;
            Random rnd = new Random();
            int iRandom = min + Math.abs(rnd.nextInt()) % (max - min + 1);
            coll.add(iRandom, targetList.get(iRandom));
        }

        return coll;
    }

    static String usingUUID() {
        UUID randomUUID = UUID.randomUUID();
        return randomUUID.toString().replaceAll("-", "");
    }

    public static List<User> findDuplicates(Collection<User> collA, Collection<User> collB) {
        HashSet<User> duplicates = new HashSet(collA);
        ArrayList<User> results = new ArrayList(50);
        Iterator var4 = collB.iterator();

        while(var4.hasNext()) {
            User x = (User)var4.next();
            if (!duplicates.add(x)) {
                results.add(x);
            }
        }

        return results;
    }
}
