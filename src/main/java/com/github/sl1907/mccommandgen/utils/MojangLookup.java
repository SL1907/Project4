package com.github.sl1907.mccommandgen.utils;

import com.github.benmanes.caffeine.cache.AsyncLoadingCache;
import com.github.benmanes.caffeine.cache.Caffeine;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

public class MojangLookup {

    private static final JSONParser parser = new JSONParser();

    private static final HttpClient httpClient = HttpClient.newBuilder()
            .connectTimeout(Duration.ofSeconds(10))
            .build();

    private static final AsyncLoadingCache<String, UUID> usernameUuidCache = Caffeine.newBuilder()
            .maximumSize(1000)
            .expireAfterWrite(Duration.ofMinutes(15))
            .refreshAfterWrite(Duration.ofMinutes(30))
            .buildAsync((username, executor) -> MojangLookup.lookupUuid(username));

    private static CompletableFuture<UUID> lookupUuid(String username) {
        return httpClient.sendAsync(
                HttpRequest.newBuilder()
                    .uri(URI.create("https://api.mojang.com/users/profiles/minecraft/%s".formatted(username)))
                    .GET()
                    .build(), HttpResponse.BodyHandlers.ofString())
                    .thenApply(response -> {
                        System.out.println("Response: " + response.body());
                        if (response.statusCode() == 200) {
                            String body = response.body();
                            try {
                                JSONObject object = (JSONObject) parser.parse(body);
                                return UUID.fromString((String) object.get("id"));
                            } catch (ParseException e) {
                                e.printStackTrace();
                                return null;
                            }
                        } else {
                            return null;
                        }
                    });
    }

    public static CompletableFuture<UUID> get(String username) {
        return usernameUuidCache.get(username);
    }
}
