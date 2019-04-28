package networking.request.Lobby;

import java.io.IOException;

import networking.request.GameRequest;
import networking.response.Lobby.ResponseJoinGame;
import utility.Log;

public class RequestJoinGame extends GameRequest {

    private ResponseJoinGame responseJoinGame;

    public RequestJoinGame() {
        responseJoinGame = new ResponseJoinGame();
    }

    @Override
    public void parse() throws IOException {
    }

    @Override
    public void doBusiness() throws Exception {
        if(!client.inGame()) {
            Log.printf("User '%s' joined the game.", client.getPlayer().getUsername());

            responseJoinGame.setCharacter(client.getPlayer().getCharacter());

            client.setInGame(true);

            responses.add(responseJoinGame);
        }
    }
}