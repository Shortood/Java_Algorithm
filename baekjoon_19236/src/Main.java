import java.util.*;

public class Main {
    static Fish[][] map = new Fish[4][4];
    static List<Fish> fishList = new ArrayList<Fish>();
    static int result = 0;

    public static class Fish implements Comparable<Fish>, Cloneable {
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
        public Fish clone() throws CloneNotSupportedException {
            return (Fish) super.clone();
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
        System.out.println("DFS x : " + shark.x + " y : " + shark.y);
        int dx, dy; //바꿀 물고기 좌표
        //물고기 이동
        System.out.println("물고기 이동");
        for (int i = 0; i < fishList.size(); i++) {
            if (fishList.get(i).alive == true) {
                int cnt = 0;// 이동 가능한지 확인
                while (true) {
                    dx = fishList.get(i).x;
                    dy = fishList.get(i).y;
                    //System.out.println("x : " + dx + " y : " + dy + " num : " + fishList.get(i).num + " dir : " + fishList.get(i).dir);
                    switch (fishList.get(i).dir) {
                        case 1: //위
                            dx--;
                            break;
                        case 2: //왼쪽 위
                            dx--;
                            dy--;
                            break;
                        case 3: //왼쪽
                            dy--;
                            break;
                        case 4: //왼쪽 아래
                            dy--;
                            dx++;
                            break;
                        case 5: //아래
                            dx++;
                            break;
                        case 6: //오른쪽 아래
                            dx++;
                            dy++;
                            break;
                        case 7: //오른쪽
                            dy++;
                            break;
                        case 8: //오른쪽 위
                            dy++;
                            dx--;
                            break;
                    }
                    //System.out.println("dx : " + dx + " dy : " + dy);
                    //이동 가능
                    if (dx >= 0 && dy >= 0 && dx < 4 && dy < 4 && (dx != shark.x || dy != shark.y)) {
                        //System.out.println("이동 dx : " + dx + " dy : " + dy);
                        for (int j = 0; j < fishList.size(); j++) {
                            if (fishList.get(j).x == dx && fishList.get(j).y == dy) {//바꿀 물고기 찾음
                                //System.out.println("바꿈 " + i + " " + j);
                                int tempx, tempy;
                                tempx = fishList.get(i).x;
                                tempy = fishList.get(i).y;
                                fishList.get(i).x = fishList.get(j).x;
                                fishList.get(i).y = fishList.get(j).y;
                                fishList.get(j).x = tempx;
                                fishList.get(j).y = tempy;
                                break;
                            }
                        }
                        break;
                    } else cnt++;
                    fishList.get(i).dir++;
                    if (fishList.get(i).dir > 8) fishList.get(i).dir = 1;
                    if (cnt > 7) break;
                }
            }
        }
        int sx, sy;
        sx = shark.x;
        sy = shark.y;
        //상어 이동
        while (true) { //상어가 이동 가능할 동안 반복
            System.out.println("sx : " + sx + " sy : " + sy);
            switch (shark.dir) {
                case 1: //위
                    sx--;
                    break;
                case 2: //왼쪽 위
                    sx--;
                    sy--;
                    break;
                case 3: //왼쪽
                    sy--;
                    break;
                case 4: //왼쪽 아래
                    sy--;
                    sx++;
                    break;
                case 5: //아래
                    sx++;
                    break;
                case 6: //오른쪽 아래
                    sy++;
                    sx++;
                    break;
                case 7: //오른쪽
                    sy++;
                    break;
                case 8: //오른쪽 위
                    sy++;
                    sx--;
                    break;
            }
            if (sx >= 0 && sy >= 0 && sx < 4 && sy < 4) {//이동가능
                shark.x = sx;
                shark.y = sy;
                if (fishList.get(getfishindex(sx, sy, fishList)).alive == Boolean.TRUE) {
                    List<Fish> tempfishList = new ArrayList<Fish>();
                    tempfishList.addAll(fishList);

                    tempfishList.get(getfishindex(sx, sy, fishList)).alive = Boolean.FALSE;
                    System.out.println("물고기 먹음 " + fishList.get(getfishindex(sx, sy, fishList)).num);
                    System.out.println("test");
                    printFish(tempfishList);
                    System.out.println();
                    printFish(fishList);
                    int tempdir = shark.dir;
                    shark.dir = fishList.get(getfishindex(sx, sy, tempfishList)).dir;
                    System.out.println("dir : " + shark.dir);
                    DFS(shark, fishList);
                    shark.dir = tempdir;
                    printFish(fishList);
                }
            } else break;
        }
        int sum = 0;
        for (int i = 0; i < fishList.size(); i++) {
            if (fishList.get(i).alive == Boolean.FALSE)
                sum += fishList.get(i).num;
        }
        if (result < sum) result = sum;
        System.out.println("sum : " + sum);
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
        printFish(fishList);
        DFS(shark, fishList);

        System.out.println("result : " + result);
    }
}