import java.util.HashMap;
import java.util.Map;

class UndergroundSystem {

    // Class to store check-in information for a customer
    private static class CheckInInfo {
        String stationName;
        int checkInTime;

        CheckInInfo(String stationName, int checkInTime) {
            this.stationName = stationName;
            this.checkInTime = checkInTime;
        }
    }

    // Class to store total time and total trip count between two stations
    private static class RouteData {
        double totalTime;
        int count;

        RouteData(double totalTime, int count) {
            this.totalTime = totalTime;
            this.count = count;
        }
    }

    // Maps passenger ID -> CheckInInfo
    private Map<Integer, CheckInInfo> checkInMap;
    // Maps "startStation->endStation" -> RouteData
    private Map<String, RouteData> routeMap;

    public UndergroundSystem() {
        checkInMap = new HashMap<>();
        routeMap = new HashMap<>();
    }
    
    public void checkIn(int id, String stationName, int t) {
        checkInMap.put(id, new CheckInInfo(stationName, t));
    }
    
    public void checkOut(int id, String stationName, int t) {
        // Retrieve and remove customer's check-in info
        CheckInInfo checkIn = checkInMap.remove(id);
        
        String routeKey = checkIn.stationName + "->" + stationName;
        int travelTime = t - checkIn.checkInTime;
        
        // Update route statistics
        RouteData route = routeMap.getOrDefault(routeKey, new RouteData(0, 0));
        route.totalTime += travelTime;
        route.count += 1;
        
        routeMap.put(routeKey, route);
    }
    
    public double getAverageTime(String startStation, String endStation) {
        String routeKey = startStation + "->" + endStation;
        RouteData route = routeMap.get(routeKey);
        
        return route.totalTime / route.count;
    }
}
