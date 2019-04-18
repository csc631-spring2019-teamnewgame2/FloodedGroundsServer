package networking.request.Lobby;

import java.io.IOException;

import networking.request.GameRequest;
import networking.response.Lobby.ResponseCreateLobby;
import utility.Log;

public class RequestJoinLobby extends GameRequest {

    private ResponseCreateLobby responseCreateLobby;

    public RequestJoinLobby() {
        this.responses.add(responseCreateLobby = new ResponseCreateLobby());
    }

    @Override
    public void parse() throws IOException {
    }

    @Override
    public void doBusiness() throws Exception {
        Log.println("Create Lobby Requested");
    }
}