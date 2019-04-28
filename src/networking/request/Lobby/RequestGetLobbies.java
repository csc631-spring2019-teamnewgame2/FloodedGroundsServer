package networking.request.Lobby;

import java.io.IOException;

import networking.request.GameRequest;
import networking.response.Lobby.ResponseGetLobbies;
import utility.Log;

public class RequestGetLobbies extends GameRequest {

    private ResponseGetLobbies responseGetLobbies;

    public RequestGetLobbies() {
        responses.add(responseGetLobbies = new ResponseGetLobbies());
    }

    @Override
    public void parse() throws IOException {
    }

    @Override
    public void doBusiness() throws Exception {
        Log.printf("User '%s' requested lobbies.", client.getPlayer().getUsername());
    }
}