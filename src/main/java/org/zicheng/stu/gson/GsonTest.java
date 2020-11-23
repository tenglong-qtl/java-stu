package org.zicheng.stu.gson;

import com.google.gson.Gson;

import java.io.*;

/**
 * Author: T.L. QIU
 * Date: 2020-11-23 15:18.
 */
public class GsonTest {
    public static void main(String[] args) {
//        List<Model> masks = new ArrayList<>();
//        masks.add(new Model("tom1", 18));
//        masks.add(new Model("tom2", 18));
//        masks.add(new Model("tom3", 18));
//        masks.add(new Model("tom4", 18));
//        masks.add(new Model("tom5", 18));
//        masks.add(new Model("tom6", 18));
//
//        Map<String, Model> modelMap = new HashMap<>();
//        for (Model model : masks) {
//            modelMap.put(model.getName(), model);
//        }
//
//        AllModel allModel = new AllModel(modelMap, new HashMap<>());
//
//        Gson gson = new Gson();
//        String s = gson.toJson(allModel);
//        System.out.println(s);
//
//        try {
//            FileWriter writer = new FileWriter("F:\\config.json");
//            writer.write(s);
//            writer.close();
//        } catch (IOException e) {
//
//        }

        File file;
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("F:\\config.json")));
            String s = bufferedReader.readLine();
            Gson gson = new Gson();
            AllModel allModel = gson.fromJson(s,AllModel.class);
            System.out.println(allModel.toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
