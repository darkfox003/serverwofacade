package serverwofacade;

public class ServerFacade {
    private static ServerFacade serverFacade = null;
    private static ScheduleServer scheduleServer = null;
    
    private ServerFacade() {}

    public static ServerFacade getServerFacade() {
        if (serverFacade == null){
            serverFacade = new ServerFacade();
            scheduleServer = new ScheduleServer();
        }
        return serverFacade;
    }

    public void startServer() {
        scheduleServer.startBooting();
        scheduleServer.readSystemConfigFile();
        scheduleServer.init();
        scheduleServer.initializeContext();
        scheduleServer.initializeListeners();
        scheduleServer.createSystemObjects();
    }

    public void stopServer() {
        scheduleServer.releaseProcesses();
        scheduleServer.destory();
        scheduleServer.destroySystemObjects();
        scheduleServer.destoryListeners();
        scheduleServer.destoryContext();
        scheduleServer.shutdown();
    }
}
