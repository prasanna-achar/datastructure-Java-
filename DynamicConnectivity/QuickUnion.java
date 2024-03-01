import java.util.Scanner;

public class QuickUnion {
    private int[] id;
    public QuickUnion(int N){
        id = new int[N];
        for(int i =0; i < N; i++)   id[i] = i;
    }
    private int root(int i){
        while(i != id[i]) i = id[i];
        return i;
    }
    public boolean connected(int p, int q){
        return root(p) == root(q);
    }

    public void union(int p, int q){
        int i = root(p);
        int j = root(q);
        id[i] = j;
    }

    @SuppressWarnings("resource")
    public static void main(String arg[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the array:");
        int N = sc.nextInt();
        QuickUnion uf = new QuickUnion(N);
    
        while(true){
            System.out.print("Union: ");
            int p = sc.nextInt();
            int q = sc.nextInt();
            if(p >= N|| p < 0){
                System.out.println(p + " value is not valid");
                continue;
            }
            if(q >= N|| q < 0){
                System.out.println(q + " value is not valid");
                continue;
            }

            if(!uf.connected(p, q)){
                uf.union(p, q);
                System.out.println(p + " connects " + q);
            }else{
                System.out.println("Already Connected");
            }
            
            // if(uf.checkConnection()){
            //     break;
            // }
        }
    }
}
