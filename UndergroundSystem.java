class UndergroundSystem {
HashMap<Integer, Record> userRecords;
HashMap<String, Station> endStations;
public UndergroundSystem() {
userRecords = new HashMap<>();
endStations = new HashMap<>();
}

public void checkIn(int id, String stationName, int t) {
    userRecords.put(id, new Record(id, stationName, t));
}

public void checkOut(int id, String stationName, int t) {
    Record record = userRecords.get(id);
    record.checkOut(stationName, t);
    Station station = endStations.get(stationName);
    if (station == null) {
        station = new Station();
        endStations.put(stationName, station);
    }
    station.saveRecord(record);
}

public double getAverageTime(String startStation, String endStation) {
    Station station = endStations.get(endStation);
    if (station == null) return 0;
    return station.getAverageTime(startStation);
}
public class StationInfo {
    public double totalTime;
    public int totalCount;
    public double getAverage() {
        if (totalCount == 0) {
            return 0;
        }
        return totalTime / totalCount;
    }
}
// End Station
public class Station {
    // Start Station Map
    public Map<String, StationInfo> map;
    public Station () {
        map = new HashMap<>();
    }
    public double getAverageTime(String startStation) {
        StationInfo info = map.get(startStation);
        if (info == null) return 0;
        return info.getAverage();
    }
    public void saveRecord(Record record) {
        String startStation = record.getStartStation();
        StationInfo info = map.get(startStation);
        if (info == null) {
            info = new StationInfo();
            map.put(startStation, info);
        }
        info.totalTime += record.getTime();
        info.totalCount++;
    }
}
public class Record {
    private int id;
    private int checkIn;
    private int checkOut;
    private String startStation;
    private String endStation;
    public Record(int id, String station, int checkIn) {
        this.id = id;
        this.checkIn = checkIn;
        this.startStation = station;
        this.checkOut = -1;
        this.endStation = null;
    }
    public void checkIn(String station, int checkIn) {
        this.checkIn = checkIn;
        this.startStation = station;
    }
    public void checkOut(String station, int checkOut) {
        this.checkOut = checkOut;
        this.endStation = station;
    }
    public String getStartStation() {
        return this.startStation;
    }
    public String getEndStation() {
        return this.endStation;
    }
    public int getTime() {
        return this.checkOut - this.checkIn;
    }
}
}