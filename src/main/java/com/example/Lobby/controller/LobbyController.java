package com.example.Lobby.controller;

import com.example.Lobby.model.Lobby;
import com.example.Lobby.service.LobbyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/lobbies")
public class LobbyController {

    @Autowired
    private LobbyService lobbyService;

    @GetMapping
    public List<Lobby> getAllLobbies() {
        return lobbyService.getAllLobbies();
    }

    @GetMapping("/{id}")
    public Lobby getLobbyById(@PathVariable Long id) {
        return lobbyService.getLobbyById(id);
    }

    @PostMapping
    public Lobby createLobby(@RequestBody Lobby lobby) {
        return lobbyService.createLobby(lobby);
    }

    @DeleteMapping("/{id}")
    public void deleteLobby(@PathVariable Long id) {
        lobbyService.deleteLobby(id);
    }
}
