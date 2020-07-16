import java.util.List;
import java.util.Scanner;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.mysql.jdbc.PreparedStatement;

public class Text {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Menu();
		int choose = 10;
		while(true){
			System.out.println("请选择您需要使用的功能:");
			choose = sc.nextInt();
			switch (choose) {
			case 1:
				addPerson();
				break;
			case 2:
				updatePerson();
				break;
				
			case 3:
				System.out.println("英雄姓名:");
				String name = sc.next();
				deletePerson1(name);
				break;
				
			case 4:
				System.out.println("英雄编号:");
				int id = sc.nextInt();
				deletePerson(id);
				break;
				
			case 5:
				System.out.println("英雄编号:");
				int idd = sc.nextInt();
				findAllPerson1(idd);
				break;
			case 6:
				findAllPerson();
				break;

			case 0:
				System.exit(0);
				break;
			}
		}
		
	}

	private static void Menu() {
		System.out.println("1:添加		2:修改		3:由姓名删除英雄");
		System.out.println("4:由id删除英雄	5:由id查询英雄	6:查询所有英雄	0:退出");
	}

	// 添加方法
	private static void addPerson() {

		Scanner sc = new Scanner(System.in);
		JdbcTemplate jt = new JdbcTemplate(JDBCUtils.getDataSource());
		String sql = "insert into person(id,name,username,password,age,des,weight) values(?,?,?,?,?,?,?)";
		System.out.println("hero's number");
		int id = sc.nextInt();
		System.out.println("hero's name");
		String name = sc.next();
		System.out.println("username");
		String username = sc.next();
		System.out.println("password");
		String password = sc.next();
		System.out.println("age");
		int age = sc.nextInt();
		System.out.println("阿吧阿吧");
		String des = sc.next();
		System.out.println("weight");
		double weight = sc.nextDouble();
		int update = jt.update(sql, id, name, username, password, age,
				des, weight);
		System.out.println("修改数为:"+update);
	}

	// 修改方法
	private static void updatePerson() {
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入英雄编号:");
			int id = sc.nextInt();
		JdbcTemplate jt = new JdbcTemplate(JDBCUtils.getDataSource());
		
		
		while(true){
			System.out.println("2:修改name");
			System.out.println("3:修改username");
			System.out.println("4:修改password");
			System.out.println("5:修改age");
			System.out.println("6:修改desc");
			System.out.println("7:修改weight");
			System.out.println("8:exit");
			
			int x = sc.nextInt();
			switch (x) {
			case 1:
				
				break;
			case 2:
				System.out.println("请输入新的name");
				String name = sc.next();
				int update2 = jt.update(" update person set name = ? where id = ? ",
						name, id);
				System.out.println("修改数为:"+update2);
				break;
			case 3:
				System.out.println("请输入新的username");
				String username = sc.next();
				int update3 = jt.update(" update person set username = ? where id = ? ",
						username, id);
				System.out.println("修改数为:"+update3);
				break;
			case 4:
				System.out.println("请输入新的password");
				String password = sc.next();
				int update4 = jt.update(" update person set password = ? where id = ? ",
						password, id);
				System.out.println("修改数为:"+update4);
				break;
			case 5:
				System.out.println("请输入新的age");
				int age = sc.nextInt();
				int update5 = jt.update(" update person set age = ? where id = ? ",
						age, id);
				System.out.println("修改数为:"+update5);
				break;
			case 6:
				System.out.println("请输入新的username");
				String des = sc.next();
				int update6 = jt.update(" update person set des = ? where id = ? ",
						des, id);
				System.out.println("修改数为:"+update6);
				break;
			case 7:
				System.out.println("请输入新的username");
				double weight = sc.nextDouble();
				int update7 = jt.update(" update person set weight = ? where id = ? ",
						weight, id);
				System.out.println("修改数为:"+update7);
				break;

			case 8:
				System.out.println("exit");
				System.exit(0);
				break;
			}
		}
		
		
	}

	// name删除 aaa
	private static void deletePerson1(String x) {
		
		JdbcTemplate jt = new JdbcTemplate(JDBCUtils.getDataSource());
		int update = jt.update(" delete from person where name = ?", x);
		System.out.println("修改记录:"+update);
	}
	

	// id删除 
	private static void deletePerson(int x) {
		JdbcTemplate jt = new JdbcTemplate(JDBCUtils.getDataSource());
		int update = jt.update(" delete from person where id = ?", x);
		System.out.println("修改数为:"+update);
	}

	// find id 
	private static void findAllPerson1(int x) {
		JdbcTemplate jt = new JdbcTemplate(JDBCUtils.getDataSource());

		String sql = "select * from person where id = ?";
		List<Person> list = jt.query(sql, new BeanPropertyRowMapper<Person>(
				Person.class), x);

		for (Person person : list) {
			System.out.println(person);
		}
	}

	// all
	private static void findAllPerson() {
		JdbcTemplate jt = new JdbcTemplate(JDBCUtils.getDataSource());

		String sql = "select * from person";
		List<Person> list = jt.query(sql, new BeanPropertyRowMapper<Person>(
				Person.class));

		for (Person person : list) {
			System.out.println(person);
		}
	}
}







