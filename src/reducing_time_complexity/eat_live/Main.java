package reducing_time_complexity.eat_live;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Main {
    class Food implements Comparable<Food>{
        int index; long time;
        Food(int i, long t){
            this.index = i;
            this.time = t;
        }

        @Override
        public int compareTo(Food o) {
            return Long.compare(this.time, o.time);
        }
    }

    public static void main(String[] args) {
        Main m = new Main();
        System.out.println(m.solution(new int[]{3, 1, 2},5));
    }
    public int solution(int[] food_times, long k) {
        int answer = 0;
        ArrayList<Food> foods = new ArrayList<>();
        for(int i=0; i<food_times.length; i++) foods.add(new Food(i, food_times[i]));
        Collections.sort(foods);
        long before = 0;
        for(int i=0; i<foods.size(); i++){
            int start =i;
            long eat_time = foods.get(i).time;
            while(i+1 < foods.size() && foods.get(i+1).time==eat_time){
                i++;
            }

            long total_time = (long)(eat_time-before)*(long)(food_times.length-start);
            if(total_time > k) {
                Collections.sort(foods.subList(start, food_times.length) , new Comparator<Food>() {
                            @Override
                    public int compare(Food o1, Food o2) {
                        return Long.compare(o1.index,o2.index);
                    }
                });
                int residx = (int)(start + k%(food_times.length-start));
                return foods.get(residx).index+1;
            }else{
                k-= total_time;
                before = eat_time;
            }
        }
        return -1;
    }

}
