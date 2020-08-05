package com.company;

import java.lang.reflect.Field;
import java.util.*;

public class Main {

    public static void pervoeResh(){
        System.out.println("Program Start");
        int[][] mass = new int[][]
                {
                        {1,2,3,4},
                        {3,5,7,8},
                        {1,2,3,4},
                        {3,5,7,8}
                };
        int min = mass[0][mass.length-1];
        for (int i=1;i<mass.length;++i)
            if (mass[i][mass.length-i-1]<min)
                min=mass[i][mass.length-i-1];
        System.out.println(min);
    }

    public static void vtoroeResh(){
        TwoDimensionalMatrix mass1 = new TwoDimensionalMatrix();
        mass1.printMatrix();
        TwoDimensionalMatrix mass2 = new TwoDimensionalMatrix(8);
        mass2.printMatrix();
    }

    public static void listExample(){
        List<String> people = new ArrayList<>();
        people.add("Kate");
        people.add("Kirill");
        people.add("Ketr");
        people.add("Feder");
        people.add("Milka");
        people.add(1,"Lisa");

        System.out.println(people.get(0));

        people.set(3,"Boray");
        System.out.println(people.size());

        for(String p : people)
            System.out.println(p);

        System.out.println(people.contains("Milka"));

        System.out.println("_________");

        people.remove("Kate");
        people.remove(1);

        Object[] peopleArray = people.toArray();
        for(Object o : peopleArray)
            System.out.println(o);

        System.out.println(people.size());
    }

    public static void mapExample(){
        Map<Integer,String> states = new HashMap<>();

        states.put(1, "Germany");
        states.put(2, "Spain");
        states.put(4, "France");
        states.put(3, "Italy");

        System.out.println(states.get(2));

        Set<Integer> keys = states.keySet();

        Collection<String> values = states.values();

        states.replace(1,"Poland");
        states.remove(2);
        for (Map.Entry<Integer,String> item: states.entrySet())
            System.out.println("Key: "+ item.getKey()+" Value: "+ item.getValue());

        Map<String, TwoDimensionalMatrix> mass = new HashMap<>();
        mass.put("Little Matrix", new TwoDimensionalMatrix(3));
        mass.put("Random Matrix", new TwoDimensionalMatrix());
        mass.put("Big Matrix", new TwoDimensionalMatrix(555));

        for (Map.Entry<String, TwoDimensionalMatrix> item: mass.entrySet())
            System.out.println("Key: "+ item.getKey()+" CountElem: "+ item.getValue().countElementMatrix());

    }

    public static void streamExample(){
        List<Map<String,String>> name = new ArrayList<>();
        name.add(Map.of("Dog","Petr","Cat","Milka"));
        name.add(Map.of("Dog","Vasa","Cat","Kis"));
        name.add(Map.of("Dog","Fedor","Cat","Milka"));

        name.stream().forEach(x-> System.out.println(x.get("Cat")));

        name.stream()
                .filter(x->x.get("Cat").equals("Milka"))
                .forEach(x-> System.out.println(x.get("Dog")));

        for(Map<String, String> a : name){
            if(a.get("Cat").equals("Milka")){
                System.out.println(a.get("Dog"));
            }
        }
    }

    public static void reflectExample(){
        TwoDimensionalMatrix mass = new TwoDimensionalMatrix();
        int[][] m = new int[mass.getLenghtMatrix()][mass.getLenghtMatrix()];
        try{
            Field field = mass.getClass().getDeclaredField("mass");
            field.setAccessible(true);
            m=(int[][]) field.get(mass);
        }
        catch (Exception e){
            System.out.println(e);
        }
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m.length; j++) {
                System.out.print(m[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
	// write your code here
        reflectExample();
    }
}
