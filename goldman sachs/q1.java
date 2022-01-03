//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

class q1 {
    public static void main (String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        
	    int t=Integer.parseInt(br.readLine().trim());
	    while(t > 0)
	    {
	        int n= Integer.parseInt(br.readLine().trim());
	        String x = br.readLine().trim();
	        String string_list[] = x.split(" ",n);
	        
	        Solution ob = new  Solution();
	        
	        List <List<String>> ans = ob.Anagrams(string_list);
	        
	        Collections.sort(ans, new Comparator<List<String>>(){
            public int compare(List<String> l1, List<String> l2) {
                    String s1 =  l1.get(0);
                    String s2 = l2.get(0);
                    
                    return s1.compareTo(s2);
                }
            });
	        
	        for(int i=0;i<ans.size();i++)
	        {
	            for(int j=0;j<ans.get(i).size();j++)
	            {
	                System.out.print(ans.get(i).get(j) + " ");
	            }
	            System.out.println();
	        }
	       
	       
            t--;
	    }
	}
    
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    public List<List<String>> Anagrams(String[] string_list) {
        // Code here
        HashMap<String, List<String>> hm = new HashMap();
        for(int i=0; i<string_list.length; i++){
            String str = sortString(string_list[i]);
            if(hm.containsKey(str)) hm.get(str).add(string_list[i]);
            else{
                hm.put(str, new ArrayList());
                hm.get(str).add(string_list[i]);
            }
        }
        List<List<String>> ans = new ArrayList();
        for(String str : hm.keySet()){
            ans.add(hm.get(str));
        }
        return ans;
    }
    
    public String sortString(String str){
        char[] arr = str.toCharArray();
        Arrays.sort(arr);
        str = "";
        for(int i=0; i<arr.length; i++) str+=arr[i];
        return str;
    }
}
