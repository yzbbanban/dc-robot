package com.yzb.discordrobot;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.requests.GatewayIntent;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DiscordrobotApplication {

    public static void main(String[] args) {
        SpringApplication.run(DiscordrobotApplication.class, args);
        try {
            String token = "your token";
            // Note: It is important to register your ReadyListener before building
            JDA jda = JDABuilder.createDefault(token)
//                    .enableIntents(GatewayIntent.MESSAGE_CONTENT)
                    .build();

            jda.addEventListener(new MessageEvent());


            // optionally block until JDA is ready
            jda.awaitReady();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
