package networking.response.Lobby;

import metadata.Constants;
import networking.response.GameResponse;
import utility.GamePacket;

public class ResponseGetLobbies extends GameResponse {

    public ResponseGetLobbies() {
        responseCode = Constants.SMSG_GETLOBBIES;
    }

    @Override
    public byte[] constructResponseInBytes() {
        GamePacket packet = new GamePacket(responseCode);
        return packet.getBytes();
    }
}
