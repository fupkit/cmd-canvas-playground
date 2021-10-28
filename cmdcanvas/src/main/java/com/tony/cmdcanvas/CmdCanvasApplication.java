package com.tony.cmdcanvas;

import com.tony.cmdcanvas.object.Playground;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class CmdCanvasApplication implements CommandLineRunner {
	@Autowired
	private Playground playground;

	public static void main(String[] args) {
		SpringApplication.run(CmdCanvasApplication.class, args);
	}

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
