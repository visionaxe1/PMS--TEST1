package PROJECT;
import worry.PMS2;

import java.awt.*;
import java.awt.desktop.SystemSleepEvent;
import java.lang.annotation.RetentionPolicy;
import java.sql.SQLOutput;
import java.util.ArrayList;

import java.sql.SQLSyntaxErrorException;
import java.util.Scanner;
//这里开始写第七步的PMS方法

//开发以及PMS系统2.0   custom数据与系统






public class PMS {

    public static PMS findroom(ArrayList<PMS>rooms,String TargetRoomNumber){
        for (PMS room : rooms){
                if(room.GetterRoomNumber().equals(TargetRoomNumber)){
                    return room;
                }
        }
return null;
    }


    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }



    public static Customer findCustomer(ArrayList<Customer> Customers, int customerId) {

        for (Customer customer : Customers) {

            if (customer.getId() == customerId) {
                return customer;
            }
        }

        return null;
    }

    //开发26.10.23---开发房间的class类
   private int ID;
    private String RoomNumber;
    private int RentMoney;
    private String State;
    private Customer customer;

    // 现在这里开始创建房间ROOM的类


    public PMS (int ID, String RoomNumber, int RentMoney, String State) {
        this.ID = ID;
        this.RoomNumber = RoomNumber;
        this.RentMoney = RentMoney;
        this.State = State;
    }
//  封装后 这里开始写提取数据的四个方法 getter //注意getter方法不能写stastc 因为要get封装的数据 不能用静态方法
        //1.ID
        public int GetterID () {
            return ID;

        }
//2.RoomNumber
        public String GetterRoomNumber () {
            return RoomNumber;
        }
//3.RentMoney
        public int GetterRentMoney () {
            return RentMoney;
        }
//4.State
        public String GettterState () {
            return State;
        }
