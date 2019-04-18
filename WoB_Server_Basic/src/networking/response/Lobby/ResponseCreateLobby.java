package networking.response.Lobby;

import metadata.Constants;
import networking.response.GameResponse;
import utility.GamePacket;

public class ResponseCreateLobby extends GameResponse {

    public ResponseCreateLobby() {
        responseCode = Constants.SMSG_CREATELOBBY;
    }

    @Override
    public byte[] constructResponseInBytes() {
        GamePacket packet = new GamePacket(responseCode);
        return packet.getBytes();
    }
}
