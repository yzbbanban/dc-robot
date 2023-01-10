package com.yzb.discordrobot;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DiscordrobotApplication {

    public static void main(String[] args) {
        SpringApplication.run(DiscordrobotApplication.class, args);
        try {
            JDA jda = JDABuilder.createDefault("your token").build().awaitReady();
            Thread.sleep(10000);
            jda.addEventListener(new MessageEvent());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
