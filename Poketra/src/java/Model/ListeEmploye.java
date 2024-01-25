package Model;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class ListeEmploye {
    private String idEmployee;
    private String employee;
    private String position;
    private int duration;
    private double hourlyRate;

    public ListeEmploye() {
    }

    public ListeEmploye(String idEmployee, String employee, String position, int duration, double hourlyRate) {
        this.idEmployee = idEmployee;
        this.employee = employee;
        this.position = position;
        this.duration = duration;
        this.hourlyRate = hourlyRate;
    }

    public String getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(String idEmployee) {
        this.idEmployee = idEmployee;
    }

    public String getEmployee() {
        return employee;
    }

    public void setEmployee(String employee) {
        this.employee = employee;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    public static int calculateAge(String birthDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate birthDay = LocalDate.parse(birthDate, formatter);
        LocalDate today = LocalDate.now();
        return (int) ChronoUnit.YEARS.between(birthDay, today);
    }

    public ArrayList<ListeEmploye> getListe(Connection connection) throws Exception {
        Postes positions = new Postes();
        Poste positionUpdater = new Poste();
        SalaireOuvrier salaryOuvrier = new SalaireOuvrier();
        LocalDate today = LocalDate.now();
        ArrayList<ListeEmploye> employeeList = new ArrayList<>();
        ArrayList<SalaireOuvrier> salaryList = salaryOuvrier.getSalaireOuvrier(connection, "VRR006");

        ArrayList<Postes> allPositions = positions.getPostes(connection);

        for (Postes position : allPositions) {
            ListeEmploye employee = new ListeEmploye();
            employee.setIdEmployee(position.getIdEmploye());
            employee.setEmployee(position.getNom().toUpperCase()+" "+position.getPrenom());
            employee.setPosition(position.getOuvrier());
            int multiplier = 1;

            if ("VRR006".equalsIgnoreCase(position.getIdOuvrier())) {
                multiplier = 2;
            } else if ("VRR004".equalsIgnoreCase(position.getIdOuvrier())) {
                multiplier = 3;
            }

            employee.setDuration(calculateAge(position.getDateEmbauche()));
            double hoursWorked = calculateAge(position.getDateEmbauche()) * 24 * 365;

            employee.setHourlyRate(multiplier * salaryList.get(0).getSalaire() );

            if ("VRR006".equalsIgnoreCase(position.getIdOuvrier()) && calculateAge(position.getDateEmbauche()) == 2) {
                employee.setPosition("Ouvrier");
                multiplier = 2;
                positionUpdater.Update(connection, position.getIdEmploye(), "VR006", today.toString());
                hoursWorked = calculateAge(position.getDateEmbauche()) * 24 * 365;
                employee.setHourlyRate(multiplier * salaryList.get(0).getSalaire() );
                employee.setDuration(calculateAge(position.getDateEmbauche()));
            } else if ("VRR004".equalsIgnoreCase(position.getIdOuvrier()) && calculateAge(position.getDateEmbauche()) >= 3) {
                employee.setPosition("Expert");
                multiplier = 3;
                positionUpdater.Update(connection, position.getIdEmploye(), "VR004", today.toString());
                hoursWorked = calculateAge(position.getDateEmbauche()) * 24 * 365;
                employee.setHourlyRate(multiplier * salaryList.get(0).getSalaire());
                employee.setDuration(calculateAge(position.getDateEmbauche()));
            }

            employeeList.add(employee);
        }
        return employeeList;
    }
}
