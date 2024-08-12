import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static ArrayList<Truck> list = new ArrayList<>();

    public static void main(String args[]) throws Exception	{
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str);

        int n = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        Queue<Truck> queue = new LinkedList<>();

        str = br.readLine();
        st = new StringTokenizer(str);

        for (int i = 0; i < n; i++) {
            queue.add(new Truck(Integer.parseInt(st.nextToken()), 0));
        }

        int time = 0;
        int currentWeight = 0;


        while (!queue.isEmpty()) {
            if (currentWeight + queue.peek().weight <= L) {
                if (!list.isEmpty()) {
                    for (int i = 0; i < list.size(); i++) {
                        list.get(i).point = list.get(i).point + 1;
                    }

                    if (list.get(0).point > w) {
                        currentWeight = currentWeight - list.get(0).weight;
                        list.remove(0);
                    }
                }

                Truck t = queue.poll();
                t.point = t.point + 1;
                list.add(t);
                currentWeight = currentWeight + t.weight;

                time = time + 1;
            } else {
                if (!list.isEmpty()) {
                    for (int i = 0; i < list.size(); i++) {
                        list.get(i).point = list.get(i).point + 1;
                    }

                    if (list.get(0).point > w) {
                        currentWeight = currentWeight - list.get(0).weight;
                        list.remove(0);

                        if (currentWeight + queue.peek().weight <= L) {
                            Truck t = queue.poll();
                            t.point = t.point + 1;
                            list.add(t);
                            currentWeight = currentWeight + t.weight;
                        }
                    }

                    time = time + 1;
                }
            }
        }

        while (!list.isEmpty()) {
            for (int i = 0; i < list.size(); i++) {
                list.get(i).point = list.get(i).point + 1;
            }

            if (list.get(0).point > w) {
                currentWeight = currentWeight - list.get(0).weight;
                list.remove(0);
            }

            time = time + 1;
        }

        bw.write(String.valueOf(time));

        br.close();
        bw.close();
    }
}

class Truck {
    int weight;
    int point;

    Truck(int w, int p) {
        weight = w;
        point = p;
    }
}