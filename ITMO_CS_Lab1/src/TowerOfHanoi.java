import java.util.Scanner;

public class TowerOfHanoi {
    final int ROD = 3;
    int disk;
    int[][] tower;

    public TowerOfHanoi(int disk) {
        this.disk = disk;
        tower = new int[ROD][disk + 1];
        for (int i = 1; i < disk + 1; ++i) {
            tower[0][i] = disk + 1 - i;
        }
        tower[0][0] = disk;
        tower[1][0] = 1;
        tower[2][0] = 1;
    }

    public void moveStack(int fromRod, int toRod, int n) {
        if (n == 1) {
            if (tower[fromRod][tower[fromRod][0]] == 0) --tower[fromRod][0];
            if (tower[toRod][tower[toRod][0]] != 0) ++tower[toRod][0];
            tower[toRod][tower[toRod][0]] = tower[fromRod][tower[fromRod][0]];
            tower[fromRod][tower[fromRod][0]] = 0;
            print();
        } else {
            int shift = 3 - fromRod - toRod;
            moveStack(fromRod, shift, n - 1);
            moveStack(fromRod, toRod, 1);
            moveStack(shift, toRod, n - 1);
        }
    }

    public void moveStack() {
        moveStack(0, 2, disk);
    }

    public void print() {
        System.out.println();
        for (int i = disk; i > 0; --i) {
            System.out.println(tower[0][i] + "\t" + tower[1][i] + "\t" + tower[2][i]);
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();

        TowerOfHanoi myTower = new TowerOfHanoi(N);
        myTower.print();
        myTower.moveStack();
    }
}