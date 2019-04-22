package networking.request.Lobby;

import database.AccessObjectImplementation.LobbyDAOImpl;
import database.AccessObjectImplementation.UserDAOImpl;
import database.AccessObjects.LobbyDAO;
import database.AccessObjects.UserDAO;
import database.Models.Lobby;
import metadata.Constants;
import networking.request.GameRequest;
import networking.response.Lobby.ResponseGetLobbies;
import utility.DataReader;
import utility.Log;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class RequestGetLobbies extends GameRequest {

    private ResponseGetLobbies responseGetLobbies;
    private LobbyDAO lobbyDAO = new LobbyDAOImpl();
    private UserDAO userDAO = new UserDAOImpl();
    private String version;
    private List<Lobby> lobbyList;
    private Map<Long, String> usernames;

    public RequestGetLobbies() {
        responses.add(responseGetLobbies = new ResponseGetLobbies());
    }

    @Override
    public void parse() throws IOException {
        version = DataReader.readString(dataInput).trim();
    }

    @Override
    public void doBusiness() throws Exception {
        if (version.compareTo(Constants.CLIENT_VERSION) >= 0) {
            Log.println("Get Lobbies Requested");

            lobbyList = lobbyDAO.getAllLobbies();
            if (lobbyList.size() > 0) {
                responseGetLobbies.setStatus((short) 0);
                responseGetLobbies.setLobbyList(lobbyList);
                responseGetLobbies.setUserNames(userDAO.getAllUsernames());
            } else {
                responseGetLobbies.setStatus((short) 1);
            }
        }
    }
}