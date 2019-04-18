package networking.request.Authentication;

import java.io.IOException;

import networking.request.GameRequest;
import networking.response.Authentication.ResponseRegister;
import utility.Log;

public class RequestRegister extends GameRequest {

    private ResponseRegister responseRegister;

    public RequestRegister() {
        responses.add(responseRegister = new ResponseRegister());
    }

    @Override
    public void parse() throws IOException {
    }

    @Override
    public void doBusiness() throws Exception {
        Log.println("Create Lobby Requested");
    }
}