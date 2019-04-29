package networking.request.Lobby;

import java.io.IOException;

import networking.request.GameRequest;
import networking.response.Lobby.ResponseCreateLobby;
import utility.Log;

public class RequestCreateLobby extends GameRequest {

    private ResponseCreateLobby responseCreateLobby;

    public RequestCreateLobby() {
        responses.add(responseCreateLobby = new ResponseCreateLobby());
    }

    @Override
    public void parse() throws IOException {
    }

    @Override
    public void doBusiness() throws Exception {
        Log.printf("User '%s' created a lobby.", client.getPlayer().getUsername());
    }
}