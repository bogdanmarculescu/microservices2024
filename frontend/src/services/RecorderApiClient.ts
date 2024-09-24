class RecorderApiClient {
    static SERVER_URL = 'http://localhost:8082';
    static GET_RECORDER = '/record?id=';

    static roundsForPlayer(player: number): Promise<Response> {
        return fetch(RecorderApiClient.SERVER_URL +
        RecorderApiClient.GET_RECORDER +
        player);
    }
}

export default RecorderApiClient;