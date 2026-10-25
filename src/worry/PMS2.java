package worry;

import java.util.ArrayList;
import java.util.Scanner;

public class PMS2 {

    // =========================
    // 1. 房间类
    // =========================
    public static class Room {

        private int id;
        private String roomNumber;
        private int rent;
        private String status;
        private String tenantName;

        // 构造方法
        public Room(int id, String roomNumber, int rent, String status) {
            this.id = id;
            this.roomNumber = roomNumber;
            this.rent = rent;
            this.status = status;
            this.tenantName = null;
        }


        // =========================
        // Getter
        // =========================

        public int getId() {
            return id;
        }

        public String getRoomNumber() {
            return roomNumber;
        }

        public int getRent() {
            return rent;
        }

        public String getStatus() {
            return status;
        }

        public String getTenantName() {
            return tenantName;
        }


        // =========================
        // Setter
        // =========================

        public void setRent(int rent) {

            if (rent > 0) {
                this.rent = rent;
                System.out.println("修改租金成功，修改为：" + rent);
            } else {
                System.out.println("修改失败：租金必须大于0");
            }
        }

        public void setRoomNumber(String roomNumber) {
            this.roomNumber = roomNumber;
        }


        // =========================
        // 判断房间是否空闲
        // =========================

        public boolean isAvailable() {
            return status.equals("available");
        }


        // =========================
        // 计算总租金
        // =========================

        public int calculateRent(int months) {
            return rent * months;
        }


        // =========================
        // 办理入住
        // =========================

        public void rentRoom(String name, int months) {

            if (isAvailable()) {

                status = "occupied";
                tenantName = name;

                int total = calculateRent(months);

                System.out.println("===== 入住成功 =====");
                System.out.println("房间号：" + roomNumber);
                System.out.println("租房者：" + tenantName);
                System.out.println("租房时间：" + months + "个月");
                System.out.println("月租：" + rent);
                System.out.println("总租金：" + total);

            } else {

                System.out.println("入住失败：该房屋已经出租！");
            }
        }


        // =========================
        // 办理退房
        // =========================

        public void checkOut() {

            if (isAvailable()) {

                System.out.println("退房失败：该房间目前就是空房");

            } else {

                status = "available";
                tenantName = null;

                System.out.println("退房成功！");
            }
        }


        // =========================
        // 显示房间详细信息
        // =========================

        public void showInfo() {

            System.out.println("----------------------");
            System.out.println("ID：" + id);
            System.out.println("房间号：" + roomNumber);
            System.out.println("月租：" + rent);
            System.out.println("状态：" + status);

            if (tenantName == null) {
                System.out.println("租客：无");
            } else {
                System.out.println("租客：" + tenantName);
            }
        }
    }


    // =========================
    // 2. 根据房间号查找房间
    // =========================

    public static Room findRoom(
            ArrayList<Room> rooms,
            String roomNumber) {

        for (Room room : rooms) {

            if (room.getRoomNumber().equals(roomNumber)) {
                return room;
            }
        }

        return null;
    }


    // =========================
    // 3. 显示所有房间
    // =========================

    public static void showAllRooms(ArrayList<Room> rooms) {

        System.out.println("===== 所有房间 =====");

        for (Room room : rooms) {
            room.showInfo();
        }
    }


    // =========================
    // 4. 显示所有空房
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
    // 5. 程序入口
    // =========================

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        ArrayList<Room> rooms = new ArrayList<>();


        // 创建三个测试房间
        Room room1 =
                new Room(1, "A101", 2500, "available");

        Room room2 =
                new Room(2, "A102", 3000, "occupied");

        Room room3 =
                new Room(3, "B201", 3200, "available");


        // 加入房间集合
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


            // 1. 查看所有房间
            if (choice == 1) {

                showAllRooms(rooms);
            }


            // 2. 查看所有空房
            else if (choice == 2) {

                showAvailableRooms(rooms);
            }


            // 3. 办理入住
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


            // 4. 办理退房
            else if (choice == 4) {

                System.out.print("请输入房间号：");
                String roomNumber = scanner.nextLine();

                Room room = findRoom(rooms, roomNumber);

                if (room == null) {

                    System.out.println("没有找到该房间");

                } else {

                    room.checkOut();
                }
            }


            // 5. 修改租金
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

                    room.setRent(newRent);
                }
            }


            // 0. 退出系统
            else if (choice == 0) {

                System.out.println("系统已退出");
                break;
            }


            // 其他数字
            else {

                System.out.println("没有这个功能，请重新输入");
            }
        }

        scanner.close();
    }
}