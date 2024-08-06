package com.example.demo;

// import java.util.List;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//import com.example.demo.model.PassengerService;

@SpringBootApplication
public class DemoApplication  {

    //@Autowired
    //public PassengerService ticketService;


    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
        System.out.println("Running successfully the project");
    }

    // @Override
    // public void run(String... args) throws Exception {
    //     // TODO Auto-generated method stub
    //     throw new UnsupportedOperationException("Unimplemented method 'run'");
    // }


   
}

