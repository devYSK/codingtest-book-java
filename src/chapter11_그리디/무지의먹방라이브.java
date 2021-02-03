package chapter11_그리디;

import java.util.*;

public class 무지의먹방라이브 {
    /**
     *
     * @param food_times 음식을 모두 먹는데 필요한 시간이 담겨있는 배열
     * @param k 네트워크 장애가 발생한 시간 k초
     * @return
     */
    public static int solution(int[] food_times, long k) {
        int answer = 0;

        // 전체 음식을 먹는 시간 보다 k가 크거나 같다면 -1 ( 더 섭취해야 할 음식이 없다면)
        long summary = 0;
        summary = Arrays.stream(food_times).sum();
        if (summary <= k)
            return -1;

        PriorityQueue<Food> foodsQueue = new PriorityQueue<>();

        for (int i = 0; i < food_times.length; i++) {
            foodsQueue.offer(new Food(food_times[i], i + 1));
        }

        summary = 0; // 먹기 위해 사용한 시간
        long previous = 0; // 직전에 다 먹은 음식 시간
        long remainderCnt = food_times.length; // 남은 음식의 개수

        // summary + (현재 음식 시간 - 이전 음식 시간) * 현재 음식 개수와 k 비교
        while (summary + ((foodsQueue.peek().getTime() - previous) * remainderCnt) <= k) {
            int now = foodsQueue.poll().getTime();
            summary += (now - previous) * remainderCnt;
            remainderCnt -= 1;
            previous = now;
        }

        // 남은 음식 중에서 몇번째 음식인지 확인하여 출력
        List<Food> foodList = new ArrayList<>();
        while (!foodsQueue.isEmpty()) {
            foodList.add(foodsQueue.poll());
        }

        // 음식 번호 기준으로 정렬
        foodList.sort(new Comparator<Food>() {
            @Override
            public int compare(Food o1, Food o2) {
                return Integer.compare(o1.getIndex(), o2.getIndex());
            }
        });


        return foodList.get((int)((k - summary) % remainderCnt)).getIndex();

    }

    public static void main(String[] args) {

    }

    static class Food implements Comparable<Food> {
        private int time;
        private int index;

        public Food(int time, int index) {
            this.time = time;
            this.index = index;
        }

        public int getTime() {
            return time;
        }

        public int getIndex() {
            return index;
        }

        // time이 짧은것이 높은 우선순위
        @Override
        public int compareTo(Food o) {
            return Integer.compare(this.time, o.time);
        }
    }

}
