import java.util.Scanner;
class QuickFindUF{
    private int[] id;
    public int checkel;
    public QuickFindUF(int N){
        id = new int[N];
        for(int i = 0; i < N; i++)
            id[i] = i;
        checkel = id[0];
    }
    public boolean connected(int p ,int q){
        return id[p] == id[q];
    }
    public void union(int p, int q){
        int pid = id[p];
        int qid = id[q];
        for(int i = 0; i < id.length; i++){
            if(id[i]== pid){
                id[i] = qid;
            }
        }
    }
    public boolean checkConnection(){
        for(int i = 0; i < id.length;i++){
            if(id[i] != checkel){
                return false;
            }
        }
        return true;
    }
    

    public static void main(String arg[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the array:");
        int N = sc.nextInt();
        QuickFindUF uf = new QuickFindUF(N);
    
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
            
            if(uf.checkConnection()){
                break;
            }
        }
    }
}