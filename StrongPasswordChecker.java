class StrongPasswordChecker {
    public int strongPasswordChecker(String password) {
        int len = password.length(), step = 6, pass = 0;
		if(password.matches(".*[0-9].*")) pass++;
        if(password.matches(".*[a-z].*")) pass++;
        if(password.matches(".*[A-Z].*")) pass++;
        int unpass = 3-pass;
		boolean continuous = false; //if password with three repeating characters in a row
		for(int i=1; i<len-1; i++) {
			if(password.charAt(i)==password.charAt(i-1)&&password.charAt(i)==password.charAt(i+1)) {
				continuous = true;
			}
		}
        ArrayList<Integer> arrli = new ArrayList<Integer>();
        arrli.add(1);
        for(int i=1; i<len; i++) {
        	if(password.charAt(i)==password.charAt(i-1)) {
        		arrli.set(arrli.size()-1,arrli.get(arrli.size()-1)+1);
        	}else arrli.add(1);
        }
        //System.out.println(arrli);
        for(int i=arrli.size()-1; i>=0; i--) { //because we'll use loops later, to reduce complexity, delete if elements<3.
        	if(arrli.get(i)<3) arrli.remove(i);
        }
        //System.out.println(arrli);
		int change_1=0; //times to change. if "aaaaa" need to do: aacaa (according to quotient)
		for(int i=0; i<arrli.size(); i++) {
			if(arrli.get(i)>2) change_1+=arrli.get(i)/3;
		}
		if(len<3) return step - len;
		else if(len<=20) return Math.max(Math.max(6-len,change_1),unpass);
		else if(len>20){
			int backspace = len-20;
			if(continuous) {
				for(int k=0; k<backspace; k++) {
					loop:
					for(int j=0; j<3; j++) {
						for(int i=0; i<arrli.size(); i++) {
							if(arrli.get(i)%3==j&&arrli.get(i)>2) {
								arrli.set(i, arrli.get(i)-1);
								break loop;
							}
						}
					}
				}
				//look this
				//System.out.println(arrli);
				int change_2 = 0;
				for(int i=0; i<arrli.size(); i++) {
					if(arrli.get(i)>2) change_2+=arrli.get(i)/3;
				}
				if(change_2>=unpass) step = backspace+change_2;
				else step = backspace+unpass;
			}else if(!continuous) step=backspace+unpass;
		}
        return step;
    }
}
