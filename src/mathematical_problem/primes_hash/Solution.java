package mathematical_problem.primes_hash;

import java.util.*;
public class Solution{
    public static void main(String[] args) {
        Solution p = new Solution();
        System.out.println(p.getHashM(1007,3));
    }
    public int getHashM(int maxK, int collision){
        int L = maxK / collision;
        int data=1, ans=0, max = Integer.MIN_VALUE;
        boolean[] prime = generate();
        while(true){
            int start = data, end = data*2;
            if(start <= L && L < end ){
                for(int i=start; i<end; i++){
                    if(prime[i] && max < dist(start,end,i)){
                        max = dist(start,end,i); ans = i;
                    }
                }
                break;
            }
            data = data*2;
        }
        return ans;
    }
    int dist(int start, int end, int prime){
        return Math.min(prime-start, end-prime);
    }
    boolean[] generate(){
        boolean[] prime_cand = new boolean[10000001];
        Arrays.fill(prime_cand,true);
        prime_cand[1] = false; prime_cand[0] = false;
        for(int i=2; i*i<prime_cand.length; i++){
            if(prime_cand[i]){
                for(int j=2; i*j<prime_cand.length; j++){
                    prime_cand[i*j]=false;
                }
            }
        }
        return prime_cand;
    }
}
