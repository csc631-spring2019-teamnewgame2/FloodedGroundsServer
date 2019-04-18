package networking.response.Authentication;

import metadata.Constants;
import networking.response.GameResponse;
import utility.GamePacket;

public class ResponseRegister extends GameResponse {

    public ResponseRegister() {
        responseCode = Constants.SMSG_REGISTER;
    }

    @Override
    public byte[] constructResponseInBytes() {
        GamePacket packet = new GamePacket(responseCode);
        return packet.getBytes();
    }
}
