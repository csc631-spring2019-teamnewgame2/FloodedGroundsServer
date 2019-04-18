package networking.response.Lobby;

import metadata.Constants;
import networking.response.GameResponse;
import utility.GamePacket;

public class ResponseJoinLobby extends GameResponse {

    public ResponseJoinLobby() {
        responseCode = Constants.SMSG_JOINLOBBY;
    }

    @Override
    public byte[] constructResponseInBytes() {
        GamePacket packet = new GamePacket(responseCode);
        return packet.getBytes();
    }
}