package networking.response;

import metadata.Constants;
import database.Models.Player;
import utility.GamePacket;
import java.util.Vector;

public class ResponseHeartbeat extends GameResponse {

    private Player myPlayer;

    public ResponseHeartbeat() {
        responseCode = Constants.SMSG_HEARTBEAT;
    }

    public void setMyPlayer(Player myPlayer) {
        this.myPlayer = myPlayer;
    }

    @Override
    public byte[] constructResponseInBytes() {
        GamePacket packet = new GamePacket(responseCode);

        //A list of players that have an update
        Vector<Player> playersWithUpdates = new Vector<>();

        for(Player player : Player.getPlayers()) {
            if(player != myPlayer && player.getClient().getLatestUpdateFromClient() != null)
                playersWithUpdates.add(player);
        }

        //Send the number of serverUpdates
        packet.addShort16((short)playersWithUpdates.size());

        //Loop through all of the players with serverUpdates
        for(Player player : playersWithUpdates) {
                //Add the character code
                packet.addShort16(Constants.characters.get(player.getCharacter()).shortValue());
                //Add the player's update
                packet.addBytes(player.getClient().getLatestUpdateFromClient());
            }

        return packet.getBytes();
    }
}