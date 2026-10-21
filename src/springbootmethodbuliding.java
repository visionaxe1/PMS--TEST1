public class springbootmethodbuliding {
public static int calculateRent(int month,int money){

    return (month*money);
}
public static boolean isExpensive(int RentCost){
    if(RentCost>=3000){
        return  (true);
        }
     else{
            return (false);
        }


    }


    public static void main(String[] args){
        int res = calculateRent(20,30);
System.out.println(res);


boolean res_1 = isExpensive(3600);
System.out.println(res_1);

}

}





