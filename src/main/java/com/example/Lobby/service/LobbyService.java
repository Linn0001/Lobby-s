package com.example.Lobby.service;

import com.example.Lobby.model.Lobby;
import com.example.Lobby.repository.LobbyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LobbyService {

    @Autowired
    private LobbyRepository lobbyRepository;

    public List<Lobby> getAllLobbies() {
        return lobbyRepository.findAll();
    }

    public Lobby getLobbyById(Long id) {
        return lobbyRepository.findById(id).orElse(null);
    }

    public Lobby createLobby(Lobby lobby) {
        return lobbyRepository.save(lobby);
    }

    public void deleteLobby(Long id) {
        lobbyRepository.deleteById(id);
    }
}
