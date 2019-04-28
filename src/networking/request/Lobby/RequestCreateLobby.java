package networking.request.Lobby;

import core.GameClient;
import core.GameLobby;
import core.GameServer;
import database.AccessObjectImplementation.LobbyDAOImpl;
import database.Models.Lobby;
import networking.request.GameRequest;
import networking.response.Lobby.ResponseCreateLobby;
import utility.DataReader;
import utility.Log;

import java.io.IOException;

public class RequestCreateLobby extends GameRequest {

    private ResponseCreateLobby responseCreateLobby;

    private short status;
    private String version;


    private long ID;
    private String name;
    private String password;
    private int privacy;
    private boolean passwordRequired;
    private long owner;

    public RequestCreateLobby() {
        responses.add(responseCreateLobby = new ResponseCreateLobby());
    }

    @Override
    public void parse() throws IOException {
        version = DataReader.readString(dataInput).trim();
        ID = DataReader.readLong(dataInput);
        name = DataReader.readString(dataInput).trim();
        privacy = DataReader.readInt(dataInput);
        passwordRequired = DataReader.readBoolean(dataInput);
        password = DataReader.readString(dataInput).trim();
        owner = DataReader.readLong(dataInput);
    }

    @Override
    public void doBusiness() throws Exception {
        Lobby lobby = new Lobby(ID, name, privacy, passwordRequired, password, owner);

        if (LobbyDAOImpl.getDao().createLobby(lobby, owner)) {
            responseCreateLobby.setStatus((short) 0);

            GameClient client = GameServer.getInstance().getThreadByUserID(owner);
            GameLobby gameLobby = new GameLobby(lobby, GameServer.getInstance().getFreePort());
            responseCreateLobby.setPort(gameLobby.getPort());

            Log.println("Lobby creation successful");
        } else {
            responseCreateLobby.setStatus((short) 1);
            Log.println("Lobby creation failed");
        }

    }
}