import java.util.*;
public class Solution{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        //this comment is made by vikash kumar
        for(int k=1;k<=t;k++){
            int r1=sc.nextInt();
            int r2=sc.nextInt();
            PriorityQueue<Double> pq1=new PriorityQueue<>();
            PriorityQueue<Double> pq2=new PriorityQueue<>();
            int n=sc.nextInt();
            for(int i=0;i<n;i++){
                int x1=sc.nextInt();
                int y1=sc.nextInt();
                double v=distance(x1,y1,0,0);
            
                if(v<=(r1+r2)){
                    pq1.add(v-r1);
                }
            }
            
            int m=sc.nextInt();
            for(int i=0;i<m;i++){
                int x1=sc.nextInt();
                int y1=sc.nextInt();
                double v=distance(x1,y1,0,0);
                if(v<=(r1+r2)){
                    pq2.add(v-r1);
                }
            }
            if(m==0){
                System.out.println("Case #"+k+": "+pq1.size()+" "+"0");
            }
            else if(n==0){
                System.out.println("Case #"+k+": "+"0"+" "+pq2.size());
            }
            else{
                int res=0;
                if(pq2.isEmpty()){System.out.println("Case #"+k+": "+pq1.size()+" "+"0");}
                else if(pq1.isEmpty()){System.out.println("Case #"+k+": "+"0"+" "+pq2.size());}
                else if(pq1.peek()<pq2.peek()){
                    
                    while(!pq1.isEmpty() && pq1.peek()<pq2.peek()){
                        res++;
                        pq1.poll();
                    }
                    System.out.println("Case #"+k+": "+res+" "+"0");
                }
                else{
                    while(!pq2.isEmpty() && pq1.peek()>pq2.peek()){
                        res++;
                        pq2.poll();
                    }
                    System.out.println("Case #"+k+": "+"0"+" "+res);
                }
                
            }
        }
    }
    
    public static double distance(int x1,int y1,int x2,int y2){
        return Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2) * 1.0);
    }
}
