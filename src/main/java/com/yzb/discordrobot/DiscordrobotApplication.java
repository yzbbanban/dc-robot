package com.yzb.discordrobot;

import com.yzb.discordrobot.jda.MessageEvent;
import discord4j.core.DiscordClientBuilder;
import discord4j.core.GatewayDiscordClient;
import discord4j.core.object.presence.ClientActivity;
import discord4j.core.object.presence.ClientPresence;
import discord4j.rest.RestClient;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import org.javacord.api.DiscordApi;
import org.javacord.api.DiscordApiBuilder;
import org.javacord.api.entity.intent.Intent;
import org.javacord.api.entity.message.MessageFlag;
import org.javacord.api.interaction.SlashCommandInteraction;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.Duration;

@SpringBootApplication(scanBasePackages = {"com.yzb"})
public class DiscordrobotApplication {

    private static String token = "MTA2MzI3NTU4OTgxNDk5NzA2Mg.GcKWJ4.6FoOdG2yophD7ivAet5WO2_wWbq4BQbXLOkCEQ";

    public static void main(String[] args) {
        SpringApplication.run(DiscordrobotApplication.class, args);
        try {
//         Note: It is important to register your ReadyListener before building
//            JDA jda = JDABuilder.createDefault(TOKEN)
//                    .build().awaitReady();
//
//            jda.addEventListener(new MessageEvent());

            //DiscordApi https://github.com/Javacord/Javacord
            DiscordApi api = new DiscordApiBuilder()
                    .setToken(token)
                    .addIntents(Intent.MESSAGE_CONTENT)
                    .login()
                    .join();

            // Add a listener which answers with "Pong!" if someone writes "!ping"
            api.addMessageCreateListener(event -> {
                if (event.getMessageContent().equalsIgnoreCase("!ping")) {
                    event.getChannel().sendMessage("Pong!");
                }
            });

            // Print the invite url of your bot
            System.out.println("You can invite the bot by using the following url: " + api.createBotInvite());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * discord4J https://github.com/Discord4J/Discord4J
     */
//    @Bean
//    public RestClient discordRestClient() {
//        System.out.println("-----------");
//        GatewayDiscordClient client = null;
//        try {
//            client = DiscordClientBuilder.create(TOKEN).build()
//                    .gateway()
//                    .setInitialPresence(ignore -> ClientPresence.online(ClientActivity.listening("to /discord4j/commands")))
//                    .login()
//                    .block();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        while (client == null) {
//            try {
//                Thread.sleep(1000);
//                client = getClient();
//            } catch (Exception e) {
//                e.printStackTrace();
//                client = null;
//            }
//        }
//        return client.getRestClient();
//    }
//
//    public GatewayDiscordClient getClient() {
//        return DiscordClientBuilder.create(TOKEN).build()
//                .gateway()
//                .setInitialPresence(ignore -> ClientPresence.online(ClientActivity.listening("to /discord4j/commands")))
//                .login().block(Duration.ofMillis(1000000));
//    }
}
