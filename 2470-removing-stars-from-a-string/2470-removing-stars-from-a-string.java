class Solution {
    public String removeStars(String s) {
        
        Stack <Character> st=new Stack<>();
        for(char c: s.toCharArray()){
        if(c=='*'){
           if(!st.isEmpty()){
            st.pop();
           }
        }
        else{
            st.push(c);
        }
        }
        StringBuilder result=new StringBuilder();
        while(!st.isEmpty()){
            result.append(st.pop());
        }

         return result.reverse().toString();
        
    }

}