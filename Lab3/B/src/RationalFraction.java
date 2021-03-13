public class RationalFraction {
    private Integer n;
    private Integer d;

    public RationalFraction(Integer n, Integer d){
        this.getFraction(n, d);
    }
    public RationalFraction(Integer n){
        this.getFraction(n,1);
    }
    public RationalFraction(String strFraction){
        strFraction = removeSpaces(strFraction);
        this.setStringFraction(strFraction);
    }
    public void setStringFraction(String strFraction){
        if(checkString(strFraction)){
            getFractionNumber(strFraction);
        }
        else{
            if(checkFraction(strFraction)){
                System.out.println(strFraction);
                System.out.println("The maximum and minimum number of numerator or denominator "
                        + "that can be entered is: + " + Integer.MAX_VALUE + " " + Integer.MIN_VALUE + "!!!!");
            }
            else{
                System.out.println("This in invalid fruction number " + strFraction);
            }
        }
    }
    private boolean checkString(String num){
        String regExp = "^[-]?[0-9]{1,10}|[-]?[0-9]{1,10}+/+[-]?[0-9]{1,10}+$";
        return num.matches(regExp);
    }
    private void getFractionNumber(String strNum){
        long n1, d1;

        if((!strNum.contains("/"))){
            n1 = Long.parseLong(strNum);
            if(n1 == 0){
                System.out.print("invalid fruction!!! numerator cannot be zero");
            }
            else if(checkIntegers(n1,1)){
                System.out.println(strNum + " numerator is out of range. It mus be smaller than " + Integer.MAX_VALUE
                        + " of greater than " + Integer.MIN_VALUE);
            }
            else{
                this.n = (int)n1;
                this.d = 1;
            }
        }
        else{
            String[] strAr = strNum.split("/");
            n1 = Long.parseLong(strAr[0]);
            d1 = Long.parseLong(strAr[1]);
            if(n1 == 0){
                System.out.print("invalid fraction!!! numerator cannot be zero");
            }
            else if(checkIntegers(n1,d1)){
                System.out.println(strNum + " numerator is out of range. It mus be smaller than " + Integer.MAX_VALUE
                        + " of greater than " + Integer.MIN_VALUE);
            }
            else{
                this.n = (int)n1;
                this.d = (int)d1;
                if(this.d != 1){
                    normalization(); }
            }
        }
    }

    private boolean checkIntegers(long a, long b){
        if(a >= Integer.MAX_VALUE) return true;
        else if (b >= Integer.MAX_VALUE) return true;
        else if (a <= Integer.MIN_VALUE) return true;
        else return b <= Integer.MIN_VALUE;
    }

    private String removeSpaces(String st){
        StringBuilder trim = new StringBuilder();
        for(int i = 0; i < st.length();i++){
            if(st.charAt(i) != ' '){
                trim.append(st.charAt(i));
            }
        }
        return trim.toString();
    }

    public void getFraction(int n, int d){
        if(n == 0){System.out.print("Invalid fraction! Numerator cannot be zero");
        }
        else if(testInteger(n,d)){
            System.out.println("The maximum entered number or result of the numerator and denominator must be smaller than " + Integer.MAX_VALUE
                    + "\nand the minimum entered number or result of the numerator and denominator must be greater than " + Integer.MIN_VALUE
                    + ".\nNumerator was assigned to zero.");
            this.n = 0;
            this.d = 0;
        }
        else{
            this.n = n;
            this.d = d;
            if(d != 1){
                normalization();
            }
        }
    }

    private boolean testInteger(int n, int d){
        if(n >= Integer.MAX_VALUE) return true;
        else if (d >= Integer.MAX_VALUE) return true;
        else if (n <= Integer.MIN_VALUE) return true;
        else return d <= Integer.MIN_VALUE;
    }

    private boolean checkFraction(String s){
        String regExp = "^[-]?[0-10]|[-]?[0-10]+/+[-]?[0-10]+$";
        return s.matches(regExp);
    }

    private void normalization(){
        int a; int b;
        if(n < 0 && d < 0){n = -n;
            d = -d;}
        else if(d < 0){n = -n;
            d = -d;}
        if(n < 0){a = -n;
        }
        else{a = n;
        }
        b = d;
        while(b>0){
            int temp = b;
            b = a%b;
            a = temp;
        }
        this.n = n/a;
        this.d = d/a;
    }

    public boolean equals(Object o){
        if (getClass() != o.getClass())return false;
        RationalFraction other = (RationalFraction) o;
        return (n.equals(other.n)) && (d.equals(other.d));
    }
    public boolean lessThan(RationalFraction f){
        return (long) n * f.d < (long) d * f.n;
    }
    public RationalFraction add(RationalFraction frcNum) {
        return new RationalFraction(this.n*frcNum.d + this.d*frcNum.n, this.d*frcNum.d);
    }
    public RationalFraction sub(RationalFraction frcNum) {
           return new RationalFraction(this.n*frcNum.d - this.d*frcNum.n, this.d*frcNum.d);
    }
    public RationalFraction mul(RationalFraction frcNum) {
        return new RationalFraction(this.n*frcNum.n, this.d*frcNum.d);
    }
    public RationalFraction div(RationalFraction frcNum) {
     return new RationalFraction(this.n*frcNum.d, this.d*frcNum.n);
    }

    @Override
    public String toString() {
        if(n == 0 || d == 0) return "0";
        else if(d == 1) return n+"";
        else if(n < 0){
            int positive = n * (-1);
            if(positive > d){ return n/d + " " + positive%d + "/" + d;}
            else return n + "/" + d;
        }
        else if(n > d) return n/d + " " + n%d + "/" + d;
        else return n + "/" + d;
    }

    public RationalFraction addNextNumber() {
        return  this.add(new RationalFraction(this.n+1, this.d));
    }
}
