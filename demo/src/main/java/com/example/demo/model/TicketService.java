package com.example.demo.model;  
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.jdbc.core.JdbcTemplate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TicketService {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    // public TicketService(JdbcTemplate jdbcTemplate) {
    //     this.jdbcTemplate = jdbcTemplate;
    // }
    @Autowired
    private AssignValues assignValues;

    private final int abx = 5;

    public void addPassenger(Passengerdetails pd) {
        String query = "INSERT INTO passengerbooking (name, starting, destination) VALUES (?, ?, ?)";
        jdbcTemplate.update(query, pd.getName(), pd.getStarting(), pd.getDestination());
    }

    public List<Passengerdetails> getAllPassengers() {
        String query = "SELECT id, name, starting, destination FROM passengerbooking";
        return jdbcTemplate.query(query, (rs, rowNum) -> {
            Passengerdetails pd = new Passengerdetails();
            pd.setId(rs.getInt("id"));
            pd.setName(rs.getString("name"));
            pd.setStarting(rs.getString("starting"));
            pd.setDestination(rs.getString("destination"));
            return pd;
        });
    }

    public void signup(String name, String email, String password) {
        System.out.println("Signup for: " + email);
        String query = "INSERT INTO login (name, emailid, password) VALUES (?, ?, ?)";
        jdbcTemplate.update(query, name, email, password);
    }

    public boolean login(String email, String password) {
        String query = "SELECT password FROM login WHERE emailid = ?";
        @SuppressWarnings("deprecation")
        List<String> passwords = jdbcTemplate.query(query, new Object[]{email}, (rs, rowNum) -> rs.getString("password"));
        if (passwords.isEmpty()) {
            
            return false;
        }
        String storedPassword = passwords.get(0);
        return password.equals(storedPassword);
    }

    @SuppressWarnings("null")
    public int countRecords(String tableName) {
        String query = "SELECT COUNT(*) FROM " + tableName;
        return jdbcTemplate.queryForObject(query, Integer.class);
    }

    public List<StationAssign> getStationAssignments() {
        String query = "SELECT stations, value FROM train";
        return jdbcTemplate.query(query, (rs, rowNum) -> {
            StationAssign sa = new StationAssign();
            sa.setStation(rs.getString("stations"));
            sa.setValue(rs.getInt("value"));
            return sa;
        });
    }

    public void bookTicket(Passengerdetails pd, String email) {
        int count = countRecords("passengerbooking");
        System.out.println("count=" + count);
        System.out.println("abx=" + abx);
        if (count < 4) {
            addPassenger(pd);
        } else {
            List<StationAssign> stationAssignments = getStationAssignments();
            System.out.println("stationAssignments=" + stationAssignments);
            //List<Passengerdetails> allPassengers = getAllPassengers();
            assignValues.check(pd, convertStationAssignToAssignValues(stationAssignments), email);
        }
    }
     private List<AssignValues> convertStationAssignToAssignValues(List<StationAssign> stationAssignments) {
        // Convert StationAssign objects to AssignValues objects
        return stationAssignments.stream()
                .map(sa -> new AssignValues(0, sa.getValue(), null, sa.getStation()))
                .collect(Collectors.toList());
    }
}
