package ru.spbstu;

import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.*;

public class Client {
    static RestTemplate restTemplate = new RestTemplate();
    static HttpHeaders headers = new HttpHeaders();
    private static String token;
    static HttpEntity<String> entity;

    static Scanner in = new Scanner(System.in);

    private static void getById(String url){
        System.out.println("Enter id: ");
        String id = in.next();
        if (!id.matches("[0-9]+")){
            System.out.println("Invalid id!");
            return;
        }
        try{
            ResponseEntity<Object> object = restTemplate.exchange(url + id, HttpMethod.GET, entity, Object.class);
            System.out.println(object.getBody().toString());
        }catch (Exception e){
            System.out.println("Object not found");
            return;
        }
    }

    private static void getByName(String url){
        System.out.println("Enter name:");
        String name = in.next();
        if (!name.matches("[а-яА-Я]+")) {
            System.out.println("Invalid name!");
            return;
        }
        try {
            ResponseEntity<Object> obj = restTemplate.exchange(url + name, HttpMethod.GET, entity, Object.class);
            System.out.println(obj.getBody().toString());
        } catch (Exception e) {
            System.out.println("Object wasn't found");
            return;
        }
    }

    private static void add(String url, JSONObject jsonObject){
        HttpEntity request = new HttpEntity<>(jsonObject.toString(), headers);
        try{
            Object object = restTemplate.postForObject(url, request, Object.class);
            System.out.println(object.toString());
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("Not created");
            return;
        }
        System.out.println("Successfully added");
    }

    public static void  signIn() throws JSONException{
        System.out.println("Login:");
        System.out.println("username: ");
        String login = in.next();
        System.out.println("password: ");
        String pwd = in.next();

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("userName", login);
        jsonObject.put("password", pwd);

        HttpEntity<String> request = new HttpEntity<>(jsonObject.toString(), headers);
        try{
            String object = restTemplate.postForObject("http://localhost:8080/auth/signIn", request, String.class);
            if (object != null){
                token = object;
                headers.set("Authorization", "Bearer " + token);
                entity = new HttpEntity<>(null, headers);
                System.out.println("Successful!");
                System.out.println(token);
            }
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("Wrong password/username");
        }

    }

    //-------------------------------BOOKS------------------------------------------------
    public static void getAllBooks(){
        ResponseEntity<List> list = restTemplate.getForEntity("http://localhost:8080/books/find-all", List.class);
        for (Object obj : Objects.requireNonNull(list.getBody())){
            System.out.println(obj.toString() + ",\n");
        }
    }

    public static void addBook() throws JSONException{
        String numRegex = "[0-9]+";
        String regex = "[а-яА-Я0-9a-zA-Z]+";
        System.out.println("Enter name");
        String name = in.next();
        if(!name.matches(regex)){
            System.out.println("Invalid name");
            return;
        }
        System.out.println("Enter cnt");
        String cnt = in.next();
        if(!cnt.matches(numRegex)){
            System.out.println("Invalid cnt");
            return;
        }
        System.out.println("Enter type id");
        String typeId = in.next();
        if(!typeId.matches(numRegex)){
            System.out.println("Invalid cnt");
            return;
        }

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", name);
        jsonObject.put("cnt", cnt);
        jsonObject.put("typeId", typeId);

        add("http://localhost:8080/books/add", jsonObject);
    }

    public static void getBookById(){
        getById("http://localhost:8080/books/find-by-id/");
    }

    public static void getBookByCount(){
        getById("http://localhost:8080/books/find-by-count/");
    }

