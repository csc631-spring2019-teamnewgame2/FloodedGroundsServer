package networking.response;

import metadata.Constants;
import utility.GamePacket;

public class ResponseHit extends GameResponse {

    private short hitPlyaer;
    private float[] particlePositions;

    public ResponseHit() {
        responseCode = Constants.SMSG_PICKUP;
    }

    public void setHitPlyaer(short hitPlayer) {
        this.hitPlyaer = hitPlyaer;
    }
    public void setParticlePositions(float[] particlePositions) {
        this.particlePositions = particlePositions;
    }

    @Override
    public byte[] constructResponseInBytes() {
        GamePacket packet = new GamePacket(responseCode);
        packet.addShort16(hitPlyaer);
        packet.addShort16((short)particlePositions.length);

        for(float position : particlePositions)
            packet.addFloat(position);

        return packet.getBytes();
    }
}
