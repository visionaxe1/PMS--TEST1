import java.lang.reflect.Array;
import java.util.Scanner;
import java.util.ArrayList;
public class PMS {
    public static class Room {
        private int id;
        private String RoomNumber;
        private int rent;
        private String Status;
private String tenantname;
//封装后用getter方法将其数据取出

        public Room(int id, String RoomNumber, int rent, String Status) {


            this.id = id;
            this.RoomNumber = RoomNumber;
            this.rent = rent;
            this.Status = Status;


        }

        public boolean isavailble() {
            if (Status.equals("availble")) {

                return true;
            } else {

                return false;
            }


        }
    public void rentRoom(String name,int months){
if(isavailble()){
    Status = "Occupied";
    tenantname = name;
    int total = months*rent;
    System.out.println("修改成功 该房屋已经出租！");
    System.out.printf("租房时间为"+months);
    System.out.printf("租房者："+name);
    System.out.printf("");
System.out.println("总租金为："+total);
}else{
    System.out.println("修改失败 该房屋已经出租!");
}


    }
public void RoomCheckOut(){
            Status = "availble";
tenantname = null;
    System.out.printf("退房成功！");


        }
        //开始写room里的数据的getter
public int GetRent(){
            return rent;

}
public String GetRoomNumber(){
            return RoomNumber;
}
public int GetId(){
            return id;
}
public String GetStatus(){

            return Status;
}

public String Gettenantname(){
            return tenantname;
}
//开始写room里的数据的setter
        public void SetRent(){
            if(rent > 0)
            this.rent = rent;
            System.out.println("修改租金成功 修改为:"+rent);
        }

public String SetRoomNumber() {
    this.RoomNumber = RoomNumber;
}

    }



    public static void main(String[] args){
        ArrayList<Room> rooms = new ArrayList<>();
        Room room1 = new Room(1, "A101", 2500, "available");
        Room room2 = new Room(2, "A102", 3000, "occupied");
        Room room3 = new Room(3, "B201", 3200, "available");
        rooms.add(room1);
        rooms.add(room2);
        rooms.add(room3);
for(Room room:rooms){
    if(room.isavailble()){
        System.out.println(room.GetRoomNumber());
    }
}
        public static Room findRoom(
                ArrayList<Room> rooms,
                String ) {

            for (Room room : rooms) {

                if (room.getRoomNumber().equals(roomNumber)) {
                    return room;
                }
            }

            return null;
        }


        // =========================
        // 显示所有房间
        // =========================

        public static void showAllRooms(ArrayList<Room> rooms) {

            System.out.println("===== 所有房间 =====");

            for (Room room : rooms) {
                room.showInfo();
            }
        }


        // =========================
        // 显示所有空房
        // =========================

        public static void showAvailableRooms(ArrayList<Room> rooms) {

            System.out.println("===== 当前可出租房间 =====");

            for (Room room : rooms) {

                if (room.isAvailable()) {

                    System.out.println(
                            room.getRoomNumber()
                                    + " | 月租："
                                    + room.getRent()
                    );
                }
            }
        }


        // =========================
        // main 程序入口
        // =========================

        public static void main(String[] args) {

            Scanner scanner = new Scanner(System.in);

            ArrayList<Room> rooms = new ArrayList<>();


            // 创建测试房间
            Room room1 =
                    new Room(1, "A101", 2500, "available");

            Room room2 =
                    new Room(2, "A102", 3000, "occupied");

            Room room3 =
                    new Room(3, "B201", 3200, "available");


            // 添加到房间集合
            rooms.add(room1);
            rooms.add(room2);
            rooms.add(room3);


            // =========================
            // PMS 主循环
            // =========================

            while (true) {

                System.out.println();
                System.out.println("========== 公寓管理系统 ==========");
                System.out.println("1. 查看所有房间");
                System.out.println("2. 查看可出租房间");
                System.out.println("3. 办理入住");
                System.out.println("4. 办理退房");
                System.out.println("5. 修改房间租金");
                System.out.println("0. 退出系统");
                System.out.println("================================");

                System.out.print("请选择功能：");

                int choice = scanner.nextInt();
                scanner.nextLine();


                // =========================
                // 1 查看所有房间
                // =========================

                if (choice == 1) {

                    showAllRooms(rooms);
                }


                // =========================
                // 2 查看空房
                // =========================

                else if (choice == 2) {

                    showAvailableRooms(rooms);
                }


                // =========================
                // 3 办理入住
                // =========================

                else if (choice == 3) {

                    System.out.print("请输入房间号：");
                    String roomNumber = scanner.nextLine();

                    Room room = findRoom(rooms, roomNumber);

                    if (room == null) {

                        System.out.println("没有找到该房间");

                    } else {

                        System.out.print("请输入租客姓名：");
                        String name = scanner.nextLine();

                        System.out.print("请输入租住月数：");
                        int months = scanner.nextInt();
                        scanner.nextLine();

                        room.rentRoom(name, months);
                    }
                }


                // =========================
                // 4 办理退房
                // =========================

                else if (choice == 4) {

                    System.out.print("请输入房间号：");
                    String roomNumber = scanner.nextLine();

                    Room room = findRoom(rooms, roomNumber);

                    if (room == null) {

                        System.out.println("没有找到该房间");

                    } else {

                        room.RoomCheckOut();
                    }
                }


                // =========================
                // 5 修改租金
                // =========================

                else if (choice == 5) {

                    System.out.print("请输入房间号：");
                    String roomNumber = scanner.nextLine();

                    Room room = findRoom(rooms, roomNumber);

                    if (room == null) {

                        System.out.println("没有找到该房间");

                    } else {

                        System.out.print("请输入新的月租：");
                        int newRent = scanner.nextInt();
                        scanner.nextLine();

                        room.SetRent(newRent);
                    }
                }


                // =========================
                // 0 退出
                // =========================

                else if (choice == 0) {

                    System.out.println("系统已退出");
                    break;
                }


                // =========================
                // 输入错误
                // =========================

                else {

                    System.out.println("没有这个功能，请重新输入");
                }
            }

            scanner.close();
        }
    }










}




















}
