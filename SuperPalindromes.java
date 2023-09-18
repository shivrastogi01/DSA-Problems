class SuperPalindromes{
public int superpalindromesInRange(String left, String right) {

    Long l=Long.parseLong(left);
    Long r=Long.parseLong(right);
    
    int count=0;
    
    List<Long> palindromes=new ArrayList<>();
    
    for(long i=1;i<10;i++)
        palindromes.add(i);
    
	/*reason for choosing 10^4 is becoz of two conditions :-
	
	1) when left part is of size 10^4+right part 10^4=10^8 it's square will be of size 10^16
	2) when left part is of size 10^4+right part 10^4 + middle single digit=10^9 it's square will be of size 10^18
	   which is the max constraint
	
	*/
	
    for(long i=1;i<10000;i++){
        
        String left_part=Long.toString(i);
        StringBuilder right_part=new StringBuilder(left_part).reverse();
        
        palindromes.add(Long.parseLong(left_part+right_part));
        
        for(int j=0;j<10;j++){
            
            palindromes.add(Long.parseLong(left_part+j+right_part));
            
        }
        
    }
    
    for(Long p:palindromes){
        
        long square=p*p;
        
        if(square>=l && square<=r && ispalin(Long.toString(square)))
            count++;
        
    }
    
    
    return count;
    
    
}

public boolean ispalin(String square){
        
        int l=0,r=square.length()-1;
        
        while(l<r){
            
            if(square.charAt(l)!=square.charAt(r))
                return false;
            
            l++;
            r--;
            
        }
        
        return true;
        
        
    }
}