    public static void getBookByTypeName(){
        String regex = "[а-яА-Я]+";
        System.out.println("Enter type name");
        String typeName = in.next();
        if(!typeName.matches(regex)){
            System.out.println("Invalid name");
        }
        try{
            String url = "http://localhost:8080/books/find-book-by-type-name/" + typeName;
            ResponseEntity<List> list = restTemplate.exchange(url, HttpMethod.GET, entity, List.class);
            for (Object obj : Objects.requireNonNull(list.getBody())){
                System.out.println(obj.toString() + ",\n");
            }
        } catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void getBookByDayCount(){
        getById("http://localhost:8080/books/find-book-by-day-count/");
    }

    public static void deleteBookByName(){
        System.out.println("Enter name:");
        String name = in.next();
        if (!name.matches("[а-яА-Я]+")) {
            System.out.println("Invalid name!");
            return;
        }
        try {
            String url = "http://localhost:8080/books/delete/" + name;
            restTemplate.exchange(url, HttpMethod.DELETE, entity, Object.class);
            System.out.println("Book deleted");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Object wasn't found");
            return;
        }
    }

    //--------------------------------------BookTypes--------------------------------
    public static void getAllBookTypes(){
        ResponseEntity<List> list = restTemplate.getForEntity("http://localhost:8080/book-types/find-all", List.class);
        for (Object obj : Objects.requireNonNull(list.getBody())){
            System.out.println(obj.toString() + ",\n");
        }
    }
    public static void addBookTypes() throws JSONException {
        String strRegex = "[a-zA-Zа-яА-Я0-9]+";
        String regex = "[0-9]+";
        System.out.println("Enter name:");
        String name = in.next();
        if(!name.matches(strRegex)){
            System.out.println("Invalid name");
            return;
        }
        System.out.println("Enter cnt:");
        String cnt = in.next();
        if(!cnt.matches(regex)){
            System.out.println("Invalid cnt");
            return;
        }
        System.out.println("Enter fine:");
        String fine = in.next();
        if(!fine.matches(regex)){
            System.out.println("Invalid fine");
            return;
        }
        System.out.println("Enter dayCount:");
        String dayCount = in.next();
        if(!dayCount.matches(regex)){
            System.out.println("Invalid dayCount");
            return;
        }

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", name);
        jsonObject.put("cnt", cnt);
        jsonObject.put("fine", fine);
        jsonObject.put("dayCount", dayCount);

        add("http://localhost:8080/book-types/add", jsonObject);
    }

    public static void getBookTypeById(){
        getById("http://localhost:8080/book-types/find-by-id/");
    }

    public static void getBookTypeByName(){
        getByName("http://localhost:8080/book-types/find-by-name/");
    }

    public static void getBookTypeByCnt(){
        getById("http://localhost:8080/book-types/find-by-cnt/");
    }

    public static void getBookTypeByDayCnt(){
        getById("http://localhost:8080/book-types/find-by-day-cnt/");
    }

    public static void deleteBookTypeByName(){
        System.out.println("Enter name:");
        String name = in.next();
        if (!name.matches("[а-яА-Я]+")) {
            System.out.println("Invalid name!");
            return;
        }
        try {
            String url = "http://localhost:8080/book-types/delete/" + name;
            restTemplate.exchange(url, HttpMethod.DELETE, entity, Object.class);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Object wasn't found");
            return;
        }
    }

    //-------------------------Client--------------------------
    public static void getAllClients(){
        ResponseEntity<List> list = restTemplate.getForEntity("http://localhost:8080/client/find-all", List.class);
        for (Object obj : Objects.requireNonNull(list.getBody())){
            System.out.println(obj.toString() + ",\n");
        }
    }

    public static void addClient() throws JSONException{
        String regex = "[0-9]+";
        String strRegex = "[а-яА-я]+";
        System.out.println("Enter first name");
        String firstName = in.next();
        if(!firstName.matches(strRegex)){
            System.out.println("Invalid first name");
            return;
        }
        System.out.println("Enter last name");
        String lastName = in.next();
        if(!lastName.matches(strRegex)){
            System.out.println("Invalid last name");
            return;
        }
        System.out.println("Enter father name");
        String fatherName = in.next();
        if(!fatherName.matches(strRegex)){
            System.out.println("Invalid father name");
            return;
        }

        System.out.println("Eneter passportSeria");
        String passportSeria = in.next();
        if(!passportSeria.matches(regex)){
            System.out.println("Invlid passport seria");
            return;
        }
        System.out.println("Eneter passport number");
        String passportNum = in.next();
        if(!passportNum.matches(regex)){
            System.out.println("Invlid passport number");
            return;
        }

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("firstName", firstName);
        jsonObject.put("lastName", lastName);
        jsonObject.put("fatherName", fatherName);
        jsonObject.put("passportSeria", passportSeria);
        jsonObject.put("passportNum", passportNum);

        add("http://localhost:8080/client/add", jsonObject);
    }

    public static void getClientById(){
        getById("http://localhost:8080/client/find-by-id/");
    }

    public static void getClientByFirstName(){
        getByName("http://localhost:8080/client/find-by-first-name/");
    }

    public static void getClientByLastName(){
        getByName("http://localhost:8080/client/find-by-last-name/");
    }

    public static void getClientByFatherName(){
        getByName("http://localhost:8080/client/find-by-father-name/");
    }

    public static void deleteClientById(){
        String regex = "[0-9]+";
        System.out.println("Enter id");
        String stringId = in.next();
        if(!stringId.matches(regex)){
            System.out.println("Invalid id");
            return;
        }
        Integer id = Integer.parseInt(stringId);

        try{
            String url = "http://localhost:8080/client/delete/" + id;
            restTemplate.exchange(url, HttpMethod.DELETE, entity, Object.class);
            System.out.println("Client deleted");
        } catch(Exception e){
            e.printStackTrace();
            System.out.println("Can't delete or not existing");
        }
    }

    public static void updateClientById() throws JSONException {
        String regex = "[0-9]+";
        String strRegex = "[а-яА-я]+";

        System.out.println("Enter id");
        String stringId = in.next();
        if(!stringId.matches(regex)){
            System.out.println("Invalid id");
            return;
        }
        Integer id = Integer.parseInt(stringId);
        System.out.println("Enter first name");
        String firstName = in.next();
        if(!firstName.matches(strRegex)){
            System.out.println("Invalid name");
            return;
        }
        System.out.println("Enter last name");
        String lastName = in.next();
        if(!lastName.matches(strRegex)){
            System.out.println("Invalid name");
            return;
        }
        System.out.println("Enter father name");
        String fatherName = in.next();
        if(!fatherName.matches(strRegex)){
            System.out.println("Invalid name");
            return;
        }

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("firstName", firstName);
        jsonObject.put("lastName", lastName);
        jsonObject.put("fatherName", fatherName);

        HttpEntity request = new HttpEntity<>(jsonObject.toString(), headers);
        try{
            String url = "http://localhost:8080/client/update-client/" + id;
            restTemplate.exchange(url,HttpMethod.PUT, request, Object.class);
            System.out.println("Updated client");
        } catch(Exception e) {
            e.printStackTrace();
            System.out.println("Something gone wrong");
        }
    }

//----------------------------------Journal-------------------------------------

    public static void getAllJournals(){
        ResponseEntity<List> list = restTemplate.getForEntity("http://localhost:8080/journal/find-all", List.class);
        for (Object obj : Objects.requireNonNull(list.getBody())){
            System.out.println(obj.toString() + ",\n");
        }
    }

    public static void addJournal() throws JSONException {
        String intRegex = "[0-9]+";
        String timeRegex = "[0-9]{4}-(0[1-9]|1[0-2])-(0[1-9]|[1-2][0-9]|3[0-1])T(2[0-3]|[01][0-9]):[0-5][0-9]:[0-5][0-9]";

        System.out.println("Enter book id");
        String bookId = in.next();
        if(!bookId.matches(intRegex)){
            System.out.println("Invalid id");
            return;
        }

        System.out.println("Enter client id:");
        String clientId = in.next();
        if(!clientId.matches(intRegex)){
            System.out.println("Invalid id");
            return;
        }

        System.out.println("Enter dateBeg");
        String dataBeg = in.next();
        if(!dataBeg.matches(timeRegex)){
            System.out.println("Invalid date");
            return;
        }

        System.out.println("Enter dateEnd");
        String dataEnd = in.next();
        if(!dataEnd.matches(timeRegex)){
            System.out.println("Invalid date");
            return;
        }

        System.out.println("Enter dateRet");
        String dataRet = in.next();
        if(! dataRet.matches(timeRegex)){
            System.out.println("Invalid date");
            return;
        }

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("bookId", bookId);
        jsonObject.put("clientId", clientId);
        jsonObject.put("dataBeg", dataBeg);
        jsonObject.put("dataEnd", dataEnd);
        jsonObject.put("dataRet", dataRet);

        add("http://localhost:8080/journal/add", jsonObject);
    }

    public static void getJournalById(){
        getById("http://localhost:8080/journal/find-by-id/");
    }

    public static void getJournalByClientInitials() throws JSONException {
        String strRegex = "[а-яА-я]+";
        System.out.println("Enter first name");
        String firstName = in.next();
        if(!firstName.matches(strRegex)){
            System.out.println("Invalid name");
            return;
        }
        System.out.println("Enter last name");
        String lastName = in.next();
        if(!lastName.matches(strRegex)){
            System.out.println("Invalid name");
            return;
        }
        System.out.println("Enter father name");
        String fatherName = in.next();
        if(!fatherName.matches(strRegex)){
            System.out.println("Invalid name");
            return;
        }

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("firstName", firstName);
        jsonObject.put("lastName", lastName);
        jsonObject.put("fatherName", fatherName);

        try{
            String url = "http://localhost:8080/journal/find-journal-by-client-initials/" + firstName + " " + lastName + " " + fatherName;
            ResponseEntity<List> list = restTemplate.exchange(url, HttpMethod.GET, entity, List.class);
            for (Object obj : Objects.requireNonNull(list.getBody())){
                System.out.println(obj.toString() + ",\n");
            }
        } catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void deleteJournalById(){
        String regex = "[0-9]+";
        System.out.println("Enter id");
        String stringId = in.next();
        if(!stringId.matches(regex)){
            System.out.println("Invalid id");
            return;
        }
        Integer id = Integer.parseInt(stringId);

        try{
            String url = "http://localhost:8080/journal/delete/" + id;
            restTemplate.exchange(url, HttpMethod.DELETE, entity, Object.class);
            System.out.println("Client deleted");
        } catch(Exception e){
            e.printStackTrace();
            System.out.println("Can't delete or not existing");
        }
    }

    public static void showCommands(){
        System.out.println("show commands");
        System.out.println("signIn");

        System.out.println("Commands for Books:");
        System.out.println("----------------------");
        System.out.println("add book");
        System.out.println("get all books");
        System.out.println("get book by id");
        System.out.println("get book by count");
        System.out.println("get book by type name");
        System.out.println("get book by day count");
        System.out.println("delete book by name");

        System.out.println("Commands for Book Types:");
        System.out.println("----------------------");
        System.out.println("add book type");
        System.out.println("get all book type");
        System.out.println("get book type by id");
        System.out.println("get book type by name");
        System.out.println("get book type by count");
        System.out.println("get book type by day count");
        System.out.println("delete book type by name");

        System.out.println("Commands for Clients:");
        System.out.println("----------------------");
        System.out.println("add client");
        System.out.println("get all clients");
        System.out.println("get client by id");
        System.out.println("get client by first name");
        System.out.println("get client by last name");
        System.out.println("get client by father name");
        System.out.println("update client by id");
        System.out.println("delete client by id");

        System.out.println("Commands for Journal:");
        System.out.println("----------------------");
        System.out.println("add journal");
        System.out.println("get all journals");
        System.out.println("get journal by id");
        System.out.println("get journal by client initials");
        System.out.println("delete journal by id");
    }

    public static void main(String[] args) {
        headers.setContentType(MediaType.APPLICATION_JSON);
        System.out.println("Start Application");
        String command = in.nextLine();
        while (!(command.equals("exit"))) {
            try {
                switch (command) {
                    case "show commands" -> showCommands();
                    case "signIn" -> signIn();
                    //books
                    case "add book" -> addBook();
                    case "get all books" -> getAllBooks();
                    case "get book by id" -> getBookById();
                    case "get book by count" -> getBookByCount();
                    case "get book by type name" -> getBookByTypeName();
                    case "get book by day count" -> getBookByDayCount();
                    case "delete book by name"-> deleteBookByName();
                    //bookTypes
                    case "add book type" ->addBookTypes();
                    case "get all book type" -> getAllBookTypes();
                    case "get book type by id" -> getBookTypeById();
                    case "get book type by name" -> getBookTypeByName();
                    case "get book type by count" -> getBookTypeByCnt();
                    case "get book type by day count" -> getBookTypeByDayCnt();
                    case "delete book type by name" -> deleteBookTypeByName();
                    //client
                    case "add client" -> addClient();
                    case "get all clients" -> getAllClients();
                    case "get client by id" -> getClientById();
                    case "get client by first name" -> getClientByFirstName();
                    case "get client by last name" -> getClientByLastName();
                    case "get client by father name" -> getClientByFatherName();
                    case "update client by id" -> updateClientById();
                    case "delete client by id" -> deleteClientById();
                    //journal
                    case "add journal" -> addJournal();
                    case "get all journals" -> getAllJournals();
                    case "get journal by id" -> getJournalById();
                    case "get journal by client initials" -> getJournalByClientInitials();
                    case "delete journal by id" -> deleteJournalById();
                    case "" -> {}
                    default -> System.out.println("Invalid Command");
                }
            } catch (JSONException ex) {
                System.out.println("Entered invalid arguments");
            } catch (Exception e) {
                e.printStackTrace();
            }
            command = in.nextLine();
        }
    }
}
