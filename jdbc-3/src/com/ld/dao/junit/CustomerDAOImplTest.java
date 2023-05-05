package com.ld.dao.junit;

import com.ld.bean.Customer;
import com.ld.dao.CustomerDAOImpl;
import com.ld.util.JDBCUtils;
import org.junit.Test;

import java.sql.Connection;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;

public class CustomerDAOImplTest {

    private CustomerDAOImpl dao=new CustomerDAOImpl();

    @Test
    public void inset() {
        Connection connection=null;
        try {
            connection= JDBCUtils.getConnection();
            Customer customer= new Customer(0,"zjy","mirror@ld.com",new Date(2002,10,23));
            dao.inset(connection,customer);
            System.out.println("添加成功！");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(connection,null);
        }
    }

    @Test
    public void deleteById() {
        Connection connection=null;
        try {
            connection= JDBCUtils.getConnection();
            System.out.println("请输入要删除人员的id:");
            Scanner sc=new Scanner(System.in);
            int id=sc.nextInt();
            dao.deleteById(connection,id);
            System.out.println("删除成功！");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(connection,null);
        }
    }

    @Test
    public void update() {
        Connection connection=null;
        try {
            connection= JDBCUtils.getConnection();
            System.out.println("请输入要修改人员的信息");
            Scanner sc=new Scanner(System.in);
            System.out.println("id: ");
            int id=sc.nextInt();
            sc.nextLine();
            System.out.println("name: ");
            String name=sc.nextLine();
            System.out.println("email: ");
            String email=sc.nextLine();
            System.out.println("birth: ");
            String birth=sc.nextLine();
            SimpleDateFormat spd=new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date date=spd.parse(birth);
            if(dao.getCustomerById(connection,id)==null){
                System.out.println("查无此人，无法执行此操作！");
            }else {
                Customer customer = new Customer(id, name, email, new Date(date.getTime()));
                dao.update(connection, customer);
                System.out.println("修改成功！");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(connection,null);
        }
    }

    @Test
    public void getCustomerById() {
        Connection connection=null;
        try {
            connection= JDBCUtils.getConnection();
            System.out.println("请输入要查询人员id:");
            int id=new Scanner(System.in).nextInt();
            Customer customer=dao.getCustomerById(connection,id);
            if(customer!=null){
                System.out.println(customer);
            }else {
                System.out.println("查无此人！");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(connection,null);
        }
    }

    @Test
    public void getAll() {
        Connection connection=null;
        try {
            connection= JDBCUtils.getConnection();
            List<Customer> customers=dao.getAll(connection);
            for (Customer customer : customers) {
                System.out.println(customer);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(connection,null);
        }
    }

    @Test
    public void getCount() {
        Connection connection=null;
        try {
            connection= JDBCUtils.getConnection();
            System.out.println("记录数目: "+dao.getCount(connection));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(connection,null);
        }
    }

    @Test
    public void getMaxDate() {
        Connection connection=null;
        try {
            connection= JDBCUtils.getConnection();
            System.out.println(dao.getMaxDate(connection));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(connection,null);
        }
    }
}