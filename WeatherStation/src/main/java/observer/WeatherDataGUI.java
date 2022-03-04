package observer;

import beans.WeatherData;

import javax.swing.*;
import java.awt.*;

/*
    Created by: Jonas Seidl
    Date: 04.03.2022
    Time: 11:57
*/
public class WeatherDataGUI extends JFrame implements WeatherDataObserver{

    private WeatherDataSubject weatherDataSubject;

    private JLabel lbTemp;
    private JLabel lbPressure;
    private JLabel lbHumidity;
    private JLabel lbWindSpeed;
    private JLabel lbWindDirection;

    private JTextField tfTemp;
    private JTextField tfPressure;
    private JTextField tfHumidity;
    private JTextField tfWindSpeed;
    private JTextField tfWindDirection;


    public WeatherDataGUI(WeatherDataSubject wds) {
        super("Weather Data");
        initComponents();
        this.weatherDataSubject = wds;
        wds.registerObserver(this);
    }

    private void initComponents() {
        setSize(300, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container container = getContentPane();
        container.setLayout(new GridLayout(5, 2, 4, 4));

        lbTemp = new JLabel("Temperature");
        lbPressure = new JLabel("Pressure");
        lbHumidity = new JLabel("Humidity");
        lbWindSpeed = new JLabel("Wind Speed");
        lbWindDirection = new JLabel("Wind Direction");

        tfTemp = new JTextField();
        tfTemp.setEditable(false);
        tfPressure = new JTextField();
        tfPressure.setEditable(false);
        tfHumidity = new JTextField();
        tfHumidity.setEditable(false);
        tfWindSpeed = new JTextField();
        tfWindSpeed.setEditable(false);
        tfWindDirection = new JTextField();
        tfWindDirection.setEditable(false);

        container.add(lbTemp);
        container.add(tfTemp);

        container.add(lbPressure);
        container.add(tfPressure);

        container.add(lbHumidity);
        container.add(tfHumidity);

        container.add(lbWindSpeed);
        container.add(tfWindSpeed);

        container.add(lbWindDirection);
        container.add(tfWindDirection);

        setLocationRelativeTo(null);
    }

    @Override
    public void update(WeatherData wd) {
        tfTemp.setText(wd.getTemperature() + "°C");
        tfPressure.setText(wd.getPressure() + " hPa");
        tfHumidity.setText(wd.getHumidity() + "%");
        tfWindSpeed.setText(wd.getWindSpeed() + " kmh");
        tfWindDirection.setText(wd.getWindDirection() + "°");
    }
}