//写完getter 现在开始写setter
        //1.setter ID；
        public void SetterID (int ID){
            this.ID = ID;
        }
        //setter RoomNumber
        public void SetterRoomNumber (String RoomNumber){
            this.RoomNumber = RoomNumber;
        }
        //setter RentMoney
        public void SetterRentMoney ( int RentMoney){
            this.RentMoney = RentMoney;
        }
        //setter State
        public void SetterState (String State){
            this.State = State;
        }

        public static void main(String[] args) {
            PMS room1 = new PMS(1, "A101", 2500, "availble");
            Customer booker = new Customer(
                    1,
                    "Devin Booker",
                    "18729879322"
            );

            room1.setCustomer(booker);
            room1.SetterState("occupied");

            System.out.println("房间：" + room1.GetterRoomNumber());
            System.out.println("租客：" + room1.getCustomer().getName());
            System.out.println("电话：" + room1.getCustomer().getPhone());



            System.out.println(room1.GetterID());
//test finish 成功取得了第一个ID 现在开始开发第二步 --- 创造多个room
            PMS room2 = new PMS(2, "A102", 2900, "occuiped");
            PMS room3 = new PMS(3, "A103", 3000, "availble");
            //开发第三步 ---  for 和ArrayList
            ArrayList<PMS> Rooms = new ArrayList<>();  //创造一个ArrayList列表 并且专门装PMS对象 这个list叫做Rooms 等号后面的意思是指创造一个新的Arraylist函数
            //往list rooms里放东西：
            Rooms.add(room1);
            Rooms.add(room2);
            Rooms.add(room3);
            System.out.println(Rooms.size());
//第四步 ---- for循环 将arraylist里的数据拿出来
            for (PMS room : Rooms) {

                System.out.println(room.GettterState());
                // PMS 意味着类型 room表示临时的标签（遍历取出来之后的名字） Rooms是list的名字（也就是你要遍历的list）
            }
// 现在开始将for 循环以及if 和equal结合在一起 写一个可以检测房间状态是available还是 occuiped
            for (PMS RoomState : Rooms) {
                if (RoomState.GettterState().equals("availble")) {     //这里意味着list中遍历的数据取它的state状态
                    System.out.println(RoomState.GetterRoomNumber());
                    System.out.println(RoomState.GetterRentMoney());
                }

            }
//开发第六步----根据房间号查询数据
            String TargetRoomNumber = "A102";
            for (PMS RoomNumber : Rooms) {
                if (RoomNumber.GetterRoomNumber().equals(TargetRoomNumber)) {
                    System.out.println(RoomNumber.GetterRentMoney());
                    System.out.println(RoomNumber.GettterState());
                    System.out.println(RoomNumber.GetterID());
                    System.out.println(RoomNumber.GettterState());
                }
//开发第七步 --- findRoom方法 自动化进行findroom的操作
// 在PMS 里写完findroom的方法后 来这里进行 测试
            }

            PMS foundroom = findroom(Rooms, "A101");
            System.out.println(foundroom.GettterState());
            System.out.println(foundroom.GetterID());
            System.out.println(foundroom.GetterRentMoney());
            System.out.println(foundroom.GetterRoomNumber());
            //开发第八步--- 修改房间信息
            if (foundroom != null) {
                if (foundroom.GettterState().equals("availble")) {
                    foundroom.SetterState("occuiped");
                    System.out.println("修改成功 该房间已经变成入住状态");
                } else {
                    System.out.println("该房间已经入住");
                }

            } else {
                System.out.println("未找到该房间");
            }

            //开发任务9-----对象引用
            //可以直接进行rooms.settterID()

            //开发任务10---退房
            if (foundroom != null) {
                if (foundroom.GettterState().equals("occuiped")) {
                    foundroom.SetterState("availble");
                    System.out.println("退房成功 房间状态已经改为空闲！");
                } else {
                    System.out.println("退房失败，该房间已经为空闲！");
                }
            } else {
                System.out.println("没有找到该房间!");
            }
//开发任务11---- Scanner 用户输入 //1.import java.util.Scanner; 来导入Scnnaer函数
            Scanner RoomScanner = new Scanner(System.in);  //创建一个叫做RoomScanner的读取器 System.in意味着监听用户输入的数据
            System.out.println("请输入你要查询的房间号：");
            String RoomNumber = RoomScanner.nextLine();

//将RoomNumber 和getter保存在一起 并且进行输入查询
            PMS SearchRoom = findroom(Rooms, RoomNumber);
            if (RoomNumber != null) {
                System.out.println("你查询的房间号码是：" + SearchRoom.GetterRoomNumber());
                System.out.println("你查询的房间租金是:" + SearchRoom.GetterRentMoney());
                System.out.println("你查询的房间状态是" + SearchRoom.GettterState());

            } else {
                System.out.println("你查询的房间不存在!");
            }

//开发任务12---- 用switch编译出PMS系统的操作台

            //开发任务17 ---- while

            Customer customer2 = new Customer(2, "Stephen Curry", "18729879323");
            Customer customer3 = new Customer(3, "LeBron James", "18729879324");

            ArrayList<Customer> Customers = new ArrayList<>();


            Customers.add(customer2);
            Customers.add(customer3);









            while(true){      //只要括号里的条件是 true，就一直重复执行 {} 里面的代码


            System.out.println("====== PMS 公寓管理系统 ======");
            System.out.println("1. 查询房间");
            System.out.println("2. 查看所有空闲房间");
            System.out.println("3. 办理入住");
            System.out.println("4. 办理退房");
            System.out.println("0. 退出系统");
            System.out.println("请输入功能编号：");

            int choice = RoomScanner.nextInt();
            RoomScanner.nextLine();
            switch (choice) {
                case 1:     //开发任务13 CASE1
                    System.out.println("你选择了查询房间");
                    System.out.println("请输入你要查询的房间号：");

                    String TargetRoomNumber1 = RoomScanner.nextLine();

                    PMS SearchRoom1 = findroom(Rooms, TargetRoomNumber);

                    if (SearchRoom1 != null) {
                        System.out.println("房间号：" + SearchRoom.GetterRoomNumber());
                        System.out.println("租金：" + SearchRoom.GetterRentMoney());
                        System.out.println("状态：" + SearchRoom.GettterState());
                    } else {
                        System.out.println("没有找到该房间");
                    }


                    break;
                case 2:     //开发任务14 CASE2
                    System.out.println("你选择了查询所有空闲房间");
                    for (PMS room : Rooms) {
                        if (room.GettterState().equals("availble")) {
                            System.out.println(room.GettterState());
                            System.out.println(room.GetterRoomNumber());
                            System.out.println(room.GetterRentMoney());
                        }

                    }


                    break;
                case 3:       //开发任务15 CASE 3
                    System.out.println("你选择了办理入住");
                    System.out.println("请输入您要办理入住的房间号：");

                    String CheckInRoomNumber = RoomScanner.nextLine();

                    PMS CheckInRoom = findroom(Rooms, CheckInRoomNumber);

                    // 第一步：判断房间是否存在
                    if (CheckInRoom == null) {
                        System.out.println("房间不存在！");
                        break;
                    }

                    // 第二步：判断房间是否空闲
                    if (!CheckInRoom.GettterState().equals("available")) {
                        System.out.println("该房间当前不可办理入住！");
                        break;
                    }

                    // 第三步：输入租客 ID
                    System.out.println("请输入租客ID：");

                    int customerId = RoomScanner.nextInt();
                    RoomScanner.nextLine();

                    // 第四步：查找租客
                    Customer CheckInCustomer = findCustomer(Customers, customerId);

                    if (CheckInCustomer == null) {
                        System.out.println("客户不存在，无法办理入住！");
                        break;
                    }

                    // 第五步：检查租客是否已经入住其他房间
                    boolean alreadyCheckedIn = false;

                    for (PMS room : Rooms) {
                        if (room.getCustomer() != null
                                && room.getCustomer().getId() == customerId) {
                            alreadyCheckedIn = true;
                            break;
                        }
                    }

                    if (alreadyCheckedIn) {
                        System.out.println("该客户已经入住其他房间！");
                        break;
                    }

                    // 第六步：绑定租客和房间
                    CheckInRoom.setCustomer(CheckInCustomer);
                    CheckInRoom.SetterState("occupied");

                    // 第七步：输出入住信息
                    System.out.println("========== 入住成功 ==========");
                    System.out.println("房间号：" + CheckInRoom.GetterRoomNumber());
                    System.out.println("房间租金：" + CheckInRoom.GetterRentMoney());
                    System.out.println("租客ID：" + CheckInCustomer.getId());
                    System.out.println("租客姓名：" + CheckInCustomer.getName());
                    System.out.println("联系电话：" + CheckInCustomer.getPhone());
                    System.out.println("房间状态：" + CheckInRoom.GettterState());
                    System.out.println("============================");


                    break;


                case 4:
                    System.out.println("你选择了办理退房");//开发任务16 CASE 4 与 CASE 3 类似的逻辑
                    System.out.println("请输入您要办理退房的房间号");
                    String CheckOutRoomNumber = RoomScanner.nextLine();

                    PMS CheckOutRoom = findroom(Rooms, CheckOutRoomNumber);
                    if (CheckOutRoom != null) {
                        if (CheckOutRoom.GettterState().equals("availble")) {
                            System.out.println("抱歉 该房间空闲 无法办理退房 请重新输入您的房间号");
                            if (CheckOutRoom.getCustomer() != null) {
                                System.out.println(room1.getCustomer().getName());
                            } else {
                                System.out.println("当前房间没有租客");
                            }




                        } else {
                            CheckOutRoom.SetterState("availble");

                            System.out.println("房间号：" + CheckOutRoom.GetterRoomNumber());
                            System.out.println("租金：" + CheckOutRoom.GetterRentMoney());
                            CheckOutRoom.setCustomer(null);

                            System.out.println("您已经办退房成功！");


                        }

                    }
                    break;

                case 0:
                    System.out.println("感谢您使用PMS系统！");
return;
//开发任务 18 --- return 结束当前正在执行的方法，并返回到调用这个方法的地方。
                default:
                    System.out.println("输入错误！");
            }




            }
            //开发任务17 switch 和 while


//开发任务18 --- 客户方面的get与set

//创造一个 list 去包含第一个custom的信息















    }
        }


















































