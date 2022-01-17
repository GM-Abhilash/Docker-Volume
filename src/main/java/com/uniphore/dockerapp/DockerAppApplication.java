package com.uniphore.dockerapp;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class DockerAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(DockerAppApplication.class, args);
	}

	@GetMapping("/message")
	public String getMessage() {
		return "Welcome to Docker";
	}

	@GetMapping("createFile")
	public String createFileInLocal() throws IOException {
		File file = new File("app/temp");
		file.mkdirs();
		File file1 = new File("app/temp/a.txt");
		file1.createNewFile();
		try (FileWriter fileWriter = new FileWriter("app/temp/a.txt")) {
			fileWriter.write("Welcome to Docker Volume");
		}
		return "File Created Successfully";
	}

	@GetMapping("readFile")
	public String readFile() throws IOException {
		try (FileReader fileReader = new FileReader("app/temp/a.txt")) {
			int value;
			StringBuilder builder = new StringBuilder();
			while ((value = fileReader.read()) != -1) {
				builder.append((char) value);
			}
			return builder.toString();
		}
	}
}
