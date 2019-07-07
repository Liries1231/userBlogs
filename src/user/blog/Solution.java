package user.blog;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {

    public static ArrayList<User> users = new ArrayList<>();

    static {
        List<User> collect = IntStream.range(0, 10).mapToObj(number -> {
            User user = new User();
            user.setLogin("test-" + number);
            user.setPassword("123" + number);
            user.setSex(Sex.MALE);
            user.setCity("fsdfds" + number);
            return user;
        }).collect(Collectors.toList());
        users.addAll(collect);

    }

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите ваш логин");
        String login = reader.readLine();
        System.out.println("Введите пароль");
        String password = reader.readLine();

        int index = 0;
        while (true) {


            for (int i = 0; i < users.size(); i++) {
                User user = users.get(i);
                String userLogin = user.getLogin();
                String userPassword = user.getPassword();
                // System.out.println("User login is: " + userLogin + " User password is: " + userPassword);
                boolean loginEquals = login.equals(userLogin);
                boolean passwordEquals = password.equals(userPassword);
                //  System.out.println("Логин совпал : " + loginEquals + " Пароль совпал: " + passwordEquals);
                if (loginEquals && passwordEquals) {

                    System.out.println("Вы авторизовались");
                    System.out.println("Введите сообщение");
                    String userMessage = reader.readLine();
                    Blog userBlog = createBlog(userMessage);

                    user.getUserBlogs().add(userBlog);
                    index = i;

                    break;

                }


            }
            System.out.println("Введите еще одно сообщение или введите exit для выхода");
            String consoleMessage = reader.readLine();
            if (consoleMessage.equals("exit")) {
                System.out.println("Ваши созданные блоги: ");
                List<Blog> userBlogs = users.get(index).getUserBlogs();
                for (Blog userBlog : userBlogs) {
                    System.out.println(userBlog.getText());
                }

                break;

            } else {
                Blog blog = createBlog(consoleMessage);
                users.get(index).getUserBlogs().add(blog);
            }


        }

    }



    }






