package networking.request.Lobby;

import java.io.IOException;

import networking.request.GameRequest;
import networking.response.Lobby.ResponseJoinGame;
import utility.Log;

public class RequestJoinGame extends GameRequest {

    private ResponseJoinGame responseJoinGame;

    public RequestJoinGame() {
        this.responses.add(responseJoinGame = new ResponseJoinGame());
    }

    @Override
    public void parse() throws IOException {
    }

    @Override
    public void doBusiness() throws Exception {
        Log.println("Join Game Requested");
        responseJoinGame.setCharacter(client.getPlayer().getCharacter());
    }
}