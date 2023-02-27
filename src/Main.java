import java.util.ArrayList;

public class Main {
    static ArrayList<Integer> List = new ArrayList<>();
    static ArrayList<Integer> evenList = new ArrayList<>();
    static ArrayList<Integer> oddList = new ArrayList<>();

    public static void main(String[] args) {
        for (int i = 1; i <= 10000; i++) {
            List.add(i);
        }

        // mainList'i 4 eşit parçaya ayır
        ArrayList<ArrayList<Integer>> subLists = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < 4; i++) {
            subLists.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < List.size(); i++) {
            subLists.get(i % 4).add(List.get(i));
        }

        // 4 Thread oluştur
        for (int i = 0; i < 4; i++) {
            Thread thread = new Thread(new MyThread(subLists.get(i), evenList, oddList));
            thread.start();
        }

        // Çift sayıları yazdır
        System.out.println("Çift sayılar: " + evenList);

        // Tek sayıları yazdır
        System.out.println("Tek sayılar: " + oddList);
    }
}
