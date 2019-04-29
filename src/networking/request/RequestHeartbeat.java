package networking.request;

import java.io.IOException;

import networking.response.ResponseHeartbeat;
import utility.Log;

public class RequestHeartbeat extends GameRequest {

    private ResponseHeartbeat responseHeartbeat;

    public RequestHeartbeat() {
        responses.add(responseHeartbeat = new ResponseHeartbeat());
    }

    @Override
    public void parse() throws IOException {
    }

    @Override
    public void doBusiness() throws Exception {
        responseHeartbeat.setUser(this.client.getUser());
        client.send(responseHeartbeat);
    }
}