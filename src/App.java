public class App {

    public static void main(String[] args) {
//        ReadingAPI api = new ReadingAPI();
//        ReadingAPIWeatherNow apiNow = new ReadingAPIWeatherNow();
//        System.out.println(api.reading());
//        System.out.println(apiNow.reading());


        GettingTemp nowy = new GettingTemp();

        System.out.println(nowy.getActualTemperature());
        System.out.println(nowy.getFutureTemperature());
//        System.out.println(nowy.getFutureTemperature().get(1487203200));









    }

}
