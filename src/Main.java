
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static String line;


    public static void main(String[] args) {
        //  инфа из файла в массив строк, возвращает массив, сколько в нем слов
        System.out.println(Arrays.toString(readFileToArray("src/input.txt")));
        System.out.println((readFileToArray("src/input.txt")).length);

        // возвращает hashmap<k,v> где key: словво, value: сколько раз оно встречается
       System.out.println(getCountOfUniqueWords("src/input.txt"));

        // возвращает самое длинное слово в файле
        System.out.println(theLongestWord("src/input.txt"));
        System.out.println(theLongestWord("src/input.txt").length());


    }
    //    1. Осуществить подсчет слов:
//    Напишите программу, которая подсчитывает количество слов в
//    файле `input.txt`.

    public static String[] readFileToArray(String filename) {
        String[] arr = null;
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            line = reader.readLine();
            while (line != null) {
                arr = line.split(" +");
                for (int i = 0; i < arr.length; i++) {
                    line = reader.readLine();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return arr;
    }

//3. Вычислить частоту слов:
//    Напишите программу, которая анализирует, сколько раз каждое
//    слово встречается в файле. Подумайте об этом как о подсчете того,
//    какие фрукты и овощи самые популярные на вашем пикнике!

    public static HashMap<String, Integer> getCountOfUniqueWords(String filename) {
        String[] arr = readFileToArray(filename);
        HashMap<String, Integer> map = new HashMap<>();
        int count = 1;
        for (String str : arr) {
            map.put(str.toLowerCase(), count);
            if (map.containsKey(str))
                count++;
        }
        return map;
    }

//    2. Найти самое длинное слово:
//    Создайте программу, которая находит самое длинное слово в
//    файле.
    public static String theLongestWord(String filename) {
        String result = "";
        HashMap<String, Integer> map = getCountOfUniqueWords(filename);
        char[] longestWord=new char[0];
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String key = entry.getKey();
            char[] word = key.toCharArray();
            if ( longestWord.length< word.length) {
                longestWord=key.toCharArray();
            }
             result=new String(longestWord);
        }
            return result;
        }

    }







