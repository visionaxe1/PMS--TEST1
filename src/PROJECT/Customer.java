package PROJECT;

import java.util.ArrayList;

public class Customer {

    // 客户属性
    private int id;
    private String name;
    private String phone;

    // 构造方法
    public Customer(int id, String name, String phone) {
        this.id = id;
        this.name = name;
        this.phone = phone;
    }

    // Getter
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    // Setter
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public static void main(String[] args) {

        // 创建三个客户对象
        Customer customer1 = new Customer(
                1,
                "Devin Booker",
                "18729879322"
        );

        Customer customer2 = new Customer(
                2,
                "Stephen Curry",
                "18729879323"
        );

        Customer customer3 = new Customer(
                3,
                "LeBron James",
                "18729879324"
        );

        // 创建客户列表
        ArrayList<Customer> Customers = new ArrayList<>();

        // 把客户加入列表
        Customers.add(customer1);
        Customers.add(customer2);
        Customers.add(customer3);

        // 遍历所有客户
        for (Customer customer : Customers) {

            System.out.println("客户ID：" + customer.getId());
            System.out.println("客户姓名：" + customer.getName());
            System.out.println("客户手机号：" + customer.getPhone());

            System.out.println("-------------------");
        }
    }
}



