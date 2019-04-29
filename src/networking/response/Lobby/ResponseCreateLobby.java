package networking.response.Lobby;

import database.Models.Lobby;
import metadata.Constants;
import networking.response.GameResponse;
import utility.GamePacket;

public class ResponseCreateLobby extends GameResponse {

    private short status;
    private Lobby lobby;
    private int port;

    public ResponseCreateLobby() {
        responseCode = Constants.SMSG_CREATELOBBY;
    }

    @Override
    public byte[] constructResponseInBytes() {
        GamePacket packet = new GamePacket(responseCode);
        return packet.getBytes();
    }

    public void setStatus(short status) {
        this.status = status;
    }

    public void setLobby(Lobby lobby) {
        this.lobby = lobby;
    }

    public void setPort(int port) {
        this.port = port;
    }


}
