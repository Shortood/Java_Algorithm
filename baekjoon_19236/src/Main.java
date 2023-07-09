import java.util.*;

public class Main {
    static List<Fish> fishList = new ArrayList<Fish>();
    static int result = 0;

    public static class Fish implements Comparable<Fish> {
        int x, y, num, dir;
        boolean alive;

        public Fish(int x, int y, int num, int dir, boolean alive) {
            this.x = x;
            this.y = y;
            this.num = num;
            this.dir = dir;
            this.alive = alive;
        }

        @Override
        public int compareTo(Fish fish) {
            return this.num - fish.num;
        }
    }

    public static class Shark {
        int x, y, dir;

        public Shark(int x, int y, int dir) { //상어
            this.x = x;
            this.y = y;
            this.dir = dir;
        }
    }

    public static void DFS(Shark shark, List<Fish> fishList) {
        int dx, dy; //바꿀 물고기 좌표
        int[] dfx = {0, -1, -1, 0, 1, 1, 1, 0, -1};
        int[] dfy = {0, 0, -1, -1, -1, 0, 1, 1, 1};

        //물고기 이동
        for (int i = 0; i < fishList.size(); i++) {
            if (fishList.get(i).alive == true) {
                int cnt = 0;// 이동 가능한지 확인
                while (true) {
                    dx = fishList.get(i).x;
                    dy = fishList.get(i).y;
                    dx += dfx[fishList.get(i).dir];
                    dy += dfy[fishList.get(i).dir];

                    //이동 가능
                    if (dx >= 0 && dy >= 0 && dx < 4 && dy < 4 && (dx != shark.x || dy != shark.y)) {
                        int index = getfishindex(dx, dy, fishList);
                        int tempx, tempy;
                        tempx = fishList.get(i).x;
                        tempy = fishList.get(i).y;
                        fishList.get(i).x = fishList.get(index).x;
                        fishList.get(i).y = fishList.get(index).y;
                        fishList.get(index).x = tempx;
                        fishList.get(index).y = tempy;
                        break;
                    } else cnt++;

                    fishList.get(i).dir++;
                    if (fishList.get(i).dir > 8) fishList.get(i).dir = 1;
                    if (cnt > 7) break;
                }
            }
        }

        int sx, sy;
        int[] sdx = {0, -1, -1, 0, 1, 1, 1, 0, -1};
        int[] sdy = {0, 0, -1, -1, -1, 0, 1, 1, 1};
        sx = shark.x;
        sy = shark.y;
        //상어 이동
        while (true) { //상어가 이동 가능할 동안 반복
            sx += sdx[shark.dir];
            sy += sdy[shark.dir];

            if (sx >= 0 && sy >= 0 && sx < 4 && sy < 4) {//이동가능
                shark.x = sx;
                shark.y = sy;
                if (fishList.get(getfishindex(sx, sy, fishList)).alive == Boolean.TRUE) {
                    List<Fish> tempfishList;
                    tempfishList = copyArray(fishList); //새로운 물고기 리스트 생성
                    tempfishList.get(getfishindex(sx, sy, fishList)).alive = Boolean.FALSE;
                    Shark tempshark = new Shark(shark.x, shark.y, shark.dir);
                    tempshark.dir = tempfishList.get(getfishindex(sx, sy, tempfishList)).dir;
                    DFS(tempshark, tempfishList);
                }
            } else break;
        }
        int sum = 0;
        for (int i = 0; i < fishList.size(); i++) {
            if (fishList.get(i).alive == Boolean.FALSE)
                sum += fishList.get(i).num;
        }
        if (result < sum) result = sum;
    }

    public static int getfishindex(int x, int y, List<Fish> fishList) {
        for (int i = 0; i < fishList.size(); i++) {
            if (fishList.get(i).x == x && fishList.get(i).y == y)
                return i;
        }
        return -1;
    }

    public static void printFish(List<Fish> fishList) {
        for (int i = 0; i < fishList.size(); i++) {
            System.out.println(" x : " + fishList.get(i).x + " y : " + fishList.get(i).y + " num : " + fishList.get(i).num + " alive : " + fishList.get(i).alive);
        }
    }

    public static List<Fish> copyArray(List<Fish> fishList) {
        List<Fish> tempfishList = new ArrayList<Fish>();
        fishList.forEach(t -> tempfishList.add(new Fish(t.x, t.y, t.num, t.dir, t.alive)));
        return tempfishList;
    }

    public static void main(String[] args) {
        int num, dir;
        Shark shark = null;
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                num = sc.nextInt();
                dir = sc.nextInt();
                if (i == 0 && j == 0) {
                    shark = new Shark(0, 0, dir);
                    fishList.add(new Fish(i, j, num, dir, Boolean.FALSE));
                } else fishList.add(new Fish(i, j, num, dir, Boolean.TRUE));
            }
        }
        fishList.sort(Comparator.naturalOrder());

        DFS(shark, fishList);

        System.out.println(result);
    }
}