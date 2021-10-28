package com.tony.cmdcanvas;

import com.tony.cmdcanvas.object.Playground;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class CmdRunner implements CommandLineRunner {
    @Autowired
    private Playground playground;

    @Override
    public void run(String... args) {
        Scanner scanner = new Scanner(System.in);
        while (playground.isPlaying()) {
            System.out.print("enter command: ");
            String input = scanner.nextLine();
            playground.readInput(input);
        }
    }
}
