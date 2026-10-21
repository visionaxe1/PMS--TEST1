public class oop {


    public static class Room {
        String RoomNumber;
        int Roomsize;
int rent;
    public int reuslt(int months){
        return months*rent;

    }



    }





    public static void main(String[] args){
Room room1 = new Room();
room1.RoomNumber="A101";
room1.Roomsize=19;
room1.rent=12;

Room room2 =new Room();
        room2.rent=16;
room2.Roomsize=23;
room2.RoomNumber="A123";




System.out.println(room1.reuslt(6));
System.out.println(room2.reuslt(8));










    }
//开始构建面向对象编程的第一步 创造类















}
