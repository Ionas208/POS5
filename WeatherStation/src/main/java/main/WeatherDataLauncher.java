package main;

import beans.WeatherData;
import conprod.WeatherDataConsumer;
import conprod.WeatherDataProducer;
import observer.WeatherDataGUI;
import observer.WeatherDataLogger;
import observer.WeatherDataPrinter;

import java.util.PriorityQueue;
import java.util.Queue;

/*
    Created by: Jonas Seidl
    Date: 04.03.2022
    Time: 11:57
*/
public class WeatherDataLauncher {
    public static void main(String[] args) {
        Queue<WeatherData> queue = new PriorityQueue<>();
        WeatherDataProducer producer = new WeatherDataProducer(queue);
        WeatherDataConsumer consumer = new WeatherDataConsumer(queue);
        Thread t1 = new Thread(producer);
        Thread t2 = new Thread(consumer);

        t1.start();
        t2.start();

        WeatherDataPrinter printer = new WeatherDataPrinter(consumer);
        WeatherDataLogger logger = new WeatherDataLogger(consumer);
        WeatherDataGUI gui = new WeatherDataGUI(consumer);
        gui.setVisible(true);
    }
}